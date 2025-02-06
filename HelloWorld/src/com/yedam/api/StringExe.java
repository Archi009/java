package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		// String str = new String(매개값);
		String str = new String(new byte[] { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 });
		System.out.println(str);

		byte[] result = str.getBytes();
		for (byte b : result) {
			System.out.print(b + ", ");
		}
		System.out.println(str.hashCode());

		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + ",");
		}

		String ssn = "010624-1230123";
		char chr = ssn.charAt(7);
		switch (chr) {
		case '1', '3': {
			System.out.println("남자");
			break;
		}
		case '2', '4': {
			System.out.println("여자옴");
			break;
		}
		default:
			System.out.println("몰라효");
		}
	}
}
