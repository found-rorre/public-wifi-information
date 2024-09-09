package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import api.WifiAPI;
import dataBase.ConnectDB;
import dto.WifiDTO;

public class WifiService {
	
	public void getData() throws IOException {
		
		WifiAPI api = new WifiAPI();
		
		int totalCnt = api.getTotalCnt();
		
		for (int i = 1; i <= totalCnt; i += 1000) {
    		
    		int start = i;
    		int end = i + 999 <= totalCnt ? i + 999 : totalCnt;
    		
    		List<WifiDTO> wifiList = api.getWifiInfo(start, end);

    		wifiInsert(wifiList);
		}
		
    }
	
	public void wifiInsert(List<WifiDTO>wifiList) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	
		try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			String sql = "INSERT INTO wifi VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			
		    for (WifiDTO dto : wifiList) {
		    	
	        	pstmt.setString(1, dto.getX_SWIFI_MGR_NO());
	        	pstmt.setString(2, dto.getX_SWIFI_WRDOFC());
	        	pstmt.setString(3, dto.getX_SWIFI_MAIN_NM());
	        	pstmt.setString(4, dto.getX_SWIFI_ADRES1());
	        	pstmt.setString(5, dto.getX_SWIFI_ADRES2());
	        	pstmt.setString(6, dto.getX_SWIFI_INSTL_FLOOR());
	        	pstmt.setString(7, dto.getX_SWIFI_INSTl_TY());
	        	pstmt.setString(8, dto.getX_SWIFI_INSTL_MBY());
	        	pstmt.setString(9, dto.getX_SWIFI_SVC_SE());
	        	pstmt.setString(10, dto.getX_SWIFI_CMCWR());
	        	pstmt.setInt(11, dto.getX_SWIFI_CNSTC_YEAR());
	        	pstmt.setString(12, dto.getX_SWIFI_INOUT_DOOR());
	        	pstmt.setString(13, dto.getX_SWIFI_REMARS3());
	        	pstmt.setDouble(14, dto.getLAT());
	        	pstmt.setDouble(15, dto.getLNT());
	        	pstmt.setTimestamp(16, Timestamp.valueOf(dto.getWORK_DTTM()));
	        	
		        pstmt.addBatch(); // 배치 추가
		    }
		    
            pstmt.executeBatch(); // 배치 실행
            
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
	public WifiDTO getWifiInfo(String X_SWIFI_MGR_NO) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	WifiDTO wifiDTO = null;
    	
    	try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			
			String sql = "SELECT * "
					+ "FROM wifi "
					+ "WHERE X_SWIFI_MGR_NO = ?";
					
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, X_SWIFI_MGR_NO);
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				wifiDTO = new WifiDTO(rs);
			}
			
			conn.commit();
			
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
		return wifiDTO;
	}
	
	public List<WifiDTO> getWifiList (double lat, double lnt) throws IOException {
		
		Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	List<WifiDTO> wifiList = new ArrayList();
    	
		try {
			conn = ConnectDB.connectDB();
			conn.setAutoCommit(false); // 자동 커밋 비활성화
			
			String sql = "SELECT * "
					+ "FROM wifi "
					+ "ORDER BY "
						+ "6371 * acos ( cos(radians( ? )) * cos(radians(LAT)) * cos(radians(LNT) - radians( ? )) + sin (radians( ? )) * sin(radians(LAT)))"
					+ "LIMIT 20";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, lat);
			pstmt.setDouble(2, lnt);
			pstmt.setDouble(3, lat);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				wifiList.add(new WifiDTO(rs));
			}
			
			conn.commit();
			
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
		
		return wifiList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}