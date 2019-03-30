package com.jzpengxiaopeng.java8.entity;

public class Dream {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dream() {
	}

	public Dream(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dream [name=" + name + "]";
	}

}
