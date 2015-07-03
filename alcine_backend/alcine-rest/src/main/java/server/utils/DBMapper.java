package server.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import server.model.FilmCache;

public class DBMapper {
	
	public static FilmCache getFilm(String fid, String lang) {
		
		FilmCache fc = null;
		
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			ResultSet rs = DataBaseConect.exeQuery("SELECT * FROM \"FILM_CACHE\" where fid = '"+ fid +"' and r_lang = '"+ lang +"'");	
			while (rs.next()) {
				fc = new FilmCache(rs.getString("fid"), rs.getString("r_lang"), rs.getDate("cache_date"), new JSONObject(rs.getString("response")));
			}
			DataBaseConect.cerrarConexion();
			
		} catch (JSONException | SQLException e) {
			e.printStackTrace();
		}
		
		return fc;
	}
	
	public static FilmCache insertFilm(String fid, String lang, Date date, JSONObject response) {
		
		return null;
	}

}
