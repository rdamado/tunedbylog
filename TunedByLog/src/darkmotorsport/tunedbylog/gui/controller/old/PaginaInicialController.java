package darkmotorsport.tunedbylog.gui.controller.old;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import darkmotorsport.tunedbylog.gui.Mainapp;
import darkmotorsport.tunedbylog.gui.calc.Calculador;
import darkmotorsport.tunedbylog.gui.model.AlvoSondaLambda;
import darkmotorsport.tunedbylog.gui.model.ArquivoLog;
import darkmotorsport.tunedbylog.gui.model.ConfiguracoesWrapper;
import darkmotorsport.tunedbylog.gui.model.DadoTabelaMap;
import darkmotorsport.tunedbylog.gui.model.CellEditavel;
import darkmotorsport.tunedbylog.gui.model.PosicaoValor;
import darkmotorsport.tunedbylog.xml.itens.DataCanal;
import darkmotorsport.tunedbylog.xml.itens.Log;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class PaginaInicialController extends SuperTabelaDadosController {

	File file = null;
	Calculador calc = new Calculador();
	
	Stage stage= null;
	
	private Mainapp mainapp;
	
	
	

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	private void abrirLog() {

		doAbrirLog();
	}

	private void doAbrirLog() {
		limparListasValoresSonda();
		limparListasValoresCorrecaoSonda();

		try {
			fileChooser.setInitialDirectory(new File("."));
			file = fileChooser.showOpenDialog(null);

			if (file == null) {
				return;
			}

			lblCaminhoArquivo.setText(file.getAbsolutePath());
			ArquivoLog logGrav = new ArquivoLog();
			Log log1 = logGrav.abrirArquivoLog(file);

			List<DataCanal> listaDados = log1.getListaDados();

			for (int i = 0; i < listaDados.size(); i++) {
				if (listaDados.get(i).getCanal().getId() == MAP) {
					float[] valores = listaDados.get(i).getValores();
					for (int j = 0; j < valores.length; j++) {
						configurarValoresWideband(listaDados, valores, j);
					}
				}
			}

			removerNullMapaWideband();
			removerNullMapaCorrecaoSonda();
			configurarTabelaSondaMedia();
			configurarTabelaCorrecaoMedia();
			configurarTabelaQtdAmostras();
			configurarCorrecao();
			configurarMapaCorrigidoEEditavel();
			configurarGrafico();

			atualizarTabela();
			tabelaMap.setItems(listaMap);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void recarregarArquivo() {

		doRecarregarArquivo();
	}

	private void doRecarregarArquivo() {
		if (file == null) {
			return;
		}

		limparListasValoresSonda();
		limparListasValoresCorrecaoSonda();

		try {

			lblCaminhoArquivo.setText(file.getAbsolutePath());
			ArquivoLog logGrav = new ArquivoLog();
			Log log1 = logGrav.abrirArquivoLog(file);

			List<DataCanal> listaDados = log1.getListaDados();

			for (int i = 0; i < listaDados.size(); i++) {
				if (listaDados.get(i).getCanal().getId() == MAP) {
					float[] valores = listaDados.get(i).getValores();
					for (int j = 0; j < valores.length; j++) {
						configurarValoresWideband(listaDados, valores, j);
					}
				}
			}
			
			removerNullMapaCorrecaoSonda();
			removerNullMapaWideband();
			configurarTabelaSondaMedia();
			configurarTabelaCorrecaoMedia();
			configurarTabelaQtdAmostras();
			configurarCorrecao();
			configurarMapaCorrigidoEEditavel();
			configurarGrafico();

			atualizarTabela();
			tabelaMap.setItems(listaMap);

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void limparListasValoresSonda() {
		wideMap_map_m_0_90.clear();
		wideMap_map_m_0_85.clear();
		wideMap_map_m_0_80.clear();
		wideMap_map_m_0_75.clear();
		wideMap_map_m_0_70.clear();
		wideMap_map_m_0_65.clear();
		wideMap_map_m_0_60.clear();
		wideMap_map_m_0_55.clear();
		wideMap_map_m_0_50.clear();
		wideMap_map_m_0_45.clear();
		wideMap_map_m_0_40.clear();
		wideMap_map_m_0_35.clear();
		wideMap_map_m_0_30.clear();
		wideMap_map_m_0_25.clear();
		wideMap_map_m_0_20.clear();
		wideMap_map_m_0_15.clear();
		wideMap_map_m_0_10.clear();
		wideMap_map_m_0_05.clear();
		wideMap_map_0_00.clear();
		wideMap_map_0_05.clear();
		wideMap_map_0_10.clear();
		wideMap_map_0_20.clear();
		wideMap_map_0_30.clear();
		wideMap_map_0_40.clear();
		wideMap_map_0_50.clear();
		wideMap_map_0_60.clear();
		wideMap_map_0_70.clear();
		wideMap_map_0_80.clear();
		wideMap_map_0_90.clear();
		wideMap_map_1_00.clear();
		wideMap_map_1_10.clear();
		wideMap_map_1_20.clear();
		wideMap_map_1_30.clear();
		wideMap_map_1_40.clear();
		wideMap_map_1_50.clear();
		wideMap_map_1_60.clear();
		wideMap_map_1_70.clear();
		wideMap_map_1_80.clear();
		wideMap_map_1_90.clear();
		wideMap_map_2_00.clear();
	}
	
	
	private void limparListasValoresCorrecaoSonda() {
		correcaoSondaLinha = getCorrecaoSondaLinhaInicial(); 
		correcaoSondaMap_map_m_0_90.clear();
		correcaoSondaMap_map_m_0_85.clear();
		correcaoSondaMap_map_m_0_80.clear();
		correcaoSondaMap_map_m_0_75.clear();
		correcaoSondaMap_map_m_0_70.clear();
		correcaoSondaMap_map_m_0_65.clear();
		correcaoSondaMap_map_m_0_60.clear();
		correcaoSondaMap_map_m_0_55.clear();
		correcaoSondaMap_map_m_0_50.clear();
		correcaoSondaMap_map_m_0_45.clear();
		correcaoSondaMap_map_m_0_40.clear();
		correcaoSondaMap_map_m_0_35.clear();
		correcaoSondaMap_map_m_0_30.clear();
		correcaoSondaMap_map_m_0_25.clear();
		correcaoSondaMap_map_m_0_20.clear();
		correcaoSondaMap_map_m_0_15.clear();
		correcaoSondaMap_map_m_0_10.clear();
		correcaoSondaMap_map_m_0_05.clear();
		correcaoSondaMap_map_0_00.clear();
		correcaoSondaMap_map_0_05.clear();
		correcaoSondaMap_map_0_10.clear();
		correcaoSondaMap_map_0_20.clear();
		correcaoSondaMap_map_0_30.clear();
		correcaoSondaMap_map_0_40.clear();
		correcaoSondaMap_map_0_50.clear();
		correcaoSondaMap_map_0_60.clear();
		correcaoSondaMap_map_0_70.clear();
		correcaoSondaMap_map_0_80.clear();
		correcaoSondaMap_map_0_90.clear();
		correcaoSondaMap_map_1_00.clear();
		correcaoSondaMap_map_1_10.clear();
		correcaoSondaMap_map_1_20.clear();
		correcaoSondaMap_map_1_30.clear();
		correcaoSondaMap_map_1_40.clear();
		correcaoSondaMap_map_1_50.clear();
		correcaoSondaMap_map_1_60.clear();
		correcaoSondaMap_map_1_70.clear();
		correcaoSondaMap_map_1_80.clear();
		correcaoSondaMap_map_1_90.clear();
		correcaoSondaMap_map_2_00.clear();
	}

	private void configurarValoresWideband(List<DataCanal> listaDados, float[] valores, int j) {

		for (int k = 0; k < listaDados.size(); k++) {
			if (listaDados.get(k).getCanal().getId() == WIDEBAND_DIGITAL) {
				WIDEBAND = WIDEBAND_DIGITAL;
				break;
			}

			if (listaDados.get(k).getCanal().getId() == WIDEBAND_ANALOGICO) {
				WIDEBAND = WIDEBAND_ANALOGICO;
				break;
			}

		}
		
		
		for (int k = 0; k < listaDados.size(); k++) {
			if (listaDados.get(k).getCanal().getId() == SONDA_CORRECAO) {
				IS_CORRRECAO_ATIVA  = true;
				break;
			}
		}

		if (testaValorMap(valores, j, MAP_m_0_90)) {
			wideMap_map_m_0_90.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_90.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_85)) {
			wideMap_map_m_0_85.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_85.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_80)) {
			wideMap_map_m_0_80.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_80.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_75)) {
			wideMap_map_m_0_75.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_75.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_70)) {
			wideMap_map_m_0_70.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_70.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_65)) {
			wideMap_map_m_0_65.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_65.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_60)) {
			wideMap_map_m_0_60.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_60.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_55)) {
			wideMap_map_m_0_55.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_55.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_50)) {
			wideMap_map_m_0_50.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_50.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_45)) {
			wideMap_map_m_0_45.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_45.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_40)) {
			wideMap_map_m_0_40.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_40.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_35)) {
			wideMap_map_m_0_35.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_35.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_30)) {
			wideMap_map_m_0_30.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_30.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_25)) {
			wideMap_map_m_0_25.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_25.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_20)) {
			wideMap_map_m_0_20.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_20.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_15)) {
			wideMap_map_m_0_15.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_15.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_10)) {
			wideMap_map_m_0_10.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_10.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_m_0_05)) {
			wideMap_map_m_0_05.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_m_0_05.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_00)) {
			wideMap_map_0_00.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_00.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_05)) {
			wideMap_map_0_05.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_05.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_10)) {
			wideMap_map_0_10.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_10.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_20)) {
			wideMap_map_0_20.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_20.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_30)) {
			wideMap_map_0_30.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_30.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_40)) {
			wideMap_map_0_40.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_40.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_50)) {
			wideMap_map_0_50.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_50.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_60)) {
			wideMap_map_0_60.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_60.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_70)) {
			wideMap_map_0_70.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_70.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_80)) {
			wideMap_map_0_80.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_80.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_0_90)) {
			wideMap_map_0_90.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_0_90.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_00)) {
			wideMap_map_1_00.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_00.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_10)) {
			wideMap_map_1_10.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_10.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_20)) {
			wideMap_map_1_20.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_20.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_30)) {
			wideMap_map_1_30.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_30.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_40)) {
			wideMap_map_1_40.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_40.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_50)) {
			wideMap_map_1_50.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_50.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_60)) {
			wideMap_map_1_60.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_60.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_70)) {
			wideMap_map_1_70.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_70.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_80)) {
			wideMap_map_1_80.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_80.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_1_90)) {
			wideMap_map_1_90.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_1_90.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		} else if (testaValorMap(valores, j, MAP_2_00)) {
			wideMap_map_2_00.add(getValorCanal(listaDados, j, WIDEBAND));
			correcaoSondaMap_map_2_00.add(getValorCanal(listaDados, j, SONDA_CORRECAO));
		}
	}

	private void removerNullMapaWideband() {
		wideMap_map_m_0_90.removeAll(Collections.singleton(null));
		wideMap_map_m_0_85.removeAll(Collections.singleton(null));
		wideMap_map_m_0_80.removeAll(Collections.singleton(null));
		wideMap_map_m_0_75.removeAll(Collections.singleton(null));
		wideMap_map_m_0_70.removeAll(Collections.singleton(null));
		wideMap_map_m_0_65.removeAll(Collections.singleton(null));
		wideMap_map_m_0_60.removeAll(Collections.singleton(null));
		wideMap_map_m_0_55.removeAll(Collections.singleton(null));
		wideMap_map_m_0_50.removeAll(Collections.singleton(null));
		wideMap_map_m_0_45.removeAll(Collections.singleton(null));
		wideMap_map_m_0_40.removeAll(Collections.singleton(null));
		wideMap_map_m_0_35.removeAll(Collections.singleton(null));
		wideMap_map_m_0_30.removeAll(Collections.singleton(null));
		wideMap_map_m_0_25.removeAll(Collections.singleton(null));
		wideMap_map_m_0_20.removeAll(Collections.singleton(null));
		wideMap_map_m_0_15.removeAll(Collections.singleton(null));
		wideMap_map_m_0_10.removeAll(Collections.singleton(null));
		wideMap_map_m_0_05.removeAll(Collections.singleton(null));
		wideMap_map_0_00.removeAll(Collections.singleton(null));
		wideMap_map_0_05.removeAll(Collections.singleton(null));
		wideMap_map_0_10.removeAll(Collections.singleton(null));
		wideMap_map_0_20.removeAll(Collections.singleton(null));
		wideMap_map_0_30.removeAll(Collections.singleton(null));
		wideMap_map_0_40.removeAll(Collections.singleton(null));
		wideMap_map_0_50.removeAll(Collections.singleton(null));
		wideMap_map_0_60.removeAll(Collections.singleton(null));
		wideMap_map_0_70.removeAll(Collections.singleton(null));
		wideMap_map_0_80.removeAll(Collections.singleton(null));
		wideMap_map_0_90.removeAll(Collections.singleton(null));
		wideMap_map_1_00.removeAll(Collections.singleton(null));
		wideMap_map_1_10.removeAll(Collections.singleton(null));
		wideMap_map_1_20.removeAll(Collections.singleton(null));
		wideMap_map_1_30.removeAll(Collections.singleton(null));
		wideMap_map_1_40.removeAll(Collections.singleton(null));
		wideMap_map_1_50.removeAll(Collections.singleton(null));
		wideMap_map_1_60.removeAll(Collections.singleton(null));
		wideMap_map_1_70.removeAll(Collections.singleton(null));
		wideMap_map_1_80.removeAll(Collections.singleton(null));
		wideMap_map_1_90.removeAll(Collections.singleton(null));
		wideMap_map_2_00.removeAll(Collections.singleton(null));
	}

	private void removerNullMapaCorrecaoSonda() {
		correcaoSondaMap_map_m_0_90.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_85.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_80.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_75.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_70.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_65.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_60.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_55.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_50.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_45.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_40.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_35.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_30.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_25.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_20.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_15.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_10.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_m_0_05.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_00.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_05.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_10.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_20.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_30.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_40.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_50.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_60.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_70.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_80.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_0_90.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_00.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_10.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_20.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_30.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_40.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_50.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_60.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_70.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_80.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_1_90.removeAll(Collections.singleton(null));
		correcaoSondaMap_map_2_00.removeAll(Collections.singleton(null));
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void configurarGrafico() {

		lineChartInjecao.getData().clear();

//		lineChartInjecao.setTitle("Tempo de Injeção:");
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.setName("Mapa(mS)");
		XYChart.Series<String, Number> seriesCorrigido = new XYChart.Series<String, Number>();
		seriesCorrigido.setName("Editável(mS)");

		for (int i = 0; i < getListaMap().size(); i++) {
			series.getData().add(new XYChart.Data(getListaMap().get(i).toString(),
					new BigDecimal(mapaMs.getValores().get(i).replace(',', '.'))));
			String string = mapaMsCorrigidoEditado.getValores().get(i);
			if (string != "-") {
				BigDecimal bigDecimal = new BigDecimal(string.replace(',', '.'));
				seriesCorrigido.getData().add(new XYChart.Data(getListaMap().get(i).toString(), bigDecimal));
			}

		}

		lineChartInjecao.setStyle("CHART_COLOR_1:lawngreen  ; CHART_COLOR_2:dodgerblue  ;");

		lineChartInjecao.getData().add(series);
		lineChartInjecao.getData().add(seriesCorrigido);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void configurarGraficoMapaEditado() {

		XYChart.Series<String, Number> seriesCorrigido = new XYChart.Series<String, Number>();
		seriesCorrigido.setName("Editável(mS)");

		for (int i = 0; i < getListaMap().size(); i++) {
			String string = mapaMsCorrigidoEditado.getValores().get(i);
			if (string != "-") {
				BigDecimal bigDecimal = new BigDecimal(string.replace(',', '.'));
				seriesCorrigido.getData().add(new XYChart.Data(getListaMap().get(i).toString(), bigDecimal));
			}

		}

		lineChartInjecao.getData().set(1, seriesCorrigido);
		lineChartInjecao.setStyle("CHART_COLOR_1:lawngreen  ; CHART_COLOR_2:dodgerblue  ;");
//		lineChartInjecao.getData().add(seriesCorrigido);
	}

	@FXML
	private void doCorrigirMapa() {
		doCorrigirMapaOb();

	}

	private void doCorrigirMapaOb() {
		configurarCorrecao();
		configurarMapaCorrigidoEEditavel();
		atualizarTabela();
		tabelaMap.setItems(listaMap);
	}

	private void configurarMapaCorrigidoEEditavel() {
		List<String> valoresCorrecaoLinha = correcaoLinha.getValores();
		List<String> valoresMapa = mapaMs.getValores();
		List<String> mapaCorrigido = new ArrayList<String>();
		for (int i = 0; i < valoresCorrecaoLinha.size(); i++) {
			BigDecimal bdFatorCorrecao = new BigDecimal(valoresCorrecaoLinha.get(i));
			BigDecimal bdValorMapa = new BigDecimal(valoresMapa.get(i).replace(',', '.'));

			mapaCorrigido.add(bdValorMapa.multiply(bdFatorCorrecao).setScale(3, BigDecimal.ROUND_HALF_EVEN).toString());
		}

		mapaMsCorrigido.setValores(mapaCorrigido);
		mapaMsCorrigidoEditado.setValores(mapaCorrigido);

	}

	private void configurarCorrecao() {
		List<String> valoresLambdaAlvo = lambdaAlvo.getValores();
		List<String> valoresSondaMedia = sondaMedia.getValores();
		List<String> valoresCorrecaoSondaMedia = correcaoSondaLinha.getValores();
		List<String> correcao = new ArrayList<String>();

		for (int i = 0; i < valoresLambdaAlvo.size(); i++) {
			BigDecimal bdLambdaAlvo = new BigDecimal(valoresLambdaAlvo.get(i).replace(",", "."));
			BigDecimal bdSondaMedia = new BigDecimal(valoresSondaMedia.get(i).replace(",", "."));
			BigDecimal bdCorrecaoSondaMedia = new BigDecimal(valoresCorrecaoSondaMedia.get(i).replace(",", "."));
			
//			BigDecimal somaUm = bdCorrecaoSondaMedia.add(BigDecimal.ONE);
			BigDecimal divideCem = bdCorrecaoSondaMedia.divide(new BigDecimal("100"), RoundingMode.HALF_EVEN);
			BigDecimal somaUm = divideCem.add(BigDecimal.ONE);
			BigDecimal multiplica = bdSondaMedia.multiply(somaUm);
			BigDecimal bdSodaMediaSemCorrecao = multiplica;
			
//			correcao.add(bdSondaMedia.divide(bdLambdaAlvo, RoundingMode.HALF_EVEN).toString());
			correcao.add(bdSodaMediaSemCorrecao.divide(bdLambdaAlvo, RoundingMode.HALF_EVEN).setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());
		}

		correcaoLinha.setValores(correcao);
	}

	private boolean testaValorMap(float[] valores, int posicao, float map) {

		float vlrPrecisaoMap = Float.parseFloat(precisaoMap.getText());
		// 0.80 0.03 / 0.77 - 0.83
		boolean b = valores[posicao] >= (map - vlrPrecisaoMap) && valores[posicao] <= (map + vlrPrecisaoMap);
		return b;
	}

	private void configurarTabelaSondaMedia() {
		DadoTabelaMap dadoTabelaMap = listaMap.get(POSICAO_SONDA_MEDIA);
//		DadoTabelaMap dadoTabelaMap = sondaMedia;
		dadoTabelaMap.setMap_m_0_90(getValorParaTabela(getValorMedio(wideMap_map_m_0_90, MAP_m_0_90)));
		dadoTabelaMap.setMap_m_0_85(getValorParaTabela(getValorMedio(wideMap_map_m_0_85, MAP_m_0_85)));
		dadoTabelaMap.setMap_m_0_80(getValorParaTabela(getValorMedio(wideMap_map_m_0_80, MAP_m_0_80)));
		dadoTabelaMap.setMap_m_0_75(getValorParaTabela(getValorMedio(wideMap_map_m_0_75, MAP_m_0_75)));
		dadoTabelaMap.setMap_m_0_70(getValorParaTabela(getValorMedio(wideMap_map_m_0_70, MAP_m_0_70)));
		dadoTabelaMap.setMap_m_0_65(getValorParaTabela(getValorMedio(wideMap_map_m_0_65, MAP_m_0_65)));
		dadoTabelaMap.setMap_m_0_60(getValorParaTabela(getValorMedio(wideMap_map_m_0_60, MAP_m_0_60)));
		dadoTabelaMap.setMap_m_0_55(getValorParaTabela(getValorMedio(wideMap_map_m_0_55, MAP_m_0_55)));
		dadoTabelaMap.setMap_m_0_50(getValorParaTabela(getValorMedio(wideMap_map_m_0_50, MAP_m_0_50)));
		dadoTabelaMap.setMap_m_0_45(getValorParaTabela(getValorMedio(wideMap_map_m_0_45, MAP_m_0_45)));
		dadoTabelaMap.setMap_m_0_40(getValorParaTabela(getValorMedio(wideMap_map_m_0_40, MAP_m_0_40)));
		dadoTabelaMap.setMap_m_0_35(getValorParaTabela(getValorMedio(wideMap_map_m_0_35, MAP_m_0_35)));
		dadoTabelaMap.setMap_m_0_30(getValorParaTabela(getValorMedio(wideMap_map_m_0_30, MAP_m_0_30)));
		dadoTabelaMap.setMap_m_0_25(getValorParaTabela(getValorMedio(wideMap_map_m_0_25, MAP_m_0_25)));
		dadoTabelaMap.setMap_m_0_20(getValorParaTabela(getValorMedio(wideMap_map_m_0_20, MAP_m_0_20)));
		dadoTabelaMap.setMap_m_0_15(getValorParaTabela(getValorMedio(wideMap_map_m_0_15, MAP_m_0_15)));
		dadoTabelaMap.setMap_m_0_10(getValorParaTabela(getValorMedio(wideMap_map_m_0_10, MAP_m_0_10)));
		dadoTabelaMap.setMap_m_0_05(getValorParaTabela(getValorMedio(wideMap_map_m_0_05, MAP_m_0_05)));
		dadoTabelaMap.setMap_0_00(getValorParaTabela(getValorMedio(wideMap_map_0_00, MAP_0_00)));
		dadoTabelaMap.setMap_0_05(getValorParaTabela(getValorMedio(wideMap_map_0_05, MAP_0_05)));
		dadoTabelaMap.setMap_0_10(getValorParaTabela(getValorMedio(wideMap_map_0_10, MAP_0_10)));
		dadoTabelaMap.setMap_0_20(getValorParaTabela(getValorMedio(wideMap_map_0_20, MAP_0_20)));
		dadoTabelaMap.setMap_0_30(getValorParaTabela(getValorMedio(wideMap_map_0_30, MAP_0_30)));
		dadoTabelaMap.setMap_0_40(getValorParaTabela(getValorMedio(wideMap_map_0_40, MAP_0_40)));
		dadoTabelaMap.setMap_0_50(getValorParaTabela(getValorMedio(wideMap_map_0_50, MAP_0_50)));
		dadoTabelaMap.setMap_0_60(getValorParaTabela(getValorMedio(wideMap_map_0_60, MAP_0_60)));
		dadoTabelaMap.setMap_0_70(getValorParaTabela(getValorMedio(wideMap_map_0_70, MAP_0_70)));
		dadoTabelaMap.setMap_0_80(getValorParaTabela(getValorMedio(wideMap_map_0_80, MAP_0_80)));
		dadoTabelaMap.setMap_0_90(getValorParaTabela(getValorMedio(wideMap_map_0_90, MAP_0_90)));
		dadoTabelaMap.setMap_1_00(getValorParaTabela(getValorMedio(wideMap_map_1_00, MAP_1_00)));
		dadoTabelaMap.setMap_1_10(getValorParaTabela(getValorMedio(wideMap_map_1_10, MAP_1_10)));
		dadoTabelaMap.setMap_1_20(getValorParaTabela(getValorMedio(wideMap_map_1_20, MAP_1_20)));
		dadoTabelaMap.setMap_1_30(getValorParaTabela(getValorMedio(wideMap_map_1_30, MAP_1_30)));
		dadoTabelaMap.setMap_1_40(getValorParaTabela(getValorMedio(wideMap_map_1_40, MAP_1_40)));
		dadoTabelaMap.setMap_1_50(getValorParaTabela(getValorMedio(wideMap_map_1_50, MAP_1_50)));
		dadoTabelaMap.setMap_1_60(getValorParaTabela(getValorMedio(wideMap_map_1_60, MAP_1_60)));
		dadoTabelaMap.setMap_1_70(getValorParaTabela(getValorMedio(wideMap_map_1_70, MAP_1_70)));
		dadoTabelaMap.setMap_1_80(getValorParaTabela(getValorMedio(wideMap_map_1_80, MAP_1_80)));
		dadoTabelaMap.setMap_1_90(getValorParaTabela(getValorMedio(wideMap_map_1_90, MAP_1_90)));
		dadoTabelaMap.setMap_2_00(getValorParaTabela(getValorMedio(wideMap_map_2_00, MAP_2_00)));

		sondaMedia = dadoTabelaMap;
	}
	
	private void configurarTabelaCorrecaoMedia() {
		DadoTabelaMap dadoTabelaMap = listaMap.get(POSICAO_CORRECAO_MEDIA);
//		DadoTabelaMap dadoTabelaMap = sondaMedia;
		dadoTabelaMap.setMap_m_0_90(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_90, MAP_m_0_90)));
		dadoTabelaMap.setMap_m_0_85(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_85, MAP_m_0_85)));
		dadoTabelaMap.setMap_m_0_80(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_80, MAP_m_0_80)));
		dadoTabelaMap.setMap_m_0_75(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_75, MAP_m_0_75)));
		dadoTabelaMap.setMap_m_0_70(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_70, MAP_m_0_70)));
		dadoTabelaMap.setMap_m_0_65(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_65, MAP_m_0_65)));
		dadoTabelaMap.setMap_m_0_60(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_60, MAP_m_0_60)));
		dadoTabelaMap.setMap_m_0_55(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_55, MAP_m_0_55)));
		dadoTabelaMap.setMap_m_0_50(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_50, MAP_m_0_50)));
		dadoTabelaMap.setMap_m_0_45(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_45, MAP_m_0_45)));
		dadoTabelaMap.setMap_m_0_40(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_40, MAP_m_0_40)));
		dadoTabelaMap.setMap_m_0_35(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_35, MAP_m_0_35)));
		dadoTabelaMap.setMap_m_0_30(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_30, MAP_m_0_30)));
		dadoTabelaMap.setMap_m_0_25(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_25, MAP_m_0_25)));
		dadoTabelaMap.setMap_m_0_20(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_20, MAP_m_0_20)));
		dadoTabelaMap.setMap_m_0_15(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_15, MAP_m_0_15)));
		dadoTabelaMap.setMap_m_0_10(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_10, MAP_m_0_10)));
		dadoTabelaMap.setMap_m_0_05(getValorParaTabela(getValorMedio(correcaoSondaMap_map_m_0_05, MAP_m_0_05)));
		dadoTabelaMap.setMap_0_00(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_00, MAP_0_00)));
		dadoTabelaMap.setMap_0_05(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_05, MAP_0_05)));
		dadoTabelaMap.setMap_0_10(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_10, MAP_0_10)));
		dadoTabelaMap.setMap_0_20(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_20, MAP_0_20)));
		dadoTabelaMap.setMap_0_30(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_30, MAP_0_30)));
		dadoTabelaMap.setMap_0_40(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_40, MAP_0_40)));
		dadoTabelaMap.setMap_0_50(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_50, MAP_0_50)));
		dadoTabelaMap.setMap_0_60(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_60, MAP_0_60)));
		dadoTabelaMap.setMap_0_70(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_70, MAP_0_70)));
		dadoTabelaMap.setMap_0_80(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_80, MAP_0_80)));
		dadoTabelaMap.setMap_0_90(getValorParaTabela(getValorMedio(correcaoSondaMap_map_0_90, MAP_0_90)));
		dadoTabelaMap.setMap_1_00(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_00, MAP_1_00)));
		dadoTabelaMap.setMap_1_10(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_10, MAP_1_10)));
		dadoTabelaMap.setMap_1_20(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_20, MAP_1_20)));
		dadoTabelaMap.setMap_1_30(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_30, MAP_1_30)));
		dadoTabelaMap.setMap_1_40(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_40, MAP_1_40)));
		dadoTabelaMap.setMap_1_50(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_50, MAP_1_50)));
		dadoTabelaMap.setMap_1_60(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_60, MAP_1_60)));
		dadoTabelaMap.setMap_1_70(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_70, MAP_1_70)));
		dadoTabelaMap.setMap_1_80(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_80, MAP_1_80)));
		dadoTabelaMap.setMap_1_90(getValorParaTabela(getValorMedio(correcaoSondaMap_map_1_90, MAP_1_90)));
		dadoTabelaMap.setMap_2_00(getValorParaTabela(getValorMedio(correcaoSondaMap_map_2_00, MAP_2_00)));

		correcaoSondaLinha = dadoTabelaMap;
	}

	private void configurarTabelaQtdAmostras() {
		DadoTabelaMap dadoTabelaMap = listaMap.get(POSICAO_QTD_AMOSTRAS);
		dadoTabelaMap.setMap_m_0_90(getIntParaTabela(wideMap_map_m_0_90.size()));
		dadoTabelaMap.setMap_m_0_85(getIntParaTabela(wideMap_map_m_0_85.size()));
		dadoTabelaMap.setMap_m_0_80(getIntParaTabela(wideMap_map_m_0_80.size()));
		dadoTabelaMap.setMap_m_0_75(getIntParaTabela(wideMap_map_m_0_75.size()));
		dadoTabelaMap.setMap_m_0_70(getIntParaTabela(wideMap_map_m_0_70.size()));
		dadoTabelaMap.setMap_m_0_65(getIntParaTabela(wideMap_map_m_0_65.size()));
		dadoTabelaMap.setMap_m_0_60(getIntParaTabela(wideMap_map_m_0_60.size()));
		dadoTabelaMap.setMap_m_0_55(getIntParaTabela(wideMap_map_m_0_55.size()));
		dadoTabelaMap.setMap_m_0_50(getIntParaTabela(wideMap_map_m_0_50.size()));
		dadoTabelaMap.setMap_m_0_45(getIntParaTabela(wideMap_map_m_0_45.size()));
		dadoTabelaMap.setMap_m_0_40(getIntParaTabela(wideMap_map_m_0_40.size()));
		dadoTabelaMap.setMap_m_0_35(getIntParaTabela(wideMap_map_m_0_35.size()));
		dadoTabelaMap.setMap_m_0_30(getIntParaTabela(wideMap_map_m_0_30.size()));
		dadoTabelaMap.setMap_m_0_25(getIntParaTabela(wideMap_map_m_0_25.size()));
		dadoTabelaMap.setMap_m_0_20(getIntParaTabela(wideMap_map_m_0_20.size()));
		dadoTabelaMap.setMap_m_0_15(getIntParaTabela(wideMap_map_m_0_15.size()));
		dadoTabelaMap.setMap_m_0_10(getIntParaTabela(wideMap_map_m_0_10.size()));
		dadoTabelaMap.setMap_m_0_05(getIntParaTabela(wideMap_map_m_0_05.size()));
		dadoTabelaMap.setMap_0_00(getIntParaTabela(wideMap_map_0_00.size()));
		dadoTabelaMap.setMap_0_05(getIntParaTabela(wideMap_map_0_05.size()));
		dadoTabelaMap.setMap_0_10(getIntParaTabela(wideMap_map_0_10.size()));
		dadoTabelaMap.setMap_0_20(getIntParaTabela(wideMap_map_0_20.size()));
		dadoTabelaMap.setMap_0_30(getIntParaTabela(wideMap_map_0_30.size()));
		dadoTabelaMap.setMap_0_40(getIntParaTabela(wideMap_map_0_40.size()));
		dadoTabelaMap.setMap_0_50(getIntParaTabela(wideMap_map_0_50.size()));
		dadoTabelaMap.setMap_0_60(getIntParaTabela(wideMap_map_0_60.size()));
		dadoTabelaMap.setMap_0_70(getIntParaTabela(wideMap_map_0_70.size()));
		dadoTabelaMap.setMap_0_80(getIntParaTabela(wideMap_map_0_80.size()));
		dadoTabelaMap.setMap_0_90(getIntParaTabela(wideMap_map_0_90.size()));
		dadoTabelaMap.setMap_1_00(getIntParaTabela(wideMap_map_1_00.size()));
		dadoTabelaMap.setMap_1_10(getIntParaTabela(wideMap_map_1_10.size()));
		dadoTabelaMap.setMap_1_20(getIntParaTabela(wideMap_map_1_20.size()));
		dadoTabelaMap.setMap_1_30(getIntParaTabela(wideMap_map_1_30.size()));
		dadoTabelaMap.setMap_1_40(getIntParaTabela(wideMap_map_1_40.size()));
		dadoTabelaMap.setMap_1_50(getIntParaTabela(wideMap_map_1_50.size()));
		dadoTabelaMap.setMap_1_60(getIntParaTabela(wideMap_map_1_60.size()));
		dadoTabelaMap.setMap_1_70(getIntParaTabela(wideMap_map_1_70.size()));
		dadoTabelaMap.setMap_1_80(getIntParaTabela(wideMap_map_1_80.size()));
		dadoTabelaMap.setMap_1_90(getIntParaTabela(wideMap_map_1_90.size()));
		dadoTabelaMap.setMap_2_00(getIntParaTabela(wideMap_map_2_00.size()));
		qtdAmostras = dadoTabelaMap;
	}

	private void atualizarTabela() {

		if (lambdaAlvo != null && lambdaAlvo.getDescricaoLinha() == null) {
			List<String> listaValores = new ArrayList<String>();
			for (int i = 0; i < 40; i++) {
				listaValores.add("2.00");
			}
			lambdaAlvo.setDescricaoLinha(new SimpleStringProperty("Lambda Alvo"));
			lambdaAlvo.setValores(listaValores);
		}

		listaMap.clear();

		listaMap.add(mapaMsCorrigidoEditado);
		listaMap.add(mapaMsCorrigido);
		listaMap.add(mapaMs);
		listaMap.add(correcaoLinha);
		listaMap.add(lambdaAlvo);
		listaMap.add(correcaoSondaLinha);
		listaMap.add(sondaMedia);
		listaMap.add(qtdAmostras);
	}

	private SimpleStringProperty getValorParaTabela(BigDecimal valorArredondado) {
		return new SimpleStringProperty(valorArredondado.toString());
	}

	private SimpleStringProperty getIntParaTabela(int size) {
		return new SimpleStringProperty(size + "");
	}

	@SuppressWarnings("unused")
	private SimpleStringProperty getStringParaTabela(String str) {
		return new SimpleStringProperty(str);
	}

	private BigDecimal getValorMedio(List<Float> listaValores, Float valorMap) {

//		return getMedia(listaValores, valorMap);
//		return getValorMediaPonderadaTruncada(listaValores, valorMap, percTruncada.getText(), checkboxTruncar.isSelected(), getMapaValorMedio());
		return calc.getValorMediaPonderadaTruncada(listaValores, percTruncada.getText(), checkboxTruncar.isSelected());
	}

