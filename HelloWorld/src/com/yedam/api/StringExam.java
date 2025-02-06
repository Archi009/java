package com.yedam.api;

public class StringExam {
	public static void main(String[] args) {
		연습();
		no1();
		no2();
		no3();
	}

	private static void 연습() {

		String text = "Hello";
		String text1 = "Java";
		StringUtil.연결하기(text, text1);
	}

	static void no1() {

		String ssn1 = "250105 3111111";
		String ssn2 = "2501053111111";
		String ssn3 = "250105-2111111";
		StringUtil.checkGender(ssn2);
	}

	static void no2() {
		String file1 = "C:/temp/flower.jpg";
		String file2 = "D:/web/project/guide.jpg";
		StringUtil.checkExtention(file1);

	}

	static void no3() {
		String str1 = "  suggest ";
		String str2 = "  currently ";
		String str3 = "  particular ";
		StringUtil.checklength(str2);
	}

}
