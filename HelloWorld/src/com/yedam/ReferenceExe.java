package com.yedam;

import com.yedam.reference.Reference1;

public class ReferenceExe {
	public static void main(String[] args) {
		
		Reference1.main(args); //정적 메소드는 이와 같이 인스턴스 생성을 하지 않고도 사용가능하다
		
		//com.yedam.reference 내부의 class의 method 실행 테스트
		Reference1 ref1 = new Reference1();
		
		ref1.method1();		//public 은 어디서든 호출이 된다.
		//ref1.method2();  //private 이기 때문에 method2의 호출이 되지 않는다.
	}
}
  