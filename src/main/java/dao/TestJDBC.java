package dao;

import java.sql.*;
import dataBase.ConnectDB;

public class TestJDBC { 

    public static void main(String[] args){
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	
        try {
        	conn = ConnectDB.connectDB();
        	
        	String sql = "INSERT INTO wifi VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	
        	pstmt = conn.prepareStatement(sql);
        	
        	pstmt.setString(1, "ARI00001");
        	pstmt.setString(2, "서대문구");
        	pstmt.setString(3, "서울아리수본부");
        	pstmt.setString(4, "서소문로 51");
        	pstmt.setString(5, "본관 1F 복도");
        	pstmt.setString(6, null);
        	pstmt.setString(7, "7-1-3. 공공 - 시산하기관");
        	pstmt.setString(8, "서울시(AP)");
        	pstmt.setString(9, "공공WiFi");
        	pstmt.setString(10, "자기망_수도사업소망");
        	pstmt.setInt(11, 2024);
        	pstmt.setString(12, "실내");
        	pstmt.setString(13, null);
        	pstmt.setDouble(14, 37.561924);
        	pstmt.setDouble(15, 126.96675);
        	pstmt.setString(16, "2024-08-27 11:13:05.0");
        	
        	pstmt.executeUpdate();
            
            
            

//            while(rs.next())
//            {
//                System.out.println("id = " + rs.getInt("id"));
//                System.out.println("name = " + rs.getString("name"));
//            }

//            rs.close();
            conn.close(); 
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
