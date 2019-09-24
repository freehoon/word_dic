package com.freehoon.dic;

import com.freehoon.dic.air.controller.AirController;
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

        WordDic wd = new NiklWordDic();
        wd.dic();

        wd = new LtgWordDic();
        wd.dic();

    }
}
