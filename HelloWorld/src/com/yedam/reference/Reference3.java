package com.yedam.reference;

import java.util.Scanner;

public class Reference3 {
	public static void main(String[] args) {
		String[][] friend = new String[100][3];
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		friend[0][0] = "이노을";
		friend[0][1] = "010-1231-1231";
		friend[0][2] = "여";

		while (run) {
			System.out.println("1.목록(이름,연락처,성별) 2.등록 3.조회(성별별로) 4.삭제(이름) 5.수정(이름조회: 연락처 수정) 9.종료");
			System.out.println("기능을 선택하세요.>");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1:
				list(friend, scn);
				break;
			case 2:
				exe(friend, scn);
				break;
			case 3:
				search(friend, scn);
				break;
			case 4:
				delList(friend, scn);
				break;
			case 5:
				System.out.println("연락처를 수정할 목록의 이름을 입력해 주세요.");
				String name = scn.nextLine();
				editList(friend, scn, name);
				break;
			case 6:
				System.out.println("==========.");
				System.out.println("프로그램 종료.");
				System.out.println("==========.");
				run = false;
				break;
			default:
				System.out.println("정의되지 않은 값입니다. 다시 선택해주세요.");
				break;
			}
		}
	}// end of main

	public static void list(String[][] friend, Scanner scn) {
		if (friend[0][0] != null) {
			System.out.println("이  름 \t  연락처\t       성별\n===========================");

			for (int i = 0; i < friend.length; i++) {

				if (friend[i][0] != null) {

					System.out.printf("%-5s%-13s%6s \n", friend[i][0], friend[i][1], friend[i][2]);
				}
			}
		} else {
			System.out.println("정보가 없습니다. 등록을 먼저 해세요.");
		}
	}// end of exe

	
	public static void search(String[][] friend, Scanner scn) {
		System.out.println("조회 할 성별을 입력하세요.>");
//		Scanner scn = new Scanner(System.in);
		String searchSex = scn.nextLine();
		for (int i = 0; i < friend.length; i++) {
			if (friend[i][0] != null && searchSex.equals(friend[i][2])) {
				System.out.printf("%-5s%-13s%6s \n", friend[i][0], friend[i][1], friend[i][2]);
			}
		}
	}// end of search

	
	public static void exe(String[][] friend, Scanner scn) {
		// 이름, 연락처, 성별 => 100개 공간.
//		Scanner scn = new Scanner(System.in);

		System.out.println("몇명을 입력하실 건가욥?>");
		int count = Integer.parseInt(scn.nextLine());
		
		for (int i = 0; i < friend.length; i++) {
			while (friend[i][0] == null && count > 0) {
				for (int j = 0; j < friend[i].length; j++) {
					switch (j) {
					case 0:
						System.out.println("이름을 입력하세요>");
						friend[i][j] = scn.nextLine();
						break;
					case 1:
						System.out.println("연락처를 입력하세요>");
						friend[i][j] = scn.nextLine();
						break;
					case 2:
						System.out.println("성별을 입력하세요>");
						friend[i][j] = scn.nextLine();
						break;
					}
				}
				count--;
			}
		}

	}// end of exe()

	
	public static void delList(String[][] friend, Scanner scn) {
		System.out.println("삭제 할 목록의 이름을 입력해 주세요.");
		String name = scn.nextLine();
		for (int i = 0; i < friend.length; i++) {
			if (name.equals(friend[i][0])) {
				for (int j = 0; j < friend[i].length; j++) {
					friend[i][j] = null;
				}
			}
		}
	}// end of delList

	
	public static void editList(String[][] friend, Scanner scn, String name) {

		for (int i = 0; i < friend.length; i++) {
			if (name.equals(friend[i][0])) {
				friend[i][2] = scn.nextLine();
			}
		}

	}// end of editList

	
	public static boolean duple(String[][] friend, String name) {
		boolean result = true;
		for (int i = 0; i < friend.length; i++) {
			if (name.equals(friend[i][0])) {
				result = false;
			}
		}

		return result;

	}//end of duple
}
