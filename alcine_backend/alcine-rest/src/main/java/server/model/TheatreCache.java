package server.model;

import java.util.Date;

import org.json.JSONObject;

public class TheatreCache {
	private String tid;
	private String r_lang;
	private Date cache_date;
	private JSONObject response;

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

	public JSONObject getResponse() {
		return response;
	}
	
	public void setResponse(JSONObject response) {
		this.response = response;
	}
}