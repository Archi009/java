package com.yedam.reference;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Reference2 {
	public static void main(String[] args) {
		String[][] srStrings = new String[5][2];
		srStrings[0][0] = "홍길동";
		srStrings[0][1] = "80";

		srStrings[1][0] = "김민수";
		srStrings[1][1] = "75";

		srStrings[2][0] = "박헌수";
		srStrings[2][1] = "85";

		srStrings[3][0] = "심상현";
		srStrings[3][1] = "88";

		srStrings[4][0] = "최기동";
		srStrings[4][1] = "90";

		String[][] scores = { { "홍길동", "80" }, { "김민수", "75" }, { "박헌수", "85" }, { "심상현", "88" }, { "최기동", "90" }, };
		// 배열의 값을 입력하는 다양한 방법!!
		Scanner scn = new Scanner(System.in);
//		for (int i = 0; i < srStrings.length; i++) {
//			for (int j = 0; j < srStrings[i].length; j++) {
//				if (j % 2 == 0) {
//					System.out.println("이름 입력");
//					srStrings[i][j] = scn.nextLine();
//				} else {
//					System.out.println("점수 입력");
//					srStrings[i][j] = scn.nextLine();
//				}
//
//			}
//		} // for end
		int sum = 0;
		for (int i = 0; i < srStrings.length; i++) {
			sum += Integer.parseInt(srStrings[i][1]);

			System.out.println("점수 => " + srStrings[i][1]);

		} // for end
		System.out.printf("점수의 총합은 %d 입니다.\n", sum);
		int max = 0;
		String name = null;
		for (int i = 0; i < scores.length; i++) {

			if (max < Integer.parseInt(srStrings[i][1])) {
				max = Integer.parseInt(srStrings[i][1]);
				name = srStrings[i][0];
			}
		} // for end
		System.out.printf("가장 점수가 높은 사람은 %d점을 %s입니다.",max,name);
		
		
		
	}// main end

}
