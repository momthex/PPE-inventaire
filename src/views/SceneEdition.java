package views;

import classes.Produit;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

public class SceneEdition extends AnchorPane {
	public Button btnRetourAcceuil2 = new Button("⏴Retour à l'accueil");
	public ListView listeProduit = new ListView();
	public TextField txtQuantite = new TextField();
	Label labelTxtQte = new Label("Quantité");
	public TableView tableHistoriquePersonel =new TableView();
	public TableColumn<Produit, String> colLibHisto = new TableColumn<>("Libellé");
	public TableColumn<Produit, Integer> colQteHisto = new TableColumn<>("Quantité");
	public TableColumn<Produit, Integer> colIdHisto = new TableColumn<>("Id");
	public Button btnEffacerAction = new Button("Effacer l'action");
	Label labelDerniereAction = new Label("Vos dernières actions");
	Label labelRetProd = new Label("Retirez des produits");
	public Button btnValider = new Button("Valider");

	public SceneEdition() {
		super();
		setComposition();
		this.setBackground(Background.EMPTY);
		this.getChildren().addAll(btnRetourAcceuil2, listeProduit, txtQuantite, labelTxtQte, tableHistoriquePersonel, labelDerniereAction, btnEffacerAction, labelRetProd, btnValider);
	}

	private void setComposition() {
		btnRetourAcceuil2.setLayoutX(11.0);
		btnRetourAcceuil2.setLayoutY(5.0);
		btnRetourAcceuil2.setPrefSize(202.0, 54.0);
		btnRetourAcceuil2.setFont(new Font("Arial", 20));

		listeProduit.setLayoutX(79);
		listeProduit.setLayoutY(105);
		listeProduit.setPrefSize(318, 433);

		txtQuantite.setLayoutX(558);
		txtQuantite.setLayoutY(400);
		txtQuantite.setPrefSize(168, 85);

		labelTxtQte.setLayoutX(443.0);
		labelTxtQte.setLayoutY(420.0);
		labelTxtQte.setPrefSize(115, 45);
		labelTxtQte.setFont(new Font("Arial", 27));

		tableHistoriquePersonel.setLayoutX(420);
		tableHistoriquePersonel.setLayoutY(136);
		tableHistoriquePersonel.setPrefSize(352, 200);
		colLibHisto.setPrefWidth(258);
		colLibHisto.setResizable(false);
		colQteHisto.setPrefWidth(92);
		colQteHisto.setResizable(false);
		colIdHisto.setPrefWidth(0);
		colIdHisto.setVisible(false);
		tableHistoriquePersonel.getColumns().addAll(colLibHisto, colQteHisto, colIdHisto);

		labelDerniereAction.setLayoutX(497.0);
		labelDerniereAction.setLayoutY(105.0);
		labelDerniereAction.setFont(new Font("Arial", 25));

		btnEffacerAction.setLayoutX(777.0);
		btnEffacerAction.setLayoutY(166.0);
		btnEffacerAction.setPrefSize(135, 31);
		btnEffacerAction.setFont(new Font("Arial", 13));

		labelRetProd.setLayoutX(322);
		labelRetProd.setLayoutY(31);
		labelRetProd.setFont(new Font("Arial", 38));

		btnValider.setLayoutX(805.0);
		btnValider.setLayoutY(486.0);
		btnValider.setPrefSize(168, 85);
		btnValider.setFont(new Font("Arial", 30));
	}
}
