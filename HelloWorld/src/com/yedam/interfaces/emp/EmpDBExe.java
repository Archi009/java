package com.yedam.interfaces.emp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDBExe implements EmpDAO {

	Connection getConnect() {

		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 DB의 접속 정보.
		String user = "hr"; // 사용자 정보
		String password = "hr"; // 비밀번호
		Connection conn = null;
		try {
			// 첫번째 매개변수.(접속정보)
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	@Override
	public boolean registerEmp(Employee emp) {
		String query = "inert into tbl_employees";
		query += "values ("+emp.getEmpNo()+", "
							+emp.getEmpNm()+", "
							+emp.getTelNo()+", "
							+emp.getHireDate()+", "
							+emp.getSalary()+")";
		try {
			Statement stmt = getConnect().createStatement();
			int r = stmt.executeUpdate(query);
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			Statement stmt = getConnect().createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_employees");
			while(rs.next()) {
				Employee empl = new Employee();
				empl.setEmpNo(rs.getInt("emp_no"));
				empl.setEmpNm(rs.getString("emp_name"));
				empl.setTelNo(rs.getString("tel_number"));
				empl.setHireDate(rs.getDate("hire_date"));
				empl.setSalary(rs.getInt("salary"));
				
				empList.add(empl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

}
