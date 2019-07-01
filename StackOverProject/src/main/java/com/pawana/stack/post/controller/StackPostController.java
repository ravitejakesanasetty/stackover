package com.pawana.stack.post.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pawana.stack.post.entities.PostTable;
import com.pawana.stack.post.entities.User;
import com.pawana.stack.post.exceptions.ModelNotFoundException;
import com.pawana.stack.post.repositories.PostTableRepository;
import com.pawana.stack.post.repositories.UserRepository;
import com.pawana.stack.post.util.APIResponse;
import com.pawana.stack.post.util.Status;


@RestController
@RequestMapping("/api")
public class StackPostController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PostTableRepository postRespository;

	@PostMapping("/user")
	public APIResponse<User> createUser(@RequestBody User user) {
		 user = userRepository.save(user);
		APIResponse<User> api=new APIResponse<>();
		api.setPayLoad(user);
		return api;
		}

	@PutMapping("/user")
	public  APIResponse<User> updateUser(@RequestBody User user) {
		user=userRepository.save(user);
		
		APIResponse<User> api=new APIResponse<>();
		api.setPayLoad(user);
		return api;

	}

	@GetMapping("/user/{userId}")
	public APIResponse<User> getUser(@PathVariable("userId") String userId) {
		User user=userRepository.findByUserId(userId);
		if(user==null)
			 throw new ModelNotFoundException("111","User id"+userId+" not found");
		
		APIResponse<User> api=new APIResponse<>();
		 
		api.setPayLoad(user);
		api.setStatus(new Status());
		return api;

	}

	@GetMapping("/user")
	public APIResponse<User> allUsers() {
		APIResponse<User> api=new APIResponse<>();
		List<User> user=new ArrayList<>();
		user=(List<User>) userRepository.findAll();
		api.setPayLoad(user);
		api.setStatus(new Status());
		return api;

	}
	
	@PostMapping("/post")
	public APIResponse<PostTable> createPost(@RequestBody PostTable post) {
        post=postRespository.save(post);
        APIResponse<PostTable> api=new APIResponse<>();
        api.setPayLoad(post);
        api.setStatus(new Status());
        return api;
	}

	@PutMapping("/post")
	public APIResponse<PostTable> updatePost(@RequestBody PostTable post) {
		post=postRespository.save(post);
        APIResponse<PostTable> api=new APIResponse<>();
        api.setPayLoad(post);
        api.setStatus(new Status());
        return api;

	}

	@GetMapping("/user/{userId}/post/{postId}")
	public PostTable getPostforUser(@PathVariable("userId") String userId,@PathVariable Integer postId) {
		
		//User user = userRepository.findByUserId(userId);
		
		PostTable post = postRespository.findById(postId).get();
		APIResponse<PostTable> api=new APIResponse<>();
		if(post == null  ||  post.getUser() == null  || !post.getUser().getUserId().equals(userId)) {
			 throw new ModelNotFoundException("113","Post id"+postId+" and"+post.getUser().getUserId()+"not found");	
		}
		api.setPayLoad(post);
		api.setStatus(new Status());
	  return post;

	}
	
	@GetMapping("/post/{postId}")
	public APIResponse<PostTable> getPost(@PathVariable("postId") Integer postId) {
		PostTable postTable=postRespository.findById(postId).get();
		APIResponse<PostTable> api=new APIResponse<>();
		if(postTable==null)
			 throw new ModelNotFoundException("112","Post id"+postId+" not found");
		
		api.setPayLoad(postTable);
		api.setStatus(new Status());
		return api;

	}


}
