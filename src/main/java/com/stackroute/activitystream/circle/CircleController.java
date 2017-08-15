package com.stackroute.activitystream.circle;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CircleController {
	
	@Autowired
	CircleDAO circleDao;
	

	
	
	//regsiter User -> if success HttpStatus.OK->if new register with existed email ->HttpStatus.CONFLICT
		@PostMapping("/addCircle")
		public ResponseEntity<Circle> addNewCircle(@RequestBody Circle circle)
		{
			
			try
			{
			boolean circleStatus=circleDao.addCircle(circle);
			if(circleStatus==true)
			{
			return new ResponseEntity<Circle>(circle,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Circle>(circle,HttpStatus.BAD_REQUEST);
			}
			}
			catch(DataIntegrityViolationException exception )
			{
				exception.printStackTrace();
				//api for httpstatus code 
				//https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/HttpStatus.html
				return new ResponseEntity<Circle>(circle,HttpStatus.CONFLICT);
					
			}
			catch(Exception exception )
			{
				return new ResponseEntity<Circle>(circle,HttpStatus.BAD_REQUEST);
					
			}
			}
		
		@PostMapping("/addUser/{userid}/{circleid}")
		public ResponseEntity<String> addUserToCircle(@PathVariable("userid") String userid,@PathVariable("circleid") Integer circleid)
		{
			
			try
			{
			boolean userStatus=circleDao.addUser(userid, circleid);
			if(userStatus==true)
			{
			return new ResponseEntity<String>("user added successfully",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("user added successfully",HttpStatus.NOT_MODIFIED);
			}
			}
			catch(Exception exception )
			{
				return new ResponseEntity<String>("user added successfully",HttpStatus.NOT_MODIFIED);
					
			}
			}
		
		
		
		
		@GetMapping("/getAllCircles")
		public ResponseEntity<List<Circle>> retrieveAllCircles()
		{
			List<Circle> allCircles=null;
			System.out.println("control at getAllCircles  user ");
			try
			{
			 allCircles=circleDao.getAllCircles();
			if(allCircles!=null)
			{
			return new ResponseEntity<List<Circle>>(allCircles,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<Circle>>(allCircles,HttpStatus.BAD_REQUEST);
			}
			}
			catch(Exception exception )
			{
				exception.printStackTrace();
				
				return new ResponseEntity<List<Circle>>(allCircles,HttpStatus.CONFLICT);
					
			}
			
			}
	

		@GetMapping("/getCircle/{circleid}")
		public ResponseEntity<Circle> retrieveOneCircle(@PathVariable("circleid") Integer circleid)
		{
			System.out.println("at circle controller in get Circle"+circleid);
			Circle circle=null;
			
			try
			{
			 circle=circleDao.getCircle(circleid);
			if(circle!=null)
			{
			return new ResponseEntity<Circle>(circle,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Circle>(circle,HttpStatus.NO_CONTENT);
			}
			}
			catch(Exception exception )
			{
				exception.printStackTrace();
				
				return new ResponseEntity<Circle>(circle,HttpStatus.NO_CONTENT);
					
			}
			
			}
	
		
		@GetMapping("/getMyCircles/{userId}")
		public ResponseEntity<List<Circle>> retrieveMyCircles(@PathVariable String userId)
		{
		System.out.println(userId);
			List<Circle> myCircles=null;
			try
			{
			 myCircles=circleDao.myCircle(userId);
			if(myCircles!=null)
			{
			return new ResponseEntity<List<Circle>>(myCircles,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<Circle>>(myCircles,HttpStatus.BAD_REQUEST);
			}
			}
			catch(Exception exception )
			{
				exception.printStackTrace();
				
				return new ResponseEntity<List<Circle>>(myCircles,HttpStatus.CONFLICT);
					
			}
			
			}


		@GetMapping("/deleteUser/{userId}/{circleId}")
		public ResponseEntity<String> deleteUserFromCircle(@PathVariable String userId,@PathVariable Integer circleId)
		{
		System.out.println(userId+circleId);
		
			boolean deleterUserStatus;
			try
			{
			 deleterUserStatus=circleDao.removeUser(userId, circleId);
			if(deleterUserStatus==true)
			{
			return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("not deleted",HttpStatus.NOT_FOUND);
					}
			}
			catch(Exception exception )
			{
				exception.printStackTrace();
				
				return new ResponseEntity<String>("not deleted",HttpStatus.NOT_MODIFIED);
					
			}
			
			}


		
		
}
