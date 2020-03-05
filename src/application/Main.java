package application;

import java.util.List;

import classes.Historique;
import classes.Personnel;
import classes.Produit;
import controllers.Authentification;
import controllers.Cauthentification;
import controllers.Cedition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import models.Mhistorique;
import models.Mproduit;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	//private Stage primaryStage;
	//private AnchorPane root;
	Stage window;
	Scene sceneConnexion, sceneAcceuil, sceneConsultation, sceneEdition;
	Personnel user;

	/*@Override
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
	}*/

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;

		//Element pour sceneConnexion
		Label labelLogin = new Label("Login");
		labelLogin.setLayoutX(69.0);
		labelLogin.setLayoutY(170.0);

		Label labelPass = new Label("Mot de passe");
		labelPass.setLayoutX(26.0);
		labelPass.setLayoutY(198.0);

		PasswordField txtPassword = new PasswordField();
		txtPassword.setLayoutX(107.0);
		txtPassword.setLayoutY(194.0);

		TextField txtLogin = new TextField();
		txtLogin.setLayoutX(107.0);
		txtLogin.setLayoutY(166.0);

		ImageView champImg = new ImageView("/asset/logogsbinventaire.png");
		champImg.setFitHeight(150);
		champImg.setFitWidth(247);
		champImg.setLayoutX(33.0);
		champImg.setLayoutY(14.0);

		Label lblErreurConnexion = new Label("Login ou mot de passe incorrecte");
		lblErreurConnexion.setLayoutX(24.0);
		lblErreurConnexion.setLayoutY(227.0);
		lblErreurConnexion.setTextFill(Color.rgb(210, 39, 30));
		lblErreurConnexion.setAlignment(Pos.CENTER);
		lblErreurConnexion.setVisible(false);

		Button btnConnexion = new Button("Connexion");
		btnConnexion.setLayoutX(113.0);
		btnConnexion.setLayoutY(252.0);


		//sceneConnexion
		AnchorPane layout1 = new AnchorPane();
		layout1.getChildren().addAll(btnConnexion, labelLogin, labelPass, txtPassword, txtLogin, champImg, lblErreurConnexion);
		sceneConnexion = new Scene(layout1, 300, 291);

		//Element pour sceneAcceuil
		Button btnConsulter = new Button("Consulter");
		btnConsulter.setLayoutX(677.0);
		btnConsulter.setLayoutY(443.0);
		btnConsulter.setPrefSize(192.0, 83.0);

		Button btnEditer = new Button("Modifier");
		btnEditer.setLayoutX(134.0);
		btnEditer.setLayoutY(443.0);
		btnEditer.setPrefSize(192.0, 83.0);

		ImageView champImgConsulter = new ImageView("/asset/consulter.png");
		champImgConsulter.setFitHeight(261.0);
		champImgConsulter.setFitWidth(254.0);
		champImgConsulter.setLayoutX(646.0);
		champImgConsulter.setLayoutY(86.0);

		ImageView champImgEditer = new ImageView("/asset/modifier.png");
		champImgEditer.setFitHeight(261.0);
		champImgEditer.setFitWidth(254.0);
		champImgEditer.setLayoutX(103.0);
		champImgEditer.setLayoutY(86.0);

		//sceneAcceuil
		AnchorPane layout2 = new AnchorPane();
		layout2.setBackground(Background.EMPTY);
		layout2.getChildren().addAll(btnConsulter, btnEditer, champImgEditer, champImgConsulter);
		sceneAcceuil = new Scene(layout2, 1000, 600);

		//Element pour sceneConsultation
		Button btnRetourAcceuil = new Button("⏴Retour à l'accueil");
		btnRetourAcceuil.setLayoutX(11.0);
		btnRetourAcceuil.setLayoutY(5.0);
		btnRetourAcceuil.setPrefSize(202.0, 54.0);

		TextField txtRecherche = new TextField();
		txtRecherche.setLayoutX(518);
		txtRecherche.setLayoutY(53);
		txtRecherche.setPrefSize(232, 65);

		Label labelConsulterStock = new Label("Consulter le stock");
		labelConsulterStock.setLayoutX(28);
		labelConsulterStock.setLayoutY(63);

		TableView tableProduit =new TableView();
		tableProduit.setLayoutX(28);
		tableProduit.setLayoutY(137);
		tableProduit.setPrefSize(932, 420);
		TableColumn<Produit, String> colLib = new TableColumn<>("Libellé");
		colLib.setPrefWidth(400);
		TableColumn<Produit, Integer> colQte = new TableColumn<>("Quantité");
		colQte.setPrefWidth(132);
		TableColumn<Produit, String> colDesc = new TableColumn<>("Description");
		colDesc.setPrefWidth(400);
		tableProduit.getColumns().addAll(colLib, colQte, colDesc);

		Button btnRecherche = new Button("Rechercher 🔍");
		btnRecherche.setLayoutX(777);
		btnRecherche.setLayoutY(59);
		btnRecherche.setPrefSize(183, 54);

		//sceneConsultation
		AnchorPane layout3 = new AnchorPane();
		layout3.setBackground(Background.EMPTY);
		layout3.getChildren().addAll(btnRetourAcceuil, txtRecherche, labelConsulterStock, tableProduit, btnRecherche);
		sceneConsultation = new Scene(layout3, 1000, 600);

		//Element pour sceneEdition
		Button btnRetourAcceuil2 = new Button("⏴Retour à l'accueil");
		btnRetourAcceuil2.setLayoutX(11.0);
		btnRetourAcceuil2.setLayoutY(5.0);
		btnRetourAcceuil2.setPrefSize(202.0, 54.0);

		ListView listeProduit = new ListView();
		listeProduit.setLayoutX(79);
		listeProduit.setLayoutY(105);
		listeProduit.setPrefSize(318, 433);

		TextField txtQuantite = new TextField();
		txtQuantite.setLayoutX(558);
		txtQuantite.setLayoutY(400);
		txtQuantite.setPrefSize(168, 85);

		Label labelTxtQte = new Label("Quantité");
		labelTxtQte.setLayoutX(443.0);
		labelTxtQte.setLayoutY(420.0);
		labelTxtQte.setPrefSize(115, 45);

		TableView tableHistoriquePersonel =new TableView();
		tableHistoriquePersonel.setLayoutX(420);
		tableHistoriquePersonel.setLayoutY(136);
		tableHistoriquePersonel.setPrefSize(352, 200);
		TableColumn<Produit, String> colLibHisto = new TableColumn<>("Libellé");
		colLibHisto.setPrefWidth(258);
		colLibHisto.setResizable(false);
		TableColumn<Produit, Integer> colQteHisto = new TableColumn<>("Quantité");
		colQteHisto.setPrefWidth(92);
		colQteHisto.setResizable(false);
		TableColumn<Produit, Integer> colIdHisto = new TableColumn<>("Id");
		colIdHisto.setPrefWidth(0);
		colIdHisto.setVisible(false);
		tableHistoriquePersonel.getColumns().addAll(colLibHisto, colQteHisto, colIdHisto);


		Label labelDerniereAction = new Label("Vos dernières actions");
		labelDerniereAction.setLayoutX(497.0);
		labelDerniereAction.setLayoutY(105.0);

		Button btnEffacerAction = new Button("Effacer l'action");
		btnEffacerAction.setLayoutX(777.0);
		btnEffacerAction.setLayoutY(166.0);
		btnEffacerAction.setPrefSize(135, 31);

		Label labelRetProd = new Label("Retirez des produits");
		labelRetProd.setLayoutX(322);
		labelRetProd.setLayoutY(31);

		Button btnValider = new Button("Valider");
		btnValider.setLayoutX(805.0);
		btnValider.setLayoutY(486.0);
		btnValider.setPrefSize(168, 85);

		//sceneEdition
		AnchorPane layout4 = new AnchorPane();
		layout4.setBackground(Background.EMPTY);
		layout4.getChildren().addAll(btnRetourAcceuil2, listeProduit, txtQuantite, labelTxtQte, tableHistoriquePersonel, labelDerniereAction, btnEffacerAction, labelRetProd, btnValider);
		sceneEdition = new Scene(layout4, 1000, 600);


		//Action listener
		btnConnexion.setOnAction(e -> { //Bouton pour se connecter de la sceneConnexion
			Cauthentification auth = new Cauthentification();
			user = auth.checkAuth(txtLogin.getText(), txtPassword.getText());
			if(user != null){
				window.setScene(sceneAcceuil);
				window.setTitle("Acceuil");
				lblErreurConnexion.setVisible(false);
			} else {
				lblErreurConnexion.setVisible(true);
			}
		});

		btnConsulter.setOnAction(e -> { //Bouton pour changer de vue de la sceneAcceuil
			window.setScene(sceneConsultation);
			window.setTitle("Consultation");
		});

		btnEditer.setOnAction(e -> { //Bouton pour changer de vue de la sceneAcceuil
			Cedition ce = new Cedition();
			Mproduit produit = new Mproduit();
			Mhistorique mh = new Mhistorique();

			//Charger la liste des produits
			listeProduit.getItems().clear();
			for (Produit prod : produit.getAll()) {
				listeProduit.getItems().add(prod);
			}
			listeProduit.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

			//Charger la table d'historique d'une personne
			tableHistoriquePersonel.getItems().clear();
			for (Historique histo : mh.getAll()) {
				tableHistoriquePersonel.getItems().add(histo);
				colLibHisto.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
				colQteHisto.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				colIdHisto.setCellValueFactory(new PropertyValueFactory<>("id"));
			}
			//tableHistoriquePersonel.add(ce.loadHistorique());
			window.setScene(sceneEdition);
			window.setTitle("Edition");
		});

		btnEffacerAction.setOnAction(e -> { //Bouton pour effacer un historique de la sceneEdition
			Cedition ce= new Cedition();
			Mhistorique mh = new Mhistorique();

			System.out.println("Effacement de la ligne");
			ce.effacerAction((Historique) tableHistoriquePersonel.getSelectionModel().getSelectedItem());

			tableHistoriquePersonel.getItems().clear();
			for (Historique histo : mh.getAll()) {
				tableHistoriquePersonel.getItems().add(histo);
				colLibHisto.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
				colQteHisto.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				colIdHisto.setCellValueFactory(new PropertyValueFactory<>("id"));
			}
		});

		btnValider.setOnAction(e -> { //Bouton pour effectuer un retrait de la sceneEdition
			try{
			Cedition ce = new Cedition();
			Mhistorique mh = new Mhistorique();
			System.out.println("Retrait");
			ce.valider((Produit) listeProduit.getSelectionModel().getSelectedItem(), Integer.parseInt(txtQuantite.getText()), user.getId());

			tableHistoriquePersonel.getItems().clear();
			for (Historique histo : mh.getAll()) {
				tableHistoriquePersonel.getItems().add(histo);
				colLibHisto.setCellValueFactory(new PropertyValueFactory<>("nom_produit"));
				colQteHisto.setCellValueFactory(new PropertyValueFactory<>("quantite"));
				colIdHisto.setCellValueFactory(new PropertyValueFactory<>("id"));
			}

			} catch (Exception e1) {
				System.out.println("Le champ quantité doit être renseigné ou le produit sélectionné : " + e1);
			}
		});

		btnRetourAcceuil.setOnAction(e -> { //Bouton pour changer de vue de la sceneConsultation
			window.setScene(sceneAcceuil);
			window.setTitle("Acceuil");
		});

		btnRetourAcceuil2.setOnAction(e -> { //Bouton pour changer de vue de la sceneEdition
			window.setScene(sceneAcceuil);
			window.setTitle("Acceuil");
		});

		btnRecherche.setOnAction(e -> { //Bouton pour effectuer une recherche de la sceneEdition
			System.out.println("Recherche...!");
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
