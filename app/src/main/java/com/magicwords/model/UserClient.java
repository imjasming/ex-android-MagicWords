package com.magicwords.model;

public class UserClient {
    private String mNickName = "chenjian";
    private String mPassword = "123456";
    private String mEmail;
    private int level = 1;

    private static UserClient instance;

    private UserClient(){}

    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String nickName) {
        mNickName = nickName;
    }

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static UserClient getInstance() {
        if (instance == null){
            instance = new UserClient();
        }
        return instance;
    }

    public static void setInstance(UserClient instance) {
        UserClient.instance = instance;
    }

    public UserClient init(User u){
        this.mNickName = u.getNickName();
        return this;
    }
}
