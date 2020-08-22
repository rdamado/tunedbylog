package darkmotorsport.tunedbylog.gui.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;

import darkmotorsport.tunedbylog.util.Constantes;
import darkmotorsport.tunedbylog.xml.itens.ControleLargadaItem;
import darkmotorsport.tunedbylog.xml.itens.ControleTracaoItem;
import darkmotorsport.tunedbylog.xml.itens.ControleTracaoMarcha;
import darkmotorsport.tunedbylog.xml.itens.DataCanal;
import darkmotorsport.tunedbylog.xml.itens.Log;
import darkmotorsport.tunedbylog.xml.itens.LogArquivo;
import darkmotorsport.tunedbylog.xml.itens.LogArquivoCanal;
import darkmotorsport.tunedbylog.xml.itens.Tag;

public class ArquivoLog {

	public static Log logcarregado;

	public Log abrirArquivoLog(File arq) throws Throwable {
		LogArquivo logArq;
		XStream xstream = new XStream();
		this.configurarAlias(xstream);
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(arq), "UTF-8");
		BufferedReader reader = new BufferedReader(inputStreamReader);
//		Throwable throwable = null;
		try {
			logArq = (LogArquivo) xstream.fromXML((Reader) reader);
		} catch (Throwable throwable2) {
			throwable2.printStackTrace();
//			throwable = throwable2;
			throw throwable2;
		} finally {
//			if (reader != null) {
//				if (throwable != null) {
//					try {
			reader.close();
//					} catch (Throwable throwable3) {
//						throwable.addSuppressed(throwable3);
//					}
//				} else {
//					reader.close();
//				}
//			}
		}
		Log log = new Log();
		log.setInformacao(logArq.getInformacao());
//		String numSerie = log.getInformacao().getNumSerieEcu();
//		if (numSerie.length() >= 2) {
//			int modeloEcu = Integer.parseInt(numSerie.substring(0, 2), 16);
//			log.getInformacao().setModeloEcu(modeloEcu);
//		}
		ArrayList<Tag> tags = new ArrayList<Tag>();
		if (logArq.getTags() != null) {
			tags.addAll(Arrays.asList(logArq.getTags()));
		}
		log.setListaTags(tags);
//		log.setAcompanharPonteiro(logArq.isAcompanharPonteiro());
//		log.setTipoControle(logArq.getTipoControle());
//		log.setControleLargadaHabilitado(logArq.isControleLargadaHabilitado());
//		log.setControleLargada(logArq.getControleLargada());
//		log.setControleTracao(logArq.getControleTracao());
//		log.setEnderecoArquivo(arq.getAbsolutePath());
		ArrayList<DataCanal> lista = new ArrayList<DataCanal>();
		for (LogArquivoCanal arqCanal : logArq.getCanais()) {
			DataCanal dataCanal = new DataCanal(arqCanal.getConfiguracaoCanal(), arqCanal.getValores());
			lista.add(dataCanal);

			if (dataCanal.getCanal().getId() == Constantes.SONDA_CORRECAO) {
				log.autoCorrecaoAtivada = true;
			}

		}
		log.setListaDados(lista);
		logcarregado = log;
		return log;
	}
