package darkmotorsport.tunedbylog.xml.itens;

import java.util.List;

public class LogArquivo {

	private String versao;
	private LogInformacao informacao;
	private Tag[] tags;
	private boolean acompanharPonteiro = true;
	private String tipoControle;
	private boolean controleLargadaHabilitado;
	private List<ControleLargadaItem> controleLargada;
	private List<ControleTracaoMarcha> controleTracao;
	private List<LogArquivoCanal> canais;
	private String controleLargadaModo;
	private String mapa;
	private String chave;

	private String mapaPowerGrip;

	public String getControleLargadaModo() {
		return this.controleLargadaModo;
	}

	public void setControleLargadaModo(String controleLargadaModo) {
		this.controleLargadaModo = controleLargadaModo;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public LogInformacao getInformacao() {
		return this.informacao;
	}

	public void setInformacao(LogInformacao informacao) {
		this.informacao = informacao;
	}

	public Tag[] getTags() {
		return this.tags;
	}

	public void setTags(Tag[] tags) {
		this.tags = tags;
	}

	public boolean isAcompanharPonteiro() {
		return this.acompanharPonteiro;
	}

	public void setAcompanharPonteiro(boolean acompanharPonteiro) {
		this.acompanharPonteiro = acompanharPonteiro;
	}

	public String getTipoControle() {
		return this.tipoControle;
	}

	public void setTipoControle(String tipoControle) {
		this.tipoControle = tipoControle;
	}

	public boolean isControleLargadaHabilitado() {
		return this.controleLargadaHabilitado;
	}

	public void setControleLargadaHabilitado(boolean controleLargadaHabilitado) {
		this.controleLargadaHabilitado = controleLargadaHabilitado;
	}

	public List<ControleLargadaItem> getControleLargada() {
		return this.controleLargada;
	}

	public void setControleLargada(List<ControleLargadaItem> controleLargada) {
		this.controleLargada = controleLargada;
	}

	public List<ControleTracaoMarcha> getControleTracao() {
		return this.controleTracao;
	}

	public void setControleTracao(List<ControleTracaoMarcha> controleTracao) {
		this.controleTracao = controleTracao;
	}

	public List<LogArquivoCanal> getCanais() {
		return this.canais;
	}

	public void setCanais(List<LogArquivoCanal> canais) {
		this.canais = canais;
	}

	public String getMapa() {
		return this.mapa;
	}

	public void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getMapaPowerGrip() {
		return this.mapaPowerGrip;
	}

	public void setMapaPowerGrip(String mapaPowerGrip) {
		this.mapaPowerGrip = mapaPowerGrip;
	}

	public String getChave() {
		return this.chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}
}
