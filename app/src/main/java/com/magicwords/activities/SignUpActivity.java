package com.magicwords.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;

import com.magicwords.R;
import com.magicwords.net.RestClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.edt_register_username)
    TextInputEditText mName;
    @BindView(R.id.edt_register_email)
    TextInputEditText mEmail;
    @BindView(R.id.edt_register_password)
    TextInputEditText mPassword;
    @BindView(R.id.edt_register_password_2)
    TextInputEditText mPassword2;
    @BindView(R.id.btn_register_confirm)
    Button mConfirm;
    @BindView(R.id.btn_register_back)
    Button mBack;

    private String username;
    private String password;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mConfirm.setOnClickListener(v -> {
            if (checkForm()) {
                RestClient.builder()
                        .url("/signup")
                        .params("username", username)
                        .params("email", email)
                        .params("password", password)
                        .success(response -> {
                            Toast.makeText(this, response, Toast.LENGTH_LONG).show();
                            this.finish();
                        })
                        .error((code, msg) -> {
                            Toast.makeText(this, "注册失败", Toast.LENGTH_LONG).show();
                        })
                        .build()
                        .post();

            }
        });

        mBack.setOnClickListener(e -> onBack());
    }

    private boolean checkForm() {
        username = mName.getText().toString();
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();
        final String reRassword = mPassword2.getText().toString();
        boolean isPass = true;
        if (username.isEmpty()) {
            mName.setError("请输用户名");
            isPass = false;
        } else {
            mName.setError(null);
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
        } else {
            mEmail.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请输入至少六位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        if (reRassword.isEmpty() || reRassword.length() < 6 || !reRassword.equals(password)) {
            mPassword2.setError("密码验证错误");
            isPass = false;
        } else {
            mPassword2.setError(null);
        }
        return isPass;
    }

    private void onBack() {
        this.finish();
    }
}
