package com.myMinutes.Springboot.Webservice.RestfulWebService;

import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserWebServiceController {

	@Autowired
	UserDAOService userDAO;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping(path = "/hello")
	public String SaySomething() {
		return "Hello YOU!";
	}
	
	@GetMapping(path = "/users")
	public ArrayList<User> retrieveAllUsers() {
		return userDAO.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		User user = userDAO.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("Id - " + id);
		}
		EntityModel<User> model = EntityModel.of(user);
		
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDAO.Save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().
		path("/{id}").buildAndExpand(savedUser.getID()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/users/i18nMessage")
	public String getI18NMessages() {
		return messageSource.getMessage("good.morning.message", null, "Default Greet", LocaleContextHolder.getLocale());
	//	return model;
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void DeleteUser(int id) {
		User deletedUser = userDAO.Delete(id);
		if(deletedUser == null)
			throw new UserNotFoundException("ID-" + id);
		//else
		//return ResponseEntity.noContent();
		
	}
}
