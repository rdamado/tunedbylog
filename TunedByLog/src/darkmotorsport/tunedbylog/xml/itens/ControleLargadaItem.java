package darkmotorsport.tunedbylog.xml.itens;

public class ControleLargadaItem {
	private float tempo;
	private int velocidade;
	private int rpm;

	public ControleLargadaItem() {
	}

	public ControleLargadaItem(float tempo, int rpm) {
		this.tempo = tempo;
		this.rpm = rpm;
	}

	public ControleLargadaItem(float tempo, int velocidade, int rpm) {
		this.tempo = tempo;
		this.velocidade = velocidade;
		this.rpm = rpm;
	}

	public float getTempo() {
		return this.tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	public int getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getRpm() {
		return this.rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
}
