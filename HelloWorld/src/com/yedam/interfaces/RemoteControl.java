package com.yedam.interfaces;
/*
 * 인터페이스
 * 필드, 메소드
 */
public interface RemoteControl {
	public int MAX_VOLUME = 10 ; //상수
	
	public void turnOn() ; //추상 메소드.
	public void turnOff() ; //추상 메소드.
}
