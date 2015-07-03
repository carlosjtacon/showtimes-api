package server.service;

import server.model.Cache;

public interface CacheService {
	public Cache getTheatresByLocation(String location, String lang, int date);
	public Cache getFilmsByLocation(String location, String lang, int date);
	public Cache getFilmsByTid(String tid, String lang, int date);
	public Cache getTheatresByFid(String fid, String lang, int date);
	public Cache getShowtimesByFidTid(String fid, String tid, String lang, int date);
}