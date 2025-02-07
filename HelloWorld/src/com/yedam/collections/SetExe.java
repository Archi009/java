package com.yedam.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("홍길동");
		set.add("반갑습니다");
		set.add("1000");
		set.add(String.valueOf(true));
		set.add("홍길동");
		
		Iterator<String> iter = set.iterator(); //반복자 ?? 객체가 가리키는 값
		while(iter.hasNext()) { //iter에 요소가 존재하는가? => hasNext()
			String result = iter.next(); //요소를 반환 => next()
			System.out.println("반복자  "+result);
		}
		
		for (String string : set) {
			System.out.println(string);
		}
		
	}
}
