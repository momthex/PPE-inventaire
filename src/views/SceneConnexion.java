package views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class SceneConnexion extends AnchorPane {

	Label labelLogin = new Label("Login");
	Label labelPass = new Label("Mot de passe");
	public PasswordField txtPassword = new PasswordField();
	ImageView champImg = new ImageView("/asset/logogsbinventaire.png");
	public Label lblErreurConnexion = new Label("Login ou mot de passe incorrecte");
	public Button btnConnexion = new Button("Connexion");
	public TextField txtLogin = new TextField();

	public SceneConnexion() {
		super();
		setComposition();
		this.getChildren().addAll(btnConnexion, labelLogin, labelPass, txtPassword, txtLogin, champImg, lblErreurConnexion);
	}

	private void setComposition() {
		labelLogin.setLayoutX(69.0);
		labelLogin.setLayoutY(170.0);

		labelPass.setLayoutX(26.0);
		labelPass.setLayoutY(198.0);

		txtPassword.setLayoutX(107.0);
		txtPassword.setLayoutY(194.0);

		txtLogin.setLayoutX(107.0);
		txtLogin.setLayoutY(166.0);

		champImg.setFitHeight(150);
		champImg.setFitWidth(247);
		champImg.setLayoutX(33.0);
		champImg.setLayoutY(14.0);

		lblErreurConnexion.setLayoutX(24.0);
		lblErreurConnexion.setLayoutY(227.0);
		lblErreurConnexion.setTextFill(Color.rgb(210, 39, 30));
		lblErreurConnexion.setAlignment(Pos.CENTER);
		lblErreurConnexion.setVisible(false);

		btnConnexion.setLayoutX(113.0);
		btnConnexion.setLayoutY(252.0);
	}
}
