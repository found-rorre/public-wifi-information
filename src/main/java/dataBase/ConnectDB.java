package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectDB {
    public static Connection connectDB() {

    	Connection conn = null;
    	
        // DB 파일 위치
    	String filePath = "C:/daeil/zerobase/wifi-workspace/public-wifi-information.db";
    	String url = "jdbc:sqlite:" + filePath;

        try {
            Class.forName("org.sqlite.JDBC");
            
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

       return conn;
    }
    
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet resultSet) {

        try {
            if (resultSet != null && ! resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (pstmt != null && ! pstmt.isClosed()) {
            	pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null && ! conn.isClosed()) {
            	conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
