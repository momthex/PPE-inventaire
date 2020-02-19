package controllers;

import classes.Historique;
import classes.Produit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EditionStock {

	@FXML
	private TextField txtQuantite;

	@FXML
	private ListView<Produit> listeProduit;

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

	}

	@FXML
	private void handleButtonEffacerActioin(ActionEvent event){

	}

}
