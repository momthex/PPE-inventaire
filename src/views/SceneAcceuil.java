package views;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

public class SceneAcceuil extends AnchorPane {
	public Button btnConsulter = new Button("Consulter");
	public Button btnEditer = new Button("Modifier");
	public Button btnAdmin = new Button("Administration");
	ImageView champImgConsulter = new ImageView("/asset/consulter.png");
	ImageView champImgEditer = new ImageView("/asset/modifier.png");


	public SceneAcceuil() {
		super();
		setComposition();
		this.setBackground(Background.EMPTY);
		this.getChildren().addAll(btnConsulter, btnEditer, champImgEditer, champImgConsulter, btnAdmin);
	}

	private void setComposition() {
		btnConsulter.setLayoutX(677.0);
		btnConsulter.setLayoutY(443.0);
		btnConsulter.setPrefSize(192.0, 83.0);
		btnConsulter.setFont(new Font("Arial", 31));


		btnEditer.setLayoutX(134.0);
		btnEditer.setLayoutY(443.0);
		btnEditer.setPrefSize(192.0, 83.0);
		btnEditer.setFont(new Font("Arial", 31));

		btnAdmin.setVisible(false);
		btnAdmin.setLayoutX(405.5);
		btnAdmin.setLayoutY(443.0);
		btnAdmin.setPrefSize(192.0, 83.0);
		btnAdmin.setFont(new Font("Arial", 23));

		champImgConsulter.setFitHeight(261.0);
		champImgConsulter.setFitWidth(254.0);
		champImgConsulter.setLayoutX(646.0);
		champImgConsulter.setLayoutY(86.0);

		champImgEditer.setFitHeight(261.0);
		champImgEditer.setFitWidth(254.0);
		champImgEditer.setLayoutX(103.0);
		champImgEditer.setLayoutY(86.0);
	}
}
