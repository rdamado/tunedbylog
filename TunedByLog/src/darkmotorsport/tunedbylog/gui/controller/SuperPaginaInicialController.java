package darkmotorsport.tunedbylog.gui.controller;

import java.util.ArrayList;
import java.util.List;

import darkmotorsport.tunedbylog.gui.model.DadoTabelaMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class SuperPaginaInicialController {

	protected static final int POSICAO_SONDA_MEDIA = 6;
	protected static final int POSICAO_CORRECAO_MEDIA = 5;
	protected static final int POSICAO_QTD_AMOSTRAS = 7;
//	protected static final int POSICAO_SONDA_MEDIA = 5;
//	protected static final int POSICAO_QTD_AMOSTRAS = ;

	
	@FXML
	protected TableView<DadoTabelaMap> tabelaMapDesc;
	@FXML
	protected TableView<DadoTabelaMap> tabelaMap;
	@FXML
	protected TableColumn<DadoTabelaMap, String> descricaoLinha;
	@FXML
	protected TableColumn<DadoTabelaMap, String> descricaoLinhaDesc;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_90;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_85;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_80;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_75;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_70;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_65;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_60;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_55;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_50;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_45;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_40;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_35;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_30;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_25;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_20;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_15;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_10;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_m_0_05;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_00;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_05;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_10;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_20;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_30;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_40;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_50;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_60;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_70;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_80;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_0_90;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_00;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_10;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_20;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_30;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_40;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_50;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_60;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_70;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_80;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_1_90;
	@FXML
	protected TableColumn<DadoTabelaMap, String> map_2_00;
	public TextField tpsMinimo;
	public TextField tpsMaximo;
	public TextField tempMotorMinimo;
	public TextField tempMotorMaximo;
	public TextField precisaoMap;
	public TextField sondaMinimo;
	public TextField sondaMaximo;
	protected FileChooser fileChooser = new FileChooser();
	List<Float> listaPosicao_map_m_0_90 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_85 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_80 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_75 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_70 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_65 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_60 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_55 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_50 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_45 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_40 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_35 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_30 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_25 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_20 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_15 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_10 = new ArrayList<Float>();
	List<Float> listaPosicao_map_m_0_05 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_00 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_05 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_10 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_20 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_30 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_40 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_50 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_60 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_70 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_80 = new ArrayList<Float>();
	List<Float> listaPosicao_map_0_90 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_00 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_10 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_20 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_30 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_40 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_50 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_60 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_70 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_80 = new ArrayList<Float>();
	List<Float> listaPosicao_map_1_90 = new ArrayList<Float>();
	List<Float> listaPosicao_map_2_00 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_90 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_85 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_80 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_75 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_70 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_65 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_60 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_55 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_50 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_45 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_40 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_35 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_30 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_25 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_20 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_15 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_10 = new ArrayList<Float>();
	protected List<Float> wideMap_map_m_0_05 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_00 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_05 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_10 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_20 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_30 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_40 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_50 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_60 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_70 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_80 = new ArrayList<Float>();
	protected List<Float> wideMap_map_0_90 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_00 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_10 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_20 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_30 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_40 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_50 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_60 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_70 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_80 = new ArrayList<Float>();
	protected List<Float> wideMap_map_1_90 = new ArrayList<Float>();
	protected List<Float> wideMap_map_2_00 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_90 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_85 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_80 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_75 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_70 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_65 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_60 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_55 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_50 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_45 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_40 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_35 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_30 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_25 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_20 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_15 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_10 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_m_0_05 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_00 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_05 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_10 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_20 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_30 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_40 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_50 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_60 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_70 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_80 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_0_90 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_00 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_10 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_20 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_30 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_40 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_50 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_60 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_70 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_80 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_1_90 = new ArrayList<Float>();
	protected List<Float> correcaoSondaMap_map_2_00 = new ArrayList<Float>();
	protected static float MAP_m_0_90 = -0.90f;
	protected static float MAP_m_0_85 = -0.85f;
	protected static float MAP_m_0_80 = -0.80f;
	protected static float MAP_m_0_75 = -0.75f;
	protected static float MAP_m_0_70 = -0.70f;
	protected static float MAP_m_0_65 = -0.65f;
	protected static float MAP_m_0_60 = -0.60f;
	protected static float MAP_m_0_55 = -0.55f;
	protected static float MAP_m_0_50 = -0.50f;
	protected static float MAP_m_0_45 = -0.45f;
	protected static float MAP_m_0_40 = -0.40f;
	protected static float MAP_m_0_35 = -0.35f;
	protected static float MAP_m_0_30 = -0.30f;
	protected static float MAP_m_0_25 = -0.25f;
	protected static float MAP_m_0_20 = -0.20f;
	protected static float MAP_m_0_15 = -0.15f;
	protected static float MAP_m_0_10 = -0.10f;
	protected static float MAP_m_0_05 = -0.05f;
	protected static float MAP_0_00 = 0.00f;
	protected static float MAP_0_05 = 0.05f;
	protected static float MAP_0_10 = 0.10f;
	protected static float MAP_0_20 = 0.20f;
	protected static float MAP_0_30 = 0.30f;
	protected static float MAP_0_40 = 0.40f;
	protected static float MAP_0_50 = 0.50f;
	protected static float MAP_0_60 = 0.60f;
	protected static float MAP_0_70 = 0.70f;
	protected static float MAP_0_80 = 0.80f;
	protected static float MAP_0_90 = 0.90f;
	protected static float MAP_1_00 = 1.00f;
	protected static float MAP_1_10 = 1.10f;
	protected static float MAP_1_20 = 1.20f;
	protected static float MAP_1_30 = 1.30f;
	protected static float MAP_1_40 = 1.40f;
	protected static float MAP_1_50 = 1.50f;
	protected static float MAP_1_60 = 1.60f;
	protected static float MAP_1_70 = 1.70f;
	protected static float MAP_1_80 = 1.80f;
	protected static float MAP_1_90 = 1.90f;
	protected static float MAP_2_00 = 2.00f;

//	private Map<Float, BigDecimal> mapaValorMedio = new HashMap<Float, BigDecimal>();
	protected DadoTabelaMap sondaMedia = new DadoTabelaMap("Sonda Média", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
	protected DadoTabelaMap qtdAmostras = new DadoTabelaMap("Qtd Amostras", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
	protected DadoTabelaMap lambdaAlvo = new DadoTabelaMap();
	protected DadoTabelaMap mapaMsCorrigido = new DadoTabelaMap("Corrigido(mS)", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
	protected DadoTabelaMap mapaMs = new DadoTabelaMap("Mapa(mS)", "0.206", "0.209", "0.209", "0.293", "0.419", "0.560",
			"0.774", "1.003", "1.206", "1.493", "1.741", "2.005", "2.269", "2.562", "2.856", "3.150", "3.446", "3.776",
			"4.068", "4.364", "4.734", "5.189", "5.773", "6.348", "7.017", "8.874", "10.730", "11.385", "12.165",
			"12.782", "13.487", "14.132", "15.000", "15.866", "16.662", "17.286", "18.053", "18.896", "18.896",
			"18.896");
	protected DadoTabelaMap mapaMsCorrigidoEditado = new DadoTabelaMap("Editável(mS)", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
	protected DadoTabelaMap correcaoLinha = new DadoTabelaMap("Correção", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
			"-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
	protected DadoTabelaMap correcaoSondaLinha = getCorrecaoSondaLinhaInicial();

	protected DadoTabelaMap getCorrecaoSondaLinhaInicial() {
		return new DadoTabelaMap("Correção Sonda", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
				"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
				"-", "-", "-", "-", "-");
	}
	
	
	
	protected DadoTabelaMap desc_sondaMediaDesc = new DadoTabelaMap("Sonda Média");
	protected DadoTabelaMap desc_qtdAmostras = new DadoTabelaMap("Qtd Amostras");
	protected DadoTabelaMap desc_lambdaAlvo = new DadoTabelaMap("LabdaAlvo");
	protected DadoTabelaMap desc_mapaMsCorrigido = new DadoTabelaMap("Corrigido(mS)");
	protected DadoTabelaMap desc_mapaMs = new DadoTabelaMap("Mapa(mS)");
	protected DadoTabelaMap desc_mapaMsCorrigidoEditado = new DadoTabelaMap("Editável(mS)");
	protected DadoTabelaMap desc_correcaoLinha = new DadoTabelaMap("Correção");
	protected DadoTabelaMap desc_correcaoSondaLinha =  new DadoTabelaMap("Correção Sonda");
	

	public ObservableList<DadoTabelaMap> listaMapDesc = FXCollections.observableArrayList();
	public ObservableList<DadoTabelaMap> listaMap = FXCollections.observableArrayList();
	@FXML
	private Button btnAbrirLog;
	@FXML
	private Button btnCorrigirMapa;
	@FXML
	public CheckBox checkboxTruncar;
	@FXML
	public TextField percTruncada;
	@FXML
	protected Label lblCaminhoArquivo;
	@FXML
	protected LineChart<String, Number> lineChartInjecao;

//	protected Map<Float, BigDecimal> getMapaValorMedio() {
//		mapaValorMedio.put(MAP_m_0_90, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_85, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_80, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_75, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_70, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_65, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_60, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_55, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_50, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_45, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_40, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_35, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_30, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_25, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_20, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_15, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_10, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_m_0_05, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_00, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_10, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_20, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_30, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_40, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_50, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_60, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_70, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_80, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_0_90, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_00, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_10, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_20, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_30, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_40, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_50, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_60, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_70, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_80, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_1_90, BigDecimal.valueOf(0L));
//		mapaValorMedio.put(MAP_2_00, BigDecimal.valueOf(0L));
//		return mapaValorMedio;
//	}

	protected List<Float> getListaMap() {
		List<Float> lista = new ArrayList<Float>();
		lista.add(-0.90f);
		lista.add(-0.85f);
		lista.add(-0.80f);
		lista.add(-0.75f);
		lista.add(-0.70f);
		lista.add(-0.65f);
		lista.add(-0.60f);
		lista.add(-0.55f);
		lista.add(-0.50f);
		lista.add(-0.45f);
		lista.add(-0.40f);
		lista.add(-0.35f);
		lista.add(-0.30f);
		lista.add(-0.25f);
		lista.add(-0.20f);
		lista.add(-0.15f);
		lista.add(-0.10f);
		lista.add(-0.05f);
		lista.add(0.00f);
		lista.add(0.05f);
		lista.add(0.10f);
		lista.add(0.20f);
		lista.add(0.30f);
		lista.add(0.40f);
		lista.add(0.50f);
		lista.add(0.60f);
		lista.add(0.70f);
		lista.add(0.80f);
		lista.add(0.90f);
		lista.add(1.00f);
		lista.add(1.10f);
		lista.add(1.20f);
		lista.add(1.30f);
		lista.add(1.40f);
		lista.add(1.50f);
		lista.add(1.60f);
		lista.add(1.70f);
		lista.add(1.80f);
		lista.add(1.90f);
		lista.add(2.00f);

		return lista;

	}

	public SuperPaginaInicialController() {
		super();
	}

}