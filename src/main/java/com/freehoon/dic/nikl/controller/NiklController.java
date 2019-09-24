package com.freehoon.dic.nikl.controller;

import com.freehoon.dic.dbConnect.DBConnect;
import com.freehoon.dic.ltg.vo.LtgVO;
import com.freehoon.dic.nikl.vo.NiklVO;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NiklController {
    public void niklMain(){
        try{
            POIFSFileSystem fileSystem = new POIFSFileSystem(new FileInputStream(new File("D:\\기상용어검색 관련 자료\\국립국어원 자료\\525777_1124223.xls")));
            HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
            //FileInputStream xlsxFile = new FileInputStream("D:\\기상용어검색 관련 자료\\국립국어원 자료\\525777_50000.xls");
            //XSSFWorkbook workbook = new XSSFWorkbook(xlsxFile);

            HSSFSheet sheet = null;
            for (int i = 0 ; i < workbook.getNumberOfSheets() ; i++ ){
                sheet = workbook.getSheetAt(i);

                List<NiklVO> list = new ArrayList<NiklVO>();

                //로우의 수 확인
                int rows = sheet.getPhysicalNumberOfRows();
                for(int j=1 ; j<rows ; j++){
                    HSSFRow row = sheet.getRow(j);
                    if(row != null){
                        //셀의 수 확인
                        NiklVO niklVO = new NiklVO();
                        int cells = row.getPhysicalNumberOfCells();

                        niklVO.setDataNm(row.getCell(0).getStringCellValue());
                        niklVO.setDataUnit(row.getCell(1).getStringCellValue());
                        niklVO.setOrgnYn(row.getCell(2).getStringCellValue());
                        niklVO.setRomalpa(row.getCell(3).getStringCellValue());
                        niklVO.setRomalpaWord(row.getCell(4).getStringCellValue());
                        niklVO.setRomalpaSound(row.getCell(5).getStringCellValue());
                        niklVO.setOrgnWord(row.getCell(6).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setOrgnWord2(row.getCell(7).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setDataSound(row.getCell(8).getStringCellValue());
                        niklVO.setDataUse(row.getCell(9).getStringCellValue());
                        niklVO.setSrchType(row.getCell(10).getStringCellValue());
                        niklVO.setDataPatsph(row.getCell(11).getStringCellValue());
                        niklVO.setMeanNo(row.getCell(12).getStringCellValue());
                        niklVO.setDataMean(row.getCell(13).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setDataRegion(row.getCell(14).getStringCellValue());
                        niklVO.setDataFrm(row.getCell(15).getStringCellValue());
                        niklVO.setDataRule(row.getCell(16).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setDataEx(row.getCell(17).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setDataSpclt(row.getCell(18).getStringCellValue());
                        niklVO.setReldWord(row.getCell(19).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setProvb(row.getCell(20).getStringCellValue());
                        niklVO.setIdiom(row.getCell(21).getStringCellValue());
                        niklVO.setTargetWord(row.getCell(22).getStringCellValue());
                        niklVO.setClsInfo(row.getCell(23).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setHistInfo(row.getCell(24).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setHndyInfo(row.getCell(25).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setExcptInfo(row.getCell(26).getStringCellValue().replace("\'", "\\\'"));
                        niklVO.setMultiInfo(row.getCell(27).getStringCellValue().replace("\'", "\\\'"));

                        list.add(niklVO);
                    }
                } //rows 읽기
                insertNiklData(list);
            }//sheet 끝
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertNiklData(List<NiklVO> list){
        System.out.println("Nikl Data Insert start...");

        DBConnect dbCon = new DBConnect();

        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO TB_NIKL_WORD (DATA_NM, DATA_UNIT, ORGN_YN, ROMALPA, ROMALPA_WORD, ROMALPA_SOUND, ORGN_WORD, ORGN_WORD2, DATA_SOUND, DATA_USE, SRCH_TYPE, DATA_PATSPH, MEAN_NO, DATA_MEAN, DATA_REGION, DATA_FRM, DATA_RULE, DATA_EX, DATA_SPCLT, RELD_WORD, PROVB, IDIOM, TARGET_WORD, CLS_INFO, HIST_INFO, HNDY_INFO, EXCPT_INFO, MULTI_INFO) VALUES");
        Iterator iterator = list.iterator();

        int cnt=0;
        while(iterator.hasNext()) {
            NiklVO niklVO = (NiklVO) iterator.next();
            query.append("('" +
                    niklVO.getDataNm() + "','" +
                    niklVO.getDataUnit() + "','" +
                    niklVO.getOrgnYn() + "','" +
                    niklVO.getRomalpa() + "','" +
                    niklVO.getRomalpaWord() + "','" +
                    niklVO.getRomalpaSound() + "','" +
                    niklVO.getOrgnWord() + "','" +
                    niklVO.getOrgnWord2() + "','" +
                    niklVO.getDataSound() + "','" +
                    niklVO.getDataUse() + "','" +
                    niklVO.getSrchType() + "','" +
                    niklVO.getDataPatsph() + "','" +
                    niklVO.getMeanNo() + "','" +
                    niklVO.getDataMean() + "','" +
                    niklVO.getDataRegion() + "','" +
                    niklVO.getDataFrm() + "','" +
                    niklVO.getDataRule() + "','" +
                    niklVO.getDataEx() + "','" +
                    niklVO.getDataSpclt() + "','" +
                    niklVO.getReldWord() + "','" +
                    niklVO.getProvb() + "','" +
                    niklVO.getIdiom() + "','" +
                    niklVO.getTargetWord() + "','" +
                    niklVO.getClsInfo() + "','" +
                    niklVO.getHistInfo() + "','" +
                    niklVO.getHndyInfo() + "','" +
                    niklVO.getExcptInfo() + "','" +
                    niklVO.getMultiInfo() + "')");

            cnt++;

            if(cnt == 1499 || !iterator.hasNext()){
                query.append(";");
                //System.out.println(query);
                dbCon.insertData(query.toString());

                query.setLength(0);
                query.append("INSERT INTO TB_NIKL_WORD (DATA_NM, DATA_UNIT, ORGN_YN, ROMALPA, ROMALPA_WORD, ROMALPA_SOUND, ORGN_WORD, ORGN_WORD2, DATA_SOUND, DATA_USE, SRCH_TYPE, DATA_PATSPH, MEAN_NO, DATA_MEAN, DATA_REGION, DATA_FRM, DATA_RULE, DATA_EX, DATA_SPCLT, RELD_WORD, PROVB, IDIOM, TARGET_WORD, CLS_INFO, HIST_INFO, HNDY_INFO, EXCPT_INFO, MULTI_INFO) VALUES");
                cnt=0;

            } else {
                query.append(",");
            }
        }

    }
}
