package dto;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WifiData {
	
	@SerializedName("row")
	@Expose
	private List<WifiDTO> row;

	
	public WifiData() { }
	
	public WifiData(List<WifiDTO> row) {
		this.row = row;
	}


	public List<WifiDTO> getRow() {
		return row;
	}


}
