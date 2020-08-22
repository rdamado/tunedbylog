package darkmotorsport.tunedbylog.gui.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import darkmotorsport.tunedbylog.gui.calc.Calculador;
import darkmotorsport.tunedbylog.gui.controller.PaginaInicialAbaRPM;
import darkmotorsport.tunedbylog.util.Constantes;
import darkmotorsport.tunedbylog.util.FiltroCanal;
import darkmotorsport.tunedbylog.util.UtilData;
import darkmotorsport.tunedbylog.xml.itens.DataCanal;
import darkmotorsport.tunedbylog.xml.itens.Log;

public class CalculadorMapRpm {

	public void setValorCelula(List<LinhaMapRpm> linhas, BigDecimal map, BigDecimal rpm, BigDecimal sondaMedia, BigDecimal correcao, BigDecimal tempoInjecaoMedia) {

		for (LinhaMapRpm linha : linhas) {
			BigDecimal map2 = linha.getMap();
			if (map2.compareTo(map) == 0) {
				List<CelulaMapRpm> listaCelulas = linha.getListaCelulas();
				for (CelulaMapRpm celula : listaCelulas) {
					BigDecimal rpm2 = celula.getRpm();
					if (rpm.compareTo(rpm2) == 0) {
						celula.setSondaMedia(sondaMedia);
						celula.setCorrecao(correcao);
						celula.setTempoInjecaoMedia(tempoInjecaoMedia);
					}
				}
			}
		}
	}

	// TODO refatorar nome desse metodo
	private void addValorSonda(List<LinhaMapRpm> linhas, BigDecimal map, BigDecimal rpm, Float valorSonda, Float valorCanalBancada_A_TI, Float valorAutoCorrecaoSonda, Float valorTempAr, Float valorPressaoComb, Float valorPressaoOleo, Float valorBateriaTensao, Float valorTemperaturaMotor) {
		// TODO precisao MAP e RPM
		BigDecimal precisaoMAP_1 = new BigDecimal(0.02);
		BigDecimal precisaoMap_2 = new BigDecimal(0.05);
		BigDecimal precisaoRPM_1 = new BigDecimal(50);
		BigDecimal precisaoRPM_2 = new BigDecimal(125);

		BigDecimal gapRPM;
		BigDecimal gapMAP;
		for (LinhaMapRpm linha : linhas) {
			BigDecimal map2 = linha.getMap();

			// if (map.compareTo(precisaoMap_2) == -1) {
			// gapMAP = precisaoMAP_1;
			// } else {
			gapMAP = precisaoMap_2;
			// }

			BigDecimal minimoMAP = map.subtract(gapMAP);
			BigDecimal maximoMAP = map.add(gapMAP);

			if (!((minimoMAP.compareTo(map2) <= 0) && (maximoMAP.compareTo(map2) >= 0))) {
				continue;
			}

			List<CelulaMapRpm> listaCelulas = linha.getListaCelulas();
			for (CelulaMapRpm celula : listaCelulas) {
				BigDecimal rpm2 = celula.getRpm();

				// if (rpm.compareTo(new BigDecimal(2000)) == -1) {
				// gapRPM = precisaoRPM_1;
				// } else {
				gapRPM = precisaoRPM_2;

				// }
				BigDecimal minimo = rpm.subtract(gapRPM);
				BigDecimal maximo = rpm.add(gapRPM);

				if ((minimo.compareTo(rpm2) <= 0) && (maximo.compareTo(rpm2) >= 0)) {
					celula.getValoresSonda().add(valorSonda);

					if (valorCanalBancada_A_TI != null) {
						celula.getTempoInjecao().add(valorCanalBancada_A_TI);
					}

					if (valorAutoCorrecaoSonda != null) {
						celula.getValoresAutoCorrecao().add(valorAutoCorrecaoSonda);
					}

					if (valorTempAr != null) {
						celula.getValoresTempAr().add(valorTempAr);
					}

					if (valorPressaoComb != null) {
						celula.getValoresPressaoComb().add(valorPressaoComb);
					}

					if (valorPressaoOleo != null) {
						celula.getValoresPressaoOleo().add(valorPressaoOleo);
					}

					if (valorBateriaTensao != null) {
						celula.getValoresBateriaTensao().add(valorBateriaTensao);
					}
					if (valorTemperaturaMotor != null) {
						celula.getValoresTemperaturaMotor().add(valorTemperaturaMotor);
					}

					return;
				}
			}
		}
	}

