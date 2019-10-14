package com.example.edusoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button loginBtn;
    private TextView forgotPwdTxt;
    private TextView signUpTxt;
    private EditText userEmail;
    private EditText userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn  = findViewById(R.id.loginBtn);
        forgotPwdTxt = findViewById(R.id.forgotPwdText);
        signUpTxt = findViewById(R.id.signUpTxt);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPwd);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        signUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        forgotPwdTxt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPwActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        /* id=admin pw=admin */
        if((!TextUtils.isEmpty(userEmail.getText()) && !TextUtils.isEmpty(userPassword.getText())) && userEmail.getText().toString().equals("admin") && userPassword.getText().toString().equals("admin") ){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Please fill all the required fields",Toast.LENGTH_SHORT).show();
        }
    }
}
