package sandbox.mapa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GravadorMapaFormato {
	public static void gravarMapa(MapaFormato mapa, File arquivo) throws Exception {
		StringBuilder dadosMapa = new StringBuilder();

		char[] nome = Arrays.copyOf(mapa.getNome().toCharArray(), 16);

		int tamNome = mapa.getNome().length();

		for (int i = tamNome; i < 16; i++) {
			nome[i] = ' ';
		}
		for (char letra : nome) {
			dadosMapa.append(String.format("%02X", new Object[] { Byte.valueOf((byte) letra) }));
		}

		dadosMapa.append(String.format("%02X", new Object[] { Integer.valueOf(mapa.getModeloECU().getId()) }));

		dadosMapa.append(String.format("%02X", new Object[] { Integer.valueOf(28) }));

		dadosMapa.append(String.format("%02X%02X%02X%02X", new Object[] { Byte.valueOf(mapa.getNumSerieOrigem()[3]), Byte.valueOf(mapa.getNumSerieOrigem()[2]), Byte.valueOf(mapa.getNumSerieOrigem()[1]), Byte.valueOf(mapa.getNumSerieOrigem()[0]) }));

		StringBuilder corpoMapa = new StringBuilder();
		int pos = 0;
		for (byte b : mapa.getMapa()) {

			if (pos > 0 && pos % 64 == 0) {
				corpoMapa.append("\r\n");
			}
			corpoMapa.append(String.format("%02X", new Object[] { Byte.valueOf(b) }));

			pos++;
		}

		pos = 0;
		for (byte b : mapa.getSondaLearn()) {

			if (pos % 64 == 0) {
				corpoMapa.append("\r\n");
			}
			corpoMapa.append(String.format("%02X", new Object[] { Byte.valueOf(b) }));

			pos++;
		}

		String hashMapa = GeradorSHA1.getSHA1(corpoMapa.toString() + dadosMapa.toString());

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {

			writer.write(dadosMapa.toString());
			writer.write("\r\n");

			writer.write(corpoMapa.toString());
			writer.write("\r\n");

			writer.write(hashMapa);
		}
	}

	public static MapaFormato lerMapa(File arquivo) throws Exception {
		MapaFormato mapa = new MapaFormato();

		List<String> linhas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				linhas.add(linha);
			}
		}

		if (linhas.size() != 34 && linhas.size() != 38) {
//			throw new EcuArquivoCorrompidoException("Número de linhas do arquivo inválido");
			throw new Exception("Número de linhas do arquivo inválido");
		}

		if (linhas.get(0).length() != 34 && linhas.get(0).length() != 36 && linhas.get(0).length() != 44) {
//			throw new EcuArquivoCorrompidoException("Número de caracteres nos dados do mapa inválido");
			throw new Exception("Número de caracteres nos dados do mapa inválido");
		}

		int qtdDataMapa = linhas.size() - 2;

		for (int i = 1; i <= qtdDataMapa; i++) {
			if (linhas.get(i).length() != 128) {
				throw new Exception("Número de caracteres no corpo do mapa inválido");
//				throw new EcuArquivoCorrompidoException("Número de caracteres no corpo do mapa inválido");
			}
		}

		if (linhas.get(qtdDataMapa + 1).length() != 40) {
//			throw new EcuArquivoCorrompidoException("Número de caracteres no rodapé do mapa inválido");
			throw new Exception("Número de caracteres no rodapé do mapa inválido");
		}

		StringBuilder corpoMapa = new StringBuilder();

		for (int k = 1; k <= qtdDataMapa; k++) {

			if (k != 1) {
				corpoMapa.append("\r\n");
			}
			corpoMapa.append(linhas.get(k));
		}

		String hashMapa = GeradorSHA1.getSHA1(corpoMapa.toString() + linhas.get(0));

		if (!hashMapa.equals(linhas.get(qtdDataMapa + 1))) {
//			throw new EcuArquivoCorrompidoException("Arquivo do mapa está corrompido ou foi alterado manualmente");
			throw new Exception("Arquivo do mapa está corrompido ou foi alterado manualmente");
		}

		mapa.setNome(lerNomeMapa(linhas.get(0)));

		mapa.setModeloECU(lerModeloEcu(linhas.get(0)));

		mapa.setVersaoMapa(lerVersaoMapa(linhas.get(0)));

		mapa.setNumSerieOrigem(lerNumSerieOrigemMapa(linhas.get(0)));

		int pos = 0;
		int j;
		for (j = 1; j <= 32; j++) {
			char[] letras = linhas.get(j).toCharArray();

			for (int m = 0; m < letras.length; m += 2) {

				int valor = Integer.parseInt(letras[m] + String.valueOf(letras[m + 1]), 16);

				mapa.getMapa()[pos++] = (byte) valor;
			}
		}

		if (qtdDataMapa == 36) {

			pos = 0;
			for (j = 33; j <= qtdDataMapa; j++) {
				char[] letras = linhas.get(j).toCharArray();

				for (int m = 0; m < letras.length; m += 2) {

					int valor = Integer.parseInt(letras[m] + String.valueOf(letras[m + 1]), 16);

					mapa.getSondaLearn()[pos++] = (byte) valor;
				}
			}
		}

		return mapa;
	}

	private static String lerNomeMapa(String linha) {
		char[] letras = linha.toCharArray();

		StringBuilder nomeMapa = new StringBuilder();

		for (int i = 0; i < 32; i += 2) {

			int valor = Integer.parseInt(letras[i] + String.valueOf(letras[i + 1]), 16);

			char letra = (char) valor;

			nomeMapa.append(letra);
		}

		return nomeMapa.toString().trim();
	}

	private static ModeloECU lerModeloEcu(String linha) {
		int valor = Integer.parseInt(linha.substring(32, 34), 16);
		return ModeloECU.getById(valor);
	}

	private static int lerVersaoMapa(String linha) {
		int valor = 0;
		if (linha.length() == 36 || linha.length() == 44) {
			valor = Integer.parseInt(linha.substring(34, 36), 16);
		}
		return valor;
	}

	private static byte[] lerNumSerieOrigemMapa(String linha) {
		byte[] numSerie = { 0, 0, 0, 0 };

		if (linha.length() == 44) {
			char[] letras = linha.toCharArray();

			int pos = 3;

			for (int i = 36; i < 44; i += 2) {

				byte valor = (byte) Integer.parseInt(letras[i] + String.valueOf(letras[i + 1]), 16);

				numSerie[pos] = valor;
				pos--;
			}
		}

		return numSerie;
	}
}
