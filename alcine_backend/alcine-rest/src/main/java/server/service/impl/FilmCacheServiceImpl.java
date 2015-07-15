package server.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import server.mappers.FilmCacheMapper;
import server.model.FilmCache;
import server.service.FilmCacheService;
import server.utils.DateUtils;
import server.utils.StringUtils;
import wrapper.KimonoGM;
import wrapper.TheMovieDB;

import com.google.gson.JsonObject;

@Service
public class FilmCacheServiceImpl implements FilmCacheService {

	public FilmCache getFilmByFid(String location, String fid, String lang) {
		
		FilmCache film = FilmCacheMapper.getFilm(fid, lang);
		
		if (film == null) {
			
			JsonObject response = getFilmCacheJSONResponse(location, fid, lang);
			film = FilmCacheMapper.insertFilm(fid, lang, new Date(), response);
			
		} else if (!DateUtils.isFilmCacheValid(film.getCache_date())) {
			
			JsonObject response = getFilmCacheJSONResponse(location, fid, lang);
			film = FilmCacheMapper.updateFilm(fid, lang, new Date(), response);
			
		}
		
		return film;
	}
	
	private JsonObject getFilmCacheJSONResponse(String location, String fid,  String lang) {
		JsonObject kimono_info = KimonoGM.getTheatresByMovie(location, fid, lang, 0);
		String fname = kimono_info.getAsJsonObject("results").getAsJsonArray("film").get(0).getAsJsonObject().get("film_name").toString();
		JsonObject tmdb_info = TheMovieDB.getFilmData(StringUtils.cleanFilmName(fname), lang);
		return tmdb_info;
	}
}