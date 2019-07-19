package com.sapient.week3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.week3.model.Post;
import com.sapient.week3.model.User;

@Repository(value="HybernateDAOImpl")
public class UserSeviceDAOHybernetImpl implements UserServiceDAO{
	
	@Autowired
    private SessionFactory sessionFactory;


	public User saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
	}

	public List<User> fetchAllUser() {
		System.out.println("Heleo");
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from User ").list();
		
	}

	public User findById(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
		
	}

	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
        session.delete(user);
		
	}

	public void update(int id, User user) {
		
		Session session = sessionFactory.getCurrentSession();
		User user1 = session.byId(User.class).load(id);
		//user.setId(id);
		user1.setName(user.getName());
        //session.saveOrUpdate(user);
	}

	

	public List<Post> fetchAllPosts() {
		Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Post ").list();
		
	}

	public List<Post> findPostsById(int id) {
		
		return sessionFactory.getCurrentSession().get(User.class, id).getPosts();
	}

	public void deleteUserPosts(int UserId, int PostId) {
		Session session = sessionFactory.getCurrentSession();
		User user = findById(UserId);
		System.out.println(user.getPosts());
		List<Post> posts = user.getPosts();
		List<Post> userPosts = new ArrayList<Post>();
		Post deletedposts = new Post();
		for (Post post : posts) {
			if (post.getId() == PostId)
			{
				deletedposts = post;
				
			} 
			else {
				userPosts.add(post);
			}
		}
		user.setPosts(userPosts);
		session.saveOrUpdate(user);
		session.delete(deletedposts);
	}

	public void deleteAllUserPosts(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
        List<Post> list = user.getPosts();
        for (Post post : list) {
			session.delete(post);
		}
		user.setPosts(null);
		session.saveOrUpdate(user);
	}

	public void savePost(Post post) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(post);
		
	}

}
