package com.yedam.collections;

import java.util.ArrayList;
import java.util.List;


public class ListExe {
	public static void main(String[] args) {
		List<String>strList= new ArrayList<String>();
		strList.add(null);
		strList.add("Hong");
		strList.add(new String("kildong"));
		strList.add(new String(new byte[] {77,108,108,111,97}));
		
		for (String string : strList) {
			System.out.println(string);
		}
		
		strList.remove(0);
		System.out.println(strList.size());
		
		//index위치에 Hello 문자를 담는다. 기존 0번째를 지우고 대체하는게 아니라 뒤로 밀어내고 들어간다
		strList.add(0,"Hello"); 
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}
		System.out.println(strList.contains("Hong"));
		strList.clear(); //전체 비우기
		System.out.println(strList.contains("Hong"));
		
	}
}
