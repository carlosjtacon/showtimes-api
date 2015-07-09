package server.service.impl;

import org.springframework.stereotype.Service;

import server.model.Cache;
import server.service.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

	public Cache getTheatresByLocation(String location, String lang, int date) {
		return new Cache();
	}

	public Cache getFilmsByLocation(String location, String lang, int date) {
		return new Cache();
	}

	public Cache getFilmsByTid(String tid, String lang, int date) {
		return new Cache();
	}

	public Cache getTheatresByFid(String fid, String lang, int date) {
		return new Cache();
	}

	public Cache getShowtimesByFidTid(String fid, String tid, String lang, int date) {
		return new Cache();
	}
}