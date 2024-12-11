package com.efraim.restassured.tests;

import com.efraim.restassured.helpers.PostsServiceHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatchPostTest {
	
	PostsServiceHelper helper;
	
	@BeforeClass
	public void initialize() {
		helper = new PostsServiceHelper();
	}

	/**
	 * Validates PATCH to update post title returns 200 status code
	 */
	@Test
	public void patchPostTitle() {
	    Response response = helper.updatePostTitle(1, "test title");
        Assert.assertEquals(response.getStatusCode(), 200);
  
	}

	/**
	 * Validates PATCH to update post body returns 200 status code
	 */
	@Test
	public void patchPostBody() {
		Response response = helper.updatePostBody(1, "test body");
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
