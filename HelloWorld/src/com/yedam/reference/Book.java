package com.yedam.reference;

public class Book {

	// 필드
	private String bookNm; // 책 제목
	private String author; // 저자
	private String publ; // 출판사
	private int price; // 가격
	
	//public, default, private => 접근제한자 (access modifier)
	public Book() { // 기본생성자
		// TODO Auto-generated constructor stub
	}

	// 모든 필드를 받아오는 생성자 //생성자 오버로딩
	public Book(String nm, String at, String pb, int pr) {
		this.bookNm = nm;
		this.author = at;
		this.publ = pb;
		this.price = pr;
	}

	// 제목 저자 가격
	public String showInfo() {
		return bookNm + "    " + author + "    " + price + "    ";
	}

	// 상세보기용 도서명: 이것이 자바다 출판사: 한빛 미디어 저자: 신용권 가격: 12900원
	public void showDetil() {
		String strFormString ="도서명: %10s\t   출판사: %6s\n저자: %10s\t\t   가격: %6d 원\n";
		System.out.printf(strFormString, bookNm, author, publ, price);
	}
	public boolean showDetil(boolean isExist) {
		String strFormString ="도서명: %10s\t   출판사: %6s\n저자: %10s\t\t   가격: %6d 원\n";
		System.out.printf(strFormString, bookNm, author, publ, price);
		return true;
	}
///////////////////////////////////////////////////////////////////////////////////////////
/////getter setter
	public void setPrice(int price) {
		if (price < 0) {
			this.price = 0;
			return;
		}
		this.price = price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	public void setPubl(String publ) {
		this.publ = publ;
	}

	public int getPrice() {
		return price;
	}

	public String getPubl() {
		return publ;
	}

	public String getBookNm() {
		return bookNm;
	}

	public String getAuthor() {
		return author;
	}

}
