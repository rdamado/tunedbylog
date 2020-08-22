package darkmotorsport.tunedbylog.gui.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LinhaMapRpm {

	BigDecimal map;
	BigDecimal mapLambdaMedia;
	BigDecimal mapCorrecaoMedia;
	BigDecimal mapLambdaAlvo;
	
	List<CelulaMapRpm> listaCelulas = new ArrayList<CelulaMapRpm>();

	public BigDecimal getMap() {
		return map;
	}

	public void setMap(BigDecimal map) {
		this.map = map;
	}

	public List<CelulaMapRpm> getListaCelulas() {
		return listaCelulas;
	}

	public void setListaCelulas(List<CelulaMapRpm> listaCelulas) {
		this.listaCelulas = listaCelulas;
	}

	public BigDecimal getMapCorrecaoMedia() {
		return mapCorrecaoMedia;
	}

	public void setMapCorrecaoMedia(BigDecimal mapCorrecaoMedia) {
		this.mapCorrecaoMedia = mapCorrecaoMedia;
	}

	public BigDecimal getMapLambdaMedia() {
		return mapLambdaMedia;
	}

	public void setMapLambdaMedia(BigDecimal mapLambdaMedia) {
		this.mapLambdaMedia = mapLambdaMedia;
	}

	public BigDecimal getMapLambdaAlvo() {
		return mapLambdaAlvo;
	}

	public void setMapLambdaAlvo(BigDecimal mapLambdaAlvo) {
		this.mapLambdaAlvo = mapLambdaAlvo;
	}
	
	


}
