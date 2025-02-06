package com.yedam.interfaces.emp;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 사원관리 App ver.1
 * 실행 클래스 : MainExe
 * interface 활용 (배열, 컬렉션)
 * Employee, EmpAryExe, EmpListExe, EmpDAO(interface)
 *  조회 추가 삭제 수정
 */
public class MainExe {
	static Scanner scn = new Scanner(System.in);
	static int eNum = 0;
	static EmpDAO dao;
	public static void main(String[] args) {
//		스캐너, run
		boolean run = true;
//		boolean runAry = false;
		String eName = "";
		String phNo = "";
		String hdate = "";
		int sal = 0;
//		배열, 컬렉션


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
			int menu = 0;
			try {
				
			  menu = Integer.parseInt(scn.nextLine());
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("숫자를 입력해 주세요.");
				break;
			}

			switch (menu) {
			case 1:
				// 추가 => 사원번호 이름 전화번호
				System.out.println("사원번호 입력 >> ");
				try {
					eNum = Integer.parseInt(scn.nextLine());
					
					} catch (InputMismatchException | NumberFormatException e) {
//						사용자가 유효한 값을 입력하지 않으면 임의로 가장 마지막 사원 번호 +1 값을 부여한다.
						Employee emp = new Employee();
						emp.setEmpNm("");
//						조회결과
						Employee[] result = dao.search(emp);
	
						for (int i = 0; i <result.length;i++) {
							if (result[i] == null) {
								
								eNum = result[i-1].getEmpNo() + 1 ;
								break;
							}
						} 
						System.out.println("유효한 값을 입력하지 않아" + eNum + "을 부여합니다.");
						break;
					}

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
				//삭제
				try {
					remove();					
				} catch (NumberFormatException e) {
					System.out.println("사원 번호 확인.");
				}
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
				System.out.println("유효한 값을 입력해 주세요");
				break;
			}
		}
		System.out.println("end of prog.");

	}// end of main.
	
	//예외 떠넘기기 throws 를 이용해 함수를 실행한 위치에서 예외 처리를 한다.
	static void remove() throws NumberFormatException {
		// 삭제
		System.out.println("삭제사원번호 입력 >> ");
		
		eNum = Integer.parseInt(scn.nextLine());

		if (dao.removeEmp(eNum)) {
			System.out.println("삭제성공");
			return;
		}
		System.out.println("번호가 존재하지 않습니다.");
	}//end of remove
}
