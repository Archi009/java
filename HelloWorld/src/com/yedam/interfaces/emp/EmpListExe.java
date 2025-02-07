package com.yedam.interfaces.emp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpListExe implements EmpDAO {

	List<Employee> empList = new ArrayList<Employee>();

	public EmpListExe() {
//		초기값
		empList.add(new Employee(1001, "홍길동", "432-1234"));
		empList.add(new Employee(1002, "홍동이", "431-1123"));
		empList.add(new Employee(1003, "길동이", "144-1422"));
		empList.add(new Employee(1004, "박사장", "144-1422", "2000-01-01", 500));
	}

	@Override
	public boolean registerEmp(Employee emp) {

		return empList.add(emp); // add()는 결과에 따라 boolean을 반환 해준다.
	}

	@Override
	public boolean modfyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < empList.size(); i++) {
//			사원비교
			if (empList.get(i).getEmpNo() == emp.getEmpNo()) {
				if (!emp.getTelNo().equals("")) {
					empList.get(i).setTelNo(emp.getTelNo());
				}
				try {
//					공백을 입력했을때 의미없는 값(1900-01-01)을 넘겨서 의미없는 값일때는 수정이 일어나지 않도록
					if (!emp.getHireDate().equals(sdf.parse("1900-01-01"))) {
						empList.get(i).setHireDate(emp.getHireDate());
					}
				} catch (ParseException e) {

					e.printStackTrace();

				}
				if (emp.getSalary() != 0) {
					empList.get(i).setSalary(emp.getSalary());
				}
				return true; // 정상 수정
			}

		}
		return false; // 수정 못함
	}

	@Override
	public boolean removeEmp(int empNo) {
		for (int i = 0; i < empList.size(); i++) {
//			사원비교
			if (empList.get(i).getEmpNo() == empNo) {
				empList.remove(i);
				return true; // 정상 삭제
			}

		}
		return false;
	}

	@Override
	public List<Employee> search(Employee emp) {
		// sal보다 급여 많은것 조회

//		Employee[] result = new Employee[100];
		List<Employee> result = new ArrayList<Employee>();

		/// 급여 조회///
//		int idx = 0;
//		for (int i = 0; i < empList.size(); i++) {
//			if (empList.get(i).getSalary() >= emp.getSalary()) {
//				result[idx] = empList.get(i);
//				idx++;
//			}
//		}

//		찾고자 하는 이름을 가진 모든 값을 출력해라
//		contain을 이용한 방법
//		int idx = 0;
//		for (int i = 0; i < empList.size(); i++) {
//			if (empList.get(i).getEmpNm().contains(emp.getEmpNm())) {
//				result[idx] = empList.get(i);
//				idx++;
//			}
//		}
		
//		indexOf를 이용한 방법
//		int idx = 0;
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i).getEmpNm().indexOf(emp.getEmpNm()) > -1) {
//				result[idx] = empList.get(i);
//				idx++;
				result.add(empList.get(i));
			}
		}

		return result;
	}

}
