package com.magicwords.model;

import android.support.annotation.NonNull;

import java.util.UUID;


public class User {
    private UUID mUUID;
    private String mNickName;
    private String mPassword;
    private String mEmail;
    //private int mTelNum;

    public User(UUID uuid, String password){
        mUUID = uuid;
        mPassword = password;
    }

    public User(UUID uuid, String nickName, String password, String email){
        mUUID = uuid;
        mNickName = nickName;
        mPassword = password;
        mEmail = email;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String nickName) {
        mNickName = nickName;
    }

//    public int getTelNum() {
//        return mTelNum;
//    }
//
//    public void setTelNum(int telNum) {
//        this.mTelNum = telNum;
//    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @NonNull
    @Override
    public String toString() {
        return mNickName;
    }
}
