package com.yedam;

import java.util.Scanner;

/*
 * 학생점수 입력 받아서 배열저장.
 * 최고점수, 평균, 합계점수 출력.
 */
public class ForLoopExe1 {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		// 정수배열
		int[] scores = new int[3];

		while (run) {
			System.out.println("1.학생점수 입력 2.최고점수 3.평균,합계점수 4.종료");
			System.out.println("선택하세요>");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("점수를 입력하세요.>");
					scores[i] = Integer.parseInt(scn.nextLine());
				}
				System.out.println("입력완료.");
				break;
			 }
			
				
			case 2: {
				int max = 0;
				for (int i = 0; i < scores.length; i++) {
					if (max < scores[i]) {
						max = scores[i];
					}
				}
				System.out.printf("최고점수는 %d 입니다.  \n", max);
				break;
			}
			case 3: {
				double avg = 0;
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					sum += scores[i];
				}
				//연산시 타입이 다르다면 좀 더 큰 범위의 타입으로 자동 형 변환 시킨다. 따라서 int타입에 double 타입을 곱해서 double타입으로 바꿔준다.
				avg = sum * 1.0 / scores.length;
				System.out.printf("점수 합계는 %d, 평균점수는 %.3f 입니다. \n", sum, avg);
				break;
			}

			case 4: {
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			}
			default:
				System.out.println("메뉴를 다시 선택하세요.");

				}

		}//end of while
		System.out.println("end of prog");

	}//end of main
}//end of class
