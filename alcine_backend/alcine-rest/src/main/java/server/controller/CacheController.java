package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import server.model.Cache;
import server.service.CacheService;

import com.google.gson.Gson;

@RestController
public class CacheController {

	@Autowired
	private CacheService cacheService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody String getRoot() {
		return"<h2>URL SCHEME</h2> <br> <p>Welcome to AlCine REST API!</p> <br> <p>- Supported languages: en, es (Other languages not tested). Spanish by default.</p> <p>- The date param works this way:</p> 0 Today. (Default) 1 Tomorrow. 2 The day after tomorrow. <br> <br> <p><b>/theatres?location=Madrid&lang=es</b> - Returns the list of theatres by location (madrid by default).</p> <p><b>/theatres/{tid}?lang=es</b> - Returns the geographic data of a theatre using nominatim, if available, of one tid = theatre_id.</p> <p><b>/theatres/{tid}/films?lang=es&date=0</b> - Returns the film list of one of one tid = theatre_id.</p> <p><b>/theatres/{tid}/films/{fid}/showtimes?lang=es&date=0</b> - Returns the showtimes of one tid = theatre_id and one fid = film_id.</p> <br> <br> <p><b>/films?location=Madrid&lang=es&date=0</b> - Returns the film list of one location.</p> <p><b>/films/{fid}?lang=es</b> - Returns the movie metadata from tmdb.</p> <p><b>/films/{fid}/theatres?location=Madrid&lang=es&date=0</b> - Returns the theatres list of one fid = film_id.</p> <p><b>/films/{fid}/theatres/{tid}/showtimes?lang=es&date=0</b> - Returns the showtimes of one tid = theatre_id and one fid = film_id.</p>";
	}

	@RequestMapping(value = "/theatres", method = RequestMethod.GET)
	public @ResponseBody String getTheatres(
			@RequestParam(value = "location", defaultValue = "Madrid") String location,
			@RequestParam(value = "lang", defaultValue = "es") String lang,
			@RequestParam(value = "date", defaultValue = "0") int date) {
		
		Gson gson = new Gson();
		Cache cache = cacheService.getTheatresByLocation(location, lang, date);
		return gson.toJson(cache);
	}

	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public @ResponseBody String getFilms(
			@RequestParam(value = "location", defaultValue = "Madrid") String location,
			@RequestParam(value = "lang", defaultValue = "es") String lang,
			@RequestParam(value = "date", defaultValue = "0") int date) {
		
		Gson gson = new Gson();
		Cache cache = cacheService.getFilmsByLocation(location, lang, date);
		return gson.toJson(cache);
	}

	@RequestMapping(value = "/theatres/{tid}/films", method = RequestMethod.GET)
	public @ResponseBody String getFilmsByTheatre(
			@PathVariable(value = "tid") String tid,
			@RequestParam(value = "lang", defaultValue = "es") String lang,
			@RequestParam(value = "date", defaultValue = "0") int date) {
		
		Gson gson = new Gson();
		Cache cache = cacheService.getFilmsByTid(tid, lang, date);
		return gson.toJson(cache);
	}

	@RequestMapping(value = "/films/{fid}/theatres", method = RequestMethod.GET)
	public @ResponseBody String getTheatresByFilm(
			@PathVariable(value = "fid") String fid,
			@RequestParam(value = "location", defaultValue = "Madrid") String location,
			@RequestParam(value = "lang", defaultValue = "es") String lang,
			@RequestParam(value = "date", defaultValue = "0") int date) {
		
		Gson gson = new Gson();
		Cache cache = cacheService.getTheatresByFid(fid, location, lang, date);
		return gson.toJson(cache);
	}

	@RequestMapping(value = { "/theatres/{tid}/films/{fid}/showtimes",
			"/films/{fid}/theatres/{tid}/showtimes" }, method = RequestMethod.GET)
	public @ResponseBody String getShowtimes(
			@PathVariable(value = "fid") String fid,
			@PathVariable(value = "tid") String tid,
			@RequestParam(value = "lang", defaultValue = "es") String lang,
			@RequestParam(value = "date", defaultValue = "0") int date) {
		
		Gson gson = new Gson();
		Cache cache = cacheService.getShowtimesByFidTid(fid, tid, lang, date);
		return gson.toJson(cache);
	}
}