package com.yedam.inheritance;

import java.util.Scanner;

/*
 * 친구 목록관리 crud
 * -친구 목록 조회
 * -등록
 * -수정
 * -삭제
 */
////////////////////////////////////////정보를 담거나 하는 class가 아니라 기능을 실행할 뿐인 class라서 singleton방식으로 해보자
public class FriendExe {
//		singleton
//		1.field
	private static FriendExe instsance = new FriendExe();

//		2.constructor 은닉.
	private FriendExe() {

	}

//		3.instence를 반환하는 method
	public static FriendExe getInstence() {
		return instsance;
	}

	Friend[] friends = new Friend[100];
	Scanner scn = new Scanner(System.in);

//	더미 데이터
	public void init() {
		friends[0] = new Friend("홍길동", "010-2222-1111");
		friends[1] = new UnivFriend("홍길동", "010-5444-1111", "예담", "사학과");
		friends[2] = new ComFriend("길동", "010-1111-1111", "예담컴", "인사과");
		friends[3] = new UnivFriend("홍동", "010-3333-1111", "그린", "물리학과");
	}

//		시작 method

	public void run() {
		init();
		boolean run = true;

		while (run) {

			System.out.println("1.친구목록 2.등록 3.수정 4.삭제 9.종료");
			System.out.println("메뉴 선택 >>");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1:
				// 목록
				friendList();
				break;
			case 2:
				// 등록
				addFriend();
				break;
			case 3:
				// 수정
				editFriend();
				break;
			case 4:
				// 삭제
				delFriend();
				break;
			case 9:
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				System.out.println("잘못된 값입니다.");
				break;
			}

		}
	}

//     삭제
	void delFriend() {
		System.out.println("삭제");

	}

//     수정
	void editFriend() {
		
		int count = 0;
		System.out.println("연락처를 수정할 친구 이름 입력 >>");
		
		String name = scn.nextLine();
		String phone ="";
		
		for(int i = 0 ; i<friends.length; i++) {
			if(friends[i] != null
					&& name.equals(friends[i].getFriendNm())
					) {	
					count++;
					
					
					
			}
		}
		if(count==1) {
			for(int i = 0 ; i<friends.length; i++) {
				if(friends[i] != null&& name.equals(friends[i].getFriendNm())) {	
						System.out.println("연락처를 입력하세요.");
						phone = scn.nextLine();
						friends[i].setPhoneNum(phone);
						System.out.println("등록 완료.");
						return;
				}
			}
		}else if (count > 1) {
			int temp ; 
			System.out.println("수정 할 연락처를 선택하세요");
			for(int i = 0 ; i<friends.length; i++) {
				if(friends[i] != null&& name.equals(friends[i].getFriendNm())) {	
					friends[i].showInfo();
					System.out.println("수정하시겠습니까?");
					System.out.println(">>1.yes 2.no");
					temp = Integer.parseInt(scn.nextLine()) ;
					if(temp==2) {
						continue;
					}else if(temp ==1){
						phone = scn.nextLine();
						friends[i].setPhoneNum(phone);
						System.out.println("수정되었습니다.");
						return;
					}else {
						System.err.println("1 혹은 2를 입력하세요");
						i--;
						
					}
				}
			}
			
		}
		
	}

//     등록
	void addFriend() {
//		 친구 :이름, 연락처
//		 학교 :친구 +학교명, 전공.
//		 회사 : 친구 +회사명+부서.
		boolean run = true;
		String name = "";
		String phone= "";
		Friend friend ;
		while (run) {
			System.out.println("1.친구 2.학교친구 3.회사친구 4.종료");
			System.out.println("선택 >>");
			int choice = Integer.parseInt(scn.nextLine());
			if (choice < 0 || choice > 4) {
				System.out.println("잘못된 정보를 입력하였습니다.");
				continue;
			} else if (choice == 4) {
				System.out.println("등록을 종료합니다.");
				return;
			}
//		이름, 연락처.
			while (true) {
				System.out.println("이름 >>");
				name = scn.nextLine().trim();
				if(name.length()<2 || name.length() >10) {
					break;
				}
				System.out.println("연락처 >>");
				phone =  scn.nextLine().trim();
				if (phone.length()!=13) {
					break;
				}
			}
			friend = null;

			switch (choice) {
			case 1:
				friend = new Friend(name, phone);
				break;
			case 2:
				System.out.println("학교 >>");
				String school = scn.nextLine();
				System.out.println("전공 >>");
				String major = scn.nextLine();
				friend = new UnivFriend(name, phone, school, major);
				break;
			case 3:
				System.out.println("회사 >>");
				String comp = scn.nextLine();
				System.out.println("부서 >>");
				String depart = scn.nextLine();
				friend = new ComFriend(name, phone, comp, depart);
				break;

			}
			for (int i = 0; i < friends.length; i++) {
				if (friends[i] == null) {
					friends[i] = friend;
					System.out.println("등록하였습니다.");
					return;
				}
			}
		}
	}

//     친구 목록 
	void friendList() {

		System.out.println("================================================");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				// override를 통해서 부모와 자식들의 매소드를 구분해서 알아서 실행시켜준다
				System.out.println(friends[i].showInfo());
				System.out.println(friends[i].getFriendNm());
			}

		}
		System.out.println("조회");
	}

}