	public List<LinhaMapRpm> gerarLinhas() {

		BigDecimal rpmInicial = new BigDecimal(500);
		BigDecimal rpmFinal = new BigDecimal(8000);

		BigDecimal mapInicial = new BigDecimal(-0.80);
		BigDecimal mapFinal = new BigDecimal(2.00);

		BigDecimal mapFator = new BigDecimal(0.05);
		BigDecimal rpmFator = new BigDecimal(250);

		BigDecimal mapPositiva_0_05 = new BigDecimal(0.05);

		BigDecimal rpm_2000 = new BigDecimal(2000);
		BigDecimal bd_100 = new BigDecimal(100);
		int int_200 = 250;

		Integer intervalosRpm = rpmFinal.subtract(rpmInicial).setScale(0, RoundingMode.HALF_EVEN).divide(rpmFator).intValue();
		Integer intervalosMap = mapFinal.subtract(mapInicial).setScale(2, RoundingMode.HALF_EVEN).divide(mapFator, 0, RoundingMode.HALF_UP).intValue();

		List<LinhaMapRpm> listaLinha = new ArrayList<LinhaMapRpm>();

		for (int j = 0; j <= intervalosMap; j++) {
			LinhaMapRpm linha = new LinhaMapRpm();
			BigDecimal map = (mapFator.multiply(BigDecimal.valueOf(j))).add(mapInicial).setScale(2, RoundingMode.HALF_EVEN);

			if (map.compareTo(mapFinal) == 1) {
				break;
			}

			if ((map.compareTo(mapPositiva_0_05) == 1) && !((map.multiply(bd_100).intValue() % 10) == 0)) {
				continue;

			}

			linha.setMap(map);
			linha.setMapCorrecaoMedia(new BigDecimal(0));
			linha.setMapLambdaMedia(new BigDecimal(0));

			for (int i = 0; i <= intervalosRpm; i++) {
				BigDecimal rpm = (rpmFator.multiply(BigDecimal.valueOf(i))).add(rpmInicial);

				if (rpm.compareTo(rpmFinal) == 1) {
					break;
				}

				if ((rpm.compareTo(rpm_2000) == 1) && !((rpm.intValue() % int_200) == 0)) {
					continue;

				}

				CelulaMapRpm celula = new CelulaMapRpm();
				celula.setMap(map);
				celula.setRpm(rpm.setScale(0, RoundingMode.HALF_EVEN));
				linha.getListaCelulas().add(celula);

			}

			listaLinha.add(linha);
		}

		return listaLinha;

	}

