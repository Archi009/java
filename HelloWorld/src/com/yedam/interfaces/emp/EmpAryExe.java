package com.yedam.interfaces.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpAryExe implements EmpDAO {

	Employee[] employees = new Employee[10];

	public EmpAryExe() {
//		초기값
		employees[0] = (new Employee(1001, "홍길동", "432-1234"));
		employees[1] = (new Employee(1002, "홍동이", "431-1123"));
		employees[2] = (new Employee(1003, "길동이", "144-1422"));
		employees[3] = (new Employee(1004, "박사장", "144-1422", "2000-01-01", 500));
	}

	@Override
	public boolean registerEmp(Employee emp) {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				employees[i] = emp;
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean modfyEmp(Employee emp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < employees.length; i++) {
//			사원비교
			if (employees[i].getEmpNo() == emp.getEmpNo()) {
				if (!emp.getTelNo().equals("")) {
					employees[i].setTelNo(emp.getTelNo());
				}
				try {
//					공백을 입력했을때 의미없는 값(1900-01-01)을 넘겨서 의미없는 값일때는 수정이 일어나지 않도록
					if (!emp.getHireDate().equals(sdf.parse("1900-01-01"))) {
						employees[i].setHireDate(emp.getHireDate());
					}
				} catch (ParseException e) {

					e.printStackTrace();

				}
				if (emp.getSalary() != 0) {
					employees[i].setSalary(emp.getSalary());
				}
				return true; // 정상 수정
			}

		}

		return false;
	}

	@Override
	public boolean removeEmp(int empNo) {
		for (int i = 0; i < employees.length; i++) {
//			사원비교
			if (employees[i].getEmpNo() == empNo) {
	   			employees[i] = null;
				return true; // 정상 삭제
			}

		}
		return false;
	}

	@Override
	public List<Employee> search(Employee emp) {
//		Employee[] result = new Employee[100];
		List<Employee> result = new ArrayList<Employee>();
//		int idx = 0;
		for (int i = 0; i < employees.length; i++) {

			if (employees[i] != null && employees[i].getEmpNm().indexOf(emp.getEmpNm()) > -1) {
//				result[idx] = employees[i];
				result.add(employees[i]);
//				idx++;
			}
		}
		return result;
	}

}
