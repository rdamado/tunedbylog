package darkmotorsport.tunedbylog.gui.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import darkmotorsport.tunedbylog.gui.model.AlvoSondaLambda;
import darkmotorsport.tunedbylog.gui.model.CalculadorMapRpm;
import darkmotorsport.tunedbylog.gui.model.CellMapRpm;
import darkmotorsport.tunedbylog.gui.model.CelulaMapRpm;
import darkmotorsport.tunedbylog.gui.model.EnumApresentacaoTabela;
import darkmotorsport.tunedbylog.gui.model.EnumApresentacaoTabelaCor;
import darkmotorsport.tunedbylog.gui.model.LinhaMapRpm;
import darkmotorsport.tunedbylog.gui.model.MapBase;
import darkmotorsport.tunedbylog.gui.model.RpmCorrecao;
import darkmotorsport.tunedbylog.xml.itens.Log;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.input.ScrollEvent;
import javafx.util.Callback;
import javafx.scene.layout.HBox;

public class PaginaInicialAbaRPM extends PaginaInicialController {

	@SuppressWarnings("rawtypes")
	@FXML
	TableView tabelaMAP_RPM;

	public ObservableList<LinhaMapRpm> listaMAP_RPM = FXCollections.observableArrayList();
	public ObservableList<LinhaMapRpm> listaMAP_RPM_desc = FXCollections.observableArrayList();

	@SuppressWarnings("rawtypes")
	@FXML
	TableView tabelaDescMAP_RPM;

	@FXML
	TableColumn<LinhaMapRpm, String> colunaDescMAP_RPM;

	@FXML
	ScrollBar scroll;

	@FXML
	TableColumn<LinhaMapRpm, String> colunaDescMAP_RPM_Perc;

	@FXML
	ComboBox<EnumApresentacaoTabela> comboApresentacaoGraficoRpm;
	@FXML
	ComboBox<EnumApresentacaoTabelaCor> comboApresentacaoGraficoRpmCor;

	public static EnumApresentacaoTabela selecaoTabelaValor = EnumApresentacaoTabela.LAMBDA_MEDIA;
	public static EnumApresentacaoTabelaCor selecaoTabelaCor = EnumApresentacaoTabelaCor.CORRECAO;

	public static Boolean tabelaRPMInicializada = false;

	public static MathContext mc = new MathContext(15, RoundingMode.HALF_UP);

	Map<BigDecimal, RpmCorrecao> mapaRpmCorrecao = new HashMap<BigDecimal, RpmCorrecao>();

	@FXML
	HBox hboxLegenda;

	@FXML
	HBox hboxSelecaoTabela;

	@FXML
	HBox hboxBotoeslog;

	@Override
	public void initialize() {
		super.initialize();

		ObservableList<EnumApresentacaoTabela> compoValor = FXCollections.observableArrayList(EnumApresentacaoTabela.values());
		Collections.sort(compoValor);
		comboApresentacaoGraficoRpm.setItems(compoValor);
		comboApresentacaoGraficoRpm.setValue(selecaoTabelaValor);

		ObservableList<EnumApresentacaoTabelaCor> comboCor = FXCollections.observableArrayList(EnumApresentacaoTabelaCor.values());
		Collections.sort(comboCor);
		comboApresentacaoGraficoRpmCor.setItems(comboCor);
		comboApresentacaoGraficoRpmCor.setValue(selecaoTabelaCor);

		configurarLegendaValoresTabelaRPM();

	}

