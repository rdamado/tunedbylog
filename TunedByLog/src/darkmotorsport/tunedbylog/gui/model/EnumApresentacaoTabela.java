package darkmotorsport.tunedbylog.gui.model;

public enum EnumApresentacaoTabela {

	LAMBDA_MEDIA("Lambda M�dia"), CORRECAO("Percentual Corre��o"), LAMBDA_ALVO("Lambda Alvo"), 
	BANCADA_A_TI("Bancada A T.I. (mS)"), 
	//BANCADA_A_TI_CORRIGIDO("Bancada A T.I. (ms) Corrigido"), 
	AUTO_CORRECAO("Corre��o Sonda"); 
	//CORRECAO_RPM("Corre��o RPM") ;

	private String label;

	EnumApresentacaoTabela(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}

}
