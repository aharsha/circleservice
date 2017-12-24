package com.stackroute.activitystream.circle.mocktest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.stackroute.activitystream.circle.CircleController;
import com.stackroute.activitystream.dao.CircleDAO;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CircleController.class, secure = false)
public class CircleTestMock {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CircleDAO circleDao;

	@Test
	public void getCirclesTestCase() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getCircle/1476")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{circleid:32958,circlediscription:Non vegetarian group,circlename:NonvegGroup,createddate:2017-08-04 17:18:02,ownerid:vharsha@gmail.com,status:active}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
