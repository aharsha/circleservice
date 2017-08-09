package com.stackroute.activitystream.circle;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="subscribecircle")
public class SubscribeCircle {

	
	@Id
		private int subscriberid;
	
	
	private String userid;
	

	private int circleid;


	public int getSubscriberid() {
		return subscriberid;
	}


	public void setSubscriberid(int subscriberid) {
		this.subscriberid = subscriberid;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public int getCircleid() {
		return circleid;
	}


	public void setCircleid(int circleid) {
		this.circleid = circleid;
	}
	
	


	


}
