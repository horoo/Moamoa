package com.example.horoo.moamoa.Join;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.horoo.moamoa.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class JoinActivity extends AppCompatActivity {
    private String password;
    private String name;
    private String phone;
    EditText Name, Phone, Password, Password_conf;
    final String TAG = "httptransfer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Button join_button = (Button)findViewById(R.id.Join_Button);
        Name = (EditText)findViewById(R.id.Input_name);
        Phone = (EditText)findViewById(R.id.Input_phone);
        Password = (EditText)findViewById(R.id.Input_phone);
        Password_conf = (EditText)findViewById(R.id.Input_password_conf);

        join_button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Handler handler = new Handler();
                password = Password.getText().toString();
                name = Name.getText().toString();
                phone = Phone.getText().toString();

                if(!(password.equals(Password_conf.getText().toString())))
                    Toast.makeText(JoinActivity.this, "비밀번호와 비밀번호 확인이 같지 않습니다.", Toast.LENGTH_SHORT).show();
                // TODO 약관 만드는거????
                else{
                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            // 새로운 아이디르 만들 때 서버에 정보를 보내는 부분이다.
                            HttpClient httpClient = new DefaultHttpClient();

                            String urlString = "http://" +getResources().getString(R.string.host)+":3000/newaccount/";
                            try {
                                URI url = new URI(urlString);

                                HttpPost httpPost = new HttpPost();
                                httpPost.setURI(url);
                                Log.d(TAG, urlString);
                                List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>(3);
                                nameValuePairs.add(new BasicNameValuePair("phone", String.valueOf(phone)));
                                nameValuePairs.add(new BasicNameValuePair("password", String.valueOf(password)));
                                nameValuePairs.add(new BasicNameValuePair("name", String.valueOf(name)));

                                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8));

                                HttpResponse response = httpClient.execute(httpPost);
                                String responseString = EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
                                Log.d(TAG, responseString);
                                if (responseString.equals("NO")) {
                                    handler.post(new Runnable() {
                                        public void run(){
                                            Toast.makeText(JoinActivity.this, "동일한 이메일이 존재 합니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                                else{
                                    Toast.makeText(JoinActivity.this, "회원 가입 완료!", Toast.LENGTH_SHORT).show();

                                }
                            } catch (URISyntaxException e) {
                                Log.e(TAG, e.getLocalizedMessage());
                                e.printStackTrace();
                            } catch (ClientProtocolException e) {
                                Log.e(TAG, e.getLocalizedMessage());
                                e.printStackTrace();
                            } catch (IOException e) {
                                Log.e(TAG, e.getLocalizedMessage());
                                handler.post(new Runnable() {
                                    public void run() {
                                        Toast.makeText(JoinActivity.this, "서버 문제로 아이디 생성에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                e.printStackTrace();
                            }

                        }
                    };
                    thread.start();
                    finish();
                }

            }
        });
    }
}
