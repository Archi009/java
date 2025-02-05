package com.yedam.interfaces.emp;

public class EmpAryExe implements EmpDAO {

	Employee[] employees  = new Employee[10];

	public EmpAryExe() {
//		초기값
		employees[0] = (new Employee(1001, "홍길동", "432-1234"));
		employees[1] = (new Employee(1002, "홍동이", "431-1123"));
		employees[2] = (new Employee(1003, "길동이", "144-1422"));
		employees[3] = (new Employee(1004, "박사장", "144-1422", "2000-01-01", 500));
	}

	@Override
	public boolean registerEmp(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modfyEmp(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEmp(int empNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee[] search(Employee emp) {
		Employee[] result = new Employee[100];
		int idx = 0;
		for (int i = 0; i < employees.length; i++) {
			
			if (employees[i]!=null && employees[i].getEmpNm().indexOf(emp.getEmpNm()) > -1 ) {
				result[idx] = employees[i];
				idx++;
			}
		}
		return result;
	}

}
