package com.example.user.yata;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectActivity1 extends AppCompatActivity {

    private static String IP_ADDRESS = "112.159.76.92";
    private static String TAG = "phptest";

    String StudentID;
    String mJsonString;
    String StudentID_of_driver;
    String Name_of_driver;
    String Phone_of_driver;
    String VehicleID_of_driver;
    TextView TextView_of_Name_of_driver;
    TextView TextView_of_Phone_of_driver;
    TextView TextView_of_VehicleID_of_driver;

    Button btnConnect2;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_connect1);
        Intent getterIntent=getIntent();
        this.StudentID=getterIntent.getStringExtra("StudentID_of_rider").toString();
        this.StudentID_of_driver=getterIntent.getStringExtra("StudentID").toString();
        TextView_of_Name_of_driver=(TextView)findViewById(R.id.TextView_of_Name_of_driver);
        TextView_of_Phone_of_driver=(TextView)findViewById(R.id.TextView_of_Phone_of_driver);
        TextView_of_VehicleID_of_driver=(TextView)findViewById(R.id.TextView_of_CarNum_of_driver);
        btnConnect2 = (Button)findViewById(R.id.btnConnect2);
        btnConnect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectActivity1.this, ConnectActivity2.class);
                intent.putExtra("StudentID",StudentID);
                intent.putExtra("StudentID_of_driver",StudentID_of_driver);
                startActivity(intent);
            }
        });
        GetData task = new GetData();
        task.execute( "http://" + IP_ADDRESS + "/getjson.php", "");
    }


    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ConnectActivity1.this,
                    "Please Wait", null, true, true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

            Log.d(TAG, "response - " + result);

            if (result == null){


            }
            else {

                mJsonString = result;
                showResult();
            }
        }

        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String postParameters = "Pwd=" + params[1];

            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();

                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();

                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();

            } catch (Exception e) {

                Log.d(TAG, "GetData : Error ", e);
                errorString = e.toString();

                return null;
            }
        }
    }

    private void showResult(){

        String TAG_JSON="shadow98a";
        String TAG_STUDENTID = "StudentID";
        String TAG_NAME = "Name";
        String TAG_PHONE ="Phone";
        String TAG_VEHICLEID = "VehicleID";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String StudentID = item.getString(TAG_STUDENTID);
                String Name = item.getString(TAG_NAME);
                String Phone = item.getString(TAG_PHONE);
                String VehicleID = item.getString(TAG_VEHICLEID);

                if(StudentID.equals(this.StudentID_of_driver))
                {
                    Name_of_driver=Name;
                    TextView_of_Name_of_driver.setText(Name_of_driver);
                    Phone_of_driver=Phone;
                    TextView_of_Phone_of_driver.setText(Phone_of_driver);
                    VehicleID_of_driver=VehicleID;
                    TextView_of_VehicleID_of_driver.setText(VehicleID_of_driver);
                }
            }
        } catch (JSONException e) {
            Log.d(TAG, "showResult : ", e);
        }
    }
}
