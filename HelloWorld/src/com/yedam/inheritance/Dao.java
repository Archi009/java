package com.yedam.inheritance;
/*
 * 추상클래스의 추상 메소드를 통해서 규칙을 통일하고 좀 더 쉽고 유지보수가 편한 프로그래밍을 할 수 있다.
 */
public abstract class Dao {
	public abstract void register();

	public abstract void remove();

	public abstract void search();
}
