package wrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

public class TheMovieDB {
	
	private static final String TMDB_API_KEY = APIKeys.TMDB_API_KEY;

	public static JSONObject getFilmData(String name, String lang) {
		
		JSONObject result = null;
		
		try {
			
			URL url = new URL("http://api.themoviedb.org/3/search/movie?api_key=" + TMDB_API_KEY + "&query=" + URLEncoder.encode(name, "UTF-8") + "&language=" + lang);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			result = new JSONObject(br.readLine());
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
		
	}
	
}
