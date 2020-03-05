package controllers;

import classes.Historique;
import classes.Produit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import models.Mhistorique;
import models.Mproduit;

public class Cedition {

	public Cedition(){
		super();
	}

	public void valider(Produit p, int qte, int idUser){
			System.out.println(p.getQuantite());
			try {
				p.subQteProduit(qte, idUser);
			} catch (Exception e) {
				System.out.println("La converstion lettre en nombre n'est pas possible : "+ e);
			}
			System.out.println(p.getQuantite());
	}


	public void effacerAction(Historique h){
		Mhistorique mh = new Mhistorique();
		Mproduit mp = new Mproduit();
		Produit p = new Produit();

		if (mh.delete(h.getId())){
			p = mp.getById(h.getId_produit());
			p.addQteProduit(h.getQuantite());
		}
	}

	/*public ListView loadProduit() {
		Mproduit produit = new Mproduit();
		ListView l = new ListView();

		//Charger la liste des produits
		for (Produit prod : produit.getAll()) {
			l.getItems().add(prod);
			System.out.println(prod);
		}
		l.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		return l;
	}*/

	/*public void loadHistorique() {
		Mhistorique mh = new Mhistorique();

		//Charger la liste des produits
		for (Produit histo : mh.getAll()) {
			tableHistoriquePersonel.getItems().add(histo);
		}
		tableHistoriquePersonel.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}*/
}
