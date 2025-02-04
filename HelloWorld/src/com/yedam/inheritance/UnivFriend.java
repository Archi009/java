package com.yedam.inheritance;

/*
 *  학교정보.
 */
public class UnivFriend extends Friend{
//  field
	
	private String schoolNm;
	private String univMajor;  
	
//	constructor
	public UnivFriend(String friendNm, String phoneNum, String schoolNm, String univMajor) {
		super(friendNm,phoneNum);
		this.schoolNm = schoolNm;
		this.univMajor = univMajor;
	}
	
	
//	showInfo overRiding 학교정보 추가.
	@Override   //어노테이션. 컴파일 하는 동안 추가적인 정보를 제공
	public String showInfo() {
		return super.showInfo() + ", 학교: " + schoolNm + ", 전공: " + univMajor;
		
	}
	

//	getter, setter


	public String getSchoolNm() {
		return schoolNm;
	}

	public void setSchoolNm(String schoolNm) {
		this.schoolNm = schoolNm;
	}

	public String getUnivMajor() {
		return univMajor;
	}

	public void setUnivMajor(String univMajor) {
		this.univMajor = univMajor;
	}
	

}
