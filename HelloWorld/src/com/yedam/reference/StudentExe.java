package com.yedam.reference;

import java.util.Scanner;

public class StudentExe {
	public static void main(String[] args) {
		Student[] students = new Student[5];
		
		Student std1 = new Student("홍길동",80,80);
		
//		std1.studentNm = "홍길동";
//		std1.enScore = 80;
//		std1.mathScore = 50;
//		
		Student std2 = new Student("김민수",50);
//		std2.studentNm = "김민수";
//		std2.enScore = 50;
		std1.mathScore = 88;

		Student std3 = new Student("홍정학");
//		std3.studentNm = "홍정학";
		std3.enScore = 80;
		std3.mathScore = 90;
		
		students[0] = std1;
		students[1] = std2;
		students[2] = std3;
		students[3] = new Student("김민지",88,100);
		
		//학생의 이름을 입력받는 변수: studName
		//학생의 평균을 출력하는 프로그램 작성
		
		//students[0]이 Student객체의 인스턴스인가?
		System.out.println(students[0] instanceof Student);
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] !=null && students[i].getAvg(students[i]) >= 85) {
				students[i].printInfo();
//				System.out.printf("이름은 %s 영어점수는 %d 수학점수는 %d \n" ,students[i].studentNm,students[i].enScore,students[i].mathScore);
			}
		}
		
		
		Scanner scn = new Scanner(System.in);
		System.out.println("평균값을 구하고자하는 학생의 이름을 입력하세요.>");
		String studName = scn.nextLine();
		for (int i = 0; i < students.length; i++) {
			
			if (students[i] !=null && studName.equals(students[i].studentNm)) {
				System.out.printf("%-3s의 평균성적은 %.2f 입니다.",students[i].studentNm,students[i].getAvg(students[i]));
			}
		}
	}
}