	@Override
	public void doAbrirLog() {
		super.doAbrirLog();
		carregarAbaCorrecaoRpm();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void carregarTabelaRpm(Log log) {

		tabelaMAP_RPM.getItems().clear();
		tabelaDescMAP_RPM.getItems().clear();
		listaMAP_RPM.clear();
		listaMAP_RPM_desc.clear();

		tabelaMAP_RPM.setColumnResizePolicy((param) -> true);

		CalculadorMapRpm m = new CalculadorMapRpm();
		List<LinhaMapRpm> linhas = m.gerarLinhas();
		LinhaMapRpm linhaMapRpm = linhas.get(0);

		m.doAbrirLog(linhas, log);
		listaMAP_RPM.addAll(linhas);
		listaMAP_RPM_desc.addAll(linhas);

		if (!tabelaRPMInicializada) {
			tabelaRPMInicializada = true;
			List<String> columns = new ArrayList<String>();
			List<CelulaMapRpm> listaCelulas = linhaMapRpm.getListaCelulas();
			for (CelulaMapRpm celulaMapRpm : listaCelulas) {
				columns.add(celulaMapRpm.getRpm().toString());
			}

			Callback cellFactory = new Callback<TableColumn, TableCell>() {
				public TableCell call(TableColumn p) {
					return new CellMapRpm();
				}
			};

			for (int i = 0; i < columns.size(); i++) {
				final int j = i;
				TableColumn<LinhaMapRpm, String> col = new TableColumn(columns.get(i));
				col.setId(columns.get(i));

				// TODO Porcentagem
				TableColumn<LinhaMapRpm, String> colMediaRpm = new TableColumn("");
				colMediaRpm.setId(columns.get(i) + "_correcao");
				colMediaRpm.setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaSondaMedia(j, cellData)));
				colMediaRpm.setCellFactory(cellFactory);
				colMediaRpm.setPrefWidth(48);

				colMediaRpm.setStyle("-fx-alignment: CENTER;");
				col.setStyle("-fx-alignment: CENTER;");

				col.getColumns().add(colMediaRpm);

				tabelaMAP_RPM.getColumns().addAll(col);
			}
			tabelaMAP_RPM.setItems(listaMAP_RPM);

			listaMAP_RPM_desc.addAll(linhas);

			colunaDescMAP_RPM.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMap().toString()));

			colunaDescMAP_RPM_Perc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMapLambdaMedia().toString()));
			colunaDescMAP_RPM_Perc.setStyle("-fx-alignment: CENTER; -fx-font-weight:bold");

			tabelaDescMAP_RPM.setItems(listaMAP_RPM_desc);

			tabelaDescMAP_RPM.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {

				@Override
				public void handle(ScrollEvent event) {
					event.consume();

				}

			});

			tabelaMAP_RPM.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
				@Override
				public void handle(ScrollEvent event) {
					event.consume();
				}
			});

			scroll.setMax(linhas.size()); // make sure the max is equal to the size of the table row data.
			scroll.setMin(0);
			scroll.valueProperty().addListener(new ChangeListener() {

				@Override
				public void changed(ObservableValue observable, Object oldValue, Object newValue) {
					// Scroll your tableview according to the table row index
					tabelaMAP_RPM.scrollTo(((Number) newValue).intValue());
					tabelaDescMAP_RPM.scrollTo(((Number) newValue).intValue());

				}

			});

		}

		ObservableList<Node> children = hboxBotoeslog.getChildren();
		List<Node> remover = new ArrayList<Node>();
		for (int i = 0; i < children.size(); i++) {
			if (children.get(i).getId() != null && children.get(i).getId().endsWith("lblIndicadorAutoCorrecao")) {
				remover.add(children.get(i));
			}
		}

		for (Node no : remover) {
			children.remove(no);
		}

		if (arquivoCarregado != null && arquivoCarregado.autoCorrecaoAtivada) {

			Label lblIndicadorAutoCorrecao = new Label();
			lblIndicadorAutoCorrecao.setId("lblIndicadorAutoCorrecao");
			lblIndicadorAutoCorrecao.setText("Mapa com correção de sonda");
			lblIndicadorAutoCorrecao.setStyle("-fx-background-color:crimson;-fx-font-weight:bold;-fx-font-size: 12pt;");
			hboxBotoeslog.getChildren().add(lblIndicadorAutoCorrecao);

		}

	}

