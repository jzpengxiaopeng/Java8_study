package com.jzpengxiaopeng.java8.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDateUtil {
	
	private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		};
	};
	
	public static Date getDate(String str) {
		try {
			return tl.get().parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			tl.remove();
		}
		return null;
	}
	
}
