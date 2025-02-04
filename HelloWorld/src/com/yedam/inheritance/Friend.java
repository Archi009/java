package com.yedam.inheritance;

/*
 * 친구 목록 - 일반(이름, 연락처)  + 혈액형이란 field를 새로 생성하려면 다른 class도 일일히 다 추가 해줘야 한다. ->이럴때 상속같은걸 쓰면 편--안
 *         - 학교(학교의 정보)
 *         - 회사(회사의 정보)
 *         
 */
public class Friend {
//	  field
      private String friendNm;
      private String phoneNum;
      private BloodType bType;
	//    constructor
      public Friend(String friendNm, String phoneNum) {
    	  this.friendNm = friendNm;
    	  this.phoneNum = phoneNum;
      }
//    이름, 연락처 보여주는 method
      public String showInfo() {
    	  return "이름: "+friendNm+", 연락처: "+phoneNum;
      }
      
      
//    getter, setter
	public String getFriendNm() {
		return friendNm;
	}
	public void setFriendNm(String friendNm) {
		this.friendNm = friendNm;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
      
	public BloodType getbType() {
		return bType;
	}
	public void setbType(BloodType bType) {
		this.bType = bType;
	}
}
