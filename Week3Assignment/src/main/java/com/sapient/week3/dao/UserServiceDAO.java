package com.sapient.week3.dao;

import java.util.List;

import com.sapient.week3.model.Post;
import com.sapient.week3.model.User;

public interface UserServiceDAO {
	
	public User saveUser(User user);

    public List<User> fetchAllUser();

    public User findById(int id);

    public void deleteUser(int id);
    
    public void update(int id,User user);
    
    public void savePost(Post post);
    
    public List<Post> fetchAllPosts();
    
    public List<Post> findPostsById(int id);
    
    public void deleteUserPosts(int UserId,int PostId);
    
    public void deleteAllUserPosts(int id);
}
