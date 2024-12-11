package com.efraim.restassured.tests;

import com.efraim.restassured.helpers.PostsServiceHelper;
import com.efraim.restassured.models.Post;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GetPostTest {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	/**
	 * Validates GET all posts returns 200 status code
	 */
	@Test
	public void getAllPostsIs200() {
	    Response response = helper.getAllPostsResponse();
        Assert.assertEquals(response.getStatusCode(), 200);
	       
	}

	/**
	 * Validates GET all posts returns data
	 */
	@Test
	public void getAllPosts_containsData() {
	    List<Post> response = helper.getAllPostsList();

        Assert.assertFalse(response.isEmpty());
	       
	}

	/**
	 * Validates GET single post returns 200 status code
	 */
	@Test
	public void getSinglePostIs200() {
	    Response response = helper.getSinglePostResponse(1);
        Assert.assertEquals(response.getStatusCode(), 200);
	       
	}

	/**
	 * Validates GET non existing post don't return 200 status code
	 */
	@Test
	public void getNonExistentPostsIsNot200() {
	    Response response = helper.getSinglePostResponse(99999);
	    Assert.assertTrue(response.getStatusCode() != 200);
	       
	}

	/**
	 * Validates GET non existing post returns 404 status code
	 */
	@Test
	public void getNonExistentPostsIs404() {
	    Response response = helper.getSinglePostResponse(99999);
        Assert.assertEquals(response.getStatusCode(), 404);
	       
	}

	/**
	 * Validates GET all posts schema is valid
	 */
	@Test
	public void getPostsSchemaValidation() {
	    helper.getAllPostSchemaValidation();
	}
}
