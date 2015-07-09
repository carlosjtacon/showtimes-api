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

import com.google.gson.Gson;

@RestController
public class TheatreCacheController {

	@Autowired
	private TheatreCacheService theatreCacheService;

	@RequestMapping(value = "/theatres/{tid}", method = RequestMethod.GET)
	public @ResponseBody String getTheatre(
			@PathVariable(value = "tid") String tid,
			@RequestParam(value = "lang", defaultValue = "es") String lang) {
		
		Gson gson = new Gson();
		TheatreCache theatre = theatreCacheService.getTheatreByTid(tid, lang);
		return gson.toJson(theatre);
	}
}