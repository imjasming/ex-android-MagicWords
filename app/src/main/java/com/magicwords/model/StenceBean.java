package com.magicwords.model;

public class StenceBean {
    private String word;
    private String stence;
    private int id;

    public StenceBean(String stence, String word) {
        this.word = word;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

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
        return stence + '\n' + word ;
    }
}
