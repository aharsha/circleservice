package com.stackroute.activitystream.circle;

import static org.junit.Assert.assertEquals;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;





@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=CircleServiceApplication.class)
public class CircleServiceApplicationTests {

	
	@Autowired
	CircleDAO circleDao;
	
	
	@Test
	public void addCircleTestCase() {
		Circle circle=new Circle();
		circle.setCirclename("Veg-NonVeg");
		
	
		circle.setCirclediscription("Veg-NonVeg Both");
		
		
		
		
		
		circle.setOwnerid("harsha@gmail.com");
		
		assertEquals("success",true,circleDao.addCircle(circle));
	}
	
	


	@Test
	public void getAllCircle() {
		
		assertEquals("success",true,circleDao.getAllCircles());
	}

	
}

