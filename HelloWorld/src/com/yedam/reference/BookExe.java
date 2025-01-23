package com.yedam.reference;

import java.util.Scanner;

/*
 *<< 도서명, 저자, 출판사, 판매가격>>
 */
public class BookExe {
	public static void main(String[] args) {
		Book[] bookRepository = new Book[100];
		// 1.전체목록 2.도서등록 3.조회(출판사) 9.종료
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		bookRepository[0] = new Book("혼공자", "이창호", "예담", 34000);
		bookRepository[1] = new Book("이우리", "몰라", "예담", 23000);
		bookRepository[2] = new Book("기흐씨자", "김민지", "예담", 31000);
		bookRepository[3] = new Book("커피", "정유환", "한빛", 12000);
		
		while (run) {
			System.out.println("실행할 기능을 선택하세요.>");
			System.out.println("1.도서목록 2.도서등록 3.조회(출판사) 9.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				System.out.println("============================");
				System.out.println("도서명    저자    출판사   판매가격");
				System.out.println("============================");
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i]!= null) {
						System.out.printf("%-6s%3s%6s   %-5d \n", bookRepository[i].bookNm, bookRepository[i].author,
								bookRepository[i].publ, bookRepository[i].price);
					}else {
						break;
					}
				}
				break;

			case 2:
				System.out.println("몇개의 책을 등록하실건가요?");
				int count = Integer.parseInt(scn.nextLine());
				;
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i] == null && count >0) {
						System.out.printf("도서명을 입력해주세요>");
						bookRepository[i] = new Book();
						bookRepository[i].bookNm = scn.nextLine();

						System.out.printf("저자을 입력해주세요>");
						bookRepository[i].author = scn.nextLine();

						System.out.printf("출판사를 입력해주세요>");
						bookRepository[i].publ = scn.nextLine();

						System.out.printf("가격을 입력해주세요>");
						bookRepository[i].price = Integer.parseInt(scn.nextLine());
						count--;
					}

				}

				break;

			case 3:
				System.out.println("조회할 출판사를 알려주세요.");
				String publi = scn.nextLine();
				for (int i = 0; i < bookRepository.length; i++) {
					if (bookRepository[i] != null && publi.equals(bookRepository[i].publ)) {
						System.out.printf("%-8s%3s%4s%5d \n", bookRepository[i].bookNm, bookRepository[i].author,
								bookRepository[i].publ, bookRepository[i].price);
					}
				}

				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;

			default:
				break;
			}
		}

	}// end of main
}
