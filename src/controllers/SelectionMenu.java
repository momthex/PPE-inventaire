package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import views.StageLoader;

public class SelectionMenu {

	@FXML
	private Button btnConsulter;

	@FXML
	private Button btnEditer;

	@FXML
	private void handleButtonConsultation(ActionEvent event) throws IOException{
		StageLoader stage = new StageLoader();
		stage.setStage("stageConsultation", "Consultation");
	}

	@FXML
	private void handleButtonEdition(ActionEvent event) throws IOException{
		StageLoader stage = new StageLoader();
		stage.setStage("stageEdition", "Edition");

	}
}
