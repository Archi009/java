package com.yedam.test;

import java.util.List;
import java.util.Scanner;

public class EmpApp {
	//구동부
	static Scanner scn = new Scanner(System.in);
	static int eNum = 0;
	static EmpDAO dao = new EmpDAO(); 
	//EmpDAO인스턴스 생성!(생성과 동시에 초기값이나 내가 사용할 메소드가 사용대기중이 된다!)
	static String eNo = "";
	static String eName = "";
	static String phNo = "";
	static String hdate = "";
	//Employee 객체에서 setter,나 생성자에 date타입 초기화로 파싱시키기 때문에 좀 더 편하게  String 으로 사용한다
	static int sal = 0;

	public static void main(String[] args) {
//		while -run
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			System.out.println(" 선택 >> ");
			int menu = 0;
			//menu 숫자 입력
			try {
				menu =Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력해주세요.");
				continue;
			}
			
			
			switch (menu) {
			case 1:
//				등록
				register();
				break;
			case 2:
//				전체조회
				searchList(2);
				break;

			case 3:
//				수정			
				modSal();
				break;

			case 4:
//				삭제
				break;

			case 5:
				searchList(5);
				break;
			case 6:
				System.out.println("end of prog");
				run = false;
				break;

		
			}// end of switch
		} // end of while
	}// end of main

	static void register() {
//      등록
		System.out.println("사번입력 >> ");
		eNo = scn.nextLine();
		System.out.println("이름입력 >> ");
		eName = scn.nextLine();
		System.out.println("전화번호입력 >> ");
		phNo = scn.nextLine();
		System.out.println("입사일입력 >> ");
		hdate = scn.nextLine();
		System.out.println("급여입력 >> ");
		sal = Integer.parseInt(scn.nextLine());

		if (dao.registerEmp(new Employee(eNo, eName, phNo, hdate, sal))) {
//			dao의 regiserEmp메소드를 실행할건데, 매개변수에 금방 받아온 값들을 Employee인스턴스에 담아 준다
			System.out.println("등록 완료");
			return;
		}
		System.out.println("등록 실패");

	}//end of register

	static void searchList(int num) {
//		조회
//		조회의 방법이 두가지! 기준을 위해 보내온 숫자를 매개변수에 받아 온다
		Employee emp = new Employee();
//		새 emp 인스턴스를 만들어 보내줄 데이터를 답아 준다
		if (num == 5) { //입사일 조회일때 출력문
			System.out.println("입사일입력 >> ");
			hdate = scn.nextLine();
			emp.setHireDate(hdate);// 입사일 조회일때 입사일 설정한 값을 담아줌
			System.out.println(" 사번   이름    입사일자");
			System.out.println("---------------------------");
		}else { //일반 조회일때 출력문 (수정시 수정 확인위해 급여추가)
		
		System.out.println(" 사번   이름    전화번호     급여");
		System.out.println("---------------------------");
		}
		List<Employee> result = dao.searchList(emp);
		//dao의 searchList메소드에 값을 담아준 emp인스턴스를 매개변수로 담은 결과물을 
//		result 변수에 담아준다.
		for (Employee empl : result) {
//			메소드의 결과갑을 가져와 조건에 맞는 empl(employee인스턴스)의 메소드를 실행한다.
			if (empl != null) {
				if (num == 5) {//입사일자 입력 조회
					System.out.println(empl.empInfoHire());
				} else {//일반 조회
					System.out.println(empl.empInfo());
				}
			}
		}
	}//end of searchList
	
	static void modSal() {
		System.out.println("사번입력 >> ");
		eNo = scn.nextLine();
		System.out.println("수정 급여입력 >> ");
		sal =Integer.parseInt(scn.nextLine()) ;
		Employee emp = new Employee();
//		정보를 담아줄 새 인스턴스
		emp.setEmpNo(eNo); 
		emp.setSalary(sal);
		if(dao.modSal(emp)) { //수정시 true반환
			System.out.println("수정완료");
			return;
		}
		System.out.println("입력하신 사번이 없습니다. 확인해주세요.");
		
	}//end of modSal
	static void delList() {
		Employee emp = new Employee();
		System.out.println("사번입력 >> ");
		eNo = scn.nextLine();
		emp.setEmpNo(eNo);
		if(dao.delList(emp)) { //삭제시 true반환
			System.out.println("삭제완료");
			return;
		}
		System.out.println("입력하신 사번이 없습니다. 확인해주세요.");
	}
}
