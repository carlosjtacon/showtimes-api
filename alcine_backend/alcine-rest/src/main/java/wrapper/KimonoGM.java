package wrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class KimonoGM {
	
	public static JSONObject getMoviesByLocation(String location, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/6nwjciog?apikey=de0879bde11259d2262353b9be57e360&near="+ location +"&hl="+ lang +"&date=" + date);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			result = new JSONObject(br.readLine());
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getTheatresByLocation(String location, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/4upry686?apikey=de0879bde11259d2262353b9be57e360&near="+ location +"&hl="+ lang +"&date=" + date);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			result = new JSONObject(br.readLine());
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getMoviesByTheatre(String tid, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/8cktlij8?apikey=de0879bde11259d2262353b9be57e360&tid="+ tid +"&hl="+ lang +"&date=" + date);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			result = new JSONObject(br.readLine());
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getTheatresByMovie(String fid, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/9e3l44ri?apikey=de0879bde11259d2262353b9be57e360&mid="+ fid +"&hl="+ lang +"&date=" + date);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			result = new JSONObject(br.readLine());
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
}