//	private BigDecimal getMedia(List<Float> listaValores, Float valorMap) {
//		calc.getValorMediaPonderadaTruncada(listaValores, valorMap, percTruncada.getText(), checkboxTruncar.isSelected(), getMapaValorMedio());
//
//		Float floatValores = getValoresSomados(listaValores);
//		BigDecimal valorArredondado = BigDecimal.valueOf(0L);
//		if (listaValores.size() > 0) {
//
//			BigDecimal media = new BigDecimal(floatValores / listaValores.size());
//			valorArredondado = media.setScale(2, BigDecimal.ROUND_HALF_EVEN);
//		}
//		getMapaValorMedio().put(valorMap, valorArredondado);
//		return valorArredondado;
//	}

//	private Float getValoresSomados(List<Float> listaFloat) {
//		Float floatValor = 0f;
//		for (int i = 0; i < listaFloat.size(); i++) {
//			Float float1 = listaFloat.get(i);
//			if (float1 != null) {
//				floatValor = floatValor + float1;
//			}
//		}
//		return floatValor;
//	}

	private Float getValorCanal(List<DataCanal> listaDados, int posicao, Integer canal) {
		
		
		if(canal == SONDA_CORRECAO && !IS_CORRRECAO_ATIVA) {
			return null;
		}
		

		float vlrTpsMinimo = Float.parseFloat(tpsMinimo.getText());
		float vlrTpsMaximo = Float.parseFloat(tpsMaximo.getText());
		float vlrTempMotorMinimo = Float.parseFloat(tempMotorMinimo.getText());
		float vlrTempMotorMaximo = Float.parseFloat(tempMotorMaximo.getText());
		float vlrSondaMinimo = Float.parseFloat(sondaMinimo.getText());
		float vlrSondaMaximo = Float.parseFloat(sondaMaximo.getText());
		
		Float valorSonda =null;

		boolean filtroOK = true;
		boolean flagTPS = true;
		boolean flagTempMotor = true;

		for (int k = 0; k < listaDados.size(); k++) {
			if (flagTPS || flagTempMotor) {

				if (listaDados.get(k).getCanal().getId() == TPS) {
					flagTPS = false;
					float valor = listaDados.get(k).getValores()[posicao];
					if (!(valor >= vlrTpsMinimo && valor <= vlrTpsMaximo)) {
						filtroOK = false;
					}
				}
				if (listaDados.get(k).getCanal().getId() == TEMP_MOTOR) {
					flagTempMotor = false;
					float valor = listaDados.get(k).getValores()[posicao];
					if (!(valor >= vlrTempMotorMinimo && valor <= vlrTempMotorMaximo)) {
						filtroOK = false;
					}
				}
			}
		}

		boolean widebandFiltroOk = true;
		if (filtroOK) {
			for (int k = 0; k < listaDados.size(); k++) {
				if (listaDados.get(k).getCanal().getId() == WIDEBAND) {
					valorSonda = listaDados.get(k).getValores()[Math.round(posicao)];
					if (!(valorSonda >= vlrSondaMinimo && valorSonda <= vlrSondaMaximo)) {
						widebandFiltroOk = false;
						valorSonda = null;
					} 
				}
			}
		}
		
		if(canal == WIDEBAND) {
			return valorSonda;
		}
		
		valorSonda = null;
		
		if (widebandFiltroOk && filtroOK) {
			for (int k = 0; k < listaDados.size(); k++) {
				if (listaDados.get(k).getCanal().getId() == canal) {
					valorSonda = listaDados.get(k).getValores()[Math.round(posicao)];
				}
			}
		}
		return valorSonda;
	}

