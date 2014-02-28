package com.js.commons;

public class JStr {

	public static boolean isEmpty(String s) {
		if (s == null || "".equals(s)) {
			return true;
		}
		return false;
	}

	public String encoding(String s, String code) {
		String _s = null;
		try {
			_s = new String(s.getBytes("ISO-8859-1"), code);
		} catch (Exception e) {
			//
		}
		return _s;
	}
}
