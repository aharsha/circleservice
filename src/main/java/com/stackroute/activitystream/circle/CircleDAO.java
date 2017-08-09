package com.stackroute.activitystream.circle;

import java.util.List;



public interface CircleDAO {
	
public boolean addCircle(Circle circle);
public boolean deleteCircle(int circleId);
	
	public boolean addUser(String userEmail, int circleId);
	
	public boolean removeUser(String userEmail, String circleId);
	
	
	public List<Circle> myCircle(String userId);
	
	public boolean updateUser(Circle circle);
	
	public List<Circle> getAllCircles();
	
	public Circle getCircle(int circleid);
	

}
