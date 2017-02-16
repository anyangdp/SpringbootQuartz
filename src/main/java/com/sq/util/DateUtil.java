package com.sq.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String date86(Date date){
		if (null != date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		}
		return null;
	}
}
