package com.yedam.test;

import java.util.ArrayList;

import java.util.List;

public class EmpDAO {
//	실행 클래스(구동부)에서 사용할 함수들.
//	****이 클래스가 구동하는게 아니라 이클래스를 실행클래스(구동부)에서 인스턴스화시켜 사용한다!!****
	List<Employee> storage = new ArrayList<Employee>(); //담을 Stroage
//	Employee 객체를 담는 List collection 을 storge라는 이름의 변수를 선언한다
//	변수안에는 List collection을 상속받은 ArrayList를 담겠다.
	public EmpDAO() {
//		초기값 (생성자통해 만들어 지는 순간 초기값이 인스턴스에 담긴다)
		storage.add(new Employee("23-11", "홍길동", "943-1234", "2023-10-11", 500));
		storage.add(new Employee("23-12", "김길동", "945-1255", "2022-10-11", 250));
		storage.add(new Employee("23-13", "박길동", "944-1744", "2021-10-11", 400));
		storage.add(new Employee("23-14", "이길동", "946-1154", "2020-10-11", 300));

	}
	
//	등록
	public boolean registerEmp(Employee emp) {
//		타입과 변수 형태로 입력되는 매개 변수도 그 타입의 특성을 가진다.
		return storage.add(emp);
	}
	
//	목록
	public List<Employee> searchList(Employee emp) {
//		목록을 조회하는 함수.
//		구동부를 보면, 조회의 방법이 2가지 이다. 받는 매개변수와 반환변수를 동일하게 하되 값을 달리 넣어준다. 
		List<Employee> result = new ArrayList<Employee>();
//		List<Employee>형태로 반환 할 것이니까 사용할 변수를 선언한다
		for (int i = 0; i < storage.size(); i++) {
//			조회를 위해 넘어온 매개변수의 값과 저장돼있는 데이터 사이에 
//			원하는 조건에 맞는 값을 구하여 반환하기 위한 반복문
			if (emp.getHireDate()!=null) { //매개변수에 hireDate존재유무 확인
				if(storage.get(i).getHireDate().compareTo(emp.getHireDate())>=0) {
//					compareTo가 날짜를 비교해서 크면 양수 작으면 음수 같으면 0을 반환
					result.add(storage.get(i));
				}
			}else { //매개변수에  hireDate가 없으면,
//				일반조회
			result.add(storage.get(i));
			}
		}//end of for
		return result;
	}
	
//	수정
	public boolean modSal(Employee emp) {
		for(int i = 0; i <storage.size();i++) {
//			매개변수의 사번과 비교
			if(storage.get(i).getEmpNo().equals(emp.getEmpNo())) {
//				객체값의 비교는 equals! 인스턴스 내부의 값 설정은 setter!
			 storage.get(i).setSalary(emp.getSalary());
			 return true;
			}
		}
		return false;
	}
	
//	삭제
	public boolean delList(Employee emp) {
		for(int i = 0; i <storage.size();i++) {
//			매개변수의 사번과 비교
			if(storage.get(i).getEmpNo().equals(emp.getEmpNo())) {
				 storage.remove(i);
				 return true;
				}
		}
		
		return false;
	}
	
}
