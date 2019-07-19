package com.sapient.week3.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.week3.model.Address;
import com.sapient.week3.model.Post;
import com.sapient.week3.model.User;
import com.sapient.week3.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/api/v1/users/")
//@PropertySource("classpath:documentation.properties")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	// User Details
	
	
	@PostMapping(value = "/" , consumes = {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public String saveUser(@Valid  @RequestBody User user)
	{
		
		System.out.println("Came inside the save user");
		userservice.saveUser(user);
 		return "SUCESS";
	}
	
	@PutMapping(value = "/{id}" , consumes = {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	public void updateUser(@PathVariable int id,@RequestBody User user)
	{
		System.out.println("Came inside the update user");
		userservice.update(id,user);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable int id)
	{
		System.out.println("Came inside the delete product");
		userservice.deleteUser(id);
	}
	
	
	@GetMapping(value="users/", produces = {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	@ApiOperation(value="fetch all posts", notes = "API to fetch all the Posts")
	public  List<User> listAllUsers()
	{
		System.out.println("Heleo");
		//List<Product> products = Arrays.asList(new Product(),new Product(),new Product());
		return userservice.fetchAllUser();
	}
	
	
	
	
	//Post details
	
	
	
	@PostMapping(value = "post/" , consumes = {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	public String savePost( @RequestBody Post post)
	{
		System.out.println("Came inside the save user");
		userservice.savePost(post);
 		return "SUCESS";
	}
	
	
	
	@GetMapping(value="posts/", produces = {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	@ApiOperation(value="fetch all posts", notes = "API to fetch all the Posts")
	public  List<Post> listAllPosts()
	{
		System.out.println("Heleo");
		//List<Product> products = Arrays.asList(new Product(),new Product(),new Product());
		return userservice.fetchAllPosts();
	}
	
	@GetMapping(value="postsById/{id}", produces = {APPLICATION_JSON_VALUE , APPLICATION_XML_VALUE})
	public List<Post> findPostById(@ApiParam(value = "${ProductionController.FetchByID") @PathVariable("id") int id)
	{
		return userservice.findPostsById(id);
	}
	
	@DeleteMapping(value = "deletePost/{userId}/{postId}")
	public void deletePost(@PathVariable int userId , @PathVariable int postId)
	{
		System.out.println("Came inside the delete product");
		userservice.deleteUserPosts(userId,postId);
	}
	
	@DeleteMapping(value = "deleteAllPosts/{id}")
	public void deleteAllPosts(@PathVariable int id )
	{
		System.out.println("Came inside the delete product");
		userservice.deleteAllUserPosts(id);
	}
	
}
