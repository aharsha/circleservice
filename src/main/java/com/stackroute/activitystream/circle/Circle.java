package com.stackroute.activitystream.circle;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="circle")
public class Circle {
	@Id
	private int circleid;
	
private String circlename,ownerid,circlediscription,status;



	
	private Date createddate;




	public int getCircleid() {
		return circleid;
	}




	public void setCircleid(int circleid) {
		this.circleid = circleid;
	}




	public String getCirclename() {
		return circlename;
	}




	public void setCirclename(String circlename) {
		this.circlename = circlename;
	}




	public String getOwnerid() {
		return ownerid;
	}




	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}




	public String getCirclediscription() {
		return circlediscription;
	}




	public void setCirclediscription(String circlediscription) {
		this.circlediscription = circlediscription;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public Date getCreateddate() {
		return createddate;
	}




	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}




	



	
	
	

	
	
	
}
