package dto;

import java.time.LocalDateTime;

public class BookMarkGroupDTO {
	
	private int id;
	private int seq;
	private String name;	
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
	
	@Override
	public String toString() {
		return "BookMarkGroupDTO [id=" + id + ", seq=" + seq + ", name=" + name + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	
	
}
