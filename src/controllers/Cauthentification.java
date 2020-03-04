package controllers;

import classes.Personnel;
import models.Mauthentification;
import views.StageLoader;

public class Cauthentification {

	public Cauthentification(){
		super();
	}

	public Personnel checkAuth(String login, String pass){
		Mauthentification auth = new Mauthentification();
		Personnel user;
		user = auth.checkAuth(login, pass);
		if(user != null){
			return user;
		} else {
			return null;
		}
	}
}
