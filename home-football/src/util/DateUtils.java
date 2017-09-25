package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat yyyyMMddHHmm = new SimpleDateFormat("yyyy-MM-ddHH:mm");
	
	public static Date changeNotTimeStrToDate(String str) throws ParseException {
		return yyyyMMdd.parse(str);
	}
	
	public static String changeNotTimeDateToString(Date date) {
		return yyyyMMdd.format(date);
	}
	
	public static Date changeStrToDate(String str) throws ParseException {
		return yyyyMMddHHmm.parse(str);
	}
	
	public static String changeDateToString(Date date) {
		return yyyyMMddHHmm.format(date);
	}
}
