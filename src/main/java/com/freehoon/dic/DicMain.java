package com.freehoon.dic;

import com.freehoon.dic.air.controller.AirController;
import com.freehoon.dic.goes.controller.GoesController;
import com.freehoon.dic.ltg.controller.LtgController;
import com.freehoon.dic.nikl.controller.NiklController;

import java.util.Scanner;

public class DicMain {
    public static void main(String[] args) {

        //System.out.println(args.length);
        System.out.println("번호를 선택해 주세요.\n 1.기상위성용어집 등록\n 2.레이더-낙뢰DB용어 등록\n 3.대기과학용어 등록\n 4.국립국어원자료 등록\n 5.종료");
        Scanner input = new Scanner(System.in);

        int no = Integer.parseInt(input.nextLine());
        input(no);

        /*
        while(input.hasNextLine()) {
            System.out.println("입력한 번호 : " + no);

            if (no >= 6 || no < 1) {
                System.out.println("1-5 사이의 숫자를 입력해 주세요");
                no = Integer.parseInt(input.nextLine());
            } else {
                switch (no) {
                    case 1:     // 기상위성용어집
                        GoesController goes = new GoesController();
                        goes.goesMain();
                        break;
                    case 2:     //레이더-낙뢰DB용어
                        LtgController ltg = new LtgController();
                        ltg.ltgMain();
                        break;
                    case 3:     //대기과학용어
                        AirController air = new AirController();
                        air.airMain();
                        break;
                    case 4:     //국립국어원 자료
                        NiklController nikl = new NiklController();
                        nikl.niklMain();
                        break;
                    case 5:
                        System.out.println("종료합니다.");
                        return;
                }
            }
        }
        */
        //대기과학용어집
        //AirController air = new AirController();
        //air.airMain();

        //기상위성용어집
        //GoesController goes = new GoesController();
        //goes.goesMain();

        //레이더-낙뢰DB용어
        //LtgController ltg = new LtgController();
        //ltg.ltgMain();

        //국립국어원자료
        //NiklController nikl = new NiklController();
        //nikl.niklMain();

        //WordDic niklWordDic = new NiklWordDic();
        //niklWordDic.dic();
/*
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
 */
    }

    public static void input(int no){
        boolean co = true;

        if (no >= 6 || no < 1 ) {
            System.out.println("1-5 사이의 숫자를 입력해 주세요");
        } else {
            switch (no) {
                case 1:     // 기상위성용어집
                    System.out.println("기상위성용어집.");
                    //GoesController goes = new GoesController();
                    //goes.goesMain();
                    break;
                case 2:     //레이더-낙뢰DB용어
                    System.out.println("레이더-낙뢰DB용어.");
                    //LtgController ltg = new LtgController();
                    //ltg.ltgMain();
                    break;
                case 3:     //대기과학용어
                    System.out.println("대기과학용어.");
                    //AirController air = new AirController();
                    //air.airMain();
                    break;
                case 4:     //국립국어원 자료
                    System.out.println("국립국어원.");
                    //NiklController nikl = new NiklController();
                    //nikl.niklMain();
                    break;
                case 5:
                    System.out.println("종료합니다.");
                    return;
            }
            Scanner input = new Scanner(System.in);
            String strNo = input.nextLine();
            if(strNo == null || strNo.equals("")) strNo = "5";
            input(Integer.parseInt(strNo));
        }

    }

}
