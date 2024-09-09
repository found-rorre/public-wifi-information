package dao;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.WifiDTO;
import dto.WifiData;

public class Test {
	
	static String key = "5a564d637173686a35347861655048";
	static String type = "json";
	static String kind = "TbPublicWifiInfo";
	
	static StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088" + "/" + key + "/" + type + "/" + kind);
	
	private static Gson gson;
    public static synchronized Gson getInstance() {
        if (gson == null) gson = new Gson();
        return gson;
    }
    public static void main(String[] args) throws IOException {
    	
    	URL url = null;
    	HttpURLConnection conn = null;
    	JsonObject result = null;
    
    	
		url = new URL(urlBuilder.toString() + "/" +1+ "/" +1+ "/");
		System.out.println(url);
		
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		
//		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader br = null;
		
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <=300) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(br.ready()) {
			sb.append(br.readLine());
		}
		
		br.close();
		conn.disconnect();
		
		
		result = (JsonObject) new JsonParser().parse(sb.toString());
		result = (JsonObject) result.get("TbPublicWifiInfo");
		
		int totalCnt = Integer.parseInt(String.valueOf(result.get("list_total_count")));
		System.out.println(totalCnt);
		System.out.println(result.get("row"));
		
		
		WifiData data = getInstance().fromJson(result.toString(), WifiData.class);
		List<WifiDTO> wifiList = new ArrayList();
		
        for (int i = 0; i < data.getRow().size(); i++) {
        	wifiList.add(data.getRow().get(i));
        }
        
        for(WifiDTO dto : wifiList){
            System.out.println(dto.getX_SWIFI_MAIN_NM());
        }
		
		

		
		
    }
}