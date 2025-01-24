package com.yedam.reference;

import java.util.Scanner;



/*
 *<< 도서명, 저자, 출판사, 판매가격>>
 */
public class BookExe {

	static Book[] bookRepository = new Book[100];
	static Scanner scn = new Scanner(System.in);
	static boolean run = true;
	static String name = null;
	static boolean isExist = false;
	static Calculator cal = new Calculator();
	// 저장공간에 초기값을 생성.
	public static void init() {
		// 초기 더미데이터
		bookRepository[0] = new Book("혼공자", "이창호", "예담", 34000);
		bookRepository[1] = new Book("이우리", "몰라", "예담", 23000);
		bookRepository[2] = new Book("기흐씨자", "김민지", "예담", 31000);
		bookRepository[3] = new Book("커피", "정유환", "한빛", 12000);
	}// end of init

	public static void main(String[] args) {
		init();
// 1.전체목록 2.도서등록 3.조회(출판사) 9.종료
		while (run) {
			System.out.println("실행할 기능을 선택하세요.>");
			System.out.println("1.도서목록 2.도서등록 3.조회(출판사) 4.금액수정 5.상세조회 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				listUp();
				break;

			case 2:
				addBook();
				break;

			case 3:
				searchBook();
				break;
			case 4: // 수정
				editBook();

				break;
			case 5: // 상세조회
				searchDtail();
				break;
			case 9:
				exitBook();
				break;

			default:
				break;
			}// end of switch
		} // end of while

	}// end of main
		// 목록 출력 메소드

	public static void listUp() {
		System.out.println("============================");
		System.out.println("도서명    저자    출판사   판매가격");
		System.out.println("============================");
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null) {
//			System.out.printf("%-6s%3s%6s   %-5d \n", bookRepository[i].bookNm, bookRepository[i].author,
//					bookRepository[i].publ, bookRepository[i].price);
				System.out.println(bookRepository[i].showInfo());
			} else {
				break;
			}
		}
	}// end of listUp

	// 도서 등록 메소드
	public static void addBook() {
		System.out.println("몇개의 책을 등록하실건가요?");
		int count = Integer.parseInt(scn.nextLine());

		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] == null && count > 0) {
				System.out.printf("도서명을 입력해주세요>");
				// 기본생성자를 통한 작성
//				bookRepository[i] = new Book();
//				bookRepository[i].bookNm = scn.nextLine();
//
//				System.out.printf("저자을 입력해주세요>");
//				bookRepository[i].author = scn.nextLine();
//
//				System.out.printf("출판사를 입력해주세요>");
//				bookRepository[i].publ = scn.nextLine();
//
//				System.out.printf("가격을 입력해주세요>");
//				bookRepository[i].price = Integer.parseInt(scn.nextLine());

				// 설정한 생성자를 통한 작성
				name = scn.nextLine();

				System.out.printf("저자을 입력해주세요>");
				String auth = scn.nextLine();

				System.out.printf("출판사를 입력해주세요>");
				String publi = scn.nextLine();

				System.out.printf("가격을 입력해주세요>");
				int price = Integer.parseInt(scn.nextLine());

				bookRepository[i] = new Book(name, auth, publi, price);

				if (count > 1) {
					System.out.println("등록완료" + (count - 1) + "개 더 등록가능합니다.");
				} else {
					System.out.println("모든 등록이 완료되었습니다.");
				}
				count--;
			}

		}

	}// end of addBook
		// 도서 조회

	public static void searchBook() {
		System.out.println("조회할 출판사를 알려주세요.");
		String publi = scn.nextLine();
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && publi.equals(bookRepository[i].getPubl())) {
//				System.out.printf("%-8s%3s%4s%5d \n", bookRepository[i].bookNm, bookRepository[i].author,
//						bookRepository[i].publ, bookRepository[i].price);

				System.out.println(bookRepository[i].showInfo());
			}
		}
	}// end of searchBook

	// 도서 수정
	public static void editBook() {
		System.out.println("도서명 입력.");
		String name = scn.nextLine();
		isExist = false;
		for (int i = 0; i < bookRepository.length; i++) {
			if (bookRepository[i] != null && name.equals(bookRepository[i].getBookNm())) {

				System.out.println(bookRepository[i].showInfo() + "의 수정할 가격입력");
				bookRepository[i].setPrice(Integer.parseInt(scn.nextLine()));
				System.out.println(bookRepository[i].showInfo() + "수정 완료");
				isExist = true;
				break;// 수정완료되면 반복문 종료
			}
		}
		// 수정 기능이 실행 됐는지 확인.
		if (!isExist) {
			System.out.println("도서명이 없습니다.");
		}
	}// end of editBook

	public static void searchDtail() {
		System.out.println("도서명 입력.");
		name = scn.nextLine();
		isExist = false;
		isExist = cal.getBookInfo(name, bookRepository).showDetil(isExist);
		// 수정 기능이 실행 됐는지 확인.
		if (!isExist) {
			System.out.println("도서명이 없습니다.");
		}

	}// end of searchDtail

	public static void exitBook() {
		System.out.println("프로그램을 종료합니다.");
		run = false;
	}//end of exitBook
}
