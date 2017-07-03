package com.example.horoo.moamoa.Login;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.*;

import com.example.horoo.moamoa.R;


public class LoginActivity extends AppCompatActivity {

    EditText idInput, passwordInput;
    Button loginBtn, signUpBtn;
    CheckBox autoLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idInput = (EditText) findViewById(R.id.idInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);

        loginBtn = (Button) findViewById((R.id.loginButton));
        signUpBtn = (Button) findViewById((R.id.signupButton));

        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
            }
        });

    }


}
