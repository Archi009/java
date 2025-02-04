package com.yedam.inheritance;

import java.lang.System.Logger;

public class CastingExe {
	public static void main(String[] args) {
		// byte < short < int < long
		int n1 = 100;
		long n2 = 0;
		n2 = n1; //promotion n2 = (int) n1 으로 자동 캐스팅(promotion) 된다. (자식클래스가 부모클래스에 담길때)
//		n1 = n2; //부모클래스가 자식 클래스에 담기거나 서로 맞지 않는 타입의 클래스를 담을 때 강제 형변환(casting)이 필요하다.
		n1 = (int) n2;
	}
	
}
