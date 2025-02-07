package com.yedam.collections;

public class Person {
//     필드: 이름 , 나이 , 취미
	private String name;
	private int age;
	private String hobby;
	
//	생성자
	public Person(String name , int age, String hobby) {
		this.age = age;
		this.name = name;
		this.hobby = hobby;
	}

//	getter, setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}
