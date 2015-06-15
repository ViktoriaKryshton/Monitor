package main.java.com.fpmi.project.entity;

import java.util.Date;

public class Record {

	private int id;
	private Date date;
	private long available;
	
	public long getAvailable() {
		return available;
	}
	public void setAvailable(long available) {
		this.available = available;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
