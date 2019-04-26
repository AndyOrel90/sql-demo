package com.revature.sqldemo.domain;

public class Artist {
	private int id;
	private String name;

	public Artist(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Artist() {
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + "]";
	}
}
