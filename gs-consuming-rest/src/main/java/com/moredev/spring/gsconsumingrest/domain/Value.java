package com.moredev.spring.gsconsumingrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Value {

	private Long id;
	private String quote;
	
	public Value() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	@Override
	public String toString() {
		return "Value{"+
				"id=" + id +
				", quote='" + quote + '\'' +
				'}';
	}
}
