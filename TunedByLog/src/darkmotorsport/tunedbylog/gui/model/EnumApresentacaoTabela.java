package darkmotorsport.tunedbylog.gui.model;

public enum EnumApresentacaoTabela {

	LAMBDA_MEDIA("Lambda Média"), CORRECAO("Percentual Correção"), LAMBDA_ALVO("Lambda Alvo"), 
	BANCADA_A_TI("Bancada A T.I. (mS)"), 
	//BANCADA_A_TI_CORRIGIDO("Bancada A T.I. (ms) Corrigido"), 
	AUTO_CORRECAO("Correção Sonda"); 
	//CORRECAO_RPM("Correção RPM") ;

	private String label;

	EnumApresentacaoTabela(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}

}
