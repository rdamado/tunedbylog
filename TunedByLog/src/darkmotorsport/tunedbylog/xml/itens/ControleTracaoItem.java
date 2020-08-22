package darkmotorsport.tunedbylog.xml.itens;

public class ControleTracaoItem {
	private float tempo;
	private int rpm;

	public ControleTracaoItem() {
	}

	public ControleTracaoItem(float tempo, int rpm) {
		this.tempo = tempo;
		this.rpm = rpm;
	}

	public float getTempo() {
		return this.tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	public int getRpm() {
		return this.rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
}
