package darkmotorsport.tunedbylog.gui.calc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Calculador {

	public BigDecimal getValorMediaPonderadaTruncada(List<Float> listaValores, String percTruncar, boolean isTruncarCkb) {

		return calculo(listaValores, percTruncar, isTruncarCkb);
	}

	private BigDecimal calculo(List<Float> listaValores, String percTruncar, boolean isTruncarCkb) {
		Float resultadoMediaPonderada = 0f;
		float porcentagemTruncada = Float.parseFloat(percTruncar);
		boolean isTruncar = isTruncarCkb;

		Collections.sort(listaValores);

		//Truncamento baseado em porcentagem
		if (isTruncar) {
			int size = listaValores.size();
			int qtdTruncado = (int) (size * (porcentagemTruncada / 100.0f));
			listaValores.subList(0, qtdTruncado).clear();
			listaValores.subList(listaValores.size() - qtdTruncado, listaValores.size()).clear();
		}

		Map<Float, Float> mapaDeOcorrencias = new HashMap<Float, Float>();
		
		//Media ponderada
		for (Float sonda : listaValores) {
			Float qtdOcorrencias = mapaDeOcorrencias.get(sonda);
			if (qtdOcorrencias == null) {
				mapaDeOcorrencias.put(sonda, 1f);
			} else {
				mapaDeOcorrencias.put(sonda, ++qtdOcorrencias);
			}
		}

		Float somaPesos = 0f;
		Float somaSondaPonderada = 0f;

		for (Entry<Float, Float> entry : mapaDeOcorrencias.entrySet()) {

			somaPesos = somaPesos + entry.getValue();

			somaSondaPonderada = somaSondaPonderada + (entry.getKey() * entry.getValue());

		}

		if (somaPesos > 0) {
			resultadoMediaPonderada = somaSondaPonderada / somaPesos;
		}
		BigDecimal valorArredondado = BigDecimal.valueOf(0L);

		BigDecimal media = new BigDecimal(resultadoMediaPonderada);
		valorArredondado = media.setScale(3, BigDecimal.ROUND_HALF_EVEN);
		return valorArredondado;
	}


}
