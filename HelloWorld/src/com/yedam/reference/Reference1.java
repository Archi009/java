package com.yedam.reference;


public class Reference1 {
	public void method1() { // static 없는 동적 메소드 인스턴스 만들어사용
		System.out.println("mothod1()이 호출되엇습니다.");
	}

//	타입 범위 반환타입
	private void mothod2() {
		System.out.println("mothod2()이 호출되엇습니다.");
	}

	public int sum(int num1, int num2) {
		return num1 + num2;
	}

	public static void name(String[] args) {
		// 어디서든 호출이 가능한, 정적인, 반환하는 값이 없는, String 타입의 매개변수를 받는 name이라는 이름의 메소드이다
	}

//	타입범위 메소드타입 반환타입	
	public static void main(String[] args) { // static 동적 메소드 인스턴스 없어도 되는
		String s1 = new String("Hong");
		String s2 = new String("Hong");
		
		System.out.println((s1 == s2) + "  문자열(참조타입)의 일반 연산자 비교");
		System.out.println(s1.equals(s2) + "  String객체의 Method로 비교");

		int n1 = 1;
		int n2 = 1;
		char c1 = 'A';
		char c2 = 'A';

		System.out.println((n1 == n2) + "int" + (c1 == c2) + "char" + "  기본타입(int,char...etc) 일반 연산자 비교");

		// 배열 선언.
		double[] ablAry = new double[5];
		ablAry[0] = 160.5;
		System.out.println(ablAry.length);

//		ablAry = {}; 이미 배열의 길이를 포함해서 선언했는데 동일 이름으로 새로운 배열을 선언하려 할 때는 (배열의 내용을 바꾸려 할 때)
//		위와 같은 간편식이 아니라 new 연산자를 통해 선언해야한다.

		ablAry = new double[] { 160.5, 173.8 };
		System.out.println(ablAry.length);

		// 배열[][] 다차원 배열
		int[][] intAry = new int[2][3];
		intAry[0][0] = 10;
		intAry[0][1] = 20;
		intAry[0][2] = 30;
		intAry[1][0] = 40;
		intAry[1][1] = 50;
		intAry[1][2] = 60;
		
		for (int i = 0; i < intAry.length; i++) {
			for (int j = 0; j < intAry[i].length; j++) {
				System.out.println("intAry["+i+"]"+"["+j+"]"+" => "+intAry[i][j]);
			}
		}

	}
}
