package com.efraim.restassured.tests;

import com.efraim.restassured.helpers.PostsServiceHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeletePostTest {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	/**
	 * Validates DELETE an existing Post returns 200
	 */
	@Test
	public void DeletePostReturns200() {
		Response response = helper.deletePost(1);
        Assert.assertEquals(response.getStatusCode(), 200);
	}

}
