package server.service.impl;

import org.springframework.stereotype.Service;

import server.model.TheatreCache;
import server.service.TheatreCacheService;

@Service
public class TheatreCacheServiceImpl implements TheatreCacheService {

	public TheatreCache getTheatreByTid(String tid, String lang) {
		return new TheatreCache();
	}
}