package com.freehoon.dic;

import com.freehoon.dic.air.controller.AirController;
import com.freehoon.dic.goes.vo.GoesController;
import com.freehoon.dic.goes.vo.GoesVO;
import com.freehoon.dic.ltg.controller.LtgController;
import com.freehoon.dic.nikl.controller.NiklController;

public class DicMain {
    public static void main(String[] args) {
        //AirController air = new AirController();
        //air.airMain();

        //GoesController goes = new GoesController();
        //goes.goesMain();

        //LtgController ltg = new LtgController();
        //ltg.ltgMain();

        NiklController nikl = new NiklController();
        nikl.niklMain();
    }
}
