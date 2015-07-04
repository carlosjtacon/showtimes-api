package wrapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TheMovieDB {
	
	private static final String TMDB_API_KEY = APIKeys.TMDB_API_KEY;

	public static JSONObject getFilmData(String name, String lang) {
		
		JSONObject result = null;
		
		try {
			
			HttpResponse<JsonNode> request = Unirest.get("http://api.themoviedb.org/3/search/movie?api_key=" + TMDB_API_KEY + "&query=" + URLEncoder.encode(name, "UTF-8") + "&language=" + lang).asJson();
			result = request.getBody().getObject();
			
		} catch (UnirestException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
