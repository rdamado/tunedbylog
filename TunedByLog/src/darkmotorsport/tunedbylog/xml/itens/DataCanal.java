package darkmotorsport.tunedbylog.xml.itens;

import java.text.DecimalFormat;
import java.util.Arrays;

public class DataCanal {
	private Canal canal;
	private float[] valores;
	private boolean visivel = true;
	private boolean selecionado = false;
	private float valorAtual;
	private float valorMin;
	private float valorMax;
	private int posicaoValorMin;
	private int posicaoValorMax;

	public DataCanal() {
		super();
	}

	public DataCanal(Canal canal, float[] valores) {
		this.canal = canal;
		this.valores = valores;
		this.processarMinMax();
	}

	private void processarMinMax() {
		if (this.valores == null) {
			return;
		}
		this.valorMin = Float.MAX_VALUE;
		this.valorMax = Float.MIN_VALUE;
		for (int i = 0; i < this.valores.length; ++i) {
			float valor = this.valores[i];
			if (valor > this.valorMax) {
				this.valorMax = valor;
				this.posicaoValorMax = i;
			}
			if (valor >= this.valorMin)
				continue;
			this.valorMin = valor;
			this.posicaoValorMin = i;
		}
	}

	public void cortarParaFrente(int posicao) {
		this.valores = Arrays.copyOfRange(this.valores, 0, posicao + 1);
		this.processarMinMax();
	}

	public void cortarParaTras(int posicao) {
		this.valores = Arrays.copyOfRange(this.valores, posicao, this.valores.length);
		this.processarMinMax();
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public Canal getCanal() {
		return this.canal;
	}

	public float[] getValores() {
		return this.valores;
	}

	public boolean isVisivel() {
		return this.visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public boolean isSelecionado() {
		return this.selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public float getValorAtual() {
		return this.valorAtual;
	}

	public void setValorAtual(float valorAtual) {
		this.valorAtual = valorAtual;
	}

	public float getValorMin() {
		return this.valorMin;
	}

	public float getValorMax() {
		return this.valorMax;
	}

	public int getPosicaoValorMin() {
		return this.posicaoValorMin;
	}

	public int getPosicaoValorMax() {
		return this.posicaoValorMax;
	}

	public String getValorFormatado(int posicao) {
		if (posicao >= this.valores.length || posicao == -1) {
			return "";
		}
		DecimalFormat decimalFormat = new DecimalFormat(this.canal.getFormato());
		return decimalFormat.format(this.valores[posicao]);
	}
}
