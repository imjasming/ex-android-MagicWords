package com.magicwords.fragments;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.magicwords.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpFragment extends BaseBackFragment {

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

    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return a new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, v);

        mConfirm.setOnClickListener(v1 -> {
            if (checkForm()) {
                /*RestClient.builder()
                        .url("/signup")
                        .params("username", username)
                        .params("email", email)
                        .params("password", password)
                        .success(response -> {
                            Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                        })
                        .error((code, msg) -> {
                            Toast.makeText(getContext(), "注册失败", Toast.LENGTH_LONG).show();
                        })
                        .build()
                        .post();*/
                Toast.makeText(getContext(), "test", Toast.LENGTH_LONG).show();
                pop();
            }
        });

        mBack.setOnClickListener(e -> pop());

        Toolbar toolbar = v.findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.register);
        initToolbarNav(toolbar);

        return v;
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        hideSoftInput();
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
}
