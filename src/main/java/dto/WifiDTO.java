package dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class WifiDTO {
	
	private String X_SWIFI_MGR_NO;		// 관리번호
	private String X_SWIFI_WRDOFC;		// 자치구
	private String X_SWIFI_MAIN_NM;		// wifi 명
	private String X_SWIFI_ADRES1;		// 도로명 주소
	private String X_SWIFI_ADRES2;		// 상세주소
	private String X_SWIFI_INSTL_FLOOR;	// 설치 위치(층)
	private String X_SWIFI_INSTl_TY;	// 설치 유형
	private String X_SWIFI_INSTL_MBY;	// 설치 기관
	private String X_SWIFI_SVC_SE;		// 서비스 구분
	private String X_SWIFI_CMCWR;		// 망종류
	private int X_SWIFI_CNSTC_YEAR;	// 설치년도
	private String X_SWIFI_INOUT_DOOR;	// 실내외 구분
	private String X_SWIFI_REMARS3;		// wifi 접속환경
	private double LAT;					// Y좌표
	private double LNT;					// X좌표
	private LocalDateTime WORK_DTTM;	// 작업일자
	
	public WifiDTO() {}

	public WifiDTO(ResultSet rs) throws SQLException {
	
		this.X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
		this.X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
		this.X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
		this.X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
		this.X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
		this.X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
		this.X_SWIFI_INSTl_TY = rs.getString("X_SWIFI_INSTl_TY");
		this.X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
		this.X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
		this.X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
		this.X_SWIFI_CNSTC_YEAR = rs.getInt("X_SWIFI_CNSTC_YEAR");
		this.X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
		this.X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
		this.LAT = rs.getDouble("LAT");
		this.LNT = rs.getDouble("LNT");
		this.WORK_DTTM = rs.getTimestamp("WORK_DTTM").toLocalDateTime();
	}


	public String getX_SWIFI_MGR_NO() {
		return X_SWIFI_MGR_NO;
	}


	public void setX_SWIFI_MGR_NO(String X_SWIFI_MGR_NO) {
		this.X_SWIFI_MGR_NO = X_SWIFI_MGR_NO;
	}

				  
	public String getX_SWIFI_WRDOFC() {
		return X_SWIFI_WRDOFC;
	}


	public void setX_SWIFI_WRDOFC(String X_SWIFI_WRDOFC) {
		this.X_SWIFI_WRDOFC = X_SWIFI_WRDOFC;
	}


	public String getX_SWIFI_MAIN_NM() {
		return X_SWIFI_MAIN_NM;
	}


	public void setX_SWIFI_MAIN_NM(String X_SWIFI_MAIN_NM) {
		this.X_SWIFI_MAIN_NM = X_SWIFI_MAIN_NM;
	}


	public String getX_SWIFI_ADRES1() {
		return X_SWIFI_ADRES1;
	}


	public void setX_SWIFI_ADRES1(String X_SWIFI_ADRES1) {
		this.X_SWIFI_ADRES1 = X_SWIFI_ADRES1;
	}


	public String getX_SWIFI_ADRES2() {
		return X_SWIFI_ADRES2;
	}


	public void setX_SWIFI_ADRES2(String x_SWIFI_ADRES2) {
		X_SWIFI_ADRES2 = x_SWIFI_ADRES2;
	}


	public String getX_SWIFI_INSTL_FLOOR() {
		return X_SWIFI_INSTL_FLOOR;
	}


	public void setX_SWIFI_INSTL_FLOOR(String X_SWIFI_INSTL_FLOOR) {
		this.X_SWIFI_INSTL_FLOOR = X_SWIFI_INSTL_FLOOR;
	}


	public String getX_SWIFI_INSTl_TY() {
		return X_SWIFI_INSTl_TY;
	}


	public void setX_SWIFI_INSTl_TY(String X_SWIFI_INSTl_TY) {
		this.X_SWIFI_INSTl_TY = X_SWIFI_INSTl_TY;
	}


	public String getX_SWIFI_INSTL_MBY() {
		return X_SWIFI_INSTL_MBY;
	}


	public void setX_SWIFI_INSTL_MBY(String X_SWIFI_INSTL_MBY) {
		this.X_SWIFI_INSTL_MBY = X_SWIFI_INSTL_MBY;
	}


	public String getX_SWIFI_SVC_SE() {
		return X_SWIFI_SVC_SE;
	}


	public void setX_SWIFI_SVC_SE(String X_SWIFI_SVC_SE) {
		this.X_SWIFI_SVC_SE = X_SWIFI_SVC_SE;
	}


	public String getX_SWIFI_CMCWR() {
		return X_SWIFI_CMCWR;
	}


	public void setX_SWIFI_CMCWR(String X_SWIFI_CMCWR) {
		this.X_SWIFI_CMCWR = X_SWIFI_CMCWR;
	}


	public int getX_SWIFI_CNSTC_YEAR() {
		return X_SWIFI_CNSTC_YEAR;
	}


	public void setX_SWIFI_CNSTC_YEAR(int X_SWIFI_CNSTC_YEAR) {
		this.X_SWIFI_CNSTC_YEAR = X_SWIFI_CNSTC_YEAR;
	}


	public String getX_SWIFI_INOUT_DOOR() {
		return X_SWIFI_INOUT_DOOR;
	}


	public void setX_SWIFI_INOUT_DOOR(String X_SWIFI_INOUT_DOOR) {
		this.X_SWIFI_INOUT_DOOR = X_SWIFI_INOUT_DOOR;
	}


	public String getX_SWIFI_REMARS3() {
		return X_SWIFI_REMARS3;
	}


	public void setX_SWIFI_REMARS3(String X_SWIFI_REMARS3) {
		this.X_SWIFI_REMARS3 = X_SWIFI_REMARS3;
	}


	public double getLAT() {
		return LAT;
	}


	public void setLAT(double LAT) {
		this.LAT = LAT;
	}


	public double getLNT() {
		return LNT;
	}


	public void setLNT(double LNT) {
		this.LNT = LNT;
	}


	public LocalDateTime getWORK_DTTM() {
		return WORK_DTTM;
	}


	public void setWORK_DTTM(LocalDateTime WORK_DTTM) {
		this.WORK_DTTM = WORK_DTTM;
	}


	@Override
	public String toString() {
		return "WifiDTO [X_SWIFI_MGR_NO=" + X_SWIFI_MGR_NO + ", X_SWIFI_WRDOFC=" + X_SWIFI_WRDOFC + ", X_SWIFI_MAIN_NM="
				+ X_SWIFI_MAIN_NM + ", X_SWIFI_ADRES1=" + X_SWIFI_ADRES1 + ", X_SWIFI_ADRES2=" + X_SWIFI_ADRES2
				+ ", X_SWIFI_INSTL_FLOOR=" + X_SWIFI_INSTL_FLOOR + ", X_SWIFI_INSTl_TY=" + X_SWIFI_INSTl_TY
				+ ", X_SWIFI_INSTL_MBY=" + X_SWIFI_INSTL_MBY + ", X_SWIFI_SVC_SE=" + X_SWIFI_SVC_SE + ", X_SWIFI_CMCWR="
				+ X_SWIFI_CMCWR + ", X_SWIFI_CNSTC_YEAR=" + X_SWIFI_CNSTC_YEAR + ", X_SWIFI_INOUT_DOOR="
				+ X_SWIFI_INOUT_DOOR + ", X_SWIFI_REMARS3=" + X_SWIFI_REMARS3 + ", LAT=" + LAT + ", LNT=" + LNT
				+ ", WORK_DTTM=" + WORK_DTTM + "]";
	}
	
	
	
	
	
}
