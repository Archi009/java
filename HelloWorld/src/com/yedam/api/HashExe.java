package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class HashExe {
	public static void main(String[] args) {
			//컬랙션(List/ Set/ Map)
		Set<Member> set = new HashSet<Member>();  //Set의 대표적인 구현 클래스
		
		
//			set : 중복된 값은 저장 불가. 중복된 값이랑? set의 중복된 값 검사는 hashCode와 equals의 결과로 알 수 있다.
			
			set.add(new Member("user02",80));
			set.add(new Member("user02",80));
			set.add(new Member("user02",80));
			set.add(new Member("user03",90));
			
			for (Member member : set) {
				System.out.println("id: "+member.memberId+ "  point: "+member.memPoint+"///hashCode");
				//hashCode를 반환하는 메소드를 수정하기 전에는 각 주소값을 받오기때문에 입력받은 클래스들이 다르다고 인식해서 모두 Set에 담아 줬지만,
				//hachCode를 수정해서 memPoint가 같을 때 (물론 필드가 늘어나면 조건이 늘어날 것이다)라는 조건을 내걸어 Set이 중복된 값을 걸러서 하나만 담아줬다.
			}
			
			for (Member member : set) {
				System.out.println(member.toString()); //Member.java에 toString을 정의하지 않았다면 주소값을 반환해줄것이다.
				
			}
	}//end of main

}
