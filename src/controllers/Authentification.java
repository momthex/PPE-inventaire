package controllers;

import java.io.IOException;

import classes.Personnel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Mauthentification;
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
		Mauthentification auth = new Mauthentification();
		Personnel user;
		user = auth.checkAuth(this.txtLogin.getText(), this.txtPassword.getText());
		if(user != null){
			lblErreurConnexion.setVisible(false);
			StageLoader stage = new StageLoader();
			stage.setStage("stageAcceuil", "Acceuil");
		} else {
			lblErreurConnexion.setVisible(true);
		}
	}
}
