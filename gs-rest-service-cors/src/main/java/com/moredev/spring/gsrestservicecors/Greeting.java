package com.moredev.spring.gsrestservicecors;

public class Greeting {
	
	private final long id;
	private final String content;
	
	public Greeting() {
		this.id = -1;
		this.content = "";
	}

	public Greeting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}

}
