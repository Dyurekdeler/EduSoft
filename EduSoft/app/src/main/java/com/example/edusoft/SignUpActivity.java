package com.example.edusoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private CheckBox showPwdCheckBox;
    private EditText userPwd;
    private EditText userEmail;
    private Button signUpButton;
    private ProgressBar mProgressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        showPwdCheckBox = findViewById(R.id.showPwdCheckBox);
        userPwd = findViewById(R.id.signUpUserPwd);
        userEmail = findViewById(R.id.signUpUserEmail);
        signUpButton = findViewById(R.id.signUpButton);
        mProgressBar = findViewById(R.id.signUpProgress);

        showPwdCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    userPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    userPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());;
                }
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                if(!TextUtils.isEmpty(userEmail.getText().toString()) && !TextUtils.isEmpty(userPwd.getText().toString())) {
                    mAuth.createUserWithEmailAndPassword(userEmail.getText().toString(), userPwd.getText().toString())
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        mProgressBar.setVisibility(View.GONE);
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("userTag", "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(getApplicationContext(), "Failure", Toast.LENGTH_SHORT).show();
                                    }
                                    // ...
                                }
                            });
                }else{
                    Toast.makeText(getApplicationContext(),"Empty fields are not allowed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
