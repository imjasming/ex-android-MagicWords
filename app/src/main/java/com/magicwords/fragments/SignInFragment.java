package com.magicwords.fragments;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.magicwords.R;
import com.magicwords.model.User;
import com.magicwords.model.UserClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

public class SignInFragment extends BaseBackFragment {

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

    public SignInFragment(){}

    public static SignInFragment newInstance() {

        Bundle args = new Bundle();

        SignInFragment fragment = new SignInFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.bind(this, v);

        mLoginButton.setOnClickListener((View v1) -> {
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

                //Toast.makeText(getContext(), "",Toast.LENGTH_LONG).show();

                UserClient client = UserClient.getInstance().init(new User(username));
                SupportFragment fragment = findFragment(HomeFragment.class);
                if (fragment == null) {
                    replaceFragment(HomeFragment.newInstance(), false);
                }else {
                    popTo(HomeFragment.class, false);
                }
            }
        });
        mRegisterButton.setOnClickListener((View v1) -> start(SignUpFragment.newInstance()));

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.login);
        /*initToolbarNav(toolbar);*/

        return v;
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        hideSoftInput();
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