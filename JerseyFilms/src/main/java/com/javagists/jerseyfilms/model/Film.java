package com.javagists.jerseyfilms.model;

public class Film {
	private String id;
	private String name;
	private String year;
	private Genre genere;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Genre getGenere() {
		return genere;
	}
	public void setGenere(Genre genere) {
		this.genere = genere;
	}
	
	
}
