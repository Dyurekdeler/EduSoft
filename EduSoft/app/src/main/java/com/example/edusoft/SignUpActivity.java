package com.example.edusoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    private CheckBox showPwdCheckBox;
    private EditText userPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        showPwdCheckBox = findViewById(R.id.showPwdCheckBox);
        userPwd = findViewById(R.id.signUpUserPwd);

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
    }
}
