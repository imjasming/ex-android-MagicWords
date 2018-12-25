package com.magicwords.model;

public class StenceBean {
    private String word;
    private String stence;
    private int id;
    private String title;

    public StenceBean(int id,String title,String stence, String word) {
        this.word = word;
        this.stence=stence;
        this.id=id;
        this.title=title;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void settitle(){this.title=title;}
    public String gettitle(){return title;}
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
    public String getStence() {
        return stence;
    }

    public void setStence(String Stence) {
        this.stence = stence;
    }


    @Override
    public String toString() {
        return stence +"\n"+ word ;
    }

    public String toString1(){
        return stence;
    }
    public String toString2(){
        return word;
    }
    public int toint(){
        return id;
    }
    public String totitle(){
        return title;
    }
}