	public void doAbrirLog(List<LinhaMapRpm> linhas, Log log) {
		try {

			List<String> listaValoresSonda = PaginaInicialAbaRPM.listaValoresSonda;
			if (listaValoresSonda.size() > 0) {

				for (int i = 0; i < linhas.size(); i++) {
					LinhaMapRpm linhaMapRpm = linhas.get(i);
					String vlrSonda = listaValoresSonda.get(i);
					BigDecimal lambdaAlvo = new BigDecimal(vlrSonda);
					linhaMapRpm.setMapLambdaAlvo(lambdaAlvo);

					for (int j = 0; j < linhaMapRpm.getListaCelulas().size(); j++) {
						linhaMapRpm.getListaCelulas().get(j).setSondaAlvo(lambdaAlvo);

					}
				}
			}

			List<DataCanal> listaDados = log.getListaDados();

			for (int i = 0; i < listaDados.size(); i++) {
				if (listaDados.get(i).getCanal().getId() == Constantes.MAP) {
					float[] valores = listaDados.get(i).getValores();
					for (int j = 0; j < valores.length; j++) {
						configurarValores(listaDados, linhas, valores, j);
					}
				}
			}

			Calculador calc = new Calculador();
			MathContext mc = new MathContext(15, RoundingMode.HALF_UP);

			for (LinhaMapRpm linha : linhas) {
				for (CelulaMapRpm celula : linha.getListaCelulas()) {

					// TODO Parametrizar o percentual de truncamento
					BigDecimal valorMPTruncSonda = calc.getValorMediaPonderadaTruncada(celula.getValoresSonda(), "10", true).setScale(2, BigDecimal.ROUND_HALF_EVEN);
					celula.setSondaMedia(valorMPTruncSonda);

					BigDecimal valorMPTruncTempoInjecao = calc.getValorMediaPonderadaTruncada(celula.getTempoInjecao(), "10", true);
					celula.setTempoInjecaoMedia(valorMPTruncTempoInjecao);

					BigDecimal valorMPTruncAutoCorrecao = calc.getValorMediaPonderadaTruncada(celula.getValoresAutoCorrecao(), "10", true).setScale(0, BigDecimal.ROUND_HALF_EVEN);
					;
					celula.setAutoCorrecao(valorMPTruncAutoCorrecao);

					BigDecimal valorvalorTempAr = calc.getValorMediaPonderadaTruncada(celula.getValoresTempAr(), "10", true).setScale(1, BigDecimal.ROUND_HALF_EVEN);
					;
					celula.setValorTempAr(valorvalorTempAr);

					BigDecimal valorPressaoComb = calc.getValorMediaPonderadaTruncada(celula.getValoresPressaoComb(), "10", true).setScale(1, BigDecimal.ROUND_HALF_EVEN);
					;
					celula.setValorPressaoComb(valorPressaoComb);

					BigDecimal valorPressaoOleo = calc.getValorMediaPonderadaTruncada(celula.getValoresPressaoOleo(), "10", true).setScale(1, BigDecimal.ROUND_HALF_EVEN);
					;
					celula.setValorPressaoOleo(valorPressaoOleo);

					BigDecimal valorBateriaTensao = calc.getValorMediaPonderadaTruncada(celula.getValoresBateriaTensao(), "10", true).setScale(1, BigDecimal.ROUND_HALF_EVEN);
					;
					celula.setValorBateriaTensao(valorBateriaTensao);

					BigDecimal valorTemperaturaMotor = calc.getValorMediaPonderadaTruncada(celula.getValoresTemperaturaMotor(), "10", true).setScale(1, BigDecimal.ROUND_HALF_EVEN);
					;
					celula.setValorTemperaturaMotor(valorTemperaturaMotor);

					BigDecimal sondaAlvo = celula.getSondaAlvo();

					if (sondaAlvo == null) {
						celula.setSondaAlvo(BigDecimal.ONE);
						sondaAlvo = celula.getSondaAlvo();
					}

					if (valorMPTruncSonda.compareTo(BigDecimal.ZERO) != 0) {
						BigDecimal correcao = sondaAlvo.divide(valorMPTruncSonda, mc).setScale(2, BigDecimal.ROUND_HALF_EVEN);

						BigDecimal cem = new BigDecimal(100);
						BigDecimal menos1 = new BigDecimal(-1);
						correcao = correcao.subtract(BigDecimal.ONE, mc).multiply(menos1).multiply(cem, mc).setScale(0, BigDecimal.ROUND_HALF_EVEN);

						// Add autocorrecao
						correcao = correcao.add(valorMPTruncAutoCorrecao);

						celula.setCorrecao(correcao);

						if (valorMPTruncTempoInjecao.compareTo(BigDecimal.ZERO) != 0) {

							BigDecimal tempoInjecaoCorrigido = valorMPTruncTempoInjecao;

							BigDecimal divide = correcao.divide(cem, mc);
							BigDecimal subtract = BigDecimal.ONE.add(divide);
							BigDecimal multiply = valorMPTruncTempoInjecao.multiply(subtract);
							tempoInjecaoCorrigido = multiply.setScale(3, BigDecimal.ROUND_HALF_EVEN);

							celula.setTempoInjecaoMediaCorrigida(tempoInjecaoCorrigido);

						}

					}

				}
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void configurarValores(List<DataCanal> listaDados, List<LinhaMapRpm> linhas, float[] valores, int j) {

		for (int k = 0; k < listaDados.size(); k++) {
			if (listaDados.get(k).getCanal().getId() == Constantes.WIDEBAND_DIGITAL) {
				Constantes.WIDEBAND = Constantes.WIDEBAND_DIGITAL;
				break;
			}

			if (listaDados.get(k).getCanal().getId() == Constantes.WIDEBAND_ANALOGICO) {
				Constantes.WIDEBAND = Constantes.WIDEBAND_ANALOGICO;
				break;
			}

		}

		for (int k = 0; k < listaDados.size(); k++) {
			if (listaDados.get(k).getCanal().getId() == Constantes.SONDA_CORRECAO) {
				Constantes.IS_CORRRECAO_ATIVA = true;
				break;
			}
		}

		UtilData utilData = new UtilData();
		FiltroCanal filtro = new FiltroCanal();

		filtro.setStrTpsMinimo(PaginaInicialAbaRPM.filtro.getStrTpsMinimo());
		filtro.setStrTpsMaximo(PaginaInicialAbaRPM.filtro.getStrTpsMaximo());
		filtro.setStrTempMotorMinimo(PaginaInicialAbaRPM.filtro.getStrTempMotorMinimo());
		filtro.setStrTempMotorMaximo(PaginaInicialAbaRPM.filtro.getStrTempMotorMaximo());
		filtro.setStrSondaMinimo(PaginaInicialAbaRPM.filtro.getStrSondaMinimo());
		filtro.setStrSondaMaximo(PaginaInicialAbaRPM.filtro.getStrSondaMaximo());

		Float valorCanalWideband = utilData.getValorCanal(listaDados, j, Constantes.WIDEBAND, filtro);
		Float valorCanalRPM = utilData.getValorCanal(listaDados, j, Constantes.RPM, filtro);
		Float valorCanalBancada_A_TI = utilData.getValorCanal(listaDados, j, Constantes.BANCADA_A_TEMPO_INJECAO, filtro);
		Float valorAutoCorrecaoSonda = utilData.getValorCanal(listaDados, j, Constantes.SONDA_CORRECAO, filtro);

		Float valorTempAr = utilData.getValorCanal(listaDados, j, Constantes.TEMPERATURA_AR, filtro);
		Float valorPressaoComb = utilData.getValorCanal(listaDados, j, Constantes.PRESSAO_COMB, filtro);
		Float valorPressaoOleo = utilData.getValorCanal(listaDados, j, Constantes.PRESSAO_OLEO, filtro);
		Float valorBateriaTensao = utilData.getValorCanal(listaDados, j, Constantes.BATERIA_TENSAO, filtro);

		Float valorTemperaturaMotor = utilData.getValorCanal(listaDados, j, Constantes.TEMP_MOTOR, filtro);

		if (valorCanalWideband != null && valorCanalRPM != null) {
			this.addValorSonda(linhas, new BigDecimal(valores[j]), new BigDecimal(valorCanalRPM.doubleValue()), valorCanalWideband, valorCanalBancada_A_TI, valorAutoCorrecaoSonda, valorTempAr, valorPressaoComb, valorPressaoOleo, valorBateriaTensao, valorTemperaturaMotor);
		}

	}

}
