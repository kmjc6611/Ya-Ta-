package com.example.shadow98a.log_in_test_0;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.ArrayList;
import java.util.Collections;


public class Member_info extends AppCompatActivity {

    private static String IP_ADDRESS = "112.159.76.92";
    private static String TAG = "phptest";

    private EditText mEditTextStudentID;
    private EditText mEditTextPwd;
    private EditText mEditTextName;
    private EditText mEditTextPhone;
    private ArrayList<PersonalData> mArrayList;
    private UsersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText mEditTextSearchKeyword;
    private String mJsonString;
    private EditText EditTextStudentID;
    private Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_info);

        mRecyclerView = (RecyclerView) findViewById(R.id.listView_main_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

EditTextStudentID=(EditText) findViewById(R.id.editText);


        mArrayList = new ArrayList<>();

        mAdapter = new UsersAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        Button button_all = (Button) findViewById(R.id.button_main_all);
        button_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mArrayList.clear();
                mAdapter.notifyDataSetChanged();

                GetData task = new GetData();
                task.execute( "http://" + IP_ADDRESS + "/getjson.php", "");


            }
        });
        delete = (Button) findViewById(R.id.button);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String StudentID=EditTextStudentID.getText().toString();



                InsertData inserttask = new InsertData();
                inserttask.execute("http://" + IP_ADDRESS + "/delete.php", StudentID);

                EditTextStudentID.setText("");
            }
        });

    }



    private class GetData extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(Member_info.this,
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
        String TAG_ID = "id";
        String TAG_STUDENTID = "StudentID";
        String TAG_PWD ="Pwd";
        String TAG_NAME = "Name";
        String TAG_PHONE ="Phone";
        String TAG_VEHICLEID="VehicleID";


        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String id = item.getString(TAG_ID);
                String StudentID = item.getString(TAG_STUDENTID);
                String Pwd = item.getString(TAG_PWD);
                String Name = item.getString(TAG_NAME);
                String Phone = item.getString(TAG_PHONE);
                String VehicleID = item.getString(TAG_VEHICLEID);
                if(StudentID.contains(EditTextStudentID.getText().toString())) {
                    PersonalData personalData = new PersonalData();

                    personalData.setMember_id(id);
                    personalData.setMember_StudentID(StudentID);
                    personalData.setMember_Pwd(Pwd);
                    personalData.setMember_Name(Name);
                    personalData.setMember_Phone(Phone);
                    personalData.setMember_VehicleID(VehicleID);

                    mArrayList.add(personalData);
                    Collections.sort(mArrayList);
                    mAdapter.notifyDataSetChanged();
                }
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(Member_info.this,
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

            String serverURL = (String)params[0];
            String postParameters = "StudentID=" + StudentID;


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
