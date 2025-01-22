package com.yedam;

import java.util.Scanner;

/*
 * 친구정보관리 앱 v.1
 * 이름, 연락처, 성별(남/여) = 홍길동, 010-1234-2345, 남
 * 1.목록  (이름,연락처,성별)
 * 2.등록
 * 3.조회 (성별별로)
 * 4.삭제 (이름)
 * 5.수정 (이름조회: 연락처 수정)
 * 9.종료
 */
public class Todo2 {
	public static void main(String[] args) {
		String[] listOfriends = new String[100];
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		listOfriends[0] = "노을, 010-1231-1231, 여";
		listOfriends[1] = "정유환, 010-1234-1244, 남";
		listOfriends[2] = "김빛나래, 010-1111-1111, 여";
		listOfriends[3] = "김나박이, 010-1441-1555, 남";

		while (run) {
			System.out.println("1.목록(이름,연락처,성별) 2.등록 3.조회(성별별로) 4.삭제(이름) 5.수정(이름조회: 연락처 수정) 9.종료");
			System.out.println("기능을 선택하세요.>");
			int num = Integer.parseInt(scn.nextLine());
			switch (num) {
			case 1:
				System.out.println("이  름 \t 연락처\t       성별");
				//
				for (int i = 0; i < listOfriends.length; i++) {
					if (listOfriends[i] != null) {
						String name = listOfriends[i].split(",")[0];
						String phone = listOfriends[i].split(",")[1];
						String sex = listOfriends[i].split(",")[2];
						System.out.printf("%-5s %s %s \n", name, phone, sex);

					}
				}
				break;
			case 2:
				for (int i = 0; i < listOfriends.length; i++) {
					if (listOfriends[i] == null) {
						System.out.println("이름,연락처,성별을 입력하세요.>");
						listOfriends[i] = scn.nextLine();
						break;
					}

				}

				break;
			case 3:
				System.out.println("조회 할 성별을 입력하세요.>");
				String searchSex = scn.nextLine();
				for (int i = 0; i < listOfriends.length; i++) {
					if (listOfriends[i] != null) {
						
						String sex = listOfriends[i].split(",")[2];
						if (sex.trim().equals(searchSex)) {
							System.out.printf("%4s자는  %s \n",  sex , listOfriends[i]);
						}
					} 
				}
				break;

			case 4:
				System.out.println("삭제 할 이름을 입력하세요.>");
				String delNm = scn.nextLine();
				for (int i = 0; i < listOfriends.length; i++) {
					if (listOfriends[i] != null) {
						String name = listOfriends[i].split(",")[0];

						if (name.trim().equals(delNm)) {
							listOfriends[i] = null;
							System.out.printf("%s의 정보를 삭제하였습니다. \n", name);
						}
					}
				}

				break;
			case 5:
				System.out.println("연락처를 수정 할 이름을 입력하세요.>");
				String editNm = scn.nextLine();
				for (int i = 0; i < listOfriends.length; i++) {
					if (listOfriends[i] != null) {
						String name = listOfriends[i].split(",")[0];

						if (name.trim().equals(editNm)) {
							System.out.printf("%s의 수정할 연락처를 입력하세요.",name);
							String editPh = scn.nextLine();
							String sex = listOfriends[i].split(",")[2];
							
							listOfriends[i] = name +","+editPh+","+sex ;
							
							System.out.printf("%s의 연락처를 수정하였습니다. \n", name);
						}
					}
				}

				break;
			case 6:
				System.out.println("시스템을 종료합니다.");
				run = false;
				break;

			default:
				System.out.println("값이 존재하지 않습니다.");
				break;
			}
		}

	}

}
