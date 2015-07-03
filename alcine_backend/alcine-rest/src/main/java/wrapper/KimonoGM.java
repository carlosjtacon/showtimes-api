package wrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class KimonoGM {
	
	private static final String KIMONO_API_KEY = APIKeys.KIMONO_API_KEY;
	
	public static JSONObject getMoviesByLocation(String location, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/6nwjciog?apikey="+ KIMONO_API_KEY +"&near="+ location +"&hl="+ lang +"&date=" + date);
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
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/4upry686?apikey="+ KIMONO_API_KEY +"&near="+ location +"&hl="+ lang +"&date=" + date);
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
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/8cktlij8?apikey="+ KIMONO_API_KEY +"&tid="+ tid +"&hl="+ lang +"&date=" + date);
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
			
			URL url = new URL("http://www.kimonolabs.com/api/ondemand/9e3l44ri?apikey="+ KIMONO_API_KEY +"&mid="+ fid +"&hl="+ lang +"&date=" + date);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String s = br.readLine();
			result = new JSONObject(s);
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
}
