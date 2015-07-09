package server.utils;

import java.util.Date;

public class DateUtils {
	
	private static final int FILM_CACHE_TIME_DAYS = 30;
	private static final int THEATRE_CACHE_TIME_DAYS = 30;

	public static boolean isFilmCacheValid(Date cacheDate) {

		Date now = new Date();
		long diff = now.getTime() - cacheDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		if (diffDays > FILM_CACHE_TIME_DAYS)
			return false;
		else
			return true;

	}
	
	public static boolean isTheatreCacheValid(Date cacheDate) {

		Date now = new Date();
		long diff = now.getTime() - cacheDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		if (diffDays > THEATRE_CACHE_TIME_DAYS)
			return false;
		else
			return true;

	}
}
