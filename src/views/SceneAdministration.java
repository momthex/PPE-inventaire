package views;

import java.sql.Timestamp;

import classes.Historique;
import classes.Produit;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

public class SceneAdministration extends AnchorPane {
	Label labelAdmin = new Label("Administration");
	Label labelNom = new Label("Nom");
	Label labelPrenom = new Label("Prénom");
	Label labelLogin = new Label("Login");
	Label labelMdp = new Label("Mot de passe");
	Label labelUtilisateur = new Label("Utilisateur");
	Label labelLibelle = new Label("Libellé");
	Label labelQuantite = new Label("Quantité");
	Label labelDescription = new Label("Description");
	Label labelProduit = new Label("Produit");
	Label labelHistorique = new Label("Historique");
	public Button btnRetourAcceuil = new Button("⏴Retour à l'accueil");
	public Button btnAjouterPersonne = new Button("Ajouter");
	public Button btnAjouterProduit = new Button("Ajouter");
	public TableView<Historique> tableHistoriqueGlobal = new TableView();
	public TableColumn<Historique, Timestamp> colDate = new TableColumn<>("Date");
	public TableColumn<Historique, String> colPersonnel = new TableColumn<>("Personnel");
	public TableColumn<Historique, Integer> colQte = new TableColumn<>("Quantité");
	public TableColumn<Historique, String> colLib = new TableColumn<>("Libellé");
	public TableColumn<Historique, Integer> colId = new TableColumn<>("Id");
	public TextField txtNom = new TextField();
	public TextField txtPrenom = new TextField();
	public TextField txtLogin = new TextField();
	public TextField txtMdp = new TextField();
	public TextField txtLib = new TextField();
	public TextField txtQte = new TextField();
	public TextField txtDesc = new TextField();

	public SceneAdministration() {
		super();
		setComposition();
		this.setBackground(Background.EMPTY);
		this.getChildren().addAll(labelAdmin, labelNom, labelPrenom, labelLogin, labelMdp, labelUtilisateur, labelLibelle, labelQuantite, labelDescription, labelProduit, labelHistorique, btnRetourAcceuil, btnAjouterPersonne, btnAjouterProduit, tableHistoriqueGlobal, txtNom, txtPrenom, txtLogin, txtMdp, txtLib, txtQte, txtDesc);
	}

	private void setComposition() {
		labelAdmin.setLayoutX(377);
		labelAdmin.setLayoutY(21);
		labelAdmin.setFont(new Font("Arial", 38));

		labelNom.setLayoutX(56);
		labelNom.setLayoutY(160);

		labelPrenom.setLayoutX(49);
		labelPrenom.setLayoutY(197);

		labelLogin.setLayoutX(55);
		labelLogin.setLayoutY(234);

		labelMdp.setLayoutX(14);
		labelMdp.setLayoutY(271);

		labelUtilisateur.setLayoutX(115);
		labelUtilisateur.setLayoutY(140);
		labelUtilisateur.setFont(new Font("System bold", 12));

		labelLibelle.setLayoutX(56);
		labelLibelle.setLayoutY(447);

		labelQuantite.setLayoutX(43);
		labelQuantite.setLayoutY(487);

		labelDescription.setLayoutX(32);
		labelDescription.setLayoutY(516);

		labelProduit.setLayoutX(124);
		labelProduit.setLayoutY(426);
		labelProduit.setFont(new Font("System bold", 12));

		labelHistorique.setLayoutX(627);
		labelHistorique.setLayoutY(110);
		labelHistorique.setFont(new Font("Arial", 22));

		btnRetourAcceuil.setLayoutX(11.0);
		btnRetourAcceuil.setLayoutY(5.0);
		btnRetourAcceuil.setPrefSize(202.0, 54.0);
		btnRetourAcceuil.setFont(new Font("Arial", 20));


		btnAjouterPersonne.setLayoutX(143.0);
		btnAjouterPersonne.setLayoutY(309.0);
		btnAjouterPersonne.setPrefSize(71.0, 29.0);

		btnAjouterProduit.setLayoutX(143.0);
		btnAjouterProduit.setLayoutY(549.0);
		btnAjouterProduit.setPrefSize(71.0, 29.0);

		tableHistoriqueGlobal.setLayoutX(379.0);
		tableHistoriqueGlobal.setLayoutY(143.0);
		tableHistoriqueGlobal.setPrefSize(596.0, 425.0);
		colDate.setPrefWidth(98);
		colPersonnel.setPrefWidth(191);
		colQte.setPrefWidth(64);
		colLib.setPrefWidth(240);
		colId.setPrefWidth(0);
		colId.setVisible(false);
		tableHistoriqueGlobal.getColumns().addAll(colDate, colPersonnel, colQte, colLib, colId);

		txtNom.setLayoutX(107);
		txtNom.setLayoutY(160);

		txtPrenom.setLayoutX(107);
		txtPrenom.setLayoutY(197);

		txtLogin.setLayoutX(107);
		txtLogin.setLayoutY(234);

		txtMdp.setLayoutX(107);
		txtMdp.setLayoutY(271);

		txtLib.setLayoutX(107);
		txtLib.setLayoutY(447);

		txtQte.setLayoutX(107);
		txtQte.setLayoutY(484);

		txtDesc.setLayoutX(107);
		txtDesc.setLayoutY(516);
	}
}
