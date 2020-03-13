package application;

import java.util.List;

import javax.swing.JOptionPane;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import classes.Historique;
import classes.Personnel;
import classes.Produit;
import controllers.Cadministration;
import controllers.Cauthentification;
import controllers.Cedition;
import javafx.application.Application;
import javafx.stage.Stage;
import models.Mhistorique;
import models.Mpersonnel;
import models.Mproduit;
import views.SceneAcceuil;
import views.SceneAdministration;
import views.SceneConnexion;
import views.SceneConsulter;
import views.SceneEdition;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;


public class Main extends Application {
	//private Stage primaryStage;
	//private AnchorPane root;
	Stage window;
	Scene sceneConnexion, sceneAcceuil, sceneConsultation, sceneEdition, sceneAdministration;
	Personnel user;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;

		//sceneConnexion
		SceneConnexion layout1 = new SceneConnexion();
		sceneConnexion = new Scene(layout1, 300, 291);

		//sceneAcceuil
		SceneAcceuil layout2 = new SceneAcceuil();
		sceneAcceuil = new Scene(layout2, 1000, 600);

		//sceneConsultation
		SceneConsulter layout3 = new SceneConsulter();
		sceneConsultation = new Scene(layout3, 1000, 600);

		//sceneEdition
		SceneEdition layout4 = new SceneEdition();
		sceneEdition = new Scene(layout4, 1000, 600);

		//sceneAdministration
		SceneAdministration layout5 = new SceneAdministration();
		sceneAdministration = new Scene(layout5, 1000, 600);


		//Action listener
		layout1.btnConnexion.setOnAction(e -> { //Bouton pour se connecter de la sceneConnexion
			Cauthentification auth = new Cauthentification();
			user = auth.checkAuth(layout1.txtLogin.getText(), layout1.txtPassword.getText());
			if(user != null){
				window.setScene(sceneAcceuil);
				window.setTitle("Acceuil");
				layout1.lblErreurConnexion.setVisible(false);
				System.out.println(user.getIsAdmin());
				if(user.getIsAdmin()){
					layout2.btnAdmin.setVisible(true);
				}
			} else {
				layout1.lblErreurConnexion.setVisible(true);
			}
		});

		layout2.btnConsulter.setOnAction(e -> { //Bouton pour changer de vue de la sceneAcceuil
			Mproduit mp = new Mproduit();

			layout3.tableProduit.getItems().clear();
			for (Produit p : mp.getAll()) {
				layout3.tableProduit.getItems().add(p);
				layout3.colLib.setCellValueFactory(new PropertyValueFactory<>("libelle"));
				layout3.colQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				layout3.colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
			}
			window.setScene(sceneConsultation);
			window.setTitle("Consultation");
		});

		layout2.btnAdmin.setOnAction(e -> { //Bouton pour changer de vue de la sceneAcceuil
			Mhistorique mh = new Mhistorique();

			layout5.tableHistoriqueGlobal.getItems().clear();
			for (Historique p : mh.getAll()) {
				layout5.tableHistoriqueGlobal.getItems().add(p);
				layout5.colLib.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
				layout5.colQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				layout5.colDate.setCellValueFactory(new PropertyValueFactory<>("date_time"));
				layout5.colId.setCellValueFactory(new PropertyValueFactory<>("id"));
				layout5.colPersonnel.setCellValueFactory(new PropertyValueFactory<>("nom_prenom_personnel"));
			}
			window.setScene(sceneAdministration);
			window.setTitle("Administration");
		});

		layout2.btnEditer.setOnAction(e -> { //Bouton pour changer de vue de la sceneAcceuil
			Cedition ce = new Cedition();
			Mproduit produit = new Mproduit();
			Mhistorique mh = new Mhistorique();

			//Charger la liste des produits
			layout4.listeProduit.getItems().clear();
			for (Produit prod : produit.getAll()) {
				layout4.listeProduit.getItems().add(prod);
			}
			layout4.listeProduit.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

			//Charger la table d'historique d'une personne
			layout4.tableHistoriquePersonel.getItems().clear();
			for (Historique histo : mh.getAll()) {
				layout4.tableHistoriquePersonel.getItems().add(histo);
				layout4.colLibHisto.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
				layout4.colQteHisto.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				layout4.colIdHisto.setCellValueFactory(new PropertyValueFactory<>("id"));
			}
			//tableHistoriquePersonel.add(ce.loadHistorique());
			window.setScene(sceneEdition);
			window.setTitle("Edition");
		});

