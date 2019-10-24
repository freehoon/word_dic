package com.freehoon.dic.air.controller;

import com.freehoon.dic.dbConnect.DBConnect;

import com.freehoon.dic.air.vo.AirVO;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AirController {

    public void airMain(String fileName){
        try{
            FileInputStream xlsxFile = new FileInputStream("D:\\기상용어검색 관련 자료\\" + fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);

            XSSFSheet sheet = null;
            for (int i = 0 ; i < workbook.getNumberOfSheets() ; i++ ){
                sheet = workbook.getSheetAt(i);

                List<AirVO> list = new ArrayList<AirVO>();

                //로우의 수 확인
                int rows = sheet.getPhysicalNumberOfRows();
                for(int j=0 ; j<rows ; j++){
                    XSSFRow row = sheet.getRow(j);
                    if(row != null){
                        //셀의 수 확인
                        AirVO airVO = new AirVO();
                        int cells = row.getPhysicalNumberOfCells();

                        String dataEn = row.getCell(2).getStringCellValue().replace("\'", "\\\'");
                        String dataDesc = row.getCell(4).getStringCellValue().replace("\'", "\\\'");

                        airVO.setDataKo(row.getCell(1).getStringCellValue());
                        airVO.setDataEn(dataEn);
                        airVO.setDataCn(row.getCell(3).getStringCellValue());
                        airVO.setDataDesc(dataDesc);


                        list.add(airVO);
                    }
                } //rows 읽기
                insertAirData(list);
            }//sheet 끝
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertAirData(List<AirVO> list){
        System.out.println("Air Data Insert start...");

        DBConnect dbCon = new DBConnect();

        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TB_AIR_WORD (DATA_KR, DATA_EN, DATA_CN, DATA_DESC) VALUES");
        Iterator iterator = list.iterator();

        int cnt=0;
        while(iterator.hasNext()) {
            AirVO airVO = (AirVO) iterator.next();
            query.append("('" + airVO.getDataKo() + "','" + airVO.getDataEn() + "','" + airVO.getDataCn() + "','" + airVO.getDataDesc() + "')");

            cnt++;

            if(cnt == 4999 || !iterator.hasNext()){
                query.append(";");
                System.out.println(query);
                dbCon.insertData(query.toString());

                query.setLength(0);
                query.append("INSERT INTO TB_AIR_WORD (DATA_KR, DATA_EN, DATA_CN, DATA_DESC) VALUES");
                cnt=0;


            } else {
                query.append(",");
            }
        }



    }
}
