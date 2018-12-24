package com.magicwords.model;

import java.util.ArrayList;

public class WordsLab {
    private static WordsLab sWordsLab;
    private static ArrayList<WordBean> sWordBeanArrayList;

    private WordsLab(){
        sWordBeanArrayList = new ArrayList<>();
    }

    public static WordsLab getInstance(){
        if (sWordsLab == null){
            sWordsLab = new WordsLab();
        }

        return sWordsLab;
    }

    public WordBean get(int i){
        return sWordBeanArrayList.get(i);
    }

    public int getLen(){
        return sWordBeanArrayList.size();
    }

    public void set(int i, WordBean v){
        sWordBeanArrayList.set(i, v);
    }

    public void add(WordBean v){
        sWordBeanArrayList.add(v);
    }

    public void init(ArrayList<WordBean> list){
        sWordBeanArrayList.addAll(list);
    }
}
