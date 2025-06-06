package test;

import java.io.*;


public class BookBean implements Serializable{
	
	private String code, name, author;
	private float price;
	private int qty;
	
	public BookBean() {} //0 parameter constructor or o arg constructor
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) 
	{
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
}
