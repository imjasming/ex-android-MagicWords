package com.magicwords.model;

import java.util.ArrayList;

public class Stence1Lab {
    private static Stence1Lab sWordsLab;
    private static ArrayList<Stence1Bean> sWordBeanArrayList;

    private Stence1Lab(){
        sWordBeanArrayList = new ArrayList<>();
    }

    public static Stence1Lab getInstance(){
        if (sWordsLab == null){
            sWordsLab = new Stence1Lab();
        }

        return sWordsLab;
    }

    public Stence1Bean get(int i){
        return sWordBeanArrayList.get(i);
    }

    public int getLen(){
        return sWordBeanArrayList.size();
    }

    public void set(int i, Stence1Bean v){
        sWordBeanArrayList.set(i, v);
    }

    public void add(Stence1Bean v){
        sWordBeanArrayList.add(v);
    }

    public void init(ArrayList<Stence1Bean> list){
        sWordBeanArrayList.addAll(list);
    }
}
