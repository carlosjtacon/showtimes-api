package server.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import server.model.FilmCache;
import server.utils.DataBaseConect;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FilmCacheMapper {
	
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fc;
	}
	
	public static FilmCache insertFilm(String fid, String lang, Date date, JsonObject response) {
				
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			DataBaseConect.exeUpdate("INSERT INTO \"FILM_CACHE\" (fid, r_lang, cache_date, response) VALUES ('"+ fid +"', '"+ lang +"', '"+ new java.sql.Timestamp((date).getTime()) +"', '"+ response.toString() +"');");	
			DataBaseConect.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new FilmCache(fid, lang, date, response);
	}
	
	public static FilmCache updateFilm(String fid, String lang, Date date, JsonObject response) {
				
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			DataBaseConect.exeUpdate("UPDATE \"FILM_CACHE\" SET cache_date='"+ new java.sql.Timestamp((date).getTime()) +"', response='"+ response.toString() +"' WHERE fid = '"+ fid +"' AND r_lang = '"+ lang +"';");	
			DataBaseConect.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new FilmCache(fid, lang, date, response);
	}

}