//	private <T> void addTooltipToColumnCells(TableColumn<LinhaMapRpm, T> column) {
//
//		Callback<TableColumn<LinhaMapRpm, T>, TableCell<LinhaMapRpm, T>> existingCellFactory = column.getCellFactory();
//
//		column.setCellFactory(c -> {
//			TableCell<LinhaMapRpm, T> cell = existingCellFactory.call(c);
//			Tooltip tooltip = new Tooltip();
//	        
////			cell.getTableView().getda
//			
//			
//	        
//	        tooltip.textProperty().bind(cell.itemProperty().asString());
//			cell.setTooltip(tooltip);
//			return cell;
//		});
//	}

	private String getValorCelulaSondaMedia(final int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		String string = "";
		if (cellData.getValue().getListaCelulas().size() < j - 1) {
			return string;
		}

		BigDecimal sondaMedia2 = cellData.getValue().getListaCelulas().get(j).getSondaMedia();
		if (sondaMedia2 == null) {
			return string;
		}

		if (sondaMedia2.compareTo(new BigDecimal(0)) == 0) {
			return string;
		}

		string = sondaMedia2.toString();

		return string;
	}

	private String getValorCelulaBancadaATI(final int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		String string = "";
		if (cellData.getValue().getListaCelulas().size() < j - 1) {
			return string;
		}

//		BigDecimal valor = cellData.getValue().getListaCelulas().get(j).getTempoInjecaoMedia();
		BigDecimal valor = cellData.getValue().getListaCelulas().get(j).getTempoInjecaoMediaCorrigida();
		if (valor == null) {
			return string;
		}

		if (valor.compareTo(new BigDecimal(0)) == 0) {
			return string;
		}

		string = valor.toString();

		return string;
	}

	private String getValorCelulaBancadaATICorrigido(final int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		String string = "";
		if (cellData.getValue().getListaCelulas().size() < j - 1) {
			return string;
		}

		BigDecimal valor = cellData.getValue().getListaCelulas().get(j).getTempoInjecaoMediaCorrigida();
		if (valor == null) {
			return string;
		}

		if (valor.compareTo(new BigDecimal(0)) == 0) {
			return string;
		}

		string = valor.toString();

		return string;
	}

	private String getValorCelulaCorrecaoRpm(int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		String string = "";
		if (cellData.getValue().getListaCelulas().size() < j - 1) {
			return string;
		}

		BigDecimal valor = cellData.getValue().getListaCelulas().get(j).getTempoInjecaoComparadaAnterior();
		if (valor == null) {
			return string;
		}

		if (valor.compareTo(new BigDecimal(0)) == 0) {
			return string;
		}

		string = valor.toString();

		return string;
	}

	private String getValorCelulaAutoCorrecaos(int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		String string = "";
		if (cellData.getValue().getListaCelulas().size() < j - 1) {
			return string;
		}

		BigDecimal valor = cellData.getValue().getListaCelulas().get(j).getAutoCorrecao();
		if (valor == null) {
			return string;
		}

		if (valor.compareTo(new BigDecimal(0)) == 0) {
			return string;
		}

		string = valor.toString();

		return string;
	}

	private String getValorCelulaCorrecao(final int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		BigDecimal valor = cellData.getValue().getListaCelulas().get(j).getCorrecao();
		BigDecimal valorSondaMedia = cellData.getValue().getListaCelulas().get(j).getSondaMedia();
		String string = "";
		if (valor == null) {
			return string;
		}

		if (valor.compareTo(new BigDecimal(0)) == 0 && valorSondaMedia.compareTo(new BigDecimal(0)) == 0) {
			return string;
		}

		string = valor.toString();

		return string;
	}

	private String getValorCelulaSondaAlvo(final int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		BigDecimal valor = cellData.getValue().getListaCelulas().get(j).getSondaAlvo();
		String string = "";
		if (valor == null) {
			return string;
		}

		if (valor.compareTo(new BigDecimal(0)) == 0) {
			return string;
		}

		string = valor.toString();

		return string;
	}

	private CelulaMapRpm getCelula(final int j, CellDataFeatures<LinhaMapRpm, String> cellData) {
		CelulaMapRpm celulaMapRpm = cellData.getValue().getListaCelulas().get(j);

		return celulaMapRpm;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@FXML
	public void calcularCorrecaoRPM_Media() {
		ObservableList columns = tabelaMAP_RPM.getColumns();
		List<LinhaMapRpm> items = tabelaMAP_RPM.getItems();

		switch (selecaoTabelaValor) {
		case CORRECAO:
			carregarMediaCorrecaoTabelaMap(items, mc);
			carregarMediaCorrecaoTabelaRPM(columns, items, mc);
			break;
		case LAMBDA_ALVO:
//			carregarLambdaAlvoTabelaMap(items);
//			carregarLambdaAlvoTabelaRPM(columns, items);
			break;
		case LAMBDA_MEDIA:
			carregarMediaSondaTabelaMap(items, mc);
			carregarMediaSondaTabelaRPM(columns, items, mc);
			break;
//		case CORRECAO_RPM:
//			carregarCorrecaoRpmTabelaRPM(columns, items, mc);
//			break;

		default:
			break;
		}

		calcularCurvaRpm(items);

	}

	private void calcularCurvaRpm(List<LinhaMapRpm> items) {

		// Eleger um valor fixo
		BigDecimal rpmBase = new BigDecimal(1000);
		Map<BigDecimal, MapBase> mapMapaBase = new HashMap<>();
		for (LinhaMapRpm linhaMapRpm : items) {

			List<CelulaMapRpm> listaCelulas = linhaMapRpm.getListaCelulas();

			for (CelulaMapRpm celula : listaCelulas) {

				if (celula.getRpm().compareTo(rpmBase) == 0) {
					MapBase mb = new MapBase();
					mb.setMap(celula.getMap());
					mb.setRpm(celula.getRpm());
					mb.setTempoInjecao(celula.getTempoInjecaoMedia());
					
					mapMapaBase.put(celula.getMap(), mb);
				}

			}

		}

		for (int i = 0; i < items.size(); i++) {
			LinhaMapRpm linha = items.get(i);
			List<CelulaMapRpm> rpm = linha.getListaCelulas();
			for (int j = 1; j < rpm.size(); j++) {
				CelulaMapRpm atual = rpm.get(j);
				CelulaMapRpm anterior = rpm.get(j - 1);

				BigDecimal tempoimAtual = atual.getTempoInjecaoMedia();
				BigDecimal tempoimAnterior = anterior.getTempoInjecaoMedia();
				if ((tempoimAtual != null && tempoimAtual.compareTo(BigDecimal.ZERO) > 0) && (tempoimAnterior != null && tempoimAnterior.compareTo(BigDecimal.ZERO) > 0)) {
					// TODO Corrigir base do rpm corrigido

					
//					tempoimAnterior
					
					
					BigDecimal divisor = mapMapaBase.get(atual.getMap()).getTempoInjecao();
					BigDecimal tempoInjec = BigDecimal.ZERO;
					
					if(divisor.compareTo(BigDecimal.ZERO) == 0 && tempoimAnterior.compareTo(BigDecimal.ZERO) != 0) {
						MapBase mb = new MapBase();
						mb.setMap(anterior.getMap());
						mb.setRpm(rpmBase);
						mb.setTempoInjecao(tempoimAnterior);
						mapMapaBase.put(anterior.getMap(), mb);
						divisor = tempoimAnterior;
						
					}
					
					BigDecimal multiply = tempoimAtual.multiply(new BigDecimal("100"), mc);
					BigDecimal divide = multiply.divide(divisor, mc);
					tempoInjec = divide.setScale(1, RoundingMode.HALF_EVEN).subtract(new BigDecimal("100"));
					
					atual.setTempoInjecaoComparadaAnterior(tempoInjec);
					
					

				}
			}
		}

		for (int i = 0; i < items.size(); i++) {
			LinhaMapRpm linha = items.get(i);
			List<CelulaMapRpm> listaRpm = linha.getListaCelulas();
			for (CelulaMapRpm valor : listaRpm) {
				BigDecimal rpm = valor.getRpm();
				if (mapaRpmCorrecao.containsKey(rpm)) {
					RpmCorrecao rpmCorrecao = mapaRpmCorrecao.get(rpm);
					rpmCorrecao.getValores().add(valor.getTempoInjecaoComparadaAnterior());
					mapaRpmCorrecao.put(rpm, rpmCorrecao);
				} else {
					RpmCorrecao rpmCorrecao = new RpmCorrecao();
					rpmCorrecao.setRpm(rpm);
					rpmCorrecao.getValores().add(valor.getTempoInjecaoComparadaAnterior());
					mapaRpmCorrecao.put(rpm, rpmCorrecao);
				}

			}
		}

//		System.out.println(items);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void carregarMediaCorrecaoTabelaRPM(ObservableList columns, List<LinhaMapRpm> items, MathContext mc) {
		for (int i = 0; i < columns.size(); i++) {
			TableColumn<LinhaMapRpm, String> colunaRPMVazia = (TableColumn<LinhaMapRpm, String>) columns.get(i);
			TableColumn<LinhaMapRpm, ?> coluna = colunaRPMVazia.getColumns().get(0);
			int indexOf = columns.indexOf(colunaRPMVazia);

			List<BigDecimal> listaValores = new ArrayList<BigDecimal>();

			for (int j = 0; j < items.size(); j++) {
				BigDecimal valor = items.get(j).getListaCelulas().get(indexOf).getCorrecao();
				if (valor != null && valor.compareTo(new BigDecimal(0)) != 0) {
					listaValores.add(valor);
				}
			}

			BigDecimal resultadoMediaPonderada = getMediaPonderada(listaValores);

			coluna.setText(resultadoMediaPonderada.toString());

		}

	}

	private BigDecimal getMediaPonderada(List<BigDecimal> listaValores) {
		Map<BigDecimal, Integer> mapaDeOcorrencias = new HashMap<BigDecimal, Integer>();

		// Media ponderada
		for (BigDecimal valor : listaValores) {
			Integer qtdOcorrencias = mapaDeOcorrencias.get(valor);
			if (qtdOcorrencias == null) {
				mapaDeOcorrencias.put(valor, 1);
			} else {
				mapaDeOcorrencias.put(valor, qtdOcorrencias);
			}
		}

		BigDecimal somaPesos = BigDecimal.ZERO;
		BigDecimal somaSondaPonderada = BigDecimal.ZERO;
		BigDecimal resultadoMediaPonderada = BigDecimal.ZERO;

		for (Entry<BigDecimal, Integer> entry : mapaDeOcorrencias.entrySet()) {

			if (entry.getValue() == null || entry.getKey() == null) {
				continue;
			}

			somaPesos = somaPesos.add(new BigDecimal(entry.getValue()));

			somaSondaPonderada = somaSondaPonderada.add(entry.getKey().multiply(new BigDecimal(entry.getValue()))).setScale(2, RoundingMode.HALF_EVEN);

		}

		if (somaPesos.compareTo(BigDecimal.ZERO) > 0) {
			resultadoMediaPonderada = somaSondaPonderada.divide(somaPesos, mc).setScale(2, RoundingMode.HALF_EVEN);
		}
		return resultadoMediaPonderada;
	}

	private void carregarMediaCorrecaoTabelaMap(List<LinhaMapRpm> items, MathContext mc) {
		for (int i = 0; i < items.size(); i++) {
			List<CelulaMapRpm> listaCelulas = items.get(i).getListaCelulas();

			List<BigDecimal> listaValores = new ArrayList<BigDecimal>();
			for (int j = 0; j < listaCelulas.size(); j++) {
				CelulaMapRpm celulaMapRpm = listaCelulas.get(j);
				BigDecimal correcao = celulaMapRpm.getCorrecao();
				listaValores.add(correcao);
			}

			BigDecimal resultadoMediaPonderada = getMediaPonderada(listaValores);

			items.get(i).setMapCorrecaoMedia(resultadoMediaPonderada);

		}

		listaMAP_RPM_desc.clear();
		listaMAP_RPM_desc.addAll(items);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void carregarMediaSondaTabelaRPM(ObservableList columns, List<LinhaMapRpm> items, MathContext mc) {
		for (int i = 0; i < columns.size(); i++) {
			TableColumn<LinhaMapRpm, String> colunaRPMVazia = (TableColumn<LinhaMapRpm, String>) columns.get(i);
			TableColumn<LinhaMapRpm, ?> coluna = colunaRPMVazia.getColumns().get(0);
			int indexOf = columns.indexOf(colunaRPMVazia);

			List<BigDecimal> listaValores = new ArrayList<BigDecimal>();

			for (int j = 0; j < items.size(); j++) {
				BigDecimal valor = items.get(j).getListaCelulas().get(indexOf).getSondaMedia();
				if (valor != null && valor.compareTo(new BigDecimal(0)) != 0) {
					listaValores.add(valor);
				}
			}

			BigDecimal resultadoMediaPonderada = getMediaPonderada(listaValores);
			coluna.setText(resultadoMediaPonderada.toString());

		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void carregarCorrecaoRpmTabelaRPM(ObservableList columns, List<LinhaMapRpm> items, MathContext mc) {
		for (int i = 0; i < columns.size(); i++) {
			TableColumn<LinhaMapRpm, String> colunaRPMVazia = (TableColumn<LinhaMapRpm, String>) columns.get(i);
			TableColumn<LinhaMapRpm, ?> coluna = colunaRPMVazia.getColumns().get(0);
			int count = 0;
			BigDecimal somaTotal = BigDecimal.ZERO;
			BigDecimal media = BigDecimal.ZERO;

			BigDecimal valorColuna = new BigDecimal(colunaRPMVazia.getText());

			if (mapaRpmCorrecao.containsKey(valorColuna)) {

				RpmCorrecao rpmCorrecao = mapaRpmCorrecao.get(valorColuna);
				rpmCorrecao.getValores();
				for (BigDecimal valor : rpmCorrecao.getValores()) {
					if (valor != null) {
						somaTotal = somaTotal.add(valor);
						count++;
					}
				}
			}

			if (count > 0) {
				media = somaTotal.divide(new BigDecimal(count), mc).setScale(1, RoundingMode.HALF_EVEN);
			}

			coluna.setText(media.toString());

		}
	}

	private void carregarMediaSondaTabelaMap(List<LinhaMapRpm> items, MathContext mc) {
		for (int i = 0; i < items.size(); i++) {
			List<CelulaMapRpm> listaCelulas = items.get(i).getListaCelulas();
			BigDecimal sondaMediaMap = new BigDecimal(0);
			int qtdValoresMap = 0;
			for (int j = 0; j < listaCelulas.size(); j++) {
				CelulaMapRpm celulaMapRpm = listaCelulas.get(j);
				BigDecimal sondaMediaMap2 = celulaMapRpm.getSondaMedia();
				if (sondaMediaMap2.compareTo(new BigDecimal(0)) != 0) {
					qtdValoresMap++;
					sondaMediaMap = sondaMediaMap.add(sondaMediaMap2);
				}
			}

			BigDecimal divide = new BigDecimal(0);
			if (qtdValoresMap != 0) {
				divide = sondaMediaMap.divide(new BigDecimal(qtdValoresMap), mc).setScale(2, BigDecimal.ROUND_HALF_EVEN);

			}
			items.get(i).setMapLambdaMedia(divide);

		}

		listaMAP_RPM_desc.clear();
		listaMAP_RPM_desc.addAll(items);
	}

	@SuppressWarnings("unchecked")
	@FXML
	public void trocarApresentacao() {
		List<TableColumn<LinhaMapRpm, String>> columns = tabelaMAP_RPM.getColumns();

		selecaoTabelaValor = comboApresentacaoGraficoRpm.getValue();

		for (int i = 0; i < columns.size(); i++) {
			final int j = i;

			switch (selecaoTabelaValor) {
			case CORRECAO:
				((TableColumn<LinhaMapRpm, String>) columns.get(i).getColumns().get(0)).setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaCorrecao(j, cellData)));
				break;
			case LAMBDA_ALVO:
				((TableColumn<LinhaMapRpm, String>) columns.get(i).getColumns().get(0)).setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaSondaAlvo(j, cellData)));
				break;
			case LAMBDA_MEDIA:
				((TableColumn<LinhaMapRpm, String>) columns.get(i).getColumns().get(0)).setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaSondaMedia(j, cellData)));
				break;
			case BANCADA_A_TI:
				((TableColumn<LinhaMapRpm, String>) columns.get(i).getColumns().get(0)).setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaBancadaATI(j, cellData)));
				break;
