package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.WifiDTO;
import dto.WifiData;

public class WifiAPI  {
	
	private static final String BASE_URL = "http://openapi.seoul.go.kr:8088" + "/5a564d637173686a35347861655048/json/TbPublicWifiInfo"; // URL 빌더의 기본 URL 설정
	
	private static final Gson gson = GsonConfig.createGson();
    
    public int getTotalCnt() throws IOException {
    	
    	HttpURLConnection conn = null;
    	JsonObject result = null;
    	
    	URL url = new URL(BASE_URL + "/1/1/");

		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300
                        ? conn.getInputStream()
                        : conn.getErrorStream()))) {
        	
            StringBuilder sb = new StringBuilder();
            String line;
            
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            
            result = gson.fromJson(sb.toString(), JsonObject.class);
            
        } finally {
            conn.disconnect();
        }

        result = result.getAsJsonObject("TbPublicWifiInfo");
        
        return result.get("list_total_count").getAsInt();
    }

    
    
    public List<WifiDTO> getWifiInfo(int start, int end) throws IOException {
    	
    	HttpURLConnection conn = null;
    	JsonObject result = null;
    	
    	URL url = new URL(BASE_URL + "/" +start+ "/" +end+ "/");

		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
		BufferedReader br = null;
		
        InputStreamReader inputStreamReader = new InputStreamReader(
                conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300
                ? conn.getInputStream()
                : conn.getErrorStream()
        );
        
        br = new BufferedReader(inputStreamReader);
		
		StringBuilder sb = new StringBuilder();
		
		while(br.ready()) {
			sb.append(br.readLine());
		}
		
		br.close();
		conn.disconnect();
		
		result = (JsonObject) new JsonParser().parse(sb.toString());
		result = (JsonObject) result.get("TbPublicWifiInfo");
		
		WifiData data = gson.fromJson(result.toString(), WifiData.class);
		
		List<WifiDTO> wifiList = data.getRow();

		return wifiList;
    }
    
    public List<WifiDTO> getTotalWifiInfo() throws IOException {
    	int totalCnt = getTotalCnt();
    	
    	List<WifiDTO> wifiList = new ArrayList();
    	
    	for (int i = 1; i <= totalCnt; i += 1000) {
    		
    		int start = i;
    		int end = i + 999 <= totalCnt ? i + 999 : totalCnt;
    		
    		wifiList.addAll(getWifiInfo(start, end));
			
		}

    	
    	return wifiList;
    }
}
