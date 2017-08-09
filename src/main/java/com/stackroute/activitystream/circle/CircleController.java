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
			System.out.println("control at add  user ");
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
		
		
		@GetMapping("/getAllCircles")
		public ResponseEntity<List<Circle>> retrieveAllCircles()
		{
			List<Circle> allCircles=null;
			System.out.println("control at add  user ");
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
		public ResponseEntity<Circle> retrieveOneCircle(int circleid)
		{
			Circle circle=null;
			System.out.println("control at add  user ");
			try
			{
			 circle=circleDao.getCircle(circleid);
			if(circle!=null)
			{
			return new ResponseEntity<Circle>(circle,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Circle>(circle,HttpStatus.BAD_REQUEST);
			}
			}
			catch(Exception exception )
			{
				exception.printStackTrace();
				
				return new ResponseEntity<Circle>(circle,HttpStatus.CONFLICT);
					
			}
			
			}
	
		
		@GetMapping("/getAllCircles/{circleName}")
		public ResponseEntity<List<Circle>> retrieveMyCircles(@PathVariable String circleName)
		{
			List<Circle> allCircles=null;
			System.out.println("control at add  user ");
			try
			{
			 allCircles=circleDao.myCircle(circleName);
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


}