//	private Float getValorCanalSemFiltro(List<DataCanal> listaDados, int posicao, Integer canal) {
//		for (int k = 0; k < listaDados.size(); k++) {
//			if (listaDados.get(k).getCanal().getId() == canal) {
//				return (listaDados.get(k).getValores()[Math.round(posicao)]);
//			}
//		}
//		return null;
//	}

	// Reference to the main application.
	private Mainapp mainApp;
	@FXML
	MenuItem menuItemColarMapa;
	@FXML
	MenuItem menuItemSondaAlvo;
	@FXML
	Button btnInterpolar;
	@FXML
	public Label lblCaminhoArquivoConfiguracao;
	@FXML
	ImageView imgDoacao;
	@FXML VBox vboxTela;

	public PaginaInicialController() {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	private void initialize() {
		
//		
//		tabelaMap.prefHeightProperty().bind(stage.heightProperty());
//		tabelaMap.prefWidthProperty().bind(stage.widthProperty());
		
		VBox.setVgrow(lineChartInjecao, Priority.ALWAYS);
		

		percTruncada.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,2}(\\.\\d{0,2})?")) {
					percTruncada.setText(oldValue);
				} else {
					percTruncada.setText(newValue);
				}
			}
		});
		
		
		tpsMinimo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,2}(\\.\\d{0,2})?")) {
					tpsMinimo.setText(oldValue);
				} else {
					tpsMinimo.setText(newValue);
				}
			}
		});
		
		tpsMaximo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,3}(\\.\\d{0,2})?")) {
					tpsMaximo.setText(oldValue);
				} else {
					tpsMaximo.setText(newValue);
				}
			}
		});
		
		tempMotorMinimo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,2}(\\.\\d{0,2})?")) {
					tempMotorMinimo.setText(oldValue);
				} else {
					tempMotorMinimo.setText(newValue);
				}
			}
		});
		
		tempMotorMaximo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,3}(\\.\\d{0,2})?")) {
					tempMotorMaximo.setText(oldValue);
				} else {
					tempMotorMaximo.setText(newValue);
				}
			}
		});
		
		sondaMinimo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,2}(\\.\\d{0,2})?")) {
					sondaMinimo.setText(oldValue);
				} else {
					sondaMinimo.setText(newValue);
				}
			}
		});
		
		sondaMaximo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				newValue = newValue.replace(',', '.');
