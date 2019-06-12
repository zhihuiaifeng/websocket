package com.lumacong.websocket.vo;

public class Echars {
	private String name;
	private Integer num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Echars(String name, Integer num) {
		super();
		this.name = name;
		this.num = num;
	}
}
