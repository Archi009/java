package com.yedam.reference;

public class Book {

	// 필드
	String bookNm = null;
	String author;
	String publ;
	int price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String nm, String at, String pb, int pr) {
		this.bookNm = nm;
		this.author = at;
		this.publ = pb;
		this.price = pr;
	}

}
