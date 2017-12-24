package com.stackroute.activitystream.circle;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Link;



@RestController

public class CircleController {
	
	@Autowired
	CircleDAO circleDao;
	

	
	
	//regsiter User -> if success HttpStatus.OK->if new register with existed email ->HttpStatus.CONFLICT
	@CrossOrigin(origins = {"http://localhost:4200","http://localhost:3030"}, maxAge = 4800, allowCredentials = "false",allowedHeaders="*")	
	@PostMapping("addCircle")
		public ResponseEntity<Circle> addNewCircle(@RequestBody Circle circle)
		{
			System.out.println("at circle controller ==================================");
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
			System.out.println("control at getAllCircles  user ");
			try
			{
			 allCircles=circleDao.getAllCircles();
			 
			 
			
			
			if(allCircles!=null)
			{
				 for(Circle circle:allCircles)
					{
						Link link=linkTo(CircleController.class).slash(circle.getOwnerid()).withSelfRel();
						circle.add(link);
					}
					
			return new ResponseEntity<List<Circle>>(allCircles,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<List<Circle>>(allCircles,HttpStatus.NO_CONTENT);
			}
			}
			catch(Exception exception )
			{
				exception.printStackTrace();
				
				return new ResponseEntity<List<Circle>>(allCircles,HttpStatus.NO_CONTENT);
					
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
	
		
		
				
		
}
