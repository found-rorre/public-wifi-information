package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConnectDB;
import dto.HistoryDTO;
import dto.WifiDTO;

public class HistoryService {
	
	public void historyInsert(double lat, double lnt) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
		
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "INSERT INTO history VALUES (null, ?, ?, datetime('now'))";
			
			pstmt = conn.prepareStatement(sql);
			
        	pstmt.setDouble(1, lat);
        	pstmt.setDouble(2, lnt);
		    
            pstmt.execute();
            
            conn.commit(); // 트랜잭션 커밋		    
            
            
        } catch (Exception e) {
        	System.out.println("서비스 오류");
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // 오류 발생 시 롤백
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
        	ConnectDB.close(conn, pstmt, null);
        }
	}
	
	public void historyDelete(int id) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "DELETE FROM history WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
        	pstmt.setInt(1, id);
		    
            pstmt.execute();
            
            conn.commit(); // 트랜잭션 커밋		    
            
            
        } catch (Exception e) {
        	System.out.println("서비스 오류");
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // 오류 발생 시 롤백
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
        	ConnectDB.close(conn, pstmt, null);
        }
	}
	
	public List<HistoryDTO> getHistoryList() throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	List<HistoryDTO> historyList = new ArrayList();
		
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "SELECT * from history";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				historyList.add(new HistoryDTO(rs));
			}
            
            conn.commit(); // 트랜잭션 커밋		    
            
            
        } catch (Exception e) {
        	System.out.println("서비스 오류");
            e.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // 오류 발생 시 롤백
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
        	ConnectDB.close(conn, pstmt, rs);
        }
    	
    	return historyList;
	}
		
	
}