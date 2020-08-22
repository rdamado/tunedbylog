package darkmotorsport.tunedbylog.xml.itens;

public class LogInformacao {
	private int idLog;
	private String nomeLog;
	private float pontoInicial;
	private float pontoFinal;
	private String dataDownload;
	private int modeloEcu;
	private String numSerieEcu;
	private String evento;
	private String piloto;
	private String dataEvento;
	private String preparador;
	private String observacao;
	private int frequencia;

	public int getIdLog() {
		return this.idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public String getNomeLog() {
		return this.nomeLog;
	}

	public void setNomeLog(String nomeLog) {
		this.nomeLog = nomeLog;
	}

	public float getPontoInicial() {
		return this.pontoInicial;
	}

	public void setPontoInicial(float pontoInicial) {
		this.pontoInicial = pontoInicial;
	}

	public float getPontoFinal() {
		return this.pontoFinal;
	}

	public void setPontoFinal(float pontoFinal) {
		this.pontoFinal = pontoFinal;
	}

	public String getDataDownload() {
		return this.dataDownload;
	}

	public void setDataDownload(String dataDownload) {
		this.dataDownload = dataDownload;
	}

	public int getModeloEcu() {
		return this.modeloEcu;
	}

	public void setModeloEcu(int modeloEcu) {
		this.modeloEcu = modeloEcu;
	}

	public String getNumSerieEcu() {
		return this.numSerieEcu;
	}

	public void setNumSerieEcu(String numSerieEcu) {
		this.numSerieEcu = numSerieEcu;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getPiloto() {
		return this.piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getDataEvento() {
		return this.dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getPreparador() {
		return this.preparador;
	}

	public void setPreparador(String preparador) {
		this.preparador = preparador;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getFrequencia() {
		return this.frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
}
