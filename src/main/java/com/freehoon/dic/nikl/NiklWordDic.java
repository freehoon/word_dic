package com.freehoon.dic.nikl;

import com.freehoon.dic.WordDic;
import com.freehoon.dic.nikl.vo.NiklVO;

import java.util.ArrayList;
import java.util.List;

public class NiklWordDic<T> implements WordDic<T> {

    @Override
    public void dic() {
        List<NiklVO> niklList = new ArrayList<NiklVO>();
        System.out.println(("Nikl dic..."));
        insertWord((List<T>) niklList);
    }

    @Override
    public void insertWord(List<T> list) {
        List<NiklVO> niklList = (List<NiklVO>) list;
        System.out.println(("Nikl list..."));
    }
}
