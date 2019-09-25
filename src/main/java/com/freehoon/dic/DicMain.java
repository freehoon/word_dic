package com.freehoon.dic;

import com.freehoon.dic.air.AirWordDic;
import com.freehoon.dic.air.controller.AirController;
import com.freehoon.dic.air.vo.AirVO;
import com.freehoon.dic.goes.vo.GoesController;
import com.freehoon.dic.goes.vo.GoesVO;
import com.freehoon.dic.ltg.LtgWordDic;
import com.freehoon.dic.ltg.controller.LtgController;
import com.freehoon.dic.ltg.vo.LtgVO;
import com.freehoon.dic.nikl.NiklWordDic;
import com.freehoon.dic.nikl.controller.NiklController;
import com.freehoon.dic.nikl.vo.NiklVO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DicMain {
    public static void main(String[] args) {
        //AirController air = new AirController();
        //air.airMain();

        //GoesController goes = new GoesController();
        //goes.goesMain();

        //LtgController ltg = new LtgController();
        //ltg.ltgMain();

        //NiklController nikl = new NiklController();
        //nikl.niklMain();

        WordDic niklWordDic = new NiklWordDic();
        niklWordDic.dic();

        WordDic ltgWordDic = new LtgWordDic();
        List<LtgVO> ltgList = new ArrayList<LtgVO>();
        LtgVO ltgVO = new LtgVO();
        ltgVO.setAbbr("1111");
        ltgVO.setDataCls("1111");
        ltgVO.setDataKr("1111");
        ltgList.add(ltgVO);
        ltgWordDic.insertWord(ltgList);

        WordDic airWordDic = new AirWordDic<AirVO>();
        List<AirVO> airList = new ArrayList<AirVO>();
        AirVO airVO = new AirVO();
        airVO.setDataCn("2222");
        airVO.setDataKo("2222");
        airVO.setDataDesc("2222");
        airVO.setDataEn("2222");
        airVO.setDataId("2222");
        airList.add(airVO);

        airWordDic.insertWord(airList);
    }
}
