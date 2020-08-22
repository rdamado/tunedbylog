package darkmotorsport.tunedbylog.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import darkmotorsport.tunedbylog.gui.controller.PaginaInicialAbaRPM;
import darkmotorsport.tunedbylog.gui.model.AlvoSondaLambda;
import darkmotorsport.tunedbylog.gui.model.ConfiguracoesWrapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Mainapp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

//	static InicioController inicioContr;
	public static PaginaInicialAbaRPM tabelaContr;

	public Mainapp() {
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Tuned by Log (TbyL) - rian.diego@gmail.com - V:3.0.1");
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		
//		this.primaryStage.setWidth(width/1.5);
//		this.primaryStage.setHeight(height/1.5);
		
//		this.primaryStage.setWidth(1024);
//		this.primaryStage.setHeight(768);
		
//		this.primaryStage.setMaximized(true);

//		initRootLayout(primaryStage);
//		showTabelaDadosView(primaryStage);
		
		paginaInicial(primaryStage);

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initRootLayout(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mainapp.class.getResource("/darkmotorsport/tunedbylog/gui/view/Inicio.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			
			rootLayout.setPrefWidth(1024);
			rootLayout.setPrefHeight(768);

//			inicioContr = loader.getController();
//			inicioContr.setMainapp(this);

			primaryStage.setScene(scene);
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			
//			primaryStage.setFullScreen(true);
//			(gd.getDisplayMode().getWidth());
//			primaryStage.setHeight(gd.getDisplayMode().getWidth());
			primaryStage.show();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paginaInicial(Stage stage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mainapp.class.getResource("/darkmotorsport/tunedbylog/gui/view/PaginaInicialAbas.fxml"));
//			loader.setLocation(Mainapp.class.getResource("/darkmotorsport/tunedbylog/gui/view/PaginaInicial.fxml"));
			this.rootLayout = ((BorderPane) loader.load());
			Scene scene = new Scene(rootLayout);
			tabelaContr = loader.getController();
			
//			scene.getStylesheets().add(getClass().getResource("/darkmotorsport/tunedbylog/gui/application.css").toExternalForm());
			
			
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			int width = gd.getDisplayMode().getWidth();
			int height = gd.getDisplayMode().getHeight();
			
//			rootLayout.setPrefWidth(width/3);
//			rootLayout.setPrefHeight(height/3);
			
			rootLayout.setPrefWidth(1024);
			rootLayout.setPrefHeight(768);
			
			tabelaContr = loader.getController();
			tabelaContr.setMainapp(this);
			
			primaryStage.setScene(scene);
			
//			primaryStage.setFullScreen(true);
//			(gd.getDisplayMode().getWidth());
//			primaryStage.setHeight(gd.getDisplayMode().getWidth());
			primaryStage.show();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mostra o person overview dentro do root layout.
	 * @param primaryStage2 
	 */
	public void showTabelaDadosView(Stage primaryStage2) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Mainapp.class.getResource("/darkmotorsport/tunedbylog/gui/view/TabelaDadosView.fxml"));
			tabelaContr = loader.getController();
			AnchorPane personOverview = (AnchorPane) loader.load();
			
			rootLayout.setLeft(personOverview);
			
//				controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna o palco principal.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void callBackSonda(List<AlvoSondaLambda> alvos) {
		tabelaContr.callBackConfigurarSonda(alvos);

	}

	public void salvarConfiguracoes(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(ConfiguracoesWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ConfiguracoesWrapper wrapper = new ConfiguracoesWrapper();
			tabelaContr.configurarArquivoDeConfiguracaoes(wrapper);
			tabelaContr.lblCaminhoArquivoConfiguracao.setText(file.getAbsolutePath());
			m.marshal(wrapper, file);

			// Save the file path to the registry.
//			setPersonFilePath(file);
		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao salvar");
			alert.setHeaderText("Não foi possível salvar os dados");
			alert.setContentText("Não foi possível salvar os dados para o arquivo:\n" + file.getPath());

			alert.showAndWait();
		}

	}

	public void setPersonFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(Mainapp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			primaryStage.setTitle("AddressApp - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			primaryStage.setTitle("AddressApp");
		}
	}

	public void carregarConfiguracoes(File file) {

		try {
			JAXBContext context = JAXBContext.newInstance(ConfiguracoesWrapper.class);
			Unmarshaller um = context.createUnmarshaller();
			ConfiguracoesWrapper wrapper = (ConfiguracoesWrapper) um.unmarshal(file);
			tabelaContr.carregarConfiguracoes(wrapper);
			tabelaContr.lblCaminhoArquivoConfiguracao.setText(file.getAbsolutePath());
			


		} catch (Exception e) { // catches ANY exception
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro ao carregar");
			alert.setHeaderText("Não foi possível carregar os dados");
			alert.setContentText("Não foi possível carregar os dados do arquivo:\n" + file.getPath());

			alert.showAndWait();
		}

	}

}
