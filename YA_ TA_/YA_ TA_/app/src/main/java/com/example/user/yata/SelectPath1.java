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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SelectPath1 extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_path1);
        Intent getterIntent=getIntent();
        final String StudentID=getterIntent.getStringExtra("StudentID").toString();
        root1 = (Button)findViewById(R.id.root1);
        root1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "1");
                                intent.putExtra("Path",StudentID);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "2");
                                intent.putExtra("Path",StudentID);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "3");
                                intent.putExtra("Path",StudentID);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "4");
                                intent.putExtra("Path",StudentID);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "5");
                                intent.putExtra("Path",StudentID);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "6");
                                intent.putExtra("Path",StudentID);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "7");
                                intent.putExtra("Path",StudentID);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(SelectPath1.this);
                builder.setMessage("현금 1000원! 준비하셨나요?");
                builder.setTitle("※ 확인 ※")
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(SelectPath1.this, SelectPath2.class);
                                InsertData task = new InsertData();
                                task.execute("http://" + IP_ADDRESS + "/requestinsert.php", StudentID, "8");
                                intent.putExtra("Path",StudentID);
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
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(SelectPath1.this,
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
}
