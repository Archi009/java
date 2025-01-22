package com.yedam;

import java.util.Scanner;

public class ForLoop2 {
	public static void main(String[] args) {
//		"홍길동, 80" .split("") String 클래스가 가진 매소드 구분자를 기준으로 문자열을 나눠준다.
//		String[] infoAry = "홍길동, 80".split(","); //나누면 둘이 되니 배열에 담아야쥐?
//		System.out.println(infoAry[0]);
//		System.out.println(Integer.parseInt(infoAry[1]));//안댐
		Scanner scn = new Scanner(System.in);

		String[] studentAry = new String[100];

		// 문자열의 기본값은 null 이다. null여부를 확인하자 //Java의 배열은 늘리거나 할 수 없기때문에 문자 배열일때 항상 null값을
		// 체크 해줘야 한다.
//		for (int i = 0; i < studentAry.length; i++) {
//			System.out.println(studentAry[i]);
//			
//		}
		studentAry[0] = "홍길동,30";
		studentAry[1] = "김민수,50";
		studentAry[2] = "정유환,10";
		studentAry[3] = "박우식,70";
		boolean run = true;

		while (run) {
			System.out.println("1.학생 이름,점수 2.최고점수 출력 3.단건 입력 4.조회(이름) 9.종료");
			System.out.println("선택하세요.>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:

				for (int i = 0; i < studentAry.length; i++) {
					System.out.println("학생 이름과 점수를 \",\"로 구분해서 입력하세요.");
					;
					studentAry[i] = scn.nextLine();
				}

				break;
			case 2:
				int max = 0;

				String name = null;

				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] != null) { // 값이 있을 경우.
						int temp = Integer.parseInt(studentAry[i].split(",")[1]);
						if (max < temp) {
							max = temp;
							name = studentAry[i].split(",")[0];
						}
					}
				}

				System.out.printf("%s가 %d점수로 가장 높읖 점수를 기록했습니다 \n", name, max);
				break;
			case 3:

				System.out.println("이름과 점수를 ,로 구분해서 입력하세요.");

				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] == null) {
						studentAry[i] = (scn.nextLine());
						System.out.println(studentAry[i]);
						break;
					}
				}
				break;
			case 4:

				System.out.println("조회 할 이름을 입력하세요>");
				String searchNm = scn.nextLine();
				int nmScore = 0;
				for (int i = 0; i < studentAry.length; i++) {
					if (studentAry[i] != null) {

						if (searchNm.equals(studentAry[i].split(",")[0])) {
							nmScore = Integer.parseInt(studentAry[i].split(",")[1]);
							System.out.printf("%s의 점수는 %d점입니다.", searchNm, nmScore);
							break;
						}

					} else {
						System.out.println("찾으시는 이름이 없습니다.");
						break;
					}
				}
				break;
			case 9:
				System.err.println("end of prog");
				run = false;
				break;
			default:

				System.out.println("메뉴를 다시 선택하세요.");

			}

		} // end of while
		System.out.println("end of prog");

	}// end of main
}// end of class
