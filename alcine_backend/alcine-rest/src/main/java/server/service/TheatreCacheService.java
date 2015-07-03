package server.service;

import server.model.TheatreCache;

public interface TheatreCacheService {
	public TheatreCache getTheatreByTid(String tid, String lang);
}