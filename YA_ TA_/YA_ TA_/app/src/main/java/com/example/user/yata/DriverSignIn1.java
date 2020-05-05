package com.example.user.yata;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DriverSignIn1 extends AppCompatActivity {
    Button next;
    private static String IP_ADDRESS = "112.159.76.92";
    private static String TAG = "phptest";

    Button insert;
    private EditText studentID;
    private EditText password;
    private EditText name;
    private EditText phone;
    private EditText vehicleID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sign_in1);
        studentID = (EditText)findViewById(R.id.studentID);//
        password = (EditText)findViewById(R.id.password);//
        name = (EditText)findViewById(R.id.name);//
        phone = (EditText)findViewById(R.id.phone);//
        vehicleID = (EditText)findViewById(R.id.carNum);//

        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!((((studentID.getText()).toString()).equals("")) || (((password.getText()).toString()).equals("")) || (((name.getText()).toString()).equals("")) || (((phone.getText()).toString()).equals(""))||( ((vehicleID.getText()).toString()).equals(""))))
        {
            String StudentID = studentID.getText().toString();//
            String Pwd = password.getText().toString();//
            String Name = name.getText().toString();//
            String Phone = phone.getText().toString();//
            String VehicleID = vehicleID.getText().toString();//

            DriverSignIn1.InsertData task = new DriverSignIn1.InsertData();
            task.execute("http://" + IP_ADDRESS + "/insert.php", StudentID, Pwd, Name, Phone, VehicleID);//


            studentID.setText("");//
            password.setText("");//
            name.setText("");//
            phone.setText("");//
            vehicleID.setText("");//

            AlertDialog.Builder builder = new AlertDialog.Builder(DriverSignIn1.this);
            builder.setMessage("회원가입이 완료되었습니다.\n" +
                    "로그인 화면으로 돌아가시겠습니까?");
            builder.setTitle("※ 알림 ※")
                    .setCancelable(false)
                    .setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(DriverSignIn1.this, MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.setTitle("※ 알림 ※");
            alert.show();
        }
            }
        });
    }

    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(DriverSignIn1.this,
                    "Please Wait", null, true, true);
        }

        // @Override
        // protected void onPostExecute(String result) {
        //     super.onPostExecute(result);

        //    progressDialog.dismiss();
        //     Result.setText(result);
        //    Log.d(TAG, "POST response  - " + result);
        // }

        @Override
        protected String doInBackground(String... params) {

            String StudentID = (String) params[1];//
            String Pwd = (String) params[2];//
            String Name = (String) params[3];//
            String Phone = (String) params[4];//
            String VehicleID = (String) params[5];//

            String serverURL = (String) params[0];
            String postParameters = "StudentID=" + StudentID + "&Pwd=" + Pwd + "&Name=" + Name + "&Phone=" + Phone + "&VehicleID=" + VehicleID;//


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(2000);
                httpURLConnection.setConnectTimeout(2000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }
}
