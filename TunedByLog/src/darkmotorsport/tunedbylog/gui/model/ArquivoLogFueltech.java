package darkmotorsport.tunedbylog.gui.model;

import java.io.File;
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ArquivoLogFueltech {

	public static String RPM = "RPM";
	public static String TPS = "TPS";
	public static String MAP = "MAP";
	public static String ALVO_MALHA = "Alvo do malha fechada";
	public static String SONDA_MALHA = "Sonda Malha Fechada";
	public static String TEMP_MOTOR = "Temp. do motor";

	public int pos_RPM = -1;
	public int pos_TPS = -1;
	public int pos_MAP = -1;
	public int pos_ALVO_MALHA = -1;
	public int pos_SONDA_MALHA = -1;
	public int pos_TEMP_MOTOR = -1;

	public List<BigDecimal> listaRpm = new ArrayList<BigDecimal>();
	public List<BigDecimal> listaTPS = new ArrayList<BigDecimal>();
	public List<BigDecimal> listaMAP = new ArrayList<BigDecimal>();
	public List<BigDecimal> listaAlvoMalha = new ArrayList<BigDecimal>();
	public List<BigDecimal> listaSondaMalha = new ArrayList<BigDecimal>();
	public List<BigDecimal> listaTempMotor = new ArrayList<BigDecimal>();

	public void abrirArquivoLog(File arq) throws Throwable {

		Boolean isPrimeira = true;

		try (Reader reader = Files.newBufferedReader(Paths.get(arq.getAbsolutePath())); CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';'));) {
			for (CSVRecord csvRecord : csvParser) {

				if (isPrimeira) {
					isPrimeira = false;
					for (int i = 0; i < csvRecord.size(); i++) {
						String string = csvRecord.get(i);
						int lastIndexOf = string.lastIndexOf('_');

						if (lastIndexOf > 0) {
							String substring = string.substring(lastIndexOf + 1, string.length());

							if (substring.equals(RPM)) {
								pos_RPM = i;
							} else if (substring.equals(TPS)) {
								pos_TPS = i;
							} else if (substring.equals(MAP)) {
								pos_MAP = i;
							} else if (substring.equals(ALVO_MALHA)) {
								pos_ALVO_MALHA = i;
							} else if (substring.equals(SONDA_MALHA)) {
								pos_SONDA_MALHA = i;
							} else if (substring.equals(TEMP_MOTOR)) {
								pos_TEMP_MOTOR = i;
							}

						}
					}
				} else {

					listaRpm.add(new BigDecimal(csvRecord.get(pos_RPM)));
					listaTPS.add(new BigDecimal(csvRecord.get(pos_TPS).replaceAll(",", ".")));
					listaMAP.add(new BigDecimal(csvRecord.get(pos_MAP).replaceAll(",", ".")));
					listaAlvoMalha.add(new BigDecimal(csvRecord.get(pos_ALVO_MALHA).replaceAll(",", ".")));
					listaSondaMalha.add(new BigDecimal(csvRecord.get(pos_SONDA_MALHA).replaceAll(",", ".")));
					listaTempMotor.add(new BigDecimal(csvRecord.get(pos_TEMP_MOTOR).replaceAll(",", ".")));
				}
			}
		}
	}

}
