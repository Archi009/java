package com.yedam;

import java.util.Scanner;

public class Todo {
	public static void main(String[] args) {
//		java.util.Scanner scn = new java.util.Scanner(System.in); //system.in (기본 입력장치 : 키보드) //Scanner의 기본 위치는 이렇게 객체의 안쪽안쪽이다.

//		Scanner scn = new Scanner(System.in); // 줄여서 편하게 쓰려면 crtl + shift + o 로 scanner를 이뮤ㅗ트 한다
//		int num = scn.nextInt(); // 숫자를 읽어들일때는 int 로 변수 설정하고 받는 값도 스캐너의 다음 int값을 받아온다는 표시 해줌
//		System.out.printf("입력한 문자 값은 %d\n", num);
//
//		Scanner scn1 = new Scanner(System.in);
//		String str = scn1.nextLine(); // 문자를 처리 할 때는
//		System.out.printf("입력한 문자 값은 %s\n", str);
//
//		Scanner scn2 = new Scanner(System.in);
//		int str1 = Integer.parseInt(scn2.nextLine()); // 문자를 처리 할 때는
//		System.out.printf("입력한 문자 값은 %s\n", str);

		// system.out (기본 출력 장치 : 화면)

		// 은행 조회 프로그램
		Scanner scn3 = new Scanner(System.in);
		int balance = 0;
		while (true) {
			System.out.println("1.입금 2.출금 3.잔액조회 4.종료");
			System.out.print("메뉴를 선택하세요.>");
			int num2 = Integer.parseInt(scn3.nextLine());

			if (num2 == 1) { //입금
				System.out.println("입금액을 입력>");
				balance = Integer.parseInt(scn3.nextLine());
			} else if (num2 == 2) { //출금

			} else if (num2 == 3) {  //잔액조회
				System.out.printf("현재 잔액은 %d 입니다\n",balance);
				
			} else if (num2 == 4) {   //종료
				break;
				
			}
		}
		System.out.printf("end of prog\n");

	}
}
