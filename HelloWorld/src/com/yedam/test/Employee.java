package com.yedam.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
//	정보를 담을 employee 객체
//	field
	private String empNo; //사번 23-11 형식
	private String empNm; //사원이름
	private String telNo; //전화번호 000-0000-0000
	private Date hireDate;//입사일자 yyyy-MM-dd
	private int salary;   //급여

//	constructor
	public Employee() { //기본 생성자

	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//날짜에 대한 형식 포멧
	public Employee(String empNo, String empNm, String telNo, String hireDate, int salary) {
//		모든 필드값을 받는 생성자
		this.empNo = empNo;
		this.empNm = empNm;
		this.telNo = telNo;
		try {
//			생성자의 hireDate 매개변수를 String으로 받아 프로그램상 사용이 용이하게 함
			this.hireDate = sdf.parse(hireDate);
//			String으로 받아온 hireDate를 저장시에는 포맷시킨 형태로 파싱시켜 저장한다
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.salary = salary;
	}

//	사번, 이름, 연락처, 급여.
	public String empInfo() {
//		사번   이름   연락처   급여
//		-------------------
//		1001 홍길동 234-1234 250

		return empNo + "  " + empNm + "  " + telNo + "  " + salary;
	}

	public String empInfoHire() {
//		사번   이름   연락처   급여
//		-------------------
//		1001 홍길동 234-1234 250

		return empNo + "  " + empNm + "  " + sdf.format(hireDate);
		//생성자와 마찬가지
	}

	// getter setter
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hdate) {

		try {
			this.hireDate = sdf.parse(hdate);
//			생성자와 마찬가지
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
