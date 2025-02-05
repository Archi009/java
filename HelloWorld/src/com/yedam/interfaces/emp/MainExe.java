package com.yedam.interfaces.emp;

import java.util.Scanner;

/*
 * 사원관리 App ver.1
 * 실행 클래스 : MainExe
 * interface 활용 (배열, 컬렉션)
 * Employee, EmpAryExe, EmpListExe, EmpDAO(interface)
 *  조회 추가 삭제 수정
 */
public class MainExe {
	public static void main(String[] args) {
//		스캐너, run
		Scanner scn = new Scanner(System.in);
		boolean run = true;
//		boolean runAry = false;
		int eNum = 0;
		String eName = "";
		String phNo = "";
		String hdate = "";
		int sal = 0;
//		배열, 컬렉션

		EmpDAO dao;

		while (true) {
			System.out.println("1.ver.Collection | 2.ver.Array");
			System.out.println("선택 >> ");
			int selecVer = Integer.parseInt(scn.nextLine());
			if (selecVer < 1 || selecVer > 2) {
				System.out.println("유효한 값 선택하세요.");
				continue;
			} else if (selecVer == 1) {
				dao = new EmpListExe();

				break;
			} else {
				dao = new EmpAryExe();

				break;
			}

		}

		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회 9.종료");
			System.out.println("선택 >> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				// 추가 => 사원번호 이름 전화번호
				System.out.println("사원번호 입력 >> ");
				eNum = Integer.parseInt(scn.nextLine());
				System.out.println("이름 입력 >> ");
				eName = scn.nextLine();
				System.out.println("연락처 입력 >> ");
				phNo = scn.nextLine();

				if (dao.registerEmp(new Employee(eNum, eName, phNo))) {
					System.out.println("등록성공");
					break;
				}
				System.out.println("등록실패");

				break; // end of case 1.
			case 2:
				// 수정 +사원번호 수정항목 : 전화번호, 입사일자, 급여
				System.out.println("수정사원번호 입력 >> ");
				eNum = Integer.parseInt(scn.nextLine());
				System.out.println("연락처 >> ");
				phNo = scn.nextLine();
				System.out.println("입사일자 >> ");
				hdate = scn.nextLine();
				if (hdate.equals("")) {
					hdate = "1900-01-01";
				}
				System.out.println("급여 >> ");
				String salString = scn.nextLine();
//				공백 입력시 오류 대신 그냥 넘어가기위한 작업
				if (salString.equals("")) {
					salString = "0";
				}
				sal = Integer.parseInt(salString);

				if (dao.modfyEmp(new Employee(eNum, "", phNo, hdate, sal))) {
					System.out.println("수정성공");
					break;
				}
				System.out.println("수정실패");

				break; // end of case 2.
			case 3:
				// 삭제
				System.out.println("삭제사원번호 입력 >> ");
				eNum = Integer.parseInt(scn.nextLine());

				if (dao.removeEmp(eNum)) {
					System.out.println("삭제성공");
					break;
				}
				System.out.println("삭제실패");

				break;
			case 4:
				// 조회
				// 조회조건 ( 급여 이상)
//				System.out.println("조회 급여 조건 >> ");
//				sal = Integer.parseInt(scn.nextLine());
//				
//				
//				Employee emp = new Employee();
//				emp.setSalary(sal);
				/// 이름으로 조회////
				System.out.println("조회 이름 >> ");
				eName = scn.nextLine();

				Employee emp = new Employee();
				emp.setEmpNm(eName);
//				조회결과
				Employee[] result = dao.search(emp);
				/////////////////////////////////////////

//				출력
				System.out.println(" 사번   이름    연락처    급여");
				System.out.println("---------------------------");
				for (Employee empl : result) {
					if (empl != null) {
						System.out.println(empl.empInfo());
					}
				}

				break;
			case 9:
				// 종료
				System.out.println("종료한합니닫");
				run = false;

				break;
			default:
				break;
			}
		}
		System.out.println("end of prog.");

	}// end of main.
}
