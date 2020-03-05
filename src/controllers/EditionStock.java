package controllers;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import classes.Historique;
import classes.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.Mproduit;

public class EditionStock {

	@FXML
	private TextField txtQuantite;

	@FXML
	private ListView<Produit> listeProduit = new ListView<>();

	@FXML
	private TableView<Historique> tableHistoriquePersonel;

	@FXML
	private Button btnValider;

	@FXML
	private Button btnRetour;

	@FXML
	private Button btnEffacerAction;

	@FXML
	private void handleButtonRetour(ActionEvent event){

	}

	@FXML
	private void handleButtonValider(ActionEvent event){
		//listeProduit.getSelectionModel().selectedIndexProperty().addListener(observable -> System.out.printf("Indice sélectionné: %d", listeProduit.getSelectionModel().getSelectedIndex()).println());
		System.out.println(listeProduit.getSelectionModel().getSelectedItem().getQuantite());
		try {
			//listeProduit.getSelectionModel().getSelectedItem().subQteProduit(Integer.parseInt(txtQuantite.getText()));
		} catch (Exception e) {
			System.out.println("La converstion lettre en nombre n'est pas possible : "+ e);
		}
		System.out.println(listeProduit.getSelectionModel().getSelectedItem().getQuantite());
	}

	@FXML
	private void handleButtonEffacerAction(ActionEvent event){

	}

	public void initialize(){
		loadData();
	}

	public void loadData() {
		Mproduit produit = new Mproduit();

		//Charger la liste des produits
		for (Produit prod : produit.getAll()) {
			listeProduit.getItems().add(prod);
		}
		listeProduit.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		//Charger l'historique
		this.tableHistoriquePersonel = tableHistoriquePersonel;
	}



}
