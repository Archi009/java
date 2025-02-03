package com.yedam.reference;

/*
 *아이디, 비밀번호, 이름 
 */
public class Member {
	// field
	private String memgerId;
	private String password;
	private String memberName;

	//constructor (생성자)
	public Member(String memgerId, String password, String memberName) {
//		super();//?????부모클래스를 가르키는데.. 아직 얻다쓰는지 모른다
		this.memgerId = memgerId;
		this.password = password;
		this.memberName = memberName;
	}

	
	
	
	
	//method
	public String getMemgerId() {
		return memgerId;
	}

	public void setMemgerId(String memgerId) {
		this.memgerId = memgerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
