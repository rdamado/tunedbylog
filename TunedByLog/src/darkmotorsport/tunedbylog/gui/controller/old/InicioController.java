package darkmotorsport.tunedbylog.gui.controller.old;

import java.io.File;
import java.io.IOException;

import darkmotorsport.tunedbylog.gui.Mainapp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InicioController {

	private Mainapp mainapp;

	@FXML
	public void doEditarSondaAlvo() {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(mainapp.getClass().getResource("/darkmotorsport/tunedbylog/gui/view/ConfigurarAlvoSonda.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Configurar Sonda Lambda Alvo");
			stage.setScene(new Scene(root1));
			stage.showAndWait();

			SondaAlvoController controller = fxmlLoader.getController();
			getMainapp().callBackSonda(controller.alvos);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Mainapp getMainapp() {
		return mainapp;
	}

	public void setMainapp(Mainapp mainapp) {
		this.mainapp = mainapp;
	}

	@FXML
	public void doSalvarConfiguracoes() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		fileChooser.setInitialDirectory(new File("."));

		File file = fileChooser.showSaveDialog(mainapp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainapp.salvarConfiguracoes(file);
		}
	}

	@FXML
	public void doCarregarConfiguracoes() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("."));

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showOpenDialog(mainapp.getPrimaryStage());

		if (file != null) {
			mainapp.carregarConfiguracoes(file);
		}
	}

	@FXML
	public void doMenuUtilizacao() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(mainapp.getClass().getResource("/darkmotorsport/tunedbylog/gui/view/UtilizacaoView.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.NONE);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle("Utilização");
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void doMenuSobre() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText("Desenvolvido por Rian Diego - rian.diego@gmail.com");
		alert.showAndWait();
	}

}
