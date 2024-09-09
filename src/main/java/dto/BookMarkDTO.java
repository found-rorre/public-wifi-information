package dto;

import java.time.LocalDateTime;

public class BookMarkDTO {
	
	private int id;
	private int groupId;
	private String wifiId;	
	private LocalDateTime createDate;
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getWifiId() {
		return wifiId;
	}
	public void setWifiId(String wifiId) {
		this.wifiId = wifiId;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	
	@Override
	public String toString() {
		return "BookMarkDTO [id=" + id + ", groupId=" + groupId + ", wifiId=" + wifiId + ", createDate=" + createDate + "]";
	}

	
}
