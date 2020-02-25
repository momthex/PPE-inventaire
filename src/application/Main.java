package application;

import classes.Produit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import models.Mproduit;
import models.modeTeset;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private Stage primaryStage;
	private AnchorPane root;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Connexion");
		this.primaryStage.setResizable(false);
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/views/fenConnexion.fxml"));
			root = (AnchorPane) loader.load();

			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		/*Mproduit t = new Mproduit();
		Produit p = new Produit();

		p = t.find(1);
		System.out.println(p.toString());*/
	}
}
