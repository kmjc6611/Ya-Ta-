package com.example.user.yata;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class InformationForDriver2 extends AppCompatActivity {
    private static String IP_ADDRESS = "112.159.76.92";
    private static String TAG = "phptest";

    String mJsonString;
    String StudentID_of_rider;
    TextView Name_of_rider;
    TextView Phone_of_rider;
    Button btnEnd2;
    String StudentID;



    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_informationfordriver);
        Name_of_rider=(TextView)findViewById(R.id.Name_of_rider);
        Phone_of_rider=(TextView)findViewById(R.id.Phone_of_rider);
        Intent getterIntent=getIntent();
        StudentID_of_rider=getterIntent.getStringExtra("Path").toString();

        GetData task = new GetData();
        task.execute("http://" + IP_ADDRESS + "/getjson.php", "");


        btnEnd2 = (Button)findViewById(R.id.btnEnd2);
        btnEnd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationForDriver2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }






    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(InformationForDriver2.this,
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
        String TAG_PHONE = "Phone";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String StudentID = item.getString(TAG_STUDENTID);
                String Name = item.getString(TAG_NAME);
                String Phone = item.getString(TAG_PHONE);

                if(StudentID.equals(StudentID_of_rider))
                {
                Name_of_rider.setText(Name);
                Phone_of_rider.setText(Phone);
                }
            }
        } catch (JSONException e) {
            Log.d(TAG, "showResult : ", e);
        }
    }
}
