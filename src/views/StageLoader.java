package views;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StageLoader {
	private AnchorPane root;
	private Stage focusStage;


	public StageLoader() {
		focusStage = new Stage();
	}



	public void setStage(String nameScene, String nameTitle) throws IOException {
		focusStage.setTitle("nameScene");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(nameScene+".fxml"));
		root = (AnchorPane) loader.load(); // Cr�ation de la sc�ne de la deuxi�me fen�tre
		focusStage.setScene(new Scene(root));
		focusStage.show();
	}
}
