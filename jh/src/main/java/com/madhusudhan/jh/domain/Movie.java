package com.madhusudhan.jh.domain;

import java.util.Date;

public class Movie {
	private int id = 0;

	private String  title = null;
	
	private String  synopsis = null;

	private String  director = null;
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getSynopsis() {
		return synopsis;
	}
}
