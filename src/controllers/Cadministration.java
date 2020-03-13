package controllers;

import models.Mpersonnel;
import models.Mproduit;

public class Cadministration {

	public Cadministration(){
		super();
	}

	public void validerAjoutPers(Object[] tabValues){
		Mpersonnel mperso = new Mpersonnel();

		mperso.add(tabValues);
	}

	public void validerAjoutProd(Object[] tabValues){
		Mproduit mprdo = new Mproduit();

		mprdo.add(tabValues);
	}
}
