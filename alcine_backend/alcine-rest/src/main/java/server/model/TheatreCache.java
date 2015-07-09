package server.model;

import java.util.Date;

import com.google.gson.JsonObject;

public class TheatreCache {
	private String tid;
	private String r_lang;
	private Date cache_date;
	private JsonObject response;

	public TheatreCache() {}
	
	public TheatreCache(String tid, String r_lang, Date cache_date, JsonObject response) {
		this.tid = tid;
		this.r_lang = r_lang;
		this.cache_date = cache_date;
		this.response = response;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getR_lang() {
		return r_lang;
	}
	
	public void setR_lang(String r_lang) {
		this.r_lang = r_lang;
	}

	public Date getCache_date() {
		return cache_date;
	}
	
	public void setCache_date(Date cache_date) {
		this.cache_date = cache_date;
	}

	public JsonObject getResponse() {
		return response;
	}
	
	public void setResponse(JsonObject response) {
		this.response = response;
	}
}