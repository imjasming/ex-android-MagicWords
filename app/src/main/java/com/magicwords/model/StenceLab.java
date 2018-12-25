package com.magicwords.model;

import java.util.ArrayList;

public class StenceLab {
    private static StenceLab sWordsLab;
    private static ArrayList<StenceBean> sWordBeanArrayList;

    private StenceLab(){
        sWordBeanArrayList = new ArrayList<>();
    }

    public static StenceLab getInstance(){
        if (sWordsLab == null){
            sWordsLab = new StenceLab();
        }

        return sWordsLab;
    }

    public StenceBean get(int i){
        return sWordBeanArrayList.get(i);
    }

    public int getLen(){
        return sWordBeanArrayList.size();
    }

    public void set(int i, StenceBean v){
        sWordBeanArrayList.set(i, v);
    }

    public void add(StenceBean v){
        sWordBeanArrayList.add(v);
    }

    public void init(ArrayList<StenceBean> list){
        sWordBeanArrayList.addAll(list);
    }
}
