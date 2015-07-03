package server.utils;

import org.json.JSONObject;

import wrapper.KimonoGM;
import wrapper.TheMovieDB;

public class JSONBuilder {
	public static JSONObject getFilmCacheJSONResponse(String fid,  String lang) {
		JSONObject kimono_info = KimonoGM.getTheatresByMovie(fid, lang, 0);
		String fname = kimono_info.getJSONObject("results").getJSONArray("film").getJSONObject(0).get("film_name").toString();
		JSONObject tmdb_info = TheMovieDB.getFilmData(StringUtils.cleanFilmName(fname), lang);
		return tmdb_info;
	}
}
