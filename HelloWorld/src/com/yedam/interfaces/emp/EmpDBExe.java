package com.yedam.interfaces.emp;

import java.sql.Statement;
import java.text.SimpleDateFormat;
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
		String query = "insert into tbl_employees (emp_no,emp_name,tel_number)";
		query += " values (" + emp.getEmpNo() + ",' " 
		                    + emp.getEmpNm() + "', '" 
				            + emp.getTelNo()  
		                    + "')";
		try {
			Statement stmt = getConnect().createStatement();
			int r = stmt.executeUpdate(query);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}//end of registerEmp

	@Override
	public boolean modfyEmp(Employee emp) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "update tbl_employees "
				+ "set tel_number = nvl('"+emp.getTelNo()+"','010-2222'), "
				+ " hire_date = case to_date('"+sdf.format(emp.getHireDate())+"','yyyy-mm-dd') when to_date('1900-01-01','yyyy-mm-dd') then hire_date"
				+ " else to_date('"+sdf.format(emp.getHireDate())+"','yyyy-mm-dd')"
				+ " end,"
				+ " salary = case "+emp.getSalary()+" when 0 then salary"
				+ " else "+emp.getSalary()+""
				+ " end "
				+ "where emp_no = " + emp.getEmpNo();
		System.out.println(query);
		try {
			
			Statement stmt = getConnect().createStatement();
			
			int r = stmt.executeUpdate(query);
			if(r>0) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeEmp(int empNo) {
		String query = "delete from tbl_empolyees where emp_no = "+empNo;
		try {
			
			Statement stmt = getConnect().createStatement();
			
			int r = stmt.executeUpdate(query);
			if(r>0) 
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> search(Employee emp) {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			Statement stmt = getConnect().createStatement();
			ResultSet rs = stmt.executeQuery("select * from tbl_employees where emp_name = nvl('"+emp.getEmpNm() +"',emp_name) order by emp_no desc");
			while (rs.next()) {
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
