package server.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import server.model.FilmCache;
import server.utils.DBMapper;
import server.utils.JSONBuilder;

import com.google.gson.JsonObject;

@Service
public class FilmCacheServiceImpl implements FilmCacheService {

	public FilmCache getFilmByFid(String fid, String lang) {
		FilmCache film = DBMapper.getFilm(fid, lang);
		
		if (film == null) {
			
			JsonObject response = JSONBuilder.getFilmCacheJSONResponse(fid, lang);
			film = DBMapper.insertFilm(fid, lang, new Date(), response);
			/* DEBUG */film = new FilmCache(fid, lang, new Date(), response);
			
		} else if (film.getCache_date().compareTo(new Date()) > 0) {
			
			JsonObject response = JSONBuilder.getFilmCacheJSONResponse(fid, lang);
			film = DBMapper.updateFilm(fid, lang, new Date(), response);
			/* DEBUG */film = new FilmCache(fid, lang, new Date(), response);
			
		}
		
		return film;
	}
}