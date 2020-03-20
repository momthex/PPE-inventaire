package controllers;

import java.security.NoSuchAlgorithmException;

import classes.Personnel;
import models.Mauthentification;

public class Cauthentification {

	public Cauthentification(){
		super();
	}

	public Personnel checkAuth(String login, String pass){
		Mauthentification auth = new Mauthentification();
		Personnel user;
		try {
			user = auth.checkAuth(login, pass);
			if(user != null){
				return user;
			} else {
				return null;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
