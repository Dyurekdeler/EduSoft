package com.example.edusoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;



public class MainActivity extends AppCompatActivity {
    private Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* login butonuna click için login ekranına gitme fonk bağlanıyor */
       loginbtn  = findViewById(R.id.getStartedBtn);
       loginbtn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               launchActivity();
           }
       });

    }

    private  void launchActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
