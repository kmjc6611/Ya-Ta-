package com.example.user.yata;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class UserLoginActivity extends AppCompatActivity {

    private static String IP_ADDRESS = "112.159.76.92";//
    private static String TAG = "phptest";

    private EditText mEditTextStudentID;
    private EditText mEditTextPwd;
    private TextView mTextViewResult;
    private String mJsonString;

    private String StudentID;
    private String Pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mEditTextStudentID = (EditText) findViewById(R.id.StudentID_to_log_in_text);
        mEditTextPwd = (EditText) findViewById(R.id.Pwd_to_log_in_text);
        mTextViewResult = (TextView) findViewById(R.id.textView_main_result);

        mTextViewResult.setMovementMethod(new ScrollingMovementMethod());

        Button button_all = (Button) findViewById(R.id.btnPath1);
        button_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                StudentID = mEditTextStudentID.getText().toString();
                Pwd = mEditTextPwd.getText().toString();

                GetData task = new GetData();
                task.execute("http://" + IP_ADDRESS + "/getjson.php", "");
            }
        });
    }

    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(UserLoginActivity.this,
                    "Please Wait", null, true, true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            Log.d(TAG, "response - " + result);

            if (result == null) {

                mTextViewResult.setText(errorString);
            } else {

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
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
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

    private void showResult() {

        String TAG_JSON = "shadow98a";
        String TAG_STUDENTID = "StudentID";
        String TAG_PWD = "Pwd";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);

                String StudentID = item.getString(TAG_STUDENTID);
                String Pwd = item.getString(TAG_PWD);

                if (StudentID.equals(this.StudentID) && Pwd.equals(this.Pwd)) {
                    Intent intent = new Intent(getApplicationContext(), SelectPath1.class);
                    intent.putExtra("StudentID", StudentID);
                    startActivity(intent);
                    return;
                }
            }
            mTextViewResult.setText("학번 또는 비밀번호를 다시 확인하세요.\n" +
                    "YA, TA!에 등록되지 않은 학번이거나, 학번 또는 비밀번호를 잘못 입력하셨습니다.");
        } catch (JSONException e) {
            Log.d(TAG, "showResult : ", e);
        }
    }
}
