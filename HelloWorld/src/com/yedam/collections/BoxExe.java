package com.yedam.collections;

class Box<E> { //=> <E> 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법 마치 함수에 매개변수의 타입을 사용할 때마다 자동으로 바꿔주는 너낌
	
	E item;
	
	void setItem(E item) {
		this.item = item;
	}
	
	E getItem() {
		return item;
	}
}

public class BoxExe {
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		
		box.setItem("바밤바");
		
		Box<Integer> box2 = new Box<Integer>();
		
		box2.setItem(1000);
		
		
	}
	
}
