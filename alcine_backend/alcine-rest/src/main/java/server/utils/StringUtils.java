package server.utils;

public class StringUtils {

	public static String cleanFilmName(String name) {
		String result = name.replace("(Dig)", "").replace("(Digital)", "").replace("3D", "");
		//añadir otras nomenclaturas -> 3, digital......
		return result;
	}
	
}
