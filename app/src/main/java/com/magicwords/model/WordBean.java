package com.magicwords.model;

public class WordBean {
    private String word;
    private String symble;
    private String mean;
    private String sample;

    public WordBean(String word, String symble, String mean, String sample) {
        this.word = word;
        this.symble = symble;
        this.mean = mean;
        this.sample = sample;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSymble() {
        return symble;
    }

    public void setSymble(String symble) {
        this.symble = symble;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        return word + symble + mean + sample;
    }
}