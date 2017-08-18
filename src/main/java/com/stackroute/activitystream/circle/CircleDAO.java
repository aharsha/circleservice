package com.stackroute.activitystream.circle;

import java.util.List;

public interface CircleDAO {

	public boolean addCircle(Circle circle);

	public boolean updateUser(Circle circle);

	public List<Circle> getAllCircles();

	public Circle getCircle(int circleid);

}
