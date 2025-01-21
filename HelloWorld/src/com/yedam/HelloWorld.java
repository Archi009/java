package com.yedam;
// 객체(object) 지향 프로그래밍 언어
// class(구현해야 하는 실물): 객체를 자바 언어로 정의 한 것.
// HelloWorld.java : 소스 코드가 만들어짐. => 저장시 컨파일해서 /bin에 HelloWorld.class 실행 파일 (실행) 
public class HelloWorld {
	//main : 메소드(method)  : 기능 
	public static void main(String[] args) {
		System.out.println("Hellow, World");
		
		int myAge = 20;
		myAge = 20;
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
			System.out.println("i의 값은" +i);
			sum += i;
			}
		}
		System.out.println("sum의 값은 " + sum);
	}
}
