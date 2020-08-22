package darkmotorsport.tunedbylog.gui.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CelulaMapRpm {
	
	private BigDecimal map;
	private BigDecimal rpm;
	private BigDecimal sondaMedia;
	private BigDecimal correcao;
	private BigDecimal tempoInjecaoMedia;
	private BigDecimal tempoInjecaoMediaCorrigida;

	private BigDecimal tempoInjecaoComparadaAnterior;
	
	
	private BigDecimal sondaAlvo;
	private BigDecimal autoCorrecao;
	
	private BigDecimal valorTempAr;
	private BigDecimal valorPressaoComb;
	private BigDecimal valorPressaoOleo;
	private BigDecimal valorBateriaTensao;
	private BigDecimal valorTemperaturaMotor;

	
	
	private List<Float> valoresSonda = new ArrayList<Float>();
	private List<Float> tempoInjecao = new ArrayList<Float>();
	private List<Float> valoresAutoCorrecao = new ArrayList<Float>();
	
	private List<Float> valoresTempAr = new ArrayList<Float>();
	private List<Float> valoresPressaoComb = new ArrayList<Float>();
	private List<Float> valoresPressaoOleo = new ArrayList<Float>();
	private List<Float> valoresBateriaTensao = new ArrayList<Float>();
	private List<Float> valoresTemperaturaMotor = new ArrayList<Float>();
	
	
	public BigDecimal getMap() {
		return map;
	}
	public void setMap(BigDecimal map) {
		this.map = map;
	}
	public BigDecimal getRpm() {
		return rpm;
	}
	public void setRpm(BigDecimal rpm) {
		this.rpm = rpm;
	}
	public BigDecimal getSondaMedia() {
		return sondaMedia;
	}
	public void setSondaMedia(BigDecimal sondaMedia) {
		this.sondaMedia = sondaMedia;
	}
	public BigDecimal getCorrecao() {
		return correcao;
	}
	public void setCorrecao(BigDecimal correcao) {
		this.correcao = correcao;
	}
	public BigDecimal getTempoInjecaoMedia() {
		return tempoInjecaoMedia;
	}
	public void setTempoInjecaoMedia(BigDecimal tempoInjecaoMedia) {
		this.tempoInjecaoMedia = tempoInjecaoMedia;
	}
	public List<Float> getValoresSonda() {
		return valoresSonda;
	}
	public void setValoresSonda(List<Float> valoresSonda) {
		this.valoresSonda = valoresSonda;
	}
	public BigDecimal getSondaAlvo() {
		return sondaAlvo;
	}
	public void setSondaAlvo(BigDecimal sondaAlvo) {
		this.sondaAlvo = sondaAlvo;
	}
	public List<Float> getTempoInjecao() {
		return tempoInjecao;
	}
	public void setTempoInjecao(List<Float> tempoInjecao) {
		this.tempoInjecao = tempoInjecao;
	}
	public BigDecimal getTempoInjecaoMediaCorrigida() {
		return tempoInjecaoMediaCorrigida;
	}
	public void setTempoInjecaoMediaCorrigida(BigDecimal tempoInjecaoMediaCorrigida) {
		this.tempoInjecaoMediaCorrigida = tempoInjecaoMediaCorrigida;
	}
	public BigDecimal getAutoCorrecao() {
		return autoCorrecao;
	}
	public void setAutoCorrecao(BigDecimal autoCorrecao) {
		this.autoCorrecao = autoCorrecao;
	}
	public List<Float> getValoresAutoCorrecao() {
		return valoresAutoCorrecao;
	}
	public void setValoresAutoCorrecao(List<Float> valoresAutoCorrecao) {
		this.valoresAutoCorrecao = valoresAutoCorrecao;
	}
	public BigDecimal getValorTempAr() {
		return valorTempAr;
	}
	public void setValorTempAr(BigDecimal valorTempAr) {
		this.valorTempAr = valorTempAr;
	}
	public BigDecimal getValorPressaoComb() {
		return valorPressaoComb;
	}
	public void setValorPressaoComb(BigDecimal valorPressaoComb) {
		this.valorPressaoComb = valorPressaoComb;
	}
	public BigDecimal getValorPressaoOleo() {
		return valorPressaoOleo;
	}
	public void setValorPressaoOleo(BigDecimal valorPressaoOleo) {
		this.valorPressaoOleo = valorPressaoOleo;
	}
	public BigDecimal getValorBateriaTensao() {
		return valorBateriaTensao;
	}
	public void setValorBateriaTensao(BigDecimal valorBateriaTensao) {
		this.valorBateriaTensao = valorBateriaTensao;
	}
	public List<Float> getValoresTempAr() {
		return valoresTempAr;
	}
	public void setValoresTempAr(List<Float> valoresTempAr) {
		this.valoresTempAr = valoresTempAr;
	}
	public List<Float> getValoresPressaoComb() {
		return valoresPressaoComb;
	}
	public void setValoresPressaoComb(List<Float> valoresPressaoComb) {
		this.valoresPressaoComb = valoresPressaoComb;
	}
	public List<Float> getValoresPressaoOleo() {
		return valoresPressaoOleo;
	}
	public void setValoresPressaoOleo(List<Float> valoresPressaoOleo) {
		this.valoresPressaoOleo = valoresPressaoOleo;
	}
	public List<Float> getValoresBateriaTensao() {
		return valoresBateriaTensao;
	}
	public void setValoresBateriaTensao(List<Float> valoresBateriaTensao) {
		this.valoresBateriaTensao = valoresBateriaTensao;
	}
	public BigDecimal getValorTemperaturaMotor() {
		return valorTemperaturaMotor;
	}
	public void setValorTemperaturaMotor(BigDecimal valorTemperaturaMotor) {
		this.valorTemperaturaMotor = valorTemperaturaMotor;
	}
	public List<Float> getValoresTemperaturaMotor() {
		return valoresTemperaturaMotor;
	}
	public void setValoresTemperaturaMotor(List<Float> valoresTemperaturaMotor) {
		this.valoresTemperaturaMotor = valoresTemperaturaMotor;
	}
	public BigDecimal getTempoInjecaoComparadaAnterior() {
		return tempoInjecaoComparadaAnterior;
	}
	public void setTempoInjecaoComparadaAnterior(BigDecimal tempoInjecaoComparadaAnterior) {
		this.tempoInjecaoComparadaAnterior = tempoInjecaoComparadaAnterior;
	}
	
	
	
	

}