//			case BANCADA_A_TI_CORRIGIDO:
//				((TableColumn<LinhaMapRpm, String>) columns.get(i).getColumns().get(0)).setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaBancadaATICorrigido(j, cellData)));
//				break;
			case AUTO_CORRECAO:
				((TableColumn<LinhaMapRpm, String>) columns.get(i).getColumns().get(0)).setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaAutoCorrecaos(j, cellData)));
				break;

//			case CORRECAO_RPM:
//				((TableColumn<LinhaMapRpm, String>) columns.get(i).getColumns().get(0)).setCellValueFactory(cellData -> new SimpleStringProperty(getValorCelulaCorrecaoRpm(j, cellData)));
//				break;

			default:
				break;
			}

		}

		switch (selecaoTabelaValor) {
		case CORRECAO:
			colunaDescMAP_RPM_Perc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMapCorrecaoMedia().toString()));
			break;
		case LAMBDA_ALVO:
			colunaDescMAP_RPM_Perc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMapLambdaAlvo() == null ? "" : cellData.getValue().getMapLambdaAlvo().toString()));
			break;
		case LAMBDA_MEDIA:
			colunaDescMAP_RPM_Perc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMapLambdaMedia().toString()));
			break;
		case BANCADA_A_TI:
			break;
//		case BANCADA_A_TI_CORRIGIDO:
//			break;

		default:
			break;
		}

		ObservableList<LinhaMapRpm> listaMAP_RPMTmp = FXCollections.observableArrayList();

		for (LinhaMapRpm linhaMapRpm : listaMAP_RPM) {
			listaMAP_RPMTmp.add(linhaMapRpm);
		}

		listaMAP_RPM.clear();
		listaMAP_RPM.addAll(listaMAP_RPMTmp);
		listaMAP_RPM_desc.clear();
		listaMAP_RPM_desc.addAll(listaMAP_RPMTmp);

		calcularCorrecaoRPM_Media();

	}

	@Override
	public void callBackConfigurarSonda(List<AlvoSondaLambda> lista) {
		super.callBackConfigurarSonda(lista);

		CalculadorMapRpm m = new CalculadorMapRpm();

		m.doAbrirLog(listaMAP_RPM, arquivoCarregado);

		ObservableList<LinhaMapRpm> listaMAP_RPMTmp = FXCollections.observableArrayList();

		for (LinhaMapRpm linhaMapRpm : listaMAP_RPM) {
			listaMAP_RPMTmp.add(linhaMapRpm);
		}

		listaMAP_RPM.clear();
		listaMAP_RPM.addAll(listaMAP_RPMTmp);
		listaMAP_RPM_desc.clear();
		listaMAP_RPM_desc.addAll(listaMAP_RPMTmp);

		calcularCorrecaoRPM_Media();

	}

	@FXML
	public void trocarApresentacaoCor() {
		selecaoTabelaCor = comboApresentacaoGraficoRpmCor.getValue();
		ObservableList<LinhaMapRpm> listaMAP_RPMTmp = FXCollections.observableArrayList();

		for (LinhaMapRpm linhaMapRpm : listaMAP_RPM) {
			listaMAP_RPMTmp.add(linhaMapRpm);
		}

		listaMAP_RPM.clear();
		listaMAP_RPM.addAll(listaMAP_RPMTmp);
		listaMAP_RPM_desc.clear();
		listaMAP_RPM_desc.addAll(listaMAP_RPMTmp);

		configurarLegendaValoresTabelaRPM();

	}

	private void configurarLegendaValoresTabelaRPM() {
		ObservableList<Node> children = hboxSelecaoTabela.getChildren();
		List<Node> remover = new ArrayList<Node>();
		for (int i = 0; i < children.size(); i++) {
			if (children.get(i).getId() != null && children.get(i).getId().endsWith("_lengenda_cor")) {
				remover.add(children.get(i));
			}
		}

		for (Node no : remover) {
			children.remove(no);
		}

		ObservableList<Node> lblAdd = FXCollections.observableArrayList();

		switch (PaginaInicialAbaRPM.selecaoTabelaCor) {
		case CORRECAO:

			Label lbl7 = new Label();
			lbl7.setId("lbl7_lengenda_cor");
			lbl7.setText("-10%<");
			lbl7.setStyle("-fx-background-color:crimson;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lbl7);

			Label lbl6 = new Label();
			lbl6.setId("lbl6_lengenda_cor");
			lbl6.setText("-9%_-5%");
			lbl6.setStyle("-fx-background-color:orangered;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lbl6);

			Label lbl5 = new Label();
			lbl5.setId("lbl5_lengenda_cor");
			lbl5.setText("-4%_-2%");
			lbl5.setStyle("-fx-background-color:sandybrown;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lbl5);

			Label lbl1 = new Label();
			lbl1.setId("lbl1_lengenda_cor");
			lbl1.setText("-1%_1%");
			lbl1.setStyle("-fx-background-color:lightslategray;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lbl1);

			Label lbl2 = new Label();
			lbl2.setId("lbl2_lengenda_cor");
			lbl2.setText("2%_4%");
			lbl2.setStyle("-fx-background-color:limegreen;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lbl2);

			Label lbl3 = new Label();
			lbl3.setId("lbl3_lengenda_cor");
			lbl3.setText("5%_9%");
			lbl3.setStyle("-fx-background-color:greenyellow;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lbl3);

			Label lbl4 = new Label();
			lbl4.setId("lbl4_lengenda_cor");
			lbl4.setText(">10%");
			lbl4.setStyle("-fx-background-color:cyan;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lbl4);

			break;
		case QTD_AMOSTRAS:

			Label lblAmostra1 = new Label();
			lblAmostra1.setId("lblAmostra1_lengenda_cor");
			lblAmostra1.setText("0-5");
			lblAmostra1.setStyle("-fx-background-color:crimson;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAmostra1);

			Label lblAmostra2 = new Label();
			lblAmostra2.setId("lblAmostra2_lengenda_cor");
			lblAmostra2.setText("6-50");
			lblAmostra2.setStyle("-fx-background-color:sandybrown;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAmostra2);

			Label lblAmostra3 = new Label();
			lblAmostra3.setId("lblAmostra3_lengenda_cor");
			lblAmostra3.setText("51-100");
			lblAmostra3.setStyle("-fx-background-color:lightblue;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAmostra3);

			Label lblAmostra4 = new Label();
			lblAmostra4.setId("lblAmostra4_lengenda_cor");
			lblAmostra4.setText(">100");
			lblAmostra4.setStyle("-fx-background-color:royalblue;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAmostra4);

			break;

		case AUTO_CORRECAO:

			Label lblAutoCorrecao1 = new Label();
			lblAutoCorrecao1.setId("lblAutoCorrecao1_lengenda_cor");
			lblAutoCorrecao1.setText("-10%<");
			lblAutoCorrecao1.setStyle("-fx-background-color:crimson;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAutoCorrecao1);

			Label lblAutoCorrecao2 = new Label();
			lblAutoCorrecao2.setId("lblAutoCorrecao2_lengenda_cor");
			lblAutoCorrecao2.setText("-9%_-5%");
			lblAutoCorrecao2.setStyle("-fx-background-color:orangered;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAutoCorrecao2);

			Label lblAutoCorrecao3 = new Label();
			lblAutoCorrecao3.setId("lblAutoCorrecao3_lengenda_cor");
			lblAutoCorrecao3.setText("-4%_-2%");
			lblAutoCorrecao3.setStyle("-fx-background-color:sandybrown;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAutoCorrecao3);

			Label lblAutoCorrecao4 = new Label();
			lblAutoCorrecao4.setId("lblAutoCorrecao4_lengenda_cor");
			lblAutoCorrecao4.setText("-1%_1%");
			lblAutoCorrecao4.setStyle("-fx-background-color:lightslategray;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAutoCorrecao4);

			Label lblAutoCorrecao5 = new Label();
			lblAutoCorrecao5.setId("lblAutoCorrecao5_lengenda_cor");
			lblAutoCorrecao5.setText("2%_4%");
			lblAutoCorrecao5.setStyle("-fx-background-color:limegreen;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAutoCorrecao5);

			Label lblAutoCorrecao6 = new Label();
			lblAutoCorrecao6.setId("lblAutoCorrecao6_lengenda_cor");
			lblAutoCorrecao6.setText("5%_9%");
			lblAutoCorrecao6.setStyle("-fx-background-color:greenyellow;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAutoCorrecao6);

			Label lblAutoCorrecao7 = new Label();
			lblAutoCorrecao7.setId("lblAutoCorrecao7_lengenda_cor");
			lblAutoCorrecao7.setText(">10%");
			lblAutoCorrecao7.setStyle("-fx-background-color:cyan;-fx-font-weight:bold;-fx-font-size: 14pt;");
			lblAdd.add(lblAutoCorrecao7);

			break;

		default:
			break;
		}

		hboxSelecaoTabela.getChildren().addAll(lblAdd);
	}

	@FXML public void recarregarArquivoWOT() {
		tpsMinimo.setText("95");
		tpsMaximo.setText("100");
		doRecarregarArquivo();
		carregarAbaCorrecaoRpm();
		
	}

	private void carregarAbaCorrecaoRpm() {
		if (arquivoCarregado != null) {
			mapaRpmCorrecao = new HashMap<BigDecimal, RpmCorrecao>();
			carregarTabelaRpm(arquivoCarregado);
			calcularCorrecaoRPM_Media();
		}
	}


	

}
