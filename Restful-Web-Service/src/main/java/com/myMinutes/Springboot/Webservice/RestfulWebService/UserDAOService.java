package com.myMinutes.Springboot.Webservice.RestfulWebService;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import antlr.collections.List;

@Component
public class UserDAOService {

	private static ArrayList<User> users =  new ArrayList<User>();
	private int countUser = 3;
	
	//Todo- Replace to connect to database later and retrieve values
	
	static {
		users.add(new User(1, "Adam"));
		users.add(new User(2, "Mane"));
		users.add(new User(3, "Shame"));
	}
	
	public ArrayList<User> findAll() {
		return users;
	}
	
	public User Save(User user) {
		if(user.getID() == 0)
			user.setID(++countUser);
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user : users) {
			if(user.getID() == id)
				return user;
		}
		return null;
	}
	
	public User Delete(int id) {
		
		Iterator<User> itr = users.iterator();
		
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getID() == id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
	
}
