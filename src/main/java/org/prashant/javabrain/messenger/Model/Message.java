package org.prashant.javabrain.messenger.Model;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private String name;
	private long id;
	private Date date;
	private String author;
	
	
	public Message()
	{}
	
	
	public Message(String name, long id,String author) {
		super();
		this.name = name;
		this.id = id;
		
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	} 
	
	

}
