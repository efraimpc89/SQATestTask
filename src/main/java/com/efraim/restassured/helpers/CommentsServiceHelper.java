package com.efraim.restassured.helpers;

import java.lang.reflect.Type;
import java.util.List;

import com.efraim.restassured.constants.Endpoints;
import com.efraim.restassured.models.Comment;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CommentsServiceHelper {

	
	public CommentsServiceHelper(){
		RestAssured.baseURI = Endpoints.BASE_URI;	
	}

	/***
	 * Gets a List of all comments from a post "id" path variable (/posts/{id}/comments)
	 * @param postId post ID to retrieve comments from
	 * @return List<Comment>
	 */
	public List<Comment> getPostCommentsList(int postId){
		
		String url = String.format(Endpoints.GET_POST_COMMENTS, postId);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(url)
				.andReturn();
		
		Type type = new TypeReference<List<Comment>>() {}.getType();
		
		List<Comment> commentsList = response.as(type);
		
		return commentsList;

	}
	
	/***
	 * Gets Response of all comments from a post "id" path variable (/posts/{id}/comments)
	 * @param postId
	 * @return Response
	 */
	public Response getPostCommentsResponse(int postId){
		
		String url = String.format(Endpoints.GET_POST_COMMENTS, postId);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(url)
				.andReturn();
		
		return response;

	}
	
	/***
	 * Gets a List of all comments from a "postId" query variable(/comments?postId={id})
	 * @param postId
	 * @return List<Comment>
	 */
	public List<Comment> getCommentsWithPostIdList(int postId){
		
		String url = String.format(Endpoints.GET_COMMENTS_WITH_POST_ID, postId);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(url)
				.andReturn();
		
		Type type = new TypeReference<List<Comment>>() {}.getType();
		
		List<Comment> commentsList = response.as(type);
		
		return commentsList;

	}
	
	/***
	 * Gets a Response of all comments from a "postId" query variable(/comments?postId={id})
	 * @param postId
	 * @return Response
	 */
	public Response getCommentsWithPostIdResponse(int postId){
		
		String url = String.format(Endpoints.GET_COMMENTS_WITH_POST_ID, postId);
		
		Response response = 
				RestAssured.given()
				.contentType(ContentType.JSON)
				.get(url)
				.andReturn();
				
		return response;

	}
	
	/**
	 * Converts a Response into a List of Comments
	 * @param response response containing the list of comments
	 * @return List<Comment>
	 */
	public List<Comment> convertResponseToCommentsList(Response response){
				
		Type type = new TypeReference<List<Comment>>() {}.getType();
		
		List<Comment> commentsList = response.as(type);
		
		return commentsList;
	}

	/**
	 * Validates the GET all comments schema
	 */
	public void getAllCommentsSchemaValidation(){
		RestAssured.given()
		.contentType(ContentType.JSON)
		.get(Endpoints.GET_ALL_COMMENTS)
		.then()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GetAllCommentsSchema.json"))
			.statusCode(200);
	}
	
	
}
