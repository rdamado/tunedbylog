package darkmotorsport.tunedbylog.xml.itens;

import java.awt.Color;

public class Canal {
	private int id;
	private boolean habilitado = true;
	private String descricao = "Canal";
	private String unidadeMedida = "";
	private Color cor = Color.BLACK;
	private String formato = "#,##0.#";
	private float espessuraLinha = 1.0f;
	private boolean valorInteiro = false;
	private float rangeMin;
	private float rangeMax;
	private boolean autoRangeMin = true;
	private boolean autoRangeMax = true;
	private float fatorMin = 0.0f;
	private float fatorMax = 0.0f;
	private Float desconectado = null;

	public Canal() {
	}

	public Canal(int id, boolean habilitado, String descricao, String unidadeMedida, String formato, Color cor,
			float espessuraLinha, boolean valorInteiro, float rangeMin, float rangeMax, boolean autoRangeMin,
			boolean autoRangeMax, float fatorMin, float fatorMax, Float desconectado) {
		this.id = id;
		this.habilitado = habilitado;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.formato = formato;
		this.cor = cor;
		this.espessuraLinha = espessuraLinha;
		this.valorInteiro = valorInteiro;
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.autoRangeMin = autoRangeMin;
		this.autoRangeMax = autoRangeMax;
		this.fatorMin = fatorMin;
		this.fatorMax = fatorMax;
		this.desconectado = desconectado;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeMedida() {
		return this.unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Color getCor() {
		return this.cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public String getFormato() {
		return this.formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public float getEspessuraLinha() {
		return this.espessuraLinha;
	}

	public void setEspessuraLinha(float espessuraLinha) {
		this.espessuraLinha = espessuraLinha;
	}

	public boolean isValorInteiro() {
		return this.valorInteiro;
	}

	public void setValorInteiro(boolean valorInteiro) {
		this.valorInteiro = valorInteiro;
	}

	public float getRangeMin() {
		return this.rangeMin;
	}

	public void setRangeMin(float rangeMin) {
		this.rangeMin = rangeMin;
	}

	public float getRangeMax() {
		return this.rangeMax;
	}

	public void setRangeMax(float rangeMax) {
		this.rangeMax = rangeMax;
	}

	public boolean isAutoRangeMin() {
		return this.autoRangeMin;
	}

	public void setAutoRangeMin(boolean autoRangeMin) {
		this.autoRangeMin = autoRangeMin;
	}

	public boolean isAutoRangeMax() {
		return this.autoRangeMax;
	}

	public void setAutoRangeMax(boolean autoRangeMax) {
		this.autoRangeMax = autoRangeMax;
	}

	public float getFatorMin() {
		return this.fatorMin;
	}

	public void setFatorMin(float fatorMin) {
		this.fatorMin = fatorMin;
	}

	public float getFatorMax() {
		return this.fatorMax;
	}

	public void setFatorMax(float fatorMax) {
		this.fatorMax = fatorMax;
	}

	public Float getDesconectado() {
		return this.desconectado;
	}

	public void setDesconectado(Float desconectado) {
		this.desconectado = desconectado;
	}

	public String toString() {
		return this.descricao;
	}
}
