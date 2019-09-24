package com.freehoon.dic.goes.vo;

import com.freehoon.dic.air.vo.AirVO;
import com.freehoon.dic.dbConnect.DBConnect;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoesController {

    public void goesMain(){
        try{
            FileInputStream xlsxFile = new FileInputStream("D:\\기상용어검색 관련 자료\\goes.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);

            XSSFSheet sheet = null;
            for (int i = 0 ; i < workbook.getNumberOfSheets() ; i++ ){
                sheet = workbook.getSheetAt(i);

                List<GoesVO> list = new ArrayList<GoesVO>();

                //로우의 수 확인
                int rows = sheet.getPhysicalNumberOfRows();
                for(int j=0 ; j<rows ; j++){
                    XSSFRow row = sheet.getRow(j);
                    if(row != null){
                        //셀의 수 확인
                        GoesVO goesVO = new GoesVO();
                        int cells = row.getPhysicalNumberOfCells();

                        String dataNm = row.getCell(0).getStringCellValue().replace("\'", "\\\'");
                        String dataDesc = row.getCell(1).getStringCellValue().replace("\'", "\\\'");

                        goesVO.setDataNm(dataNm);
                        goesVO.setDataDesc(dataDesc);

                        list.add(goesVO);
                    }
                } //rows 읽기
                insertGoesData(list);
            }//sheet 끝
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertGoesData(List<GoesVO> list){
        System.out.println("Goes Data Insert start...");

        DBConnect dbCon = new DBConnect();

        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TB_GOES_WORD (DATA_NM, DATA_DESC) VALUES");
        Iterator iterator = list.iterator();

        int cnt=0;
        while(iterator.hasNext()) {
            GoesVO goesVO = (GoesVO) iterator.next();
            query.append("('" + goesVO.getDataNm() + "','" +goesVO.getDataDesc() + "')");

            cnt++;

            if(cnt == 4999 || !iterator.hasNext()){
                query.append(";");
                //System.out.println(query);
                dbCon.insertData(query.toString());

                query.setLength(0);
                query.append("INSERT INTO TB_Goes_WORD (DATA_NM, DATA_DESC) VALUES");
                cnt=0;

            } else {
                query.append(",");
            }
        }

    }
}
