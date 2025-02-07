package com.yedam.stream;

public class Student {
//	field
	private String name;
	private double height;
	private double weight;
	private int scoure;
	
//	constructor
	public Student() {}
	public Student(String name, double height, double weight, int scoure) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.scoure = scoure;
	}
	
	
//	getter,setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHdight() {
		return height;
	}
	public void setHdight(double hdight) {
		this.height = hdight;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getScoure() {
		return scoure;
	}
	public void setScoure(int scoure) {
		this.scoure = scoure;
	}

	
	
}
