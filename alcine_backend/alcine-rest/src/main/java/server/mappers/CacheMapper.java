package server.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import server.model.Cache;
import server.utils.DataBaseConect;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CacheMapper {
	public static Cache getCache(String url, String r_location, String r_lang, int r_date) {
		
		Cache c = null;
		
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			ResultSet rs = DataBaseConect.exeQuery("SELECT * FROM \"CACHE\" WHERE url='"+ url +"' AND r_location='"+ r_location +"' AND r_lang='"+ r_lang +"' AND r_date='"+ r_date +"';");	
			while (rs.next()) {
				JsonObject jo = new JsonParser().parse(rs.getString("response")).getAsJsonObject();
				c = new Cache(rs.getString("url"), rs.getString("r_location"), rs.getString("r_lang"), rs.getInt("r_date"), rs.getString("tid"), rs.getString("fid"), rs.getDate("cache_date"), jo);
			}
			DataBaseConect.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static Cache insertCache(String url, String r_location, String r_lang, int r_date, String tid, String fid, Date cache_date, JsonObject response) {
				
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			DataBaseConect.exeUpdate("INSERT INTO \"CACHE\"(url, r_location, r_lang, r_date, tid, fid, cache_date, response) VALUES ('"+ url +"', '"+ r_location +"', '"+ r_lang +"', '"+ r_date +"', '"+ tid +"', '"+ fid +"', '"+ new java.sql.Timestamp((cache_date).getTime()) +"', '"+ response.toString() +"');");	
			DataBaseConect.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Cache(url, r_location, r_lang, r_date, tid, fid, cache_date, response);
	}
	
	public static Cache updateCache(String url, String r_location, String r_lang, int r_date, String tid, String fid, Date cache_date, JsonObject response) {
				
		try {
			
			DataBaseConect.cargarDriver();
			DataBaseConect.conectarAlServidor("postgres", "postgres", "localhost", "alcine-dev");
			DataBaseConect.exeUpdate("UPDATE \"CACHE\" SET  tid='"+ tid +"', fid='"+ fid +"', cache_date='"+ new java.sql.Timestamp((cache_date).getTime()) +"', response='"+ response.toString() +"' WHERE url='"+ url +"' AND r_location='"+ r_location +"' AND r_lang='"+ r_lang +"' AND r_date='"+ r_date +"';");	
			DataBaseConect.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Cache(url, r_location, r_lang, r_date, tid, fid, cache_date, response);
	}

}
