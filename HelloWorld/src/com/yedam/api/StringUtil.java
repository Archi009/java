package com.yedam.api;

public class StringUtil {
	static void 연결하기(String str, String str2) {
		System.out.println(str.concat(", ").concat(str2));
	}

	public static void checkGender(String str) {
		// 남자 여자

		switch (str.charAt(7 + ((str.length() - 13)) - 1)) {
		case '1', '3': {

			System.out.println("남자입니다.");
			break;
		}
		case '2', '4': {

			System.out.println("여자입니다.");
			break;
		}
		default:

		}

	}

	public static void checkExtention(String str) {
		// 확장자 출력
		System.out.println("확장자는: " + str.substring(str.indexOf(".") + 1) + "입니다.");

	}

	public static void checklength(String str) {
		// 문자 길이 출력

		System.out.println("문자의 길이: " + str.trim().length() + "입니다.");
	}

}
