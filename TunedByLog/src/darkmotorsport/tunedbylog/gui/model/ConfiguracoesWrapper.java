package darkmotorsport.tunedbylog.gui.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "configuracao")
public class ConfiguracoesWrapper {

	private DadoTabelaMap lambdaAlvo;
	private DadoTabelaMap mapaMs;
	private DadoTabelaMap mapaMsCorrigidoEditado;

	private String tpsMinimo;
	private String tpsMaximo;
	private String tempMotorMinimo;
	private String tempMotorMaximo;
	private String precisaoMap;
	private String sondaMinimo;
	private String sondaMaximo;

	private String percTruncada;
	private Boolean truncada;

	@XmlElement(name = "lambdaAlvo")
	public DadoTabelaMap getLambdaAlvo() {
		return lambdaAlvo;
	}

	public void setLambdaAlvo(DadoTabelaMap lambdaAlvo) {
		this.lambdaAlvo = lambdaAlvo;
	}

	@XmlElement(name = "mapaMs")
	public DadoTabelaMap getMapaMs() {
		return mapaMs;
	}

	public void setMapaMs(DadoTabelaMap mapaMs) {
		this.mapaMs = mapaMs;
	}

	@XmlElement(name = "mapaMsCorrigidoEditado")
	public DadoTabelaMap getMapaMsCorrigidoEditado() {
		return mapaMsCorrigidoEditado;
	}

	public void setMapaMsCorrigidoEditado(DadoTabelaMap mapaMsCorrigidoEditado) {
		this.mapaMsCorrigidoEditado = mapaMsCorrigidoEditado;
	}

	@XmlElement(name = "tpsMinimo")
	public String getTpsMinimo() {
		return tpsMinimo;
	}

	public void setTpsMinimo(String tpsMinimo) {
		this.tpsMinimo = tpsMinimo;
	}

	@XmlElement(name = "tpsMaximo")
	public String getTpsMaximo() {
		return tpsMaximo;
	}

	public void setTpsMaximo(String tpsMaximo) {
		this.tpsMaximo = tpsMaximo;
	}

	@XmlElement(name = "tempMotorMinimo")
	public String getTempMotorMinimo() {
		return tempMotorMinimo;
	}

	public void setTempMotorMinimo(String tempMotorMinimo) {
		this.tempMotorMinimo = tempMotorMinimo;
	}

	@XmlElement(name = "tempMotorMaximo")
	public String getTempMotorMaximo() {
		return tempMotorMaximo;
	}

	public void setTempMotorMaximo(String tempMotorMaximo) {
		this.tempMotorMaximo = tempMotorMaximo;
	}

	@XmlElement(name = "precisaoMap")
	public String getPrecisaoMap() {
		return precisaoMap;
	}

	public void setPrecisaoMap(String precisaoMap) {
		this.precisaoMap = precisaoMap;
	}

	@XmlElement(name = "sondaMinimo")
	public String getSondaMinimo() {
		return sondaMinimo;
	}

	public void setSondaMinimo(String sondaMinimo) {
		this.sondaMinimo = sondaMinimo;
	}

	@XmlElement(name = "sondaMaximo")
	public String getSondaMaximo() {
		return sondaMaximo;
	}

	public void setSondaMaximo(String sondaMaximo) {
		this.sondaMaximo = sondaMaximo;
	}

	@XmlElement(name = "percTruncada")
	public String getPercTruncada() {
		return percTruncada;
	}

	public void setPercTruncada(String percTruncada) {
		this.percTruncada = percTruncada;
	}

	@XmlElement(name = "truncada")
	public Boolean getTruncada() {
		return truncada;
	}

	public void setTruncada(Boolean truncada) {
		this.truncada = truncada;
	}

}