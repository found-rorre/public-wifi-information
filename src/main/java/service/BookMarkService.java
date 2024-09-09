package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataBase.ConnectDB;
import dto.BookMarkGroupDTO;

public class BookMarkService {
	public void markInsert(String wifiId, int groupId) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
		
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			
			String sql = "INSERT INTO bookMark (groupId, wifiId) VALUES (?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
        	pstmt.setInt(1, groupId);
        	pstmt.setString(2, wifiId);
		    
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
	public void groupInsert(BookMarkGroupDTO dto) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
		
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			
			String sql = "INSERT INTO bookMarkGroup (id, seq, name, updateDate) VALUES (null, ?, ?, null)";
			
			pstmt = conn.prepareStatement(sql);
			
        	pstmt.setInt(1, dto.getSeq());
        	pstmt.setString(2, dto.getName());
		    
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
	
	public void groupDelete(int id) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "DELETE FROM bookMarkGroup WHERE id = ?";
			
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
	public void groupUpdate(BookMarkGroupDTO dto) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "UPDATE bookMarkGroup "
					+ "SET "
					+ "seq = ?, "
					+ "name = ?, "
					+ "updateDate = datetime('now') "
					+ "WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
        	pstmt.setInt(1, dto.getSeq());
        	pstmt.setString(2, dto.getName());
        	pstmt.setInt(3, dto.getId());
		    
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
	
	public List<BookMarkGroupDTO> getGroupList() throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;	
    	
    	List<BookMarkGroupDTO> groupList = new ArrayList();
			
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "SELECT * from bookMarkGroup order by seq";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
            while (rs.next()) {
            	BookMarkGroupDTO dto = new BookMarkGroupDTO();
                
            	dto.setId(rs.getInt("id"));
            	dto.setSeq(rs.getInt("seq"));
            	dto.setName(rs.getString("name"));
            	dto.setCreateDate(rs.getTimestamp("createDate").toLocalDateTime());
            	dto.setUpdateDate(rs.getTimestamp("updateDate") == null ? null : rs.getTimestamp("updateDate").toLocalDateTime()); 
            
            	groupList.add(dto);
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
    	
    	return groupList;
	}
	public List<HashMap<String, Object>> getMarkList() throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;	
    	
    	List<HashMap<String, Object>> markList = new ArrayList();
			
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "SELECT " +
						 	"M.id AS id, " +
						 	"G.name AS groupName, " +
						 	"W.X_SWIFI_MAIN_NM AS wifiName, " +
						 	"M.createDate AS createDate, " +
						 	"W.X_SWIFI_MGR_NO AS wifiId " +
						 "FROM " +
						 	"bookMark as M " +
						 "JOIN " +
						 	"bookMarkGroup as G ON M.groupId = G.id " +
						 "JOIN " +
						 	"wifi as W ON M.wifiId = W.X_SWIFI_MGR_NO " +
						 "ORDER BY " +
						 	"M.id DESC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
            while (rs.next()) {
            	
            	HashMap<String, Object> markMap = new HashMap();
            	
    			int id = rs.getInt("id");
    			String groupName = rs.getString("groupName");
    			String wifiName = rs.getString("wifiName");
    			LocalDateTime createDate = rs.getTimestamp("createDate").toLocalDateTime();
    			String wifiId = rs.getString("wifiId");
    			
    			markMap.put("id", id);
    			markMap.put("groupName", groupName);
    			markMap.put("wifiName", wifiName);
    			markMap.put("createDate", createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    			markMap.put("wifiId", wifiId);
    			
    			markList.add(markMap);
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
    	
    	return markList;
	}
		
	
}