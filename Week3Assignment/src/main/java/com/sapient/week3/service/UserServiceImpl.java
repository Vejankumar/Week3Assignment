package com.sapient.week3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sapient.week3.dao.UserServiceDAO;
import com.sapient.week3.model.Post;
import com.sapient.week3.model.User;

@Service(value="userservice")
public class UserServiceImpl implements UserService {
	
	@Autowired( required = true)
	@Qualifier(value="HybernateDAOImpl")
	 private UserServiceDAO userServiceDAO;
	
	public UserServiceImpl(@Qualifier(value="HybernateDAOImpl")UserServiceDAO userServiceDAO){
        this.userServiceDAO = userServiceDAO;
    }
	
	@Transactional
	public User saveUser(User user) {
		return userServiceDAO.saveUser(user);
		
	}
	
	@Transactional
	public List<User> fetchAllUser() {
		System.out.println("Heleo");
		return userServiceDAO.fetchAllUser();
	}

	@Transactional
	public User findById(int id) {
		
		return userServiceDAO.findById(id);
	}
	
	@Transactional
	public void deleteUser(int id) {
		
		userServiceDAO.deleteUser(id);
	}
	
	@Transactional
	public void update(int id, User user) {
		userServiceDAO.update(id, user);
		
	}

	@Transactional
	public List<Post> fetchAllPosts() {
		
		return userServiceDAO.fetchAllPosts();
	}

	@Transactional
	public List<Post> findPostsById(int id) {
		
		return userServiceDAO.findPostsById(id);
	}

	@Transactional
	public void deleteUserPosts(int userId, int postId) {
		userServiceDAO.deleteUserPosts(userId, postId);
		
	}

	@Transactional
	public void deleteAllUserPosts(int id) {
		userServiceDAO.deleteAllUserPosts(id);
		
	}

	@Transactional
	public void savePost(Post post) {
		userServiceDAO.savePost(post);
	}

}
