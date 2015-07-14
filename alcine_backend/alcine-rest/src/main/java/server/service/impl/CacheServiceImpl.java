package server.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import server.mappers.CacheMapper;
import server.model.Cache;
import server.service.CacheService;
import server.utils.DateUtils;
import server.utils.JsonBuilder;
import wrapper.KimonoGM;

import com.google.gson.JsonObject;

@Service
public class CacheServiceImpl implements CacheService {

	public Cache getTheatresByLocation(String location, String lang, int date) {
		
		final String URL = "/theatres";
		
		Cache cache = CacheMapper.getCache(URL, location, lang, date, null, null);
		
		if (cache == null) {
			
			JsonObject kimono_info = KimonoGM.getTheatresByLocation(location, lang, date);
			JsonObject response = JsonBuilder.buildGetTheatresByLocation(kimono_info);
			
			cache = CacheMapper.insertCache(URL, location, lang, date, null, null, new Date(), response);
			
		} else if (!DateUtils.isCacheValid(cache.getCache_Date())) {
			
			JsonObject kimono_info = KimonoGM.getTheatresByLocation(location, lang, date);
			JsonObject response = JsonBuilder.buildGetTheatresByLocation(kimono_info);
			
			cache = CacheMapper.updateCache(URL, location, lang, date, null, null, new Date(), response);
			
		}
		
		return cache;
	}

	public Cache getFilmsByLocation(String location, String lang, int date) {
					
		final String URL = "/films";
		
		Cache cache = CacheMapper.getCache(URL, location, lang, date, null, null);
		
		if (cache == null) {
			
			JsonObject kimono_info = KimonoGM.getMoviesByLocation(location, lang, date);
			JsonObject response = JsonBuilder.buildGetFilmsByLocation(kimono_info);
			
			cache = CacheMapper.insertCache(URL, location, lang, date, null, null, new Date(), response);
			
		} else if (!DateUtils.isCacheValid(cache.getCache_Date())) {
			
			JsonObject kimono_info = KimonoGM.getMoviesByLocation(location, lang, date);
			JsonObject response = JsonBuilder.buildGetFilmsByLocation(kimono_info);
			
			cache = CacheMapper.updateCache(URL, location, lang, date, null, null, new Date(), response);
			
		}
		
		return cache;
	}

	public Cache getFilmsByTid(String tid, String lang, int date) {
		
		final String URL = "/theatres/{tid}/films";
		
		Cache cache = CacheMapper.getCache(URL, null, lang, date, tid, null);
		
		if (cache == null) {
			
			JsonObject kimono_info = KimonoGM.getMoviesByTheatre(tid, lang, date);
			JsonObject response = JsonBuilder.buildGetFilmsByTid(kimono_info);
			
			cache = CacheMapper.insertCache(URL, null, lang, date, tid, null, new Date(), response);
			
		} else if (!DateUtils.isCacheValid(cache.getCache_Date())) {
			
			JsonObject kimono_info = KimonoGM.getMoviesByTheatre(tid, lang, date);
			JsonObject response = JsonBuilder.buildGetFilmsByTid(kimono_info);
			
			cache = CacheMapper.updateCache(URL, null, lang, date, tid, null, new Date(), response);
			
		}
		
		return cache;
	}

	public Cache getTheatresByFid(String fid, String location, String lang, int date) {

		final String URL = "/films/{fid}/theatres";
		
		Cache cache = CacheMapper.getCache(URL, null, lang, date, null, fid);
		
		if (cache == null) {
			
			JsonObject kimono_info = KimonoGM.getTheatresByMovie(fid, lang, date);
			JsonObject response = JsonBuilder.buildGetTheatresByFid(kimono_info);
			
			cache = CacheMapper.insertCache(URL, null, lang, date, null, fid, new Date(), response);
			
		} else if (!DateUtils.isCacheValid(cache.getCache_Date())) {
			
			JsonObject kimono_info = KimonoGM.getTheatresByMovie(fid, lang, date);
			JsonObject response = JsonBuilder.buildGetTheatresByFid(kimono_info);
			
			cache = CacheMapper.updateCache(URL, null, lang, date, null, fid, new Date(), response);
			
		}
		
		return cache;
	}

	public Cache getShowtimesByFidTid(String fid, String tid, String lang, int date) {

		final String URL = "/theatres/{tid}/films/{fid}/showtimes";
		
		Cache cache = CacheMapper.getCache(URL, null, lang, date, tid, fid);
		
		if (cache == null) {
			
			JsonObject kimono_info = KimonoGM.getShowtimesByFidTid(fid, tid, lang, date);
			JsonObject response = JsonBuilder.buildGetShowtimesByFidTid(kimono_info);
			
			cache = CacheMapper.insertCache(URL, null, lang, date, tid, fid, new Date(), response);
			
		} else if (!DateUtils.isCacheValid(cache.getCache_Date())) {
			
			JsonObject kimono_info = KimonoGM.getShowtimesByFidTid(fid, tid, lang, date);
			JsonObject response = JsonBuilder.buildGetShowtimesByFidTid(kimono_info);
			
			cache = CacheMapper.updateCache(URL, null, lang, date, tid, fid, new Date(), response);
			
		}
		
		return cache;
	}
}