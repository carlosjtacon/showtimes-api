package server.utils;

public class StringUtils {

	public static String cleanFilmName(String name) {
		String result = name.replace("(Dig)", "");
		//añadir otras nomenclaturas -> 3, digital......
		return result;
	}
	
}
