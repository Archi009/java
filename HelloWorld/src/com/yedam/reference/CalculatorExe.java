package com.yedam.reference;

import java.util.Iterator;

public class CalculatorExe {
	public static void main(String[] args) {
		Book[] bookRep = new Book[5];
		bookRep[0] = new Book("이것이자바다", "신용권", "한빛미디어", 10000);
		bookRep[1] = new Book("자바스크립트", "마용권", "구리미디어", 20000);
		bookRep[2] = new Book("이것이리눅스", "고경희", "이지스퍼블리싱", 40000);
		bookRep[3] = new Book("이것이우분투", "고영희", "이지스퍼블리싱", 30000);
		bookRep[4] = new Book("이것이파이썬", "영고희", "예담", 50000);
		Calculator cal = new Calculator();

		int[] ary1 = cal.getNumAry(5);
		int[] ary2 = cal.getNumAry(5);

		for (int i = 0; i < 6; i++) {
			cal.printStar(i, "(⊙_⊙)？");
			System.out.println("");
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		cal.printStar(5);
		cal.printStarRight(5);
		// 랜덤 숫자로 된 배열
		int[] arr2 = cal.getNumAry(5);
		// 배열의 합이 더 큰 배열반환
		int[] arr = cal.getMaxSumAry(ary1, ary2);
		cal.printArr(arr);
		cal.printArr(arr2);

		System.out.println(cal.getBookInfo("자바스크립트",bookRep));
		cal.getBookAuthor("자바스크립트",bookRep);

		// long(4byte)>int(3byte)>short(2byte)>byte(1byte)
		// double(4byte)>float(3byte)
		System.out.println(cal.sum(1, 2));
		System.out.println(cal.sum(10.2, 20));
		System.out.println(cal.sum(new int[] { 10, 20, 30, 40, 50 }));

	}
}
