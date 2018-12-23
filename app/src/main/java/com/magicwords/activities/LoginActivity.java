package com.magicwords.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.magicwords.net.RestClient;
import com.magicwords.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edt_login_username)
    TextInputEditText mName;
    @BindView(R.id.edt_login_password)
    TextInputEditText mPassword;
    @BindView(R.id.btn_login_login)
    Button mLoginButton;
    @BindView(R.id.btn_login_register)
    Button mRegisterButton;
    @BindView(R.id.btn_login_forget)
    Button mForgetButton;

    private String username;
    private String password;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mLoginButton.setOnClickListener((View v) -> {
            if (checkForm()){
                /*RestClient.builder()
                        .url("/signin")
                        .params("username", username)
                        .params("password", password)
                        .success(response -> {
                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(this, response,Toast.LENGTH_LONG).show();
                            this.finish();
                        })
                        .failure(response -> {
                            response.printStackTrace();
                            Toast.makeText(this, response.toString(),Toast.LENGTH_LONG).show();
                        })
                        .error((code, msg) -> {
                            Toast.makeText(this, "用户名或密码输入错误",Toast.LENGTH_LONG).show();
                        })
                        .build()
                        .post();*/

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "test",Toast.LENGTH_LONG).show();
                this.finish();
            }
        });
        mRegisterButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);
        });
    }

    private boolean checkForm() {
        username = mName.getText().toString();
        password = mPassword.getText().toString();

        boolean isPass = true;
        if (username.isEmpty()) {
            mName.setError("请输用户名");
            isPass = false;
        } else {
            mName.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请输入至少六位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        return isPass;
    }
}