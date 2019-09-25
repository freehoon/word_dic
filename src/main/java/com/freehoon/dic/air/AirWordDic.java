package com.freehoon.dic.air;

import com.freehoon.dic.WordDic;

import java.util.List;

public class AirWordDic<T> implements WordDic<T> {
    @Override
    public void dic() {

    }

    @Override
    public void insertWord(List<T> list) {
        System.out.println("Air list... : " + list);
    }

}
