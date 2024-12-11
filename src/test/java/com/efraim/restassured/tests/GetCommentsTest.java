package com.efraim.restassured.tests;

import com.efraim.restassured.helpers.CommentsServiceHelper;
import com.efraim.restassured.models.Comment;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetCommentsTest {
	
	CommentsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new CommentsServiceHelper();
	}

	/**
	 * Validates GET comments returns 200 status code
	 */
	@Test
	public void getCommentsIs200() {
	    Response response = helper.getCommentsWithPostIdResponse(1);
        Assert.assertEquals(response.getStatusCode(), 200);
	       
	}

	/**
	 * Validates GET comments returns data
	 */
	@Test
	public void getComments_containsData() {
	    List<Comment> response = helper.getPostCommentsList(1);
        Assert.assertFalse(response.isEmpty());
	       
	}

	/**
	 * Validates GET comments schema
	 */
	@Test
	public void getAllCommentsSchemaValidation() {
	    helper.getAllCommentsSchemaValidation();
	}

}
