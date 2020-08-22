/*
 */
package darkmotorsport.tunedbylog.xml.itens;

import java.util.ArrayList;
import java.util.List;

public class ControleTracaoMarcha  {
	private int marcha;
	private boolean habilitado;
	private float tempoGap;
	private List<ControleTracaoItem> itens = new ArrayList<ControleTracaoItem>();

	public int getMarcha() {
		return this.marcha;
	}

	public void setMarcha(int marcha) {
		this.marcha = marcha;
	}

	public boolean isHabilitado() {
		return this.habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public float getTempoGap() {
		return this.tempoGap;
	}

	public void setTempoGap(float tempoGap) {
		this.tempoGap = tempoGap;
	}

	public List<ControleTracaoItem> getItens() {
		return this.itens;
	}

	public void setItens(List<ControleTracaoItem> itens) {
		this.itens = itens;
	}
}
