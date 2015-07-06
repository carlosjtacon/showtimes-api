package server.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.json.JSONException;

import server.model.FilmCache;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DBMapper {
	
	public static FilmCache getFilm(String fid, String lang) {
		
		FilmCache fc = null;
		
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			ResultSet rs = DataBaseConect.exeQuery("SELECT * FROM \"FILM_CACHE\" where fid = '"+ fid +"' and r_lang = '"+ lang +"'");	
			while (rs.next()) {
				JsonObject jo = new JsonParser().parse(rs.getString("response")).getAsJsonObject();
				fc = new FilmCache(rs.getString("fid"), rs.getString("r_lang"), rs.getDate("cache_date"), jo);
			}
			DataBaseConect.cerrarConexion();
			
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		return fc;
	}
	
	public static FilmCache insertFilm(String fid, String lang, Date date, JsonObject response) {
		
		return null;
	}
	
public static FilmCache updateFilm(String fid, String lang, Date date, JsonObject response) {
		
		return null;
	}

}