		layout4.btnEffacerAction.setOnAction(e -> { //Bouton pour effacer un historique de la sceneEdition
			JOptionPane confirmation = new JOptionPane();
			int n = confirmation.showConfirmDialog(null, "Confirmer la suppression?", "Suppression d'impression", confirmation.YES_NO_OPTION);
			if(n==0){
				Cedition ce= new Cedition();
				Mhistorique mh = new Mhistorique();

				System.out.println("Effacement de la ligne");
				ce.effacerAction((Historique) layout4.tableHistoriquePersonel.getSelectionModel().getSelectedItem());

				layout4.tableHistoriquePersonel.getItems().clear();
				for (Historique histo : mh.getAll()) {
					layout4.tableHistoriquePersonel.getItems().add(histo);
					layout4.colLibHisto.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
					layout4.colQteHisto.setCellValueFactory(new PropertyValueFactory<>("quantite"));
					layout4.colIdHisto.setCellValueFactory(new PropertyValueFactory<>("id"));
				}
			}
		});

		layout4.btnValider.setOnAction(e -> { //Bouton pour effectuer un retrait de la sceneEdition
			try{
				Cedition ce = new Cedition();
				Mhistorique mh = new Mhistorique();
				System.out.println("Retrait");
				ce.valider((Produit) layout4.listeProduit.getSelectionModel().getSelectedItem(), Integer.parseInt(layout4.txtQuantite.getText()), user.getId());

				layout4.tableHistoriquePersonel.getItems().clear();
				for (Historique histo : mh.getAll()) {
					layout4.tableHistoriquePersonel.getItems().add(histo);
					layout4.colLibHisto.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
					layout4.colQteHisto.setCellValueFactory(new PropertyValueFactory<>("quantite"));
					layout4.colIdHisto.setCellValueFactory(new PropertyValueFactory<>("id"));
				}

			} catch (Exception e1) {
				System.out.println("Le champ quantité doit être renseigné ou le produit sélectionné : " + e1);
			}
		});

		layout3.btnRetourAcceuil.setOnAction(e -> { //Bouton pour changer de vue de la sceneConsultation
			window.setScene(sceneAcceuil);
			window.setTitle("Acceuil");
		});

		layout4.btnRetourAcceuil2.setOnAction(e -> { //Bouton pour changer de vue de la sceneEdition
			window.setScene(sceneAcceuil);
			window.setTitle("Acceuil");
		});

		layout5.btnRetourAcceuil.setOnAction(e -> {
			window.setScene(sceneAcceuil);
			window.setTitle("Acceuil");
		});

		layout3.btnRecherche.setOnAction(e -> { //Bouton pour effectuer une recherche de la sceneEdition
			System.out.println("Recherche...!");
			Mproduit mp = new Mproduit();

			layout3.tableProduit.getItems().clear();
			for (Produit p : mp.getByLib(layout3.txtRecherche.getText())) {
				layout3.tableProduit.getItems().add(p);
				layout3.colLib.setCellValueFactory(new PropertyValueFactory<>("libelle"));
				layout3.colQte.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				layout3.colDesc.setCellValueFactory(new PropertyValueFactory<>("description"));
			}
		});

		layout5.btnAjouterPersonne.setOnAction(e -> {
			Cadministration cadmin = new Cadministration();
			Object[] tabValues = {0, layout5.txtLogin.getText(), layout5.txtMdp.getText(), layout5.txtNom.getText(), layout5.txtPrenom.getText()};
			cadmin.validerAjoutPers(tabValues);
		});

		layout5.btnAjouterProduit.setOnAction(e -> {
			Cadministration cadmin = new Cadministration();
			Object[] tabValues = {layout5.txtDesc.getText(), layout5.txtLib.getText(), layout5.txtQte.getText()};
			cadmin.validerAjoutProd(tabValues);
		});


		window.setScene(sceneConnexion);
		window.setTitle("Connexion");
		window.setResizable(false);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
		//Mproduit t = new Mproduit();

		//Select
		/*Integer id = 5;
		Produit p = new Produit();

		p = (Produit) t.getById(id);
		System.out.println(p.toString());*/

		//Modification
		/*String des = "description modifié";
		String med = "Medoc modifié";
		Integer i = 1;
		Integer id = 5;

		Object[] tabTest = {des, med, i, id};
		if(t.update(tabTest)) {
			System.out.println("modification effectuée");
		}*/


		//Ajout
		/*String des = "description de test";
		String med = "Medoc";
		Integer i = 50;

		Object[] tabTest = {des, med, i};
		if(t.add(tabTest)){
			System.out.println("Ajout effectué");
		}*/


		//Get par id
		/*Produit p = new Produit();

		p = t.find(1);
		System.out.println(p.toString());*/
	}
}
