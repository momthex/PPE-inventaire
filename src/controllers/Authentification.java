package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
	private void handleButtonConnexion(ActionEvent event){
		if(this.txtPassword.getText().equals("a")){
			System.out.println("Ok");
			lblErreurConnexion.setVisible(false);
		} else {
			lblErreurConnexion.setVisible(true);
		}
	}
}
