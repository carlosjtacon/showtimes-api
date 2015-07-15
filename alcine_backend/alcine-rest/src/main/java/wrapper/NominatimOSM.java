package wrapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class NominatimOSM {
	
	public static JsonObject getTheatreDataByLocation(String location, String lang) {
		
		JsonObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("http://nominatim.openstreetmap.org/search/" + URLEncoder.encode(location, "UTF-8") +"?format=json&accept-language="+ lang).asJson();
			if(!request.getBody().getArray().isNull(0))
				result = new JsonParser().parse(request.getBody().getArray().toString()).getAsJsonArray().get(0).getAsJsonObject();
			
		} catch (UnirestException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
