package server.service;

import server.model.FilmCache;

public interface FilmCacheService {
	public FilmCache getFilmByFid(String location, String fid, String lang);
}