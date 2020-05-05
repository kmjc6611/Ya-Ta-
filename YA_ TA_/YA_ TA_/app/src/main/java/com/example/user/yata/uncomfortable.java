package com.example.user.yata;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


public class uncomfortable extends AppCompatActivity {

    private static String IP_ADDRESS = "112.159.76.92";
    private static String TAG = "phptest";

   // private TextView mTextViewResult;
    private EditText textView25;
    Button btnConnect2;

    String StudentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uncomfortable);
        Intent getterIntent=getIntent();
        this.StudentID=getterIntent.getStringExtra("StudentID").toString();
        setContentView(R.layout.activity_uncomfortable);
        textView25 = (EditText) findViewById(R.id.textView25);
      //  mTextViewResult = (TextView)findViewById(R.id.textView_main_result);
        btnConnect2 =(Button)findViewById(R.id.btnConnect2);
        //mTextViewResult.setMovementMethod(new ScrollingMovementMethod());
        btnConnect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TextView25 = textView25.getText().toString();

                InsertData task = new InsertData();

                task.execute("http://" + IP_ADDRESS + "/uncomfortableinsert.php", StudentID, TextView25);

                textView25.setText("");


            }
        });

    }

    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(uncomfortable.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String StudentID = (String)params[1];
            String uncomfortable = (String)params[2];

            String serverURL = (String)params[0];
            String postParameters = "StudentID=" + StudentID + "&uncomfortable=" + uncomfortable;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

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
                String line = null;

                while((line = bufferedReader.readLine()) != null){
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
