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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListActivity extends AppCompatActivity {
    private static String IP_ADDRESS = "112.159.76.92";
    private static String TAG = "phptest";
    Button root1;
    Button root2;
    Button root3;
    Button root4;
    Button root5;
    Button root6;
    Button root7;
    Button root8;

    Button refresh;

    private String mJsonString;

    private String StudentID1;
    private String StudentID2;
    private String StudentID3;
    private String StudentID4;
    private String StudentID5;
    private String StudentID6;
    private String StudentID7;
    private String StudentID8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);
        Intent getterIntent=getIntent();
        final String StudentID=getterIntent.getStringExtra("StudentID").toString();
        root1 = (Button)findViewById(R.id.root1);
        root1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID1);
                                intent.putExtra("Path",StudentID1);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        root2 = (Button)findViewById(R.id.root2);
        root2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID2);
                                intent.putExtra("Path",StudentID2);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        root3 = (Button)findViewById(R.id.root3);
        root3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID3);
                                intent.putExtra("Path",StudentID3);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        root4 = (Button)findViewById(R.id.root4);
        root4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID4);
                                intent.putExtra("Path",StudentID4);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        root5 = (Button)findViewById(R.id.root5);
        root5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID5);
                                intent.putExtra("Path",StudentID5);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        root6 = (Button)findViewById(R.id.root6);
        root6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID6);
                                intent.putExtra("Path",StudentID6);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        root7 = (Button)findViewById(R.id.root7);
        root7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID7);
                                intent.putExtra("Path",StudentID7);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        root8 = (Button)findViewById(R.id.root8);
        root8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setMessage("이 경로가 확실하신가요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ListActivity.this, InformationForDriver2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/approvalinsert.php", StudentID, StudentID8);
                                intent.putExtra("Path",StudentID8);
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
                alert.setTitle("※ 확인 ※");
                alert.show();

            }
        });

        refresh = (Button)findViewById(R.id.button_main_all);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData task = new GetData();
                task.execute( "http://" + IP_ADDRESS + "/requestgetjson.php", "");
            }
        });
        
        GetData task = new GetData();
        task.execute( "http://" + IP_ADDRESS + "/requestgetjson.php", "");
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ListActivity.this,
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
            String Path = (String)params[2];

            String serverURL = (String)params[0];
            String postParameters = "StudentID=" + StudentID + "&Path=" + Path;


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
    

    

    private class GetData extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(ListActivity.this,
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
//        String TAG_ID = "id";
        String TAG_STUDENTID ="StudentID";
        String TAG_PATH ="Path";

        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
            root1.setEnabled(false);
            root1.setVisibility(View.INVISIBLE);
            root2.setEnabled(false);
            root2.setVisibility(View.INVISIBLE);
            root3.setEnabled(false);
            root3.setVisibility(View.INVISIBLE);
            root4.setEnabled(false);
            root4.setVisibility(View.INVISIBLE);
            root5.setEnabled(false);
            root5.setVisibility(View.INVISIBLE);
            root6.setEnabled(false);
            root6.setVisibility(View.INVISIBLE);
            root7.setEnabled(false);
            root7.setVisibility(View.INVISIBLE);
            root8.setEnabled(false);
            root8.setVisibility(View.INVISIBLE);

            for(int i=jsonArray.length()-1;i>=0;i--){

                JSONObject item = jsonArray.getJSONObject(i);


                String Path = item.getString(TAG_PATH);
                String StudentID=item.getString(TAG_STUDENTID);

                if(Path.equals("1"))
                {
                    root1.setEnabled(true);
                    root1.setVisibility(View.VISIBLE);
                    StudentID1=StudentID;
                }
                if(Path.equals("2"))
                {
                    root2.setEnabled(true);
                    root2.setVisibility(View.VISIBLE);
                    StudentID2=StudentID;
                }
                if(Path.equals("3"))
                {
                    root3.setEnabled(true);
                    root3.setVisibility(View.VISIBLE);
                    StudentID3=StudentID;
                }
                if(Path.equals("4"))
                {
                    root4.setEnabled(true);
                    root4.setVisibility(View.VISIBLE);
                    StudentID4=StudentID;
                }
                if(Path.equals("5"))
                {
                    root5.setEnabled(true);
                    root5.setVisibility(View.VISIBLE);
                    StudentID5=StudentID;
                }
                if(Path.equals("6"))
                {
                    root6.setEnabled(true);
                    root6.setVisibility(View.VISIBLE);
                    StudentID6=StudentID;
                }
                if(Path.equals("7"))
                {
                    root7.setEnabled(true);
                    root7.setVisibility(View.VISIBLE);
                    StudentID7=StudentID;
                }
                if(Path.equals("8"))
                {
                    root8.setEnabled(true);
                    root8.setVisibility(View.VISIBLE);
                    StudentID8=StudentID;
                }
            }
        } catch (JSONException e) {
            Log.d(TAG, "showResult : ", e);
        }
    }
}
