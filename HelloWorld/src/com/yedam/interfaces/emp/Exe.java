package com.yedam.interfaces.emp;

import java.util.ArrayList;
import java.util.List;

import com.yedam.inheritance.Friend;
import com.yedam.inheritance.UnivFriend;
import com.yedam.reference.Student;

/*
 * String[] strAry; => 배열엔 단점이 꽤 많다 null(고정된 길이기 때문에 null이 존재 할 수 있다)값을 고려해야하고 배열의 크기도 지정해줘야한다.
 * 이런 불편함을 덜어주는 Collection!!
 * 1) List 2) Set 3)Map 과 같은 Collection들이 있다.
 */
public class Exe {
	public static void main(String[] args) {
//		학생정보를 저장하는 컬랙션(ArrayList) 선언.

		List<Student> stuList = new ArrayList<Student>();

//		3명 정도 추가.
		stuList.add(new Student("홍길동"));
		stuList.add(new Student("홍정학"));
		stuList.add(new Student("김민진"));

//		출력.
		for (int i = 0; i < stuList.size(); i++) {
			stuList.get(i).printInfo();
		}
		
//		삭제
		for (int i = 0; i < stuList.size(); i++) {
			if(stuList.get(i).getStudentNm().equals("김민진")) {
				stuList.remove(i);
				break;
			}
		}
		
		
	}

	void method() {
//		List interface를 상속받는 ArrayList객체
		String[] strAry = new String[10];
		List<String> strList = new ArrayList<String>();
		List<Friend> friends = new ArrayList<Friend>();

//		friends.add("안녕하세요.")// Friend 객체로 채워넣어야 하는 List이므로 String과 같은 다른 타입은 들어갈 수 없다
		friends.add(new Friend("홍길동", "010-2222-2212"));
		friends.add(new UnivFriend("홍길동", "010-2222-2212", "예담", "영어영문"));

		friends.remove(new Friend("홍길동", "010-2222-2212"));
//		위에서 추가했던 내용과 똑같은 내용의 객체를 삭제하겠다는 메소드를 실행했지만 List의 크기는 변하지 않았다(클래스를 다르다고 인식하기 때문) 
//		따라서 삭제는 index값을 이용하는게 best다
		System.out.println("friends크기: " + friends.size());

		System.out.println(friends.get(0));

		// 추가
		strList.add("안녕하세요.");
		strList.add("반갑습니다.");
		strList.add("Hello.");

		System.out.println("StrList의 크기: " + strList.size());
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}

		System.out.println("================================================");
		// 삭제
		strList.remove(0); // index값으로 List 값 삭제
		strList.remove("Hello."); // 객체를 찾아 삭제 :가능은 하지만, 참조변수를 통해 연결된 객체를 같다 다르다 판단하기 힘듬으로 추천하지 않는다.

		for (int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i));
		}

	}
}
