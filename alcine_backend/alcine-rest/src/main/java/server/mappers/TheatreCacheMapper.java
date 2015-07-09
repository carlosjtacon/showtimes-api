package server.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import server.model.TheatreCache;
import server.utils.DataBaseConect;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TheatreCacheMapper {
	public static TheatreCache getTheatre(String tid, String lang) {
		
		TheatreCache tc = null;
		
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			ResultSet rs = DataBaseConect.exeQuery("SELECT * FROM \"THEATRE_CACHE\" where tid = '"+ tid +"' and r_lang = '"+ lang +"'");	
			while (rs.next()) {
				JsonObject jo = new JsonParser().parse(rs.getString("response")).getAsJsonObject();
				tc = new TheatreCache(rs.getString("tid"), rs.getString("r_lang"), rs.getDate("cache_date"), jo);
			}
			DataBaseConect.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tc;
	}
	
	public static TheatreCache insertTheatre(String tid, String lang, Date date, JsonObject response) {
				
		try {
			
			if(response != null) {
				DataBaseConect.cargarDriver();
				DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
				DataBaseConect.exeUpdate("INSERT INTO \"THEATRE_CACHE\" (tid, r_lang, cache_date, response) VALUES ('"+ tid +"', '"+ lang +"', '"+ new java.sql.Timestamp((date).getTime()) +"', '"+ response.toString() +"');");	
				DataBaseConect.cerrarConexion();
			} else {
				return new TheatreCache();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new TheatreCache(tid, lang, date, response);
	}
	
	public static TheatreCache updateTheatre(String tid, String lang, Date date, JsonObject response) {
				
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			DataBaseConect.exeUpdate("UPDATE \"THEATRE_CACHE\" SET cache_date='"+ new java.sql.Timestamp((date).getTime()) +"', response='"+ response.toString() +"' WHERE tid = '"+ tid +"' AND r_lang = '"+ lang +"';");	
			DataBaseConect.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new TheatreCache(tid, lang, date, response);
	}
}
