package com.yedam.inheritance;



/*
 *  Friend 상속하는 ComFriend
 *  회사명, 부서정보.
 */
public class ComFriend extends Friend{
//	field
	private String companyNm;
	private String department;
	
//	constructor.
	public ComFriend(String friendNm, String phoneNum,String companyNm,String department) {
		super( friendNm,  phoneNum);  //super:부모 의 friendNm,  phoneNum를 매개값으로 받는 생성자를 가져와 쓴다.
		this.companyNm = companyNm;
		this.department = department;
		
	}
//	showInfo overRiding 회사 부서
	@Override //어노테이션. 컴파일 하는 동안 추가적인 정보를 제공
	public String showInfo() {
		return super.showInfo() + ", 회사: "+companyNm+ ", 부서: "+department;
	}

	//	getter , setter
	public String getCompanyNm() {
		return companyNm;
	}

	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
