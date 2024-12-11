package com.efraim.restassured.helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.efraim.restassured.constants.Endpoints;
import com.efraim.restassured.models.Post;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class PostsServiceHelper {

	
	public PostsServiceHelper(){
		RestAssured.baseURI = Endpoints.BASE_URI;
	}
	
	/***
	 * Gets a list of all posts (/posts)
	 * @return List<Post>
	 */
	public List<Post> getAllPostsList(){
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(Endpoints.POSTS_CRUD)
				.andReturn();
		
		Type type = new TypeReference<List<Post>>() {}.getType();
		
		List<Post> postList = response.as(type);
		
		return postList;

	}
	
	/***
	 * Gets a list of all posts (/posts)
	 * @return Response
	 */
	public Response getAllPostsResponse(){
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(Endpoints.POSTS_CRUD)
				.andReturn();
		
		return response;

	}
	
	/***
	 * Gets a Response of a single post by ID (/posts/{id})
	 * @param postId post ID to be retrieved
	 * @return Response
	 */
	public Response getSinglePostResponse(int postId){
	
		String url = String.format(Endpoints.GET_SINGLE_POST, postId);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(url)
				.andReturn();
		
		return response;
	
	}
	
	/***
	 * Converts a Response object to a Post List
	 * @param response response that contains the list to convert
	 * @return List<Post>
	 */
	public List<Post> convertResponseToPostList(Response response){
				
		Type type = new TypeReference<List<Post>>() {}.getType();
		
		List<Post> postList = response.as(type);
		
		return postList;

	}
	
	/***
	 * Creates a new Post based on the parameters
	 * @param userId user ID of the new post
	 * @param title title of the post
	 * @param body  body of the post
	 * @return Response
	 */
	public Response newPost(int userId, String title, String body) {
		
		Post newPost = new Post();
		newPost.setUserId(userId);
		newPost.setTitle(title);
		newPost.setBody(body);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.body(newPost)
				.post(Endpoints.POSTS_CRUD)
				.andReturn();
		
		return response;

	}
	
	/***
	 * Deletes a post by ID
	 * @param postId post ID to be deleted
	 * @return Response
	 */
	public Response deletePost(int postId) {
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.delete(Endpoints.POSTS_CRUD+ "/" + postId)
				.andReturn();
		
		return response;

	}
	
	/***
	 * Updates a post based on the parameters
	 * @param postId post ID to be updated
	 * @param userId new user ID
	 * @param title new title
	 * @param body new body
	 * @return Response
	 */
	public Response updatePost(int postId, int userId, String title, String body) {
		
		Post post = new Post();
		post.setUserId(userId);
		post.setTitle(title);
		post.setBody(body);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.body(post)
				.put(Endpoints.POSTS_CRUD + "/" + postId)
				.andReturn();
		
		return response;

	}

	/***
	 * Updates a post based on the parameters
	 * @param postId post ID to be updated
	 * @param title new title
	 * @return Response
	 */
	public Response updatePostTitle(int postId, String title) {

		JSONObject requestParams = new JSONObject();
		requestParams.put("title", title);

		Response response =
				RestAssured.given()
						.contentType(ContentType.JSON)
						.body(requestParams.toJSONString())
						.patch(Endpoints.POSTS_CRUD + "/" + postId)
						.andReturn();

		return response;
	}

	/***
	 * Updates a post based on the parameters
	 * @param postId post ID to be updated
	 * @param body new body
	 * @return Response
	 */
	public Response updatePostBody(int postId, String body) {

		JSONObject requestParams = new JSONObject();
		requestParams.put("body", body);

		Response response =
				RestAssured.given()
						.contentType(ContentType.JSON)
						.body(requestParams.toJSONString())
						.patch(Endpoints.POSTS_CRUD + "/" + postId)
						.andReturn();

		return response;
	}

	/**
	 * Validates the GET all posts schema
	 */
	public void getAllPostSchemaValidation(){
		RestAssured.given()
		.contentType(ContentType.JSON)
		.get(Endpoints.POSTS_CRUD)
		.then()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GetAllPostsSchema.json"))
			.statusCode(200);
	}
	
}
