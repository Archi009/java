package com.yedam.api;

public class Member {
	String memberId;
	int memPoint;

	public Member() {};
	
	
	public Member(String id, int point) {
		this.memberId = id;
		this.memPoint = point;
	};
	
	
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memPoint=" + memPoint + "]";
	}


	@Override
	public int hashCode() {//Set Collection의 논리적 비교에는 hashCode와 equals 둘 다 같아야 같다.
//		return super.hashCode();  // Object의 hashcod는 주소값. 기본적으로 내가 만든 상속받는 것이 없는 클래스의 부모는 Object 이기 때문에 
		return memPoint;		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// memberId 같을 경우 ..논리적로 같은 객체
		if (obj instanceof Member) {	// 매개변수가 Member의 인스턴스인가?
			Member m2 = (Member) obj; // 그렇다면 Member객체로 캐스팅하자
			if (this.memberId == m2.memberId // 그 안의 memberId가 메소드의 주체(this)와 동일한가?
					&& this.memPoint == m2.memPoint) {//memberPoint도 동일한가?
				return true;
			}
		}

		return false;
	}
}
