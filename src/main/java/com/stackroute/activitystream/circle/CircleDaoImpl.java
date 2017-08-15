package com.stackroute.activitystream.circle;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository("circleDao")
@Transactional
public class CircleDaoImpl implements CircleDAO {

	
	@Autowired
	SessionFactory sessionFacory;
	
	@Override
	public boolean addCircle(Circle circle) {
		try {
			circle.setCircleid((int)(Math.random()*100000));
			circle.setCreateddate(new Date());
			sessionFacory.getCurrentSession().save(circle);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addUser(String userId, int circleId) {

		SubscribeCircle subscribeCircle=new SubscribeCircle();
		subscribeCircle.setSubscriberid((int)(Math.random()*100000));
		subscribeCircle.setCircleid(circleId);
		subscribeCircle.setUserid(userId);
		subscribeCircle.setDataofjoin(new Date());
		
		try {
			sessionFacory.getCurrentSession().save(subscribeCircle);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	
		
		
		return true;
	}

	@Override
	public boolean removeUser(String userId, int circleId) {
		Query query = sessionFacory.getCurrentSession().createQuery("delete SubscribeCircle where userid=:userId and circleid=:circleId");
		
		query.setParameter("userId",userId);
		query.setParameter("circleId",circleId);
		
		
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		   
		return true;
		}
		else
		{
			
			return false;	
		}
	}

	@Override
	public boolean updateUser(Circle circle) {
		
		return false;
	}

	@Override
	public boolean deleteCircle(int circleId) {
		Query query = sessionFacory.getCurrentSession().createQuery("delete Circle where circleId=:circleId");
		query.setParameter("circleId",circleId);
		 
		int result = query.executeUpdate();
		 
		if (result > 0) {
		   
		return true;
		}
		else
		{
			
			return false;	
		}
		
	}

	@Override
	public List<Circle> myCircle(String userId)
	{
		
		
		return sessionFacory.getCurrentSession().createQuery("from Circle where circleid in(select circleid from SubscribeCircle where userid=:userId)").setParameter("userId",userId).list();
		//return 	(List<Circle>)sessionFacory.getCurrentSession().createNativeQuery("select * from circle where circleId in( select circleId from activity.subscribecircle where userId=:userId)",Circle.class).setParameter("userId",userId).list();
	}

	@Override
	public Circle getCircle(int circleid)
	{
	
		return (Circle)sessionFacory.getCurrentSession().createQuery("from Circle where circleid =:circleid)").setParameter("circleid",circleid).uniqueResult();
		//return 	(List<Circle>)sessionFacory.getCurrentSession().createNativeQuery("select * from circle where circleId in( select circleId from activity.subscribecircle where userId=:userId)",Circle.class).setParameter("userId",userId).list();
	}
	
	@Override
	public List<Circle> getAllCircles() {
		
		List<Circle> allCircles=sessionFacory.getCurrentSession().createQuery("from Circle").list();
		return allCircles;
	}
	
	

	

}
