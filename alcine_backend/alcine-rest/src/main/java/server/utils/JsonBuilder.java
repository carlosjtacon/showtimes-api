package server.utils;

import wrapper.KimonoGM;
import wrapper.TheMovieDB;

import com.google.gson.JsonObject;

public class JsonBuilder {
	public static JsonObject getFilmCacheJSONResponse(String fid,  String lang) {
		JsonObject kimono_info = KimonoGM.getTheatresByMovie(fid, lang, 0);
		String fname = kimono_info.getAsJsonObject("results").getAsJsonArray("film").get(0).getAsJsonObject().get("film_name").toString();
		JsonObject tmdb_info = TheMovieDB.getFilmData(StringUtils.cleanFilmName(fname), lang);
		return tmdb_info;
	}
}
