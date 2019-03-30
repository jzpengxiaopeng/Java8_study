package com.jzpengxiaopeng.java8.entity;

import java.util.Optional;

public class Man {
	private Optional<Dream> dream = Optional.empty();

	public Optional<Dream> getDream() {
		return dream;
	}

	public void setDream(Optional<Dream> dream) {
		this.dream = dream;
	}

	public Man() {
	}

	public Man(Optional<Dream> dream) {
		this.dream = dream;
	}

	@Override
	public String toString() {
		return "Man [dream=" + dream + "]";
	}

}
