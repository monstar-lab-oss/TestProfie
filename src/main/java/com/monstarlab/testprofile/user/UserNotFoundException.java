package com.monstarlab.testprofile.user;
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(Long id) {
		super("Could not find user with ID: " + id);
	}
}