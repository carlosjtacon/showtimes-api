package server.service;

import org.springframework.stereotype.Service;

import server.model.FilmCache;

@Service
public class FilmCacheServiceImpl implements FilmCacheService {

	public FilmCache getFilmByFid(String fid, String lang) {
		return new FilmCache();
	}
}