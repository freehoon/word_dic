package com.freehoon.dic;

import com.freehoon.dic.air.controller.AirController;
import com.freehoon.dic.goes.controller.GoesController;
import com.freehoon.dic.ltg.controller.LtgController;
import com.freehoon.dic.nikl.controller.NiklController;

import java.util.Scanner;

public class DicMain {
    public static void main(String[] args) {

        System.out.println("번호를 선택해 주세요.\n 1.기상위성용어집 등록\n 2.레이더-낙뢰DB용어 등록\n 3.대기과학용어 등록\n 4.국립국어원자료 등록\n 5.종료");
        Scanner input = new Scanner(System.in);

        int no = Integer.parseInt(input.nextLine());
        input(no);

    }

    public static void input(int no){
        Scanner input = new Scanner(System.in);
        String fileName = "";

        if (no >= 6 || no < 1 ) {
            System.out.println("1-5 사이의 숫자를 입력해 주세요");
        } else {
            switch (no) {
                case 1:     // 기상위성용어집
                    System.out.println("기상위성용어집 파일명을 입력해 주세요.");
                    fileName = input.nextLine();
                    GoesController goes = new GoesController();
                    goes.goesMain(fileName);
                    break;
                case 2:     //레이더-낙뢰DB용어
                    System.out.println("레이더-낙뢰DB용어 파일명을 입력해 주세요.");
                    fileName = input.nextLine();
                    LtgController ltg = new LtgController();
                    ltg.ltgMain(fileName);
                    break;
                case 3:     //대기과학용어
                    System.out.println("대기과학용어 파일명을 입력해 주세요.");
                    fileName = input.nextLine();
                    AirController air = new AirController();
                    air.airMain(fileName);
                    break;
                case 4:     //국립국어원 자료
                    System.out.println("국립국어원.");
                    fileName = input.nextLine();
                    NiklController nikl = new NiklController();
                    nikl.niklMain(fileName);
                    break;
                case 5:
                    System.out.println("종료합니다.");
                    return;
            }

            String strNo = input.nextLine();
            if(strNo == null || strNo.equals("")) strNo = "5";
            input(Integer.parseInt(strNo));
        }

    }

}
