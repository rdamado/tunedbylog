package darkmotorsport.tunedbylog.gui.model;

public enum EnumApresentacaoTabelaCor {

	QTD_AMOSTRAS("Quantidade de Amostras"), CORRECAO("Perc. Corre��o"), AUTO_CORRECAO("Corre��o Sonda");

	private String label;

	EnumApresentacaoTabelaCor(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}

}
