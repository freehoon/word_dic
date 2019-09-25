package com.freehoon.dic.nikl;

import com.freehoon.dic.WordDic;
import com.freehoon.dic.nikl.vo.NiklVO;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

public class NiklWordDic<NiklVO> implements WordDic<NiklVO> {

    @Override
    public void dic() {
        List<NiklVO> niklList = new ArrayList<NiklVO>();
        System.out.println("Nikl dic...");

        insertWord((List<NiklVO>) niklList);
    }

    @Override
    public void insertWord(List<NiklVO> list) {
        List<NiklVO> niklList = (List<NiklVO>) list;
        System.out.println(("Nikl list..."));
    }
}
