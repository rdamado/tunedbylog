package darkmotorsport.tunedbylog.util;

import java.util.List;

import darkmotorsport.tunedbylog.xml.itens.DataCanal;

public class UtilData {

	public Float getValorCanal(List<DataCanal> listaDados, int posicao, int canal, FiltroCanal filtro) {

		if (canal == Constantes.SONDA_CORRECAO && !Constantes.IS_CORRRECAO_ATIVA) {
			return null;
		}

		float vlrTpsMinimo = Float.parseFloat(filtro.getStrTpsMinimo());
		float vlrTpsMaximo = Float.parseFloat(filtro.getStrTpsMaximo());
		float vlrTempMotorMinimo = Float.parseFloat(filtro.getStrTempMotorMinimo());
		float vlrTempMotorMaximo = Float.parseFloat(filtro.getStrTempMotorMaximo());
		float vlrSondaMinimo = Float.parseFloat(filtro.getStrSondaMinimo());
		float vlrSondaMaximo = Float.parseFloat(filtro.getStrSondaMaximo());

		Float vlrMapMinimo = null;
		Float vlrMapMaximo = null;

		if (filtro.getMapMinimo() != null) {
			vlrMapMinimo = Float.parseFloat(filtro.getMapMinimo());
		}

		if (filtro.getMapMinimo() != null) {
			vlrMapMaximo = Float.parseFloat(filtro.getMapMaximo());
		}

		Float valorSonda = null;

		boolean filtroOK = true;
		boolean flagTPS = true;
		boolean flagTempMotor = true;
		boolean flagMap = true;

		if (vlrMapMinimo == null || vlrMapMaximo == null) {
			flagMap = false;
		}

		for (int k = 0; k < listaDados.size(); k++) {
			if (flagTPS || flagTempMotor) {

				if (listaDados.get(k).getCanal().getId() == Constantes.TPS) {
					flagTPS = false;
					float valor = listaDados.get(k).getValores()[posicao];
					if (!(valor >= vlrTpsMinimo && valor <= vlrTpsMaximo)) {
						filtroOK = false;
					}
				}
				if (listaDados.get(k).getCanal().getId() == Constantes.TEMP_MOTOR) {
					flagTempMotor = false;
					float valor = listaDados.get(k).getValores()[posicao];
					if (!(valor >= vlrTempMotorMinimo && valor <= vlrTempMotorMaximo)) {
						filtroOK = false;
					}
				}

				if (listaDados.get(k).getCanal().getId() == Constantes.MAP && flagMap) {
					flagMap = false;
					float valor = listaDados.get(k).getValores()[posicao];
					if (!(valor >= vlrMapMinimo && valor <= vlrMapMaximo)) {
						filtroOK = false;
					}
				}

			}
		}

		boolean widebandFiltroOk = true;
		if (filtroOK) {
			for (int k = 0; k < listaDados.size(); k++) {
				if (listaDados.get(k).getCanal().getId() == Constantes.WIDEBAND) {
					valorSonda = listaDados.get(k).getValores()[Math.round(posicao)];
					if (!(valorSonda >= vlrSondaMinimo && valorSonda <= vlrSondaMaximo)) {
						widebandFiltroOk = false;
						valorSonda = null;
					}
				}
			}
		}

		if (canal == Constantes.WIDEBAND) {
			return valorSonda;
		}

		valorSonda = null;

		if (widebandFiltroOk && filtroOK) {
			for (int k = 0; k < listaDados.size(); k++) {
				if (listaDados.get(k).getCanal().getId() == canal) {
					valorSonda = listaDados.get(k).getValores()[Math.round(posicao)];
				}
			}
		}
		return valorSonda;
	}

}
