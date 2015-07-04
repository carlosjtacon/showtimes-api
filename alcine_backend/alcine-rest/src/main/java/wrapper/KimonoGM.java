package wrapper;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class KimonoGM {
	
	private static final String KIMONO_API_KEY = APIKeys.KIMONO_API_KEY;
	
	public static JSONObject getMoviesByLocation(String location, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/6nwjciog?apikey="+ KIMONO_API_KEY +"&near="+ location +"&hl="+ lang +"&date=" + date).asJson();
			result = request.getBody().getObject();
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getTheatresByLocation(String location, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/4upry686?apikey="+ KIMONO_API_KEY +"&near="+ location +"&hl="+ lang +"&date=" + date).asJson();
			result = request.getBody().getObject();
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getMoviesByTheatre(String tid, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/8cktlij8?apikey="+ KIMONO_API_KEY +"&tid="+ tid +"&hl="+ lang +"&date=" + date).asJson();
			result = request.getBody().getObject();
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JSONObject getTheatresByMovie(String fid, String lang, int date) {
		
		JSONObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/9e3l44ri?apikey="+ KIMONO_API_KEY +"&mid="+ fid +"&hl="+ lang +"&date=" + date).asJson();
			result = request.getBody().getObject();
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
