package sandbox.mapa;

public class MapaFormato {
	private static final byte ZERO = 125;
	private String nome;
	private ModeloECU modeloECU = ModeloECU.BOX_INJECT;
	private byte[] mapa = new byte[2048];
	private byte[] sondaLearn;
	private int versaoMapa = 28;
	private byte[] numSerieOrigem = new byte[4];

	public MapaFormato() {
		this.sondaLearn = getSondaLearnPadrao();
	}

	private static byte[] getSondaLearnPadrao() {
		byte[] m = new byte[256];
		for (int i = 0; i < m.length; i++) {
			m[i] = 125;
		}

		return m;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ModeloECU getModeloECU() {
		return this.modeloECU;
	}

	public void setModeloECU(ModeloECU modeloECU) {
		this.modeloECU = modeloECU;
	}

	public byte[] getMapa() {
		return this.mapa;
	}

	public void setMapa(byte[] mapa) {
		this.mapa = mapa;
	}

	public byte[] getSondaLearn() {
		return this.sondaLearn;
	}

	public void setSondaLearn(byte[] sondaLearn) {
		this.sondaLearn = sondaLearn;
	}

	public int getVersaoMapa() {
		return this.versaoMapa;
	}

	public void setVersaoMapa(int versaoMapa) {
		this.versaoMapa = versaoMapa;
	}

	public byte[] getNumSerieOrigem() {
		return this.numSerieOrigem;
	}

	public void setNumSerieOrigem(byte[] numSerieOrigem) {
		this.numSerieOrigem = numSerieOrigem;
	}
}
