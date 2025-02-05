package com.yedam.interfaces;

import com.yedam.inheritance.ComFriend;
import com.yedam.inheritance.Friend;

public class RemoteExe {
	public static void main(String[] args) {
		// 상속관계 => 부모클래스 참조변수 = 자식 인스턴스. 
		// 인터페이스 => 인터페이스 참조변수 = 구현객체의 인스턴스.
		
		Friend friend = new ComFriend(null, null, null, null);
		
		RemoteControl rc = new Television();
		// 위와 같이 상속관계의 부모 참조 변수(인터페이스)에는 자식 인스턴스(구현객체의 인스턴스)를 담을 수 있다.
		System.out.println(RemoteControl.MAX_VOLUME);
		//각 구현객체에 override된 method들이 각기 다른 내용을 담고 있으므로 같은 코드로 비슷한 맥락의 다른 기능을 실핼 할 수 있다.
		rc.turnOff();
		rc = new Radio();
		rc.turnOff();
		
	}
}