//				if (!newValue.matches("-?\\d*(\\.\\d{0,2})?")) {
				if (!newValue.matches("-?\\d{0,2}(\\.\\d{0,2})?")) {
					sondaMaximo.setText(oldValue);
				} else {
					sondaMaximo.setText(newValue);
				}
			}
		});
		

		imgDoacao.setOnMouseClicked((MouseEvent e) -> {
			try {
				Desktop.getDesktop().browse(new URI("https://pag.ae/blCwLvv"));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		});

		tabelaMap.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tabelaMap.getSelectionModel().setCellSelectionEnabled(true);

		Callback cellFactory = new Callback<TableColumn, TableCell>() {
			public TableCell call(TableColumn p) {
				return new CellEditavel();
			}
		};

		tabelaMap.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

		descricaoLinha.setCellValueFactory(cellData -> cellData.getValue().getDescricaoLinha());
		map_m_0_90.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_90());
		map_m_0_85.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_85());
		map_m_0_80.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_80());
		map_m_0_75.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_75());
		map_m_0_70.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_70());
		map_m_0_65.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_65());
		map_m_0_60.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_60());
		map_m_0_55.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_55());
		map_m_0_50.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_50());
		map_m_0_45.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_45());
		map_m_0_40.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_40());
		map_m_0_35.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_35());
		map_m_0_30.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_30());
		map_m_0_25.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_25());
		map_m_0_20.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_20());
		map_m_0_15.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_15());
		map_m_0_10.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_10());
		map_m_0_05.setCellValueFactory(cellData -> cellData.getValue().getMap_m_0_05());
		map_0_00.setCellValueFactory(cellData -> cellData.getValue().getMap_0_00());
		map_0_05.setCellValueFactory(cellData -> cellData.getValue().getMap_0_05());
		map_0_10.setCellValueFactory(cellData -> cellData.getValue().getMap_0_10());
		map_0_20.setCellValueFactory(cellData -> cellData.getValue().getMap_0_20());
		map_0_30.setCellValueFactory(cellData -> cellData.getValue().getMap_0_30());
		map_0_40.setCellValueFactory(cellData -> cellData.getValue().getMap_0_40());
		map_0_50.setCellValueFactory(cellData -> cellData.getValue().getMap_0_50());
		map_0_60.setCellValueFactory(cellData -> cellData.getValue().getMap_0_60());
		map_0_70.setCellValueFactory(cellData -> cellData.getValue().getMap_0_70());
		map_0_80.setCellValueFactory(cellData -> cellData.getValue().getMap_0_80());
		map_0_90.setCellValueFactory(cellData -> cellData.getValue().getMap_0_90());
		map_1_00.setCellValueFactory(cellData -> cellData.getValue().getMap_1_00());
		map_1_10.setCellValueFactory(cellData -> cellData.getValue().getMap_1_10());
		map_1_20.setCellValueFactory(cellData -> cellData.getValue().getMap_1_20());
		map_1_30.setCellValueFactory(cellData -> cellData.getValue().getMap_1_30());
		map_1_40.setCellValueFactory(cellData -> cellData.getValue().getMap_1_40());
		map_1_50.setCellValueFactory(cellData -> cellData.getValue().getMap_1_50());
		map_1_60.setCellValueFactory(cellData -> cellData.getValue().getMap_1_60());
		map_1_70.setCellValueFactory(cellData -> cellData.getValue().getMap_1_70());
		map_1_80.setCellValueFactory(cellData -> cellData.getValue().getMap_1_80());
		map_1_90.setCellValueFactory(cellData -> cellData.getValue().getMap_1_90());
		map_2_00.setCellValueFactory(cellData -> cellData.getValue().getMap_2_00());

		map_m_0_90.setCellFactory(cellFactory);
		map_m_0_85.setCellFactory(cellFactory);
		map_m_0_80.setCellFactory(cellFactory);
		map_m_0_75.setCellFactory(cellFactory);
		map_m_0_70.setCellFactory(cellFactory);
		map_m_0_65.setCellFactory(cellFactory);
		map_m_0_60.setCellFactory(cellFactory);
		map_m_0_55.setCellFactory(cellFactory);
		map_m_0_50.setCellFactory(cellFactory);
		map_m_0_45.setCellFactory(cellFactory);
		map_m_0_40.setCellFactory(cellFactory);
		map_m_0_35.setCellFactory(cellFactory);
		map_m_0_30.setCellFactory(cellFactory);
		map_m_0_25.setCellFactory(cellFactory);
		map_m_0_20.setCellFactory(cellFactory);
		map_m_0_15.setCellFactory(cellFactory);
		map_m_0_10.setCellFactory(cellFactory);
		map_m_0_05.setCellFactory(cellFactory);
		map_0_00.setCellFactory(cellFactory);
		map_0_05.setCellFactory(cellFactory);
		map_0_10.setCellFactory(cellFactory);
		map_0_20.setCellFactory(cellFactory);
		map_0_30.setCellFactory(cellFactory);
		map_0_40.setCellFactory(cellFactory);
		map_0_50.setCellFactory(cellFactory);
		map_0_60.setCellFactory(cellFactory);
		map_0_70.setCellFactory(cellFactory);
		map_0_80.setCellFactory(cellFactory);
		map_0_90.setCellFactory(cellFactory);
		map_1_00.setCellFactory(cellFactory);
		map_1_10.setCellFactory(cellFactory);
		map_1_20.setCellFactory(cellFactory);
		map_1_30.setCellFactory(cellFactory);
		map_1_40.setCellFactory(cellFactory);
		map_1_50.setCellFactory(cellFactory);
		map_1_60.setCellFactory(cellFactory);
		map_1_70.setCellFactory(cellFactory);
		map_1_80.setCellFactory(cellFactory);
		map_1_90.setCellFactory(cellFactory);
		map_2_00.setCellFactory(cellFactory);

		atualizarTabela();
		tabelaMap.setItems(listaMap);

		configurarGrafico();
	}

	public void callBackConfigurarSonda(List<AlvoSondaLambda> lista) {

		if (lista == null || lista.isEmpty()) {
			return;
		}

		Float[] maps = new Float[5];

		for (int i = 0; i < maps.length; i++) {
			maps[i] = lista.get(i).getValorMap();
		}
		Arrays.sort(maps);

		Float map1 = maps[0];
		Float map2 = maps[1];
		Float map3 = maps[2];
		Float map4 = maps[3];
		Float map5 = maps[4];

		List<String> listaValoresSonda = new ArrayList<String>();
		for (int i = 0; i < 40; i++) {
			listaValoresSonda.add(null);
		}
		for (AlvoSondaLambda alvo : lista) {
			listaValoresSonda.set(PosicaoValor.getMapaPosicoesValores().get(alvo.getValorMap()),
					alvo.getValorLambda().toString());
		}

		List<Float> listaMaps = new ArrayList<Float>();
		listaMaps.addAll(PosicaoValor.getMapaPosicoesValores().keySet());
		Collections.sort(listaMaps);
		for (int i = 0; i < listaMaps.size(); i++) {
			Float fMap = listaMaps.get(i);
			if (fMap < map1) {
				listaValoresSonda.set(i, getAlvoSonda(maps[0], lista));
				continue;
			} else if (fMap > map5) {
				listaValoresSonda.set(i, getAlvoSonda(maps[4], lista));
				continue;
			}
		}

		BigDecimal posMap1 = new BigDecimal(PosicaoValor.getMapaPosicoesValores().get(map1));
		BigDecimal posMap2 = new BigDecimal(PosicaoValor.getMapaPosicoesValores().get(map2));
		BigDecimal posMap3 = new BigDecimal(PosicaoValor.getMapaPosicoesValores().get(map3));
		BigDecimal posMap4 = new BigDecimal(PosicaoValor.getMapaPosicoesValores().get(map4));
		BigDecimal posMap5 = new BigDecimal(PosicaoValor.getMapaPosicoesValores().get(map5));

		BigDecimal divisor1 = posMap2.subtract(posMap1);
		BigDecimal divisor2 = posMap3.subtract(posMap2);
		BigDecimal divisor3 = posMap4.subtract(posMap3);
		BigDecimal divisor4 = posMap5.subtract(posMap4);

		if (BigDecimal.ZERO == divisor1) {
			divisor1 = BigDecimal.ONE;
		}
		if (BigDecimal.ZERO == divisor2) {
			divisor2 = BigDecimal.ONE;
		}
		if (BigDecimal.ZERO == divisor3) {
			divisor3 = BigDecimal.ONE;
		}
		if (BigDecimal.ZERO == divisor4) {
			divisor4 = BigDecimal.ONE;
		}

		BigDecimal alvoSonda1 = new BigDecimal(getAlvoSonda(map1, lista));
		BigDecimal alvoSonda2 = new BigDecimal(getAlvoSonda(map2, lista));
		BigDecimal alvoSonda3 = new BigDecimal(getAlvoSonda(map3, lista));
		BigDecimal alvoSonda4 = new BigDecimal(getAlvoSonda(map4, lista));
		BigDecimal alvoSonda5 = new BigDecimal(getAlvoSonda(map5, lista));

		MathContext mc = new MathContext(15, RoundingMode.HALF_UP);

		BigDecimal acres1 = (alvoSonda2.subtract(alvoSonda1)).divide(divisor1, mc).setScale(2,
				BigDecimal.ROUND_HALF_EVEN);
		BigDecimal acres2 = (alvoSonda3.subtract(alvoSonda2)).divide(divisor2, mc).setScale(2,
				BigDecimal.ROUND_HALF_EVEN);
		BigDecimal acres3 = (alvoSonda4.subtract(alvoSonda3)).divide(divisor3, mc).setScale(2,
				BigDecimal.ROUND_HALF_EVEN);
		BigDecimal acres4 = (alvoSonda5.subtract(alvoSonda4)).divide(divisor4, mc).setScale(2,
				BigDecimal.ROUND_HALF_EVEN);

		interpolarValores(listaValoresSonda, posMap1, divisor1, acres1);
		interpolarValores(listaValoresSonda, posMap2, divisor2, acres2);
		interpolarValores(listaValoresSonda, posMap3, divisor3, acres3);
		interpolarValores(listaValoresSonda, posMap4, divisor4, acres4);

		lambdaAlvo.setValores(listaValoresSonda);
		atualizarTabela();

	}

	private void interpolarValores(List<String> listaValoresSonda, BigDecimal posMap1, BigDecimal divisor1,
			BigDecimal acres1) {

		MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
		for (int i = 1; i < divisor1.intValue(); i++) {

			BigDecimal primeiroValor;
			if (posMap1.intValue() == 0) {
				primeiroValor = new BigDecimal(listaValoresSonda.get(posMap1.intValue()));
			} else {
				primeiroValor = new BigDecimal(listaValoresSonda.get(posMap1.intValue() + (i - 1)));
			}

			listaValoresSonda.set(posMap1.intValue() + i,
					primeiroValor.add(acres1, mc).setScale(2, BigDecimal.ROUND_HALF_EVEN).floatValue() + "");

		}
	}

	private String getAlvoSonda(Float float1, List<AlvoSondaLambda> lista) {
		for (AlvoSondaLambda alvoSondaLambda : lista) {
			if (alvoSondaLambda.getValorMap() == float1) {
				return alvoSondaLambda.getValorLambda().toString();
			}
		}
		return null;
	}

	public Mainapp getMainApp() {
		return mainApp;
	}

	public void setMainApp(Mainapp mainApp) {
		this.mainApp = mainApp;

	}

	@FXML
	public void doInterpolar() {
		doInterpolarOb();

	}

	@SuppressWarnings("rawtypes")
	private void doInterpolarOb() {
		ObservableList<TablePosition> selectedCells = tabelaMap.getSelectionModel().getSelectedCells();

		MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
		
		if(!(selectedCells != null && selectedCells.size() > 2) ) {
			apresentarAlertaAviso("Selecione três ou mais células na tabela para interpolar!");
			return;
		}

		int rowIndex = selectedCells.get(0).getRow();

		for (int i = 0; i < selectedCells.size(); i++) {
			if (selectedCells.get(i).getRow() != 0) {
				avisoInterpolacaoIncorreta();
				return;

			}
		}

		int[] posicoes = new int[selectedCells.size()];

		for (int i = 0; i < selectedCells.size(); i++) {
			posicoes[i] = selectedCells.get(i).getColumn();
		}

		Arrays.sort(posicoes);

		TablePosition tablePosition1 = null;
		TablePosition tablePosition2 = null;
		int primeiro = posicoes[0];
		int ultimo = posicoes[posicoes.length - 1];
		for (int i = 0; i < selectedCells.size(); i++) {
			if (selectedCells.get(i).getColumn() == primeiro) {
				tablePosition1 = selectedCells.get(i);
			}

			if (selectedCells.get(i).getColumn() == ultimo) {
				tablePosition2 = selectedCells.get(i);
			}
		}

		int pos1 = primeiro;
		int pos2 = ultimo;
		int intervalo = pos2 - pos1;

		String primeiroValor = (String)tablePosition1.getTableColumn().getCellObservableValue(rowIndex).getValue();
		String segundoValor = (String)tablePosition2.getTableColumn().getCellObservableValue(rowIndex).getValue();
		
		if(primeiroValor.contains("-") ||segundoValor.contains("-")) {
			apresentarAlertaAviso("A primeira e a última célula devem conter valor númerico!");
			return;
		}
		
		BigDecimal valor1 = getBigDecimalString(
				(String) primeiroValor);
		BigDecimal valor2 = getBigDecimalString(
				(String) segundoValor);

		BigDecimal acres = (valor2.subtract(valor1)).divide(new BigDecimal(intervalo), mc).setScale(3,
				BigDecimal.ROUND_HALF_EVEN);

		List<String> valores = mapaMsCorrigidoEditado.getValores();

		for (int i = 1; i < intervalo; i++) {
			valores.set((pos1 - 1) + i, getBigDecimalString(valores.get((pos1 - 1) + (i - 1))).add(acres, mc)
					.setScale(3, BigDecimal.ROUND_HALF_EVEN).toString());
		}

		mapaMsCorrigidoEditado.setValores(valores);

		atualizarTabela();
		configurarGraficoMapaEditado();
	}

	private void apresentarAlertaAviso(String msg) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Aviso");
		alert.setHeaderText(null);
		alert.setContentText(msg);
		alert.showAndWait();
	}

	private BigDecimal getBigDecimalString(String tf) {
		String replace = tf.replace(',', '.');
		BigDecimal bd = BigDecimal.ZERO;
		if (!replace.isEmpty()) {
			bd = new BigDecimal(replace);
		}
		return bd;
	}

	private void avisoInterpolacaoIncorreta() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Aviso");
		alert.setHeaderText(null);
		alert.setContentText("Somente a linha \"Editável(mS)\" pode ser interpolada.");
		alert.showAndWait();
	}

	public void configurarArquivoDeConfiguracaoes(ConfiguracoesWrapper wrapper) {
		doConfigurarArquivoDeConfigs(wrapper);
	}

	private void doConfigurarArquivoDeConfigs(ConfiguracoesWrapper wrapper) {
		wrapper.setLambdaAlvo(lambdaAlvo);
		wrapper.setMapaMs(mapaMs);
		wrapper.setMapaMsCorrigidoEditado(mapaMsCorrigidoEditado);
		wrapper.setTpsMinimo(tpsMinimo.getText());
		wrapper.setTpsMaximo(tpsMaximo.getText());
		wrapper.setTempMotorMinimo(tempMotorMinimo.getText());
		wrapper.setTempMotorMaximo(tempMotorMaximo.getText());
		wrapper.setPrecisaoMap(precisaoMap.getText());
		wrapper.setSondaMinimo(sondaMinimo.getText());
		wrapper.setSondaMaximo(sondaMaximo.getText());
		wrapper.setPercTruncada(percTruncada.getText());
		wrapper.setTruncada(checkboxTruncar.isSelected());
	}

	public void carregarConfiguracoes(ConfiguracoesWrapper wrapper) {
		doCarregarConfigs(wrapper);

	}

	private void doCarregarConfigs(ConfiguracoesWrapper wrapper) {
		lambdaAlvo.setValores(wrapper.getLambdaAlvo().getValoresVariavel());
		List<String> valoresVariavel = wrapper.getMapaMsCorrigidoEditado().getValoresVariavel();
		boolean flag = true;
		for (String string : valoresVariavel) {
			if (!string.equals("-")) {
				flag = false;
			}
		}

		if (flag) {
			valoresVariavel = wrapper.getMapaMs().getValoresVariavel();
		}

		mapaMs.setValores(valoresVariavel);
		mapaMsCorrigidoEditado.setValores(valoresVariavel);

		tpsMinimo.setText(wrapper.getTpsMinimo());
		tpsMaximo.setText(wrapper.getTpsMaximo());
		tempMotorMinimo.setText(wrapper.getTempMotorMinimo());
		tempMotorMaximo.setText(wrapper.getTempMotorMaximo());
		precisaoMap.setText(wrapper.getPrecisaoMap());
		sondaMinimo.setText(wrapper.getSondaMinimo());
		sondaMaximo.setText(wrapper.getSondaMaximo());

		percTruncada.setText(wrapper.getPercTruncada());

		checkboxTruncar.setSelected(wrapper.getTruncada());

		atualizarTabela();
		configurarGrafico();
	}

	@FXML
	public void doDoacao() {
		try {
			Desktop.getDesktop().browse(new URI("https://pag.ae/blCwLvv"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	}
	

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
