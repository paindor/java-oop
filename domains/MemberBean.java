package com.bitcamp.domains;

public class MemberBean {

	private String id, pw, name, ssn, blood;
	private double height, weight;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String tosString() {
		return String.format("-회원정보-\n"
				+ "아이디:%s\n"
				+ "비밀번호:%s\n"
				+ "이름:%s\n"
				+ "주민번호:%s\n"
				+ "혈액형:%s\n"
				+ "키%s\n"
				+ "몸무게%s\n"
				,id, pw, name, ssn, blood, height, weight);
	}
	
}
