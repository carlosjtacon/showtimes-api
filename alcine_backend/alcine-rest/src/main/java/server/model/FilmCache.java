package server.model;

import java.util.Date;

import org.json.JSONObject;

public class FilmCache {
	private String fid;
	private String r_lang;
	private Date cache_date;
	private JSONObject response;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
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