package com.efraim.restassured.tests;

import com.efraim.restassured.helpers.PostsServiceHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostPostTest {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	/**
	 * Validates POST to create a post returns 201 status code
	 */
	@Test
	public void RequestForNewPost() {
	    Response response = helper.newPost(1,"efraim", "test");
        Assert.assertEquals(response.getStatusCode(), 201);
	}

}
