package server.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import server.model.FilmCache;
import server.utils.DBMapper;
import server.utils.JSONBuilder;

@Service
public class FilmCacheServiceImpl implements FilmCacheService {

	public FilmCache getFilmByFid(String fid, String lang) {
		FilmCache film = DBMapper.getFilm(fid, lang);
		
		if (film == null)
			film = DBMapper.insertFilm(fid, lang, new Date(), JSONBuilder.getFilmCacheJSONResponse());
//		else if (film.getCache_date() < new Date())
		
		return film;
	}
}