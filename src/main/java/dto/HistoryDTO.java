package dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class HistoryDTO {
	private int id;
	private double LAT;
	private double LNT;
	private LocalDateTime searchDate;
	
	
	public HistoryDTO(ResultSet rs) throws SQLException {
		
		this.id = rs.getInt("id");
		this.LAT = rs.getDouble("LAT");
		this.LNT = rs.getDouble("LNT");
		this.searchDate = rs.getTimestamp("searchDate").toLocalDateTime();
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLAT() {
		return LAT;
	}
	public void setLAT(double lAT) {
		LAT = lAT;
	}
	public double getLNT() {
		return LNT;
	}
	public void setLNT(double lNT) {
		LNT = lNT;
	}
	public LocalDateTime getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(LocalDateTime searchDate) {
		this.searchDate = searchDate;
	}
	
	@Override
	public String toString() {
		return "History [id=" + id + ", LAT=" + LAT + ", LNT=" + LNT + ", searchDate=" + searchDate + "]";
	}
	
	
	

}
