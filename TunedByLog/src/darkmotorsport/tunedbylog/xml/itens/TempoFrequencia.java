package darkmotorsport.tunedbylog.xml.itens;

import java.math.BigDecimal;

public class TempoFrequencia {
	private int frequencia;
	private int posicaoMax;
	private float[] tempos;
	private float fracaoTempo;
	private float tempoLargada = 0.0f;

	public TempoFrequencia(int frequencia, int posicaoMax) {
		this.frequencia = frequencia;
		this.posicaoMax = posicaoMax;
		this.calcularFracaoTempo();
		this.calcularTempo();
	}

	private void calcularFracaoTempo() {
		if (this.frequencia == 0) {
			return;
		}
		float fracaoTempoCalculada = 1.0f / (float) this.frequencia;
		this.fracaoTempo = new BigDecimal(fracaoTempoCalculada).setScale(2, 4).floatValue();
	}

	private void calcularTempo() {
		this.tempos = new float[this.posicaoMax];
		for (int i = 0; i < this.posicaoMax; ++i) {
			float tempoCalculado = this.fracaoTempo * (float) i - this.tempoLargada;
			this.tempos[i] = tempoCalculado = new BigDecimal(tempoCalculado).setScale(2, 4).floatValue();
		}
	}

	public int getPosicaoByTempo(float tempo) {
		tempo = new BigDecimal(tempo).setScale(2, 4).floatValue();
		int posicao = -1;
		for (int i = 0; i < this.tempos.length; ++i) {
			if (this.tempos[i] > tempo || i != this.tempos.length - 1 && this.tempos[i + 1] <= tempo)
				continue;
			posicao = i;
			break;
		}
		return posicao;
	}

	public int getFrequencia() {
		return this.frequencia;
	}

	public int getPosicaoMax() {
		return this.posicaoMax;
	}

	public float[] getTempos() {
		return this.tempos;
	}

	public float getFracaoTempo() {
		return this.fracaoTempo;
	}

	public float getTempoLargada() {
		return this.tempoLargada;
	}

	public void setTempoLargada(float tempoLargada) {
		this.tempoLargada = tempoLargada;
		this.calcularTempo();
	}
}
