package wrapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class KimonoGM {
	
	private static final String KIMONO_API_KEY = APIKeys.KIMONO_API_KEY;
	
	public static JsonObject getMoviesByLocation(String location, String lang, int date) {
		
		JsonObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/6nwjciog?apikey="+ KIMONO_API_KEY +"&near="+ URLEncoder.encode(location, "UTF-8") +"&hl="+ lang +"&date=" + date).asJson();
			result = new JsonParser().parse(request.getBody().getObject().toString()).getAsJsonObject();
			
		} catch (UnirestException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JsonObject getTheatresByLocation(String location, String lang, int date) {
		
		JsonObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/4upry686?apikey="+ KIMONO_API_KEY +"&near="+ URLEncoder.encode(location, "UTF-8") +"&hl="+ lang +"&date=" + date).asJson();
			result = new JsonParser().parse(request.getBody().getObject().toString()).getAsJsonObject();
			
		} catch (UnirestException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JsonObject getMoviesByTheatre(String tid, String lang, int date) {
		
		JsonObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/8cktlij8?apikey="+ KIMONO_API_KEY +"&tid="+ tid +"&hl="+ lang +"&date=" + date).asJson();
			result = new JsonParser().parse(request.getBody().getObject().toString()).getAsJsonObject();
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JsonObject getTheatresByMovie(String location, String fid, String lang, int date) {
		
		JsonObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/9e3l44ri?apikey="+ KIMONO_API_KEY +"&near="+ URLEncoder.encode(location, "UTF-8") +"&mid="+ fid +"&hl="+ lang +"&date=" + date).asJson();
			result = new JsonParser().parse(request.getBody().getObject().toString()).getAsJsonObject();
			
		} catch (UnirestException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static JsonObject getShowtimesByFidTid(String fid, String tid, String lang, int date) {
		
		JsonObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("https://www.kimonolabs.com/api/ondemand/e0jphclm?apikey="+ KIMONO_API_KEY +"&mid="+ fid + "&tid=" + tid +"&hl="+ lang +"&date=" + date).asJson();
			result = new JsonParser().parse(request.getBody().getObject().toString()).getAsJsonObject();
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
