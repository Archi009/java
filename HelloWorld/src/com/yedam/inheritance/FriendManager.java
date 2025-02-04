package com.yedam.inheritance;

public class FriendManager {
	public static void main(String[] args) {
		// 홍길동, 010-1234-5678
		// 김민수, 010-1111-2222, 예담, 역사문화
		// 박민규, 010-1124-1291, 구글, 개발팀
		
//		Friend[] frienAry = new Friend[10];
//		frienAry[0] = new Friend("홍길동", "010-1234-5678");
//		frienAry[1]=new ComFriend("박민규", "010-1124-1291", "구글", "개발팀");
//		frienAry[2] = new UnivFriend("김민수", "010-1111-2222", "예담", "역사문화");
		
		FriendExe friendExe = FriendExe.getInstence();
		
		friendExe.run();
		
	}
}
