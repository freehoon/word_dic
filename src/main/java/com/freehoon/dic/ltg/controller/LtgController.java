package com.freehoon.dic.ltg.controller;

import com.freehoon.dic.dbConnect.DBConnect;
import com.freehoon.dic.ltg.vo.LtgVO;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LtgController {
    public void ltgMain(String fileName){
        try{
            FileInputStream xlsxFile = new FileInputStream("D:\\기상용어검색 관련 자료\\" + fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);

            XSSFSheet sheet = null;
            for (int i = 0 ; i < workbook.getNumberOfSheets() ; i++ ){
                sheet = workbook.getSheetAt(i);

                List<LtgVO> list = new ArrayList<LtgVO>();

                //로우의 수 확인
                int rows = sheet.getPhysicalNumberOfRows();
                for(int j=1 ; j<rows ; j++){    //ltg 파일 첫 줄은 헤더이다.
                    XSSFRow row = sheet.getRow(j);
                    if(row != null){
                        //셀의 수 확인
                        LtgVO ltgVO = new LtgVO();
                        int cells = row.getPhysicalNumberOfCells();

                        String dataDesc = row.getCell(3).getStringCellValue().replace("\'", "\\\'");

                        ltgVO.setAbbr(row.getCell(0).getStringCellValue());
                        ltgVO.setDataKr(row.getCell(1).getStringCellValue());
                        ltgVO.setDataEn(row.getCell(2).getStringCellValue());
                        ltgVO.setDataDesc(dataDesc);
                        ltgVO.setDataCls(row.getCell(4).getStringCellValue());

                        list.add(ltgVO);
                    }
                } //rows 읽기
                insertLtgData(list);
            }//sheet 끝
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertLtgData(List<LtgVO> list){
        System.out.println("Ltg Data Insert start...");

        DBConnect dbCon = new DBConnect();

        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TB_LTG_WORD (ABBR, DATA_KR, DATA_EN, DATA_DESC, DATA_CLS) VALUES");
        Iterator iterator = list.iterator();

        int cnt=0;
        while(iterator.hasNext()) {
            LtgVO ltgVO = (LtgVO) iterator.next();
            query.append("('" + ltgVO.getAbbr() + "','" + ltgVO.getDataKr() + "','" + ltgVO.getDataEn() + "','" + ltgVO.getDataDesc() + "','" + ltgVO.getDataCls() + "')");

            cnt++;

            if(cnt == 4999 || !iterator.hasNext()){
                query.append(";");
                //System.out.println(query);
                dbCon.insertData(query.toString());

                query.setLength(0);
                query.append("INSERT INTO TB_LTG_WORD (ABBR, DATA_KR, DATA_EN, DATA_DESC, DATA_CLS) VALUES");
                cnt=0;

            } else {
                query.append(",");
            }
        }

    }
}
