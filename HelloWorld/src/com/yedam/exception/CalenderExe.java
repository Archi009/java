package com.yedam.exception;

import java.util.Calendar;

public class CalenderExe {
	public static void main(String[] args) {
		
		Calendar today = Calendar.getInstance(); // 인스턴스를 받아온다
		today.set(Calendar.YEAR, 2023); //필드: 값으로 년도 설정
		today.set(2024, 1,10);//int 매개 변수 3개 지정으로 년 월 일 지정
		
		
		int year = today.get(Calendar.YEAR); //Calendar 객체안에 필드값으로 YEAR,MONTH 따위가 정의되어 사용되는데, 객체 문서 내부에서 이것을 1,2 ,3 따위의 숫자를 담아두고 사용한다. 
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DATE);
		int day = today.get(Calendar.DAY_OF_WEEK);
		int dayOfMonth = today.getActualMaximum(Calendar.DATE);
		
		
		System.out.printf("%d 년 %d월 %d일 %d요일 마지막 날은 %d",year,month +1,date,day, dayOfMonth);
		
	}
}
