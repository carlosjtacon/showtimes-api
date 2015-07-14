package server.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import server.mappers.TheatreCacheMapper;
import server.model.TheatreCache;
import server.service.TheatreCacheService;
import server.utils.DateUtils;
import server.utils.StringUtils;
import wrapper.KimonoGM;
import wrapper.NominatimOSM;

import com.google.gson.JsonObject;

@Service
public class TheatreCacheServiceImpl implements TheatreCacheService {

	public TheatreCache getTheatreByTid(String tid, String lang) {
		
		TheatreCache theatre = TheatreCacheMapper.getTheatre(tid, lang);
		
		if (theatre == null) {
			
			JsonObject response = getTheatreCacheJSONResponse(tid, lang);
			theatre = TheatreCacheMapper.insertTheatre(tid, lang, new Date(), response);
			
		} else if (!DateUtils.isTheatreCacheValid(theatre.getCache_date())) {
			
			JsonObject response = getTheatreCacheJSONResponse(tid, lang);
			theatre = TheatreCacheMapper.updateTheatre(tid, lang, new Date(), response);
			
		}
		
		return theatre;
	}
	
	private JsonObject getTheatreCacheJSONResponse(String tid,  String lang) {
		JsonObject kimono_info = KimonoGM.getMoviesByTheatre(tid, lang, 0);
		String taddress = kimono_info.getAsJsonObject("results").getAsJsonArray("movie_theaters").get(0).getAsJsonObject().getAsJsonObject("theatre_info").get("text").getAsString();
		taddress = StringUtils.cleanAddress(taddress);
		taddress = StringUtils.cleanAddressName(taddress);
		JsonObject nominatim_info = NominatimOSM.getTheatreDataByLocation(taddress, lang);
		return nominatim_info;
	}
}