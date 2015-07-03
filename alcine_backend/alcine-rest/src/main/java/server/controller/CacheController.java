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

@RestController
public class CacheController {
	
	@Autowired
	private CacheService cacheService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public @ResponseBody String getRoot() {
		return "Welcome to AlCine REST API";
	}
	
	@RequestMapping(value="/theatres", method=RequestMethod.GET)
	public @ResponseBody Cache getTheatres(@RequestParam(value="location", defaultValue="Madrid") String location, @RequestParam(value="lang", defaultValue="es") String lang, @RequestParam(value="date", defaultValue="0") int date) {
		System.out.println(location + lang + date);
		return cacheService.getTheatresByLocation(location, lang, date);
	}

	@RequestMapping(value="/films", method=RequestMethod.GET)
	public @ResponseBody Cache getFilms(@RequestParam(value="location", defaultValue="Madrid") String location, @RequestParam(value="lang", defaultValue="es") String lang, @RequestParam(value="date", defaultValue="0") int date) {
		return cacheService.getFilmsByLocation(location, lang, date);
	}
	
	@RequestMapping(value="/theatres/{tid}/films", method=RequestMethod.GET)
	public @ResponseBody Cache getFilmsByTheatre(@PathVariable(value="tid") String tid, @RequestParam(value="lang", defaultValue="es") String lang, @RequestParam(value="date", defaultValue="0") int date) {
		return cacheService.getFilmsByTid(tid, lang, date);
	}

	@RequestMapping(value="/films/{fid}/theatres", method=RequestMethod.GET)
	public @ResponseBody Cache getTheatresByFilm(@PathVariable(value="fid") String fid, @RequestParam(value="lang", defaultValue="es") String lang, @RequestParam(value="date", defaultValue="0") int date) {
		return cacheService.getTheatresByFid(fid, lang, date);
	}

	@RequestMapping(value={"/theatres/{tid}/films/{fid}/showtimes", "/films/{fid}/theatres/{tid}/showtimes"}, method=RequestMethod.GET)
	public @ResponseBody Cache getShowtimes(@PathVariable(value="fid") String fid, @PathVariable(value="tid") String tid, @RequestParam(value="lang", defaultValue="es") String lang, @RequestParam(value="date", defaultValue="0") int date) {
		return cacheService.getShowtimesByFidTid(fid, tid, lang, date);
	}
}