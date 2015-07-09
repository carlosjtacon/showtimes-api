package server.utils;

public class StringUtils {

	public static String cleanFilmName(String name) {
		String result = name
				.replace(" (Dig)", "")
				.replace(" (Digital)", "")
				.replace(" 3D", "");
		//añadir otras nomenclaturas -> 3, digital......
		return result;
	}
	
	public static String cleanAddress(String address) {
		String result[] = address.split(" -");
		return result[0];
	}
	
	public static String cleanAddressName(String aname) {
		String result = aname
				.replace("C/ ", "")
				.replace("C/", "")
				.replace("s/n", "")
				.replace("CTRA", "carretera")
				.replace(".", " ");
		return result;
	}
	
}
