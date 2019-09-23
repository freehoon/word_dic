package com.freehoon.dic.dbConnect;

import com.freehoon.dic.air.vo.AirVO;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class DBConnect {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbname?serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public DBConnect(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if(conn != null){
                System.out.println("연결 성공");
            } else {
                System.out.println("연결 실패");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String query){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("DB insert end...");
    }

}
