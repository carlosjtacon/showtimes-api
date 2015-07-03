package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import server.model.FilmCache;
import server.service.FilmCacheService;

@RestController
public class FilmCacheController {
	
	@Autowired
	private FilmCacheService filmCacheService;

	@RequestMapping(value="/films/{fid}", method=RequestMethod.GET)
	public @ResponseBody FilmCache getFilm(@PathVariable(value="fid") String fid, @RequestParam(value="lang", defaultValue="es") String lang) {
		return filmCacheService.getFilmByFid(fid, lang);
	}
}