//	public Log abrirArquivoLog(File arq) throws Throwable {
//		LogArquivo logArq;
//		XStream xstream = new XStream();
//		this.configurarAlias(xstream);
//		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(arq), "UTF-8");
//		BufferedReader reader = new BufferedReader(inputStreamReader);
//		Throwable throwable = null;
//		try {
//			logArq = (LogArquivo) xstream.fromXML((Reader) reader);
//		} catch (Throwable throwable2) {
//			throwable = throwable2;
//			throw throwable2;
//		} finally {
//			if (reader != null) {
//				if (throwable != null) {
//					try {
//						reader.close();
//					} catch (Throwable throwable3) {
//						throwable.addSuppressed(throwable3);
//					}
//				} else {
//					reader.close();
//				}
//			}
//		}
//		Log log = new Log();
//		log.setInformacao(logArq.getInformacao());
//		String numSerie = log.getInformacao().getNumSerieEcu();
//		if (numSerie.length() >= 2) {
//			int modeloEcu = Integer.parseInt(numSerie.substring(0, 2), 16);
//			log.getInformacao().setModeloEcu(modeloEcu);
//		}
//		ArrayList<Tag> tags = new ArrayList<Tag>();
//		if (logArq.getTags() != null) {
//			tags.addAll(Arrays.asList(logArq.getTags()));
//		}
//		log.setListaTags(tags);
//		log.setAcompanharPonteiro(logArq.isAcompanharPonteiro());
//		log.setTipoControle(logArq.getTipoControle());
//		log.setControleLargadaHabilitado(logArq.isControleLargadaHabilitado());
//		log.setControleLargada(logArq.getControleLargada());
//		log.setControleTracao(logArq.getControleTracao());
//		log.setEnderecoArquivo(arq.getAbsolutePath());
//		ArrayList<DataCanal> lista = new ArrayList<DataCanal>();
//		for (LogArquivoCanal arqCanal : logArq.getCanais()) {
//			DataCanal dataCanal = new DataCanal(arqCanal.getConfiguracaoCanal(), arqCanal.getValores());
//			lista.add(dataCanal);
//		}
//		log.setListaDados(lista);
//		return log;
//	}

	@SuppressWarnings({ "resource", "unused" })
	private void salvarArquivo(Log log, File arq) throws Throwable {

		Object arqCanal = null;
		LogArquivo logArq = new LogArquivo();
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter((OutputStream) new FileOutputStream(arq), "UTF-8"));
		try {
			logArq.setInformacao(log.getInformacao());
			logArq.setTags(log.getListaTags().toArray(new Tag[log.getListaTags().size()]));
//		logArq.setAcompanharPonteiro(log.isAcompanharPonteiro());
//		logArq.setTipoControle(log.getTipoControle());
//		logArq.setControleLargadaHabilitado(log.isControleLargadaHabilitado());
//		logArq.setControleLargada(log.getControleLargada());
//		logArq.setControleTracao(log.getControleTracao());
			ArrayList<LogArquivoCanal> lista = new ArrayList<LogArquivoCanal>();
			for (DataCanal dataCanal : log.getListaDados()) {
				arqCanal = new LogArquivoCanal();
				((LogArquivoCanal) arqCanal).setConfiguracaoCanal(dataCanal.getCanal());
				((LogArquivoCanal) arqCanal).setValores(dataCanal.getValores());
				lista.add((LogArquivoCanal) arqCanal);
			}
			logArq.setCanais(lista);
			XStream xstream = new XStream();
			this.configurarAlias(xstream);
			arqCanal = null;

			xstream.toXML((Object) logArq, (Writer) writer);
		} catch (Throwable throwable) {
			arqCanal = throwable;
			throw throwable;
		} finally {
			if (writer != null) {
				if (arqCanal != null) {
					try {
						writer.close();
					} catch (Throwable throwable) {
						((Throwable) arqCanal).addSuppressed(throwable);
					}
				} else {
					writer.close();
				}
			}
		}
		log.setEnderecoArquivo(arq.getAbsolutePath());
	}

	private void configurarAlias(XStream xstream) {
		XStream.setupDefaultSecurity((XStream) xstream);
		xstream.allowTypes(new Class[] { LogArquivo.class, LogArquivoCanal.class, Tag.class, ControleLargadaItem.class, ControleTracaoMarcha.class, ControleTracaoItem.class

		});
		xstream.alias("log", LogArquivo.class);
		xstream.alias("canal", LogArquivoCanal.class);
		xstream.alias("tag", Tag.class);
		xstream.alias("controleLargadaItem", ControleLargadaItem.class);
		xstream.alias("controleTracaoMarcha", ControleTracaoMarcha.class);
		xstream.alias("controleTracaoItem", ControleTracaoItem.class);
		xstream.alias("v", Float.TYPE);
		xstream.registerConverter((SingleValueConverter) new DateConverter("dd-MM-yyyy HH:mm", new String[0]));
	}

}
