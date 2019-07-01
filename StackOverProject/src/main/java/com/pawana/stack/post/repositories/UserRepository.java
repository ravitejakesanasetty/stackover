package com.pawana.stack.post.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pawana.stack.post.entities.User;

public interface UserRepository extends CrudRepository<User, String> {
	
	public User findByUserId(String userId);

}
