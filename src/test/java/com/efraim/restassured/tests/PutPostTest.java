package com.efraim.restassured.tests;

import com.efraim.restassured.helpers.PostsServiceHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PutPostTest {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	/**
	 * Validates PUT to update post returns 200 status code
	 */
	@Test
	public void RequestForNewPost() {
	    Response response = helper.updatePost(1, 1,"efraim", "test");
        Assert.assertEquals(response.getStatusCode(), 200);
  
	}

}
