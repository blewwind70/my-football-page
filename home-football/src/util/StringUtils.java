package util;

public class StringUtils {
	
	public static int stringToNumber(String str) {
		return stringToNumber(str, 0);
	}

	public static int stringToNumber(String str, int defaultValue) {
		if(str == null || "".equals(str)) {
			return defaultValue;
		}
		return Integer.parseInt(str);
	}
}
