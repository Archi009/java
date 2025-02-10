package com.yedam.stream.database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";  //오라클 DB의 접속 정보.
		String user = "hr"; //사용자 정보
		String password = "hr";		// 비밀번호
		try {
			//첫번째 매개변수.(접속정보)
			Connection conn = DriverManager.getConnection(url,user,password); 
			System.out.println("연결성공");
			//tbl_student 테이블 조회
			Statement stmt = conn.createStatement();
			String updateQuery = "update tbl_student set phone ='010-8787-5656' where student_name = '이인호'";
//			stmt.executeUpdate("insert into tbl_student (student_no,student_name,phone,address) values ('S007','이인호','010-1234-1122','대한민국')");
			String deleteQuery = "delete from tbl_student where student_name = '김민서'";
			int r = stmt.executeUpdate(deleteQuery);
			
			System.out.println(r);
			ResultSet rs = stmt.executeQuery("select * from tbl_student");
			//반복문 활용
			
			while(rs.next()) { //조회결과가 있으면 true, 마지막데이터 false //rs.next()결과가 있는지 여부 반환 
				//컬럼명.
				System.out.println(rs.getString("student_no")
						+	" "+rs.getString("student_name")
						+	" "+rs.getString("phone")
						+	" "+rs.getString("address"));
			}
			System.out.println("end of data");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
