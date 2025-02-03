package com.yedam.reference;

public class StaticExe {
	public static void main(String[] args) {
		MemberExe m1 = MemberExe.getInstance();
		MemberExe m2 = MemberExe.getInstance();

		System.err.println(m1 == m2);
	}
}
