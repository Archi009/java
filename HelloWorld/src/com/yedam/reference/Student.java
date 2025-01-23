package com.yedam.reference;

public class Student {
	//필드(속성)
	String studentNm ;				//학생이름
	int enScore;					//영어성적
	int mathScore;					//수학성적
	
	//생성자: 필드의 초기값을 지정해서 인스턴스 생성.
	Student(){ //기본 생성자: 매개값이 없는 생성자.
	}
	
	Student(String studentNm){
		this.studentNm = studentNm;
		
	}
	Student(String studentNm, int enScore){
		this.studentNm = studentNm;
		this.enScore = enScore;
		
	}
	Student(String studentNm, int enScore, int mathScore){
		this.studentNm = studentNm;
		this.enScore = enScore;
		this.mathScore = mathScore;
	}
	
	
	//메소드 (기능)
	void printInfo() { //클래스내부의 정보 출력
		System.out.printf("이름은 %s, 영어점수는 %d, 수학점수는 %d \n", studentNm, enScore,mathScore);
	}
	double getAvg(Student std) {
		return (std.enScore +std.mathScore)/2;
		
	}
}
