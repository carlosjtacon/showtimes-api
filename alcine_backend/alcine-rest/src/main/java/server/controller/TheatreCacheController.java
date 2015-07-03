package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import server.model.TheatreCache;
import server.service.TheatreCacheService;

@RestController
public class TheatreCacheController {
	
	@Autowired
	private TheatreCacheService theatreCacheService;
	
	@RequestMapping(value="/theatres/{tid}", method=RequestMethod.GET)
	public @ResponseBody TheatreCache getTheatre(@PathVariable(value="tid") String tid, @RequestParam(value="lang", defaultValue="es") String lang) {
		return theatreCacheService.getTheatreByTid(tid, lang);
	}
}