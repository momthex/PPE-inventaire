package views;

import classes.Produit;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class SceneConsulter extends AnchorPane {
	public Button btnRetourAcceuil = new Button("⏴Retour à l'accueil");
	public TextField txtRecherche = new TextField();
	Label labelConsulterStock = new Label("Consulter le stock");
	public TableView tableProduit = new TableView();
	public TableColumn<Produit, String> colLib = new TableColumn<>("Libellé");
	public TableColumn<Produit, Integer> colQte = new TableColumn<>("Quantité");
	public TableColumn<Produit, String> colDesc = new TableColumn<>("Description");
	public Button btnRecherche = new Button("Rechercher 🔍");

	public SceneConsulter() {
		super();
		setComposition();
		this.setBackground(Background.EMPTY);
		this.getChildren().addAll(btnRetourAcceuil, txtRecherche, labelConsulterStock, tableProduit, btnRecherche);
	}

	private void setComposition() {
		btnRetourAcceuil.setLayoutX(11.0);
		btnRetourAcceuil.setLayoutY(5.0);
		btnRetourAcceuil.setPrefSize(202.0, 54.0);
		btnRetourAcceuil.setFont(new Font("Arial", 20));

		txtRecherche.setLayoutX(518);
		txtRecherche.setLayoutY(53);
		txtRecherche.setPrefSize(232, 65);

		labelConsulterStock.setLayoutX(28);
		labelConsulterStock.setLayoutY(63);
		labelConsulterStock.setFont(new Font("Arial", 38));

		tableProduit.setLayoutX(28);
		tableProduit.setLayoutY(137);
		tableProduit.setPrefSize(932, 420);
		tableProduit.setEditable(true);
		colLib.setPrefWidth(400);
		colQte.setPrefWidth(132);
		colDesc.setPrefWidth(400);
		tableProduit.getColumns().addAll(colLib, colQte, colDesc);

		btnRecherche.setLayoutX(777);
		btnRecherche.setLayoutY(59);
		btnRecherche.setPrefSize(183, 54);
		btnRecherche.setFont(new Font("Arial", 23));
	}
}
