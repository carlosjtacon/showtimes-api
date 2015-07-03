package server.service;

import org.springframework.stereotype.Service;

import server.model.TheatreCache;

@Service
public class TheatreCacheServiceImpl implements TheatreCacheService {

	public TheatreCache getTheatreByTid(String tid, String lang) {
		return new TheatreCache();
	}
}