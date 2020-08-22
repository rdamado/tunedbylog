package darkmotorsport.tunedbylog.gui.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RpmCorrecao {

	private BigDecimal rpm;
	private List<BigDecimal> valores;

	public BigDecimal getRpm() {
		return rpm;
	}

	public void setRpm(BigDecimal rpm) {
		this.rpm = rpm;
	}

	public List<BigDecimal> getValores() {
		if (valores == null) {
			valores = new ArrayList<BigDecimal>();
		}
		return valores;
	}

	public void setValores(List<BigDecimal> valores) {
		this.valores = valores;
	}

}
