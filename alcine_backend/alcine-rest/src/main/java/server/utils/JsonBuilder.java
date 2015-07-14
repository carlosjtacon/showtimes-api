package server.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonBuilder {
	public static JsonObject buildGetTheatresByLocation(JsonObject kimono_response) {
		
		JsonArray kimono_theatres = kimono_response.getAsJsonObject("results").getAsJsonArray("movie_theaters");
		
		JsonArray theatres = new JsonArray();
		for (int i = 0; i < kimono_theatres.size(); i++) {
			
			JsonObject kimono_theatre = kimono_theatres.get(i).getAsJsonObject();
			
			JsonObject theatre = new JsonObject();
			
			String tid = StringUtils.getUrlParam(kimono_theatre.getAsJsonObject("name").get("href").getAsString(), "tid");
			theatre.addProperty("tid", tid);
			
			String name = kimono_theatre.getAsJsonObject("name").get("text").getAsString().toUpperCase();
			theatre.addProperty("name", name);
			
			String address  = StringUtils.cleanAddress(kimono_theatre.getAsJsonObject("info").get("text").getAsString());
			theatre.addProperty("address", address);
			
			String contact = StringUtils.cleanContactPhone(kimono_theatre.getAsJsonObject("info").get("text").getAsString());
			theatre.addProperty("contact", contact);
			
			theatres.add(theatre);
			
		}
		
		JsonObject response = new JsonObject();
		response.add("theatres", theatres);
		return response;
	}

	public static JsonObject buildGetFilmsByLocation(JsonObject kimono_response) {

		JsonArray kimono_films = kimono_response.getAsJsonObject("results").getAsJsonArray("movies");
		
		JsonArray films = new JsonArray();
		for (int i = 0; i < kimono_films.size(); i++) {
			
			JsonObject kimono_film = kimono_films.get(i).getAsJsonObject();
			
			JsonObject film = new JsonObject();
			
			String fid = StringUtils.getUrlParam(kimono_film.getAsJsonObject("mocie_name").get("href").getAsString(), "mid");
			film.addProperty("fid", fid);
			
			String name = StringUtils.cleanFilmName(kimono_film.getAsJsonObject("mocie_name").get("text").getAsString());
			film.addProperty("name", name);
			
			boolean isDigital = kimono_film.getAsJsonObject("mocie_name").get("text").getAsString().contains("(Digital)") 
					|| kimono_film.getAsJsonObject("mocie_name").get("text").getAsString().contains("(Dig)");
			film.addProperty("digital", isDigital);
			
			boolean is3D = kimono_film.getAsJsonObject("mocie_name").get("text").getAsString().contains("3D") ;
			film.addProperty("3D", is3D);
			
			boolean isVOS = kimono_film.getAsJsonObject("mocie_name").get("text").getAsString().contains("V.O.S.E.") 
					|| kimono_film.getAsJsonObject("mocie_name").get("text").getAsString().contains("V.O.S.");
			film.addProperty("vos", isVOS);
			
			String raw_info = kimono_film.get("movie_info").getAsString();
			film.addProperty("raw_info", raw_info);
			
			films.add(film);
			
		}
		
		JsonObject response = new JsonObject();
		response.add("films", films);
		return response;
	}

	public static JsonObject buildGetFilmsByTid(JsonObject kimono_response) {
		
		JsonArray kimono_films = kimono_response.getAsJsonObject("results").getAsJsonArray("movies");
		
		JsonArray films = new JsonArray();
		for (int i = 0; i < kimono_films.size(); i++) {
			
			JsonObject kimono_film = kimono_films.get(i).getAsJsonObject();
			
			JsonObject film = new JsonObject();
			
			String fid = StringUtils.getUrlParam(kimono_film.getAsJsonObject("movie_name").get("href").getAsString(), "mid");
			film.addProperty("fid", fid);
			
			String name = StringUtils.cleanFilmName(kimono_film.getAsJsonObject("movie_name").get("text").getAsString());
			film.addProperty("name", name);
			
			boolean isDigital = kimono_film.getAsJsonObject("movie_name").get("text").getAsString().contains("(Digital)") 
					|| kimono_film.getAsJsonObject("movie_name").get("text").getAsString().contains("(Dig)");
			film.addProperty("digital", isDigital);
			
			boolean is3D = kimono_film.getAsJsonObject("movie_name").get("text").getAsString().contains("3D") ;
			film.addProperty("3D", is3D);
			
			boolean isVOS = kimono_film.getAsJsonObject("movie_name").get("text").getAsString().contains("V.O.S.E.") 
					|| kimono_film.getAsJsonObject("movie_name").get("text").getAsString().contains("V.O.S.");
			film.addProperty("vos", isVOS);
			
			String raw_info = kimono_film.get("movie_info").getAsString();
			film.addProperty("raw_info", raw_info);
			
			JsonObject showtimes = new JsonObject();
			String time = kimono_film.getAsJsonObject("showtimes").get("text").getAsString();
			showtimes.addProperty("time", time);
			String tickets = kimono_film.getAsJsonObject("showtimes").get("href").getAsString();
			showtimes.addProperty("tickets", tickets);
			film.add("showtimes (beta)", showtimes);
			
			films.add(film);
			
		}
		
		JsonObject response = new JsonObject();
		response.add("films", films);
		
		JsonObject kimono_theatre = kimono_response.getAsJsonObject("results").getAsJsonArray("movie_theaters").get(0).getAsJsonObject();
		JsonObject theatre = new JsonObject();
		theatre.addProperty("tid", StringUtils.getUrlParam(kimono_response.get("url").getAsString(), "tid"));
		theatre.addProperty("name", kimono_theatre.get("theatre_name").getAsString().toUpperCase());
		theatre.addProperty("info", kimono_theatre.getAsJsonObject("theatre_info").get("text").getAsString());
		
		response.add("theatre", theatre);
		
		return response;
	}

	public static JsonObject buildGetTheatresByFid(JsonObject kimono_response) {

		JsonArray kimono_theatres = kimono_response.getAsJsonObject("results").getAsJsonArray("theatres");
		
		JsonArray theatres = new JsonArray();
		for (int i = 0; i < kimono_theatres.size(); i++) {
			
			JsonObject kimono_theatre = kimono_theatres.get(i).getAsJsonObject();
			
			JsonObject theatre = new JsonObject();
			
			String tid = StringUtils.getUrlParam(kimono_theatre.getAsJsonObject("theatre_name").get("href").getAsString(), "tid");
			theatre.addProperty("tid", tid);
			
			String name = kimono_theatre.getAsJsonObject("theatre_name").get("text").getAsString().toUpperCase();
			theatre.addProperty("name", name);
			
			String address  = StringUtils.cleanAddress(kimono_theatre.getAsJsonObject("info").get("text").getAsString());
			theatre.addProperty("address", address);
			
//			JsonArray kimono_showtimes = kimono_theatre.getAsJsonArray("showtimes");
//			JsonArray showtimes = new JsonArray();
//			for (int j = 0; j < kimono_showtimes.size(); j++) {
//				
//				JsonObject showtime = new JsonObject();
//				String time = kimono_showtimes.get(j).getAsJsonObject().get("text").getAsString();
//				showtime.addProperty("time", time);
//				String tickets = kimono_showtimes.get(j).getAsJsonObject().get("href").getAsString();
//				showtime.addProperty("tickets", tickets);
//				showtimes.add(showtime);
//			
//			}
//			
//			theatre.add("showtimes", showtimes);
			
			theatres.add(theatre);
			
		}
		
		JsonObject response = new JsonObject();
		response.add("theatres", theatres);
		
		JsonObject kimono_film = kimono_response.getAsJsonObject("results").getAsJsonArray("film").get(0).getAsJsonObject();
		JsonObject film = new JsonObject();
		film.addProperty("fid", StringUtils.getUrlParam(kimono_response.get("url").getAsString(), "mid"));
		film.addProperty("name", StringUtils.cleanFilmName(kimono_film.get("film_name").getAsString()));
		
		boolean isDigital = kimono_film.get("film_name").getAsString().contains("(Digital)") 
				|| kimono_film.get("film_name").getAsString().contains("(Dig)");
		film.addProperty("digital", isDigital);
		
		boolean is3D = kimono_film.get("film_name").getAsString().contains("3D") ;
		film.addProperty("3D", is3D);
		
		boolean isVOS = kimono_film.get("film_name").getAsString().contains("V.O.S.E.") 
				|| kimono_film.get("film_name").getAsString().contains("V.O.S.");
		film.addProperty("vos", isVOS);
		
		response.add("film", film);
		
		return response;
	}

	public static JsonObject buildGetShowtimesByFidTid(JsonObject kimono_response) {
		
		JsonObject response = new JsonObject();
		String film = StringUtils.cleanFilmName(kimono_response.getAsJsonObject("results").getAsJsonArray("film_theatre").get(0).getAsJsonObject().get("film_name").getAsString());
		response.addProperty("film", film);
		String theatre = kimono_response.getAsJsonObject("results").getAsJsonArray("film_theatre").get(0).getAsJsonObject().get("theatre_name").getAsJsonObject().get("text").getAsString().toUpperCase();
		response.addProperty("theatre", theatre);
		
		JsonArray kimono_showtimes = kimono_response.getAsJsonObject("results").getAsJsonArray("showtimes_info");
		JsonArray showtimes = new JsonArray();
		for (int j = 0; j < kimono_showtimes.size(); j++) {
			
			JsonObject showtime = new JsonObject();
			String time = kimono_showtimes.get(j).getAsJsonObject().get("showtimes").getAsJsonObject().get("text").getAsString();
			showtime.addProperty("time", time);
			String tickets = kimono_showtimes.get(j).getAsJsonObject().get("showtimes").getAsJsonObject().get("href").getAsString();
			showtime.addProperty("tickets", tickets);
			showtimes.add(showtime);
		
		}
		
		response.add("showtimes", showtimes);
		
		return response;
	}
}
