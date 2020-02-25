package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import views.StageLoader;

public class Authentification {

	@FXML
	private Button btnConnexion;

	@FXML
	private TextField txtLogin;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private Label lblErreurConnexion;

	@FXML
	private void handleButtonConnexion(ActionEvent event) throws IOException{
		if(this.txtPassword.getText().equals("a")){
			lblErreurConnexion.setVisible(false);
			StageLoader stage = new StageLoader();
			stage.setStage("stageAcceuil", "Acceuil");
		} else {
			lblErreurConnexion.setVisible(true);
		}
	}
}
