package com.yedam;

public class Variable1 {
	public static void main(String[] args) {
		// int(4byte)
		int num1 = 1111110101;

		// byte(1byte)
		byte num2 = 27; // 1byte
		short num3 = 128; // 2byte
		long num4 = 111111111111111L;
		System.out.println(Long.MAX_VALUE);

		byte num5 = 20;

		// byte result = num2 + num5; //변수의 타입을 지정해주자!!!! 더하기 연산의 기본 연산자는 int 타입을 기준으로
		// 한다
		byte result = (byte) (num2 + num5); // 연산의 결과를 다른 타입으로 받고싶다면 강제 형변환을 사용할 수 있다.(casting)
		int result1 = num2 + num5;			// 자동 형변환 (promotion)

		// 데이터 타입 변수이름 값 //변수 선언 규칙!!
		int[] inAry = { 10, 25, 82, 11 };
		String[] strAry = {"Hong", "Park","Choid"}; 
//		strAry[3] = "Kim"; //Java의 배열은 크기가 불변한다.
		
		int[] anotherAry = new int[10];  //배열 선언. 크기 설정.
		System.out.println(anotherAry);  //배열이나 Map 객체 등은 출력값은 실제 값을 출력하지 않고 메모리 주소값을 출력해준다.
		
		for (int i = 0; i < anotherAry.length; i++) {
			anotherAry[i] = (int) (Math.random() * 100) ;  // 강제형변환 
		}
				
		//배열 출력
		for(int num : anotherAry) {      //배열의 반복문 javascript의 forEach와 비슷 for in도?
			System.out.println(num);
		}
		System.out.println(strAry);
		

		
		int sum = 0;
		for (int i = 0; i < inAry.length; i++) {
			sum += inAry[i];
		}
		System.out.println("sum의 값은 : " + sum);

	}

}
