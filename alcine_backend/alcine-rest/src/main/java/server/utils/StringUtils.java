package server.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringUtils {

	public static String cleanFilmName(String name) {
		String result = name
				.replace(" (Dig)", "")
				.replace(" (Digital)", "")
				.replace(" V.O.S.E.", "")
				.replace(" V.O.S.", "")
				.replace(" 3D", "");
		return result;
	}
	
	public static String cleanAddress(String address) {
		String result[] = address.split(" - ");
		return result[0];
	}
	
	public static String cleanContactPhone(String address) {
		String result[] = address.split(" - ");
		if (result.length == 2)
			return result[1];
		else 
			return null;
	}
	
	public static String cleanAddressName(String aname) {
		String result = aname
				.replace("C/ ", "")
				.replace("C/", "")
				.replace("s/n", "")
				.replace("CTRA", "carretera")
				.replace(".", " ")
				.replace(",", " ");
		return result;
	}
	
	public static String getUrlParam(String url, String param) {
		try {
			
			Map<String, String> params = splitQuery(new URL(url));
			return params.get(param);
			
		} catch (UnsupportedEncodingException | MalformedURLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static Map<String, String> splitQuery(URL url) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new LinkedHashMap<String, String>();
	    String query = url.getQuery();
	    String[] pairs = query.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
	    }
	    return query_pairs;
	}

}
