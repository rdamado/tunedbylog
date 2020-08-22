package darkmotorsport.tunedbylog.gui.model;

public enum EnumApresentacaoTabelaCor {

	QTD_AMOSTRAS("Quantidade de Amostras"), CORRECAO("Perc. Correção"), AUTO_CORRECAO("Correção Sonda");

	private String label;

	EnumApresentacaoTabelaCor(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}

}
