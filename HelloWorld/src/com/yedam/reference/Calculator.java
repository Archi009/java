package com.yedam.reference;

import java.util.Calendar;
import java.util.function.IntPredicate;

public class Calculator {

	// 좌측 정렬 별
	public void printStar(int times) {
		for (int i = 0; i < times; i++) {
			printStar(i, "🎇");
			System.out.println("");
		}
	}

	// 우측 정렬 별
	public void printStarRight(int times) {
		for (int i = 0; i < times; i++) {
			printVoid(times - i);
			printStar(i, "*");
			System.out.println("");
		}
	}
	// 별 출력 메소드

	public void printStar(int times, String types) { // 매개변수.
		for (int i = 0; i < times; i++) {
			System.out.print(types);
		}
	}

	// 공백출력 메소드

	public void printVoid(int times) { // 매개변수.
		for (int i = 0; i < times; i++) {
			System.out.print(" ");

		}
	}

	// 두 수의 합을 반환하는 함수

	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	// 동일 이름의 메소드를 매개값따위를 달리하여 중복 정의 : 메소드 오버로딩

	public double sum(double num1, double num2) {
		return num1 + num2;
	}

	// 배열의 값을 모두 더해서 반환
	public int sum(int[] numAry) {
		int result = 0;
		for (int i = 0; i < numAry.length; i++) {
			result += numAry[i];
		}
		return result;
	}

	// 두 수 중 큰값을 반환
	public int maxNum(int num1, int num2) {

		return (num1 > num2) ? num1 : num2;
	}

	// 두 배열의 합 중 어느것이 더 큰지
	public int[] getMaxSumAry(int[] ary1, int[] ary2) {

		return (maxNum(sum(ary1), sum(ary2)) == sum(ary1)) ? ary1 : ary2;

	}

	// 1 ~ 100 사이의 임의값을 반환
	public int[] getNumAry(int num) {
		int[] numAry = new int[num];
		for (int i = 0; i < num; i++) {
			numAry[i] = (int) (Math.random() * 100) + 1;
		}
		return numAry;
	}

	// 배열 출력하는 메소드
	public void printArr(int[] arr) {
		System.out.print("{");
		for (int num : arr) {
			System.out.print(num + ",");
		}

		System.out.print("}\n");
	}

	public String getBookAuthor(String name, Book[] bookRepository) {

		for (int i = 0; i < bookRepository.length; i++) {
			if (name.equals(bookRepository[i].getBookNm())) {
				return bookRepository[i].getAuthor();
			}
		}
		return "찾으시는 책이 없습니다.";// for문이 끝나고도 return값이 없는경우 오류가 발생함으로 for문이 끝났을때 반환해줄 값이 필요!!

	}

	public int getBookPrice(String name, Book[] bookRepository) {

		for (int i = 0; i < bookRepository.length; i++) {
			if (name.equals(bookRepository[i].getBookNm())) {
				return bookRepository[i].getPrice();
			}
		}
		return 0;// for문이 끝나고도 return값이 없는경우 오류가 발생함으로 for문이 끝났을때 반환해줄 값이 필요!!

	}

	public boolean getBookEx(String name, Book[] bookRepository) {

		for (int i = 0; i < bookRepository.length; i++) {
			if (name.equals(bookRepository[i].getBookNm())) {
				return true;
			}
		}
		return false;// for문이 끝나고도 return값이 없는경우 오류가 발생함으로 for문이 끝났을때 반환해줄 값이 필요!!

	}
	public Book getBookInfo(String name, Book[] bookRepository) {
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && name.equals(bookRepository[i].getBookNm())) {
				if (name.equals(bookRepository[i].getBookNm())) {
				return bookRepository[i];
			}
		}
		}
		return null;// for문이 끝나고도 return값이 없는경우 오류가 발생함으로 for문이 끝났을때 반환해줄 값이 필요!!

	}
	
	public void showCalendar() {
//		1월달력		
		String[] days = {"Sun Mon Tue Wen Thr Fri Sat"};
		for(String day : days) { //요일 배열 for : 문으로 전체 출력
			System.out.printf("%4s",day);
		}
		System.out.println("\n=============================");
		//공백, 말일 계산.
		Calendar calen = Calendar.getInstance();  //calendar클래스는 추상 클래스이기 때문에 구현된 인스턴스를 변수에 부여하기위해 getInstance를 사용한다.
		
		int lastDay = calen.getActualMaximum(Calendar.DAY_OF_MONTH); //getActualMacimum으로 달의 실질 최대일값을 가져온다 Calendar.DAY_OF_MONTH 현재 월의 날짜 
//		System.out.println(lastDay);
		calen.set(Calendar.DATE, 1);// 만들어준 calendar인스턴스의 현재 월의 날짜를 1일로 변경한다.
		
		int dayOfWeek = calen.get(Calendar.DAY_OF_WEEK); //1일이 된 calen의 요일을 가져온다 (달력 앞쪽의 빈칸을 구한 숫자)
//		System.out.println(dayOfWeek);
		
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("    ");			//요일만큼 빈칸을 그린다.
		}
		
		for (int i = 1; i < lastDay; i++) {
			System.out.printf("%02d  ",i);		//마지막 날짜까지 출력한다.7일마다 줄바꿈
			if(dayOfWeek%7==0) {
			System.out.println("");	
			}
			dayOfWeek++;
		}
		
		
	}

}
