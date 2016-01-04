package wrapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TheMovieDB {
	
	private static final String TMDB_API_KEY = APIKeys.TMDB_API_KEY;

	public static JsonObject getFilmData(String name, String lang) {
		
		JsonObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("http://api.themoviedb.org/3/search/movie?api_key=" + TMDB_API_KEY + "&query=" + URLEncoder.encode(name, "UTF-8") + "&language=" + lang).asJson();
			JsonObject fullJson = new JsonParser().parse(request.getBody().getObject().toString()).getAsJsonObject();
			result = fullJson.getAsJsonArray("results").get(0).getAsJsonObject();
			
		} catch (UnirestException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
//	http://api.themoviedb.org/3/genre/movie/list?api_key=55a04c0aad5c2a1f9da894a06e683950&language=es
//	http://api.themoviedb.org/3/movie/135397?api_key=55a04c0aad5c2a1f9da894a06e683950&language=es
//	http://api.themoviedb.org/3/movie/135397/credits?api_key=55a04c0aad5c2a1f9da894a06e683950&language=es
	
}
