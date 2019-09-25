package com.freehoon.dic.ltg;

import com.freehoon.dic.WordDic;
import com.freehoon.dic.ltg.vo.LtgVO;

import java.util.ArrayList;
import java.util.List;

public class LtgWordDic<LtgVO> implements WordDic<LtgVO> {
    @Override
    public void dic(){
        List<LtgVO> ltgList = new ArrayList<LtgVO>();
        System.out.println(("Ltg dic..."));
        insertWord((List<LtgVO>) ltgList);
    }

    @Override
    public void insertWord(List<LtgVO> list){
        System.out.println("Ltg list... : " + list);
    }
}
