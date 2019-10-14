package com.example.edusoft;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;


public class ForgotPwActivity extends AppCompatActivity {

    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pw);

        reset = findViewById(R.id.forgotPwBtn);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Reset password e-mail has been sent.",Toast.LENGTH_SHORT).show();
                ForgotPwActivity.this.finish();
            }
        });
    }

}
