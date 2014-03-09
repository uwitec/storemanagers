package com.js.commons.util;

public enum Week {

	MONDAY("����һ", "Monday", "Mon.", 1), TUESDAY("���ڶ�", "Tuesday", "Tues.", 2), WEDNESDAY(
			"������", "Wednesday", "Wed.", 3), THURSDAY("������", "Thursday",
			"Thur.", 4), FRIDAY("������", "Friday", "Fri.", 5), SATURDAY("������",
			"Saturday", "Sat.", 6), SUNDAY("������", "Sunday", "Sun.", 7);

	String name_cn;
	String name_en;
	String name_enShort;
	int number;

	Week(String name_cn, String name_en, String name_enShort, int number) {
		this.name_cn = name_cn;
		this.name_en = name_en;
		this.name_enShort = name_enShort;
		this.number = number;
	}

	public String getChineseName() {
		return name_cn;
	}

	public String getName() {
		return name_en;
	}

	public String getShortName() {
		return name_enShort;
	}

	public int getNumber() {
		return number;
	}
}