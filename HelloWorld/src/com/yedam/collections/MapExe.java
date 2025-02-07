package com.yedam.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
//		키:값 => 엔트리
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("홍길동", 90);
		map.put("정유환", 50);
		map.put("김민수", 80);
		map.put("박은수", 70);
		map.put("김민수", 77); /// key값은 중복될 수 없으므로 김민수를 키로 가지는 값이 80에서 77로 바뀐다.

//		키 => 값 반환.
		Integer val = map.get("홍길동");
		System.out.println(val);

//		키 => Set 반환. 키값을 모아서 set방식으로 반환
		Set<String> keys = map.keySet();
		for (String str : keys) {
			System.out.println(map.get(str));
		}

//		키: 값 (엔트리) 엔트리 반환
//		entrySet()메소드는 반환 값으로 Entry 클래스를 타입으로 가지는 set에 담아 반호나한다.
		Set<Entry<String, Integer>> entry = map.entrySet(); 
		for (Entry<String, Integer> ent : entry) {
			System.out.printf("키: %s, 값: %d\n", ent.getKey(),ent.getValue());
		}

	}
}
