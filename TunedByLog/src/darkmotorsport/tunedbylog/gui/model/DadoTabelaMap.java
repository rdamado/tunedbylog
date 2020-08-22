package darkmotorsport.tunedbylog.gui.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;

public class DadoTabelaMap {

	
	

	private SimpleStringProperty descricaoLinha;
	private SimpleStringProperty map_m_0_90;
	private SimpleStringProperty map_m_0_85;
	private SimpleStringProperty map_m_0_80;
	private SimpleStringProperty map_m_0_75;
	private SimpleStringProperty map_m_0_70;
	private SimpleStringProperty map_m_0_65;
	private SimpleStringProperty map_m_0_60;
	private SimpleStringProperty map_m_0_55;
	private SimpleStringProperty map_m_0_50;
	private SimpleStringProperty map_m_0_45;
	private SimpleStringProperty map_m_0_40;
	private SimpleStringProperty map_m_0_35;
	private SimpleStringProperty map_m_0_30;
	private SimpleStringProperty map_m_0_25;
	private SimpleStringProperty map_m_0_20;
	private SimpleStringProperty map_m_0_15;
	private SimpleStringProperty map_m_0_10;
	private SimpleStringProperty map_m_0_05;
	private SimpleStringProperty map_0_00;
	private SimpleStringProperty map_0_05;
	private SimpleStringProperty map_0_10;
	private SimpleStringProperty map_0_20;
	private SimpleStringProperty map_0_30;
	private SimpleStringProperty map_0_40;
	private SimpleStringProperty map_0_50;
	private SimpleStringProperty map_0_60;
	private SimpleStringProperty map_0_70;
	private SimpleStringProperty map_0_80;
	private SimpleStringProperty map_0_90;
	private SimpleStringProperty map_1_00;
	private SimpleStringProperty map_1_10;
	private SimpleStringProperty map_1_20;
	private SimpleStringProperty map_1_30;
	private SimpleStringProperty map_1_40;
	private SimpleStringProperty map_1_50;
	private SimpleStringProperty map_1_60;
	private SimpleStringProperty map_1_70;
	private SimpleStringProperty map_1_80;
	private SimpleStringProperty map_1_90;
	private SimpleStringProperty map_2_00;
	
	private List<String> listaValores = new ArrayList<String>();

	public DadoTabelaMap() {
		super();
	}
	
	
	public DadoTabelaMap(String descricaoLinha) {
		super();
		this.descricaoLinha = new SimpleStringProperty(descricaoLinha);
	}

	public DadoTabelaMap(String descricaoLinha, String map_m_0_90, String map_m_0_85, String map_m_0_80,
			String map_m_0_75, String map_m_0_70, String map_m_0_65, String map_m_0_60, String map_m_0_55,
			String map_m_0_50, String map_m_0_45, String map_m_0_40, String map_m_0_35, String map_m_0_30,
			String map_m_0_25, String map_m_0_20, String map_m_0_15, String map_m_0_10, String map_m_0_05,
			String map_0_00, String map_0_05, String map_0_10, String map_0_20, String map_0_30, String map_0_40,
			String map_0_50, String map_0_60, String map_0_70, String map_0_80, String map_0_90, String map_1_00,
			String map_1_10, String map_1_20, String map_1_30, String map_1_40, String map_1_50, String map_1_60,
			String map_1_70, String map_1_80, String map_1_90, String map_2_00) {
		super();
		this.descricaoLinha = new SimpleStringProperty(descricaoLinha);
		this.map_m_0_90 = new SimpleStringProperty(map_m_0_90);
		this.map_m_0_85 = new SimpleStringProperty(map_m_0_85);
		this.map_m_0_80 = new SimpleStringProperty(map_m_0_80);
		this.map_m_0_75 = new SimpleStringProperty(map_m_0_75);
		this.map_m_0_70 = new SimpleStringProperty(map_m_0_70);
		this.map_m_0_65 = new SimpleStringProperty(map_m_0_65);
		this.map_m_0_60 = new SimpleStringProperty(map_m_0_60);
		this.map_m_0_55 = new SimpleStringProperty(map_m_0_55);
		this.map_m_0_50 = new SimpleStringProperty(map_m_0_50);
		this.map_m_0_45 = new SimpleStringProperty(map_m_0_45);
		this.map_m_0_40 = new SimpleStringProperty(map_m_0_40);
		this.map_m_0_35 = new SimpleStringProperty(map_m_0_35);
		this.map_m_0_30 = new SimpleStringProperty(map_m_0_30);
		this.map_m_0_25 = new SimpleStringProperty(map_m_0_25);
		this.map_m_0_20 = new SimpleStringProperty(map_m_0_20);
		this.map_m_0_15 = new SimpleStringProperty(map_m_0_15);
		this.map_m_0_10 = new SimpleStringProperty(map_m_0_10);
		this.map_m_0_05 = new SimpleStringProperty(map_m_0_05);
		this.map_0_00 = new SimpleStringProperty(map_0_00);
		this.map_0_05 = new SimpleStringProperty(map_0_05);
		this.map_0_10 = new SimpleStringProperty(map_0_10);
		this.map_0_20 = new SimpleStringProperty(map_0_20);
		this.map_0_30 = new SimpleStringProperty(map_0_30);
		this.map_0_40 = new SimpleStringProperty(map_0_40);
		this.map_0_50 = new SimpleStringProperty(map_0_50);
		this.map_0_60 = new SimpleStringProperty(map_0_60);
		this.map_0_70 = new SimpleStringProperty(map_0_70);
		this.map_0_80 = new SimpleStringProperty(map_0_80);
		this.map_0_90 = new SimpleStringProperty(map_0_90);
		this.map_1_00 = new SimpleStringProperty(map_1_00);
		this.map_1_10 = new SimpleStringProperty(map_1_10);
		this.map_1_20 = new SimpleStringProperty(map_1_20);
		this.map_1_30 = new SimpleStringProperty(map_1_30);
		this.map_1_40 = new SimpleStringProperty(map_1_40);
		this.map_1_50 = new SimpleStringProperty(map_1_50);
		this.map_1_60 = new SimpleStringProperty(map_1_60);
		this.map_1_70 = new SimpleStringProperty(map_1_70);
		this.map_1_80 = new SimpleStringProperty(map_1_80);
		this.map_1_90 = new SimpleStringProperty(map_1_90);
		this.map_2_00 = new SimpleStringProperty(map_2_00);
	}
	
	
	

	public SimpleStringProperty getDescricaoLinha() {
		return descricaoLinha;
	}

	public void setDescricaoLinha(SimpleStringProperty descricaoLinha) {
		this.descricaoLinha = descricaoLinha;
	}

	public SimpleStringProperty getMap_m_0_90() {
		return map_m_0_90;
	}

	public void setMap_m_0_90(SimpleStringProperty map_m_0_90) {
		this.map_m_0_90 = map_m_0_90;
	}

	public SimpleStringProperty getMap_m_0_85() {
		return map_m_0_85;
	}

	public void setMap_m_0_85(SimpleStringProperty map_m_0_85) {
		this.map_m_0_85 = map_m_0_85;
	}

	public SimpleStringProperty getMap_m_0_80() {
		return map_m_0_80;
	}

	public void setMap_m_0_80(SimpleStringProperty map_m_0_80) {
		this.map_m_0_80 = map_m_0_80;
	}

	public SimpleStringProperty getMap_m_0_75() {
		return map_m_0_75;
	}

	public void setMap_m_0_75(SimpleStringProperty map_m_0_75) {
		this.map_m_0_75 = map_m_0_75;
	}

	public SimpleStringProperty getMap_m_0_70() {
		return map_m_0_70;
	}

	public void setMap_m_0_70(SimpleStringProperty map_m_0_70) {
		this.map_m_0_70 = map_m_0_70;
	}

	public SimpleStringProperty getMap_m_0_65() {
		return map_m_0_65;
	}

	public void setMap_m_0_65(SimpleStringProperty map_m_0_65) {
		this.map_m_0_65 = map_m_0_65;
	}

	public SimpleStringProperty getMap_m_0_60() {
		return map_m_0_60;
	}

	public void setMap_m_0_60(SimpleStringProperty map_m_0_60) {
		this.map_m_0_60 = map_m_0_60;
	}

	public SimpleStringProperty getMap_m_0_55() {
		return map_m_0_55;
	}

	public void setMap_m_0_55(SimpleStringProperty map_m_0_55) {
		this.map_m_0_55 = map_m_0_55;
	}

	public SimpleStringProperty getMap_m_0_50() {
		return map_m_0_50;
	}

	public void setMap_m_0_50(SimpleStringProperty map_m_0_50) {
		this.map_m_0_50 = map_m_0_50;
	}

	public SimpleStringProperty getMap_m_0_45() {
		return map_m_0_45;
	}

	public void setMap_m_0_45(SimpleStringProperty map_m_0_45) {
		this.map_m_0_45 = map_m_0_45;
	}

	public SimpleStringProperty getMap_m_0_40() {
		return map_m_0_40;
	}

	public void setMap_m_0_40(SimpleStringProperty map_m_0_40) {
		this.map_m_0_40 = map_m_0_40;
	}

	public SimpleStringProperty getMap_m_0_35() {
		return map_m_0_35;
	}

	public void setMap_m_0_35(SimpleStringProperty map_m_0_35) {
		this.map_m_0_35 = map_m_0_35;
	}

	public SimpleStringProperty getMap_m_0_30() {
		return map_m_0_30;
	}

	public void setMap_m_0_30(SimpleStringProperty map_m_0_30) {
		this.map_m_0_30 = map_m_0_30;
	}

	public SimpleStringProperty getMap_m_0_25() {
		return map_m_0_25;
	}

	public void setMap_m_0_25(SimpleStringProperty map_m_0_25) {
		this.map_m_0_25 = map_m_0_25;
	}

	public SimpleStringProperty getMap_m_0_20() {
		return map_m_0_20;
	}

	public void setMap_m_0_20(SimpleStringProperty map_m_0_20) {
		this.map_m_0_20 = map_m_0_20;
	}

	public SimpleStringProperty getMap_m_0_15() {
		return map_m_0_15;
	}

	public void setMap_m_0_15(SimpleStringProperty map_m_0_15) {
		this.map_m_0_15 = map_m_0_15;
	}

	public SimpleStringProperty getMap_m_0_10() {
		return map_m_0_10;
	}

	public void setMap_m_0_10(SimpleStringProperty map_m_0_10) {
		this.map_m_0_10 = map_m_0_10;
	}

	public SimpleStringProperty getMap_m_0_05() {
		return map_m_0_05;
	}

	public void setMap_m_0_05(SimpleStringProperty map_m_0_05) {
		this.map_m_0_05 = map_m_0_05;
	}

	public SimpleStringProperty getMap_0_00() {
		return map_0_00;
	}

	public void setMap_0_00(SimpleStringProperty map_0_00) {
		this.map_0_00 = map_0_00;
	}

	public SimpleStringProperty getMap_0_10() {
		return map_0_10;
	}

	public void setMap_0_10(SimpleStringProperty map_0_10) {
		this.map_0_10 = map_0_10;
	}

	public SimpleStringProperty getMap_0_20() {
		return map_0_20;
	}

	public void setMap_0_20(SimpleStringProperty map_0_20) {
		this.map_0_20 = map_0_20;
	}

	public SimpleStringProperty getMap_0_30() {
		return map_0_30;
	}

	public void setMap_0_30(SimpleStringProperty map_0_30) {
		this.map_0_30 = map_0_30;
	}

	public SimpleStringProperty getMap_0_40() {
		return map_0_40;
	}

	public void setMap_0_40(SimpleStringProperty map_0_40) {
		this.map_0_40 = map_0_40;
	}

	public SimpleStringProperty getMap_0_50() {
		return map_0_50;
	}

	public void setMap_0_50(SimpleStringProperty map_0_50) {
		this.map_0_50 = map_0_50;
	}

	public SimpleStringProperty getMap_0_60() {
		return map_0_60;
	}

	public void setMap_0_60(SimpleStringProperty map_0_60) {
		this.map_0_60 = map_0_60;
	}

	public SimpleStringProperty getMap_0_70() {
		return map_0_70;
	}

	public void setMap_0_70(SimpleStringProperty map_0_70) {
		this.map_0_70 = map_0_70;
	}

	public SimpleStringProperty getMap_0_80() {
		return map_0_80;
	}

	public void setMap_0_80(SimpleStringProperty map_0_80) {
		this.map_0_80 = map_0_80;
	}

	public SimpleStringProperty getMap_0_90() {
		return map_0_90;
	}

	public void setMap_0_90(SimpleStringProperty map_0_90) {
		this.map_0_90 = map_0_90;
	}

	public SimpleStringProperty getMap_1_00() {
		return map_1_00;
	}

	public void setMap_1_00(SimpleStringProperty map_1_00) {
		this.map_1_00 = map_1_00;
	}

	public SimpleStringProperty getMap_1_10() {
		return map_1_10;
	}

	public void setMap_1_10(SimpleStringProperty map_1_10) {
		this.map_1_10 = map_1_10;
	}

	public SimpleStringProperty getMap_1_20() {
		return map_1_20;
	}

	public void setMap_1_20(SimpleStringProperty map_1_20) {
		this.map_1_20 = map_1_20;
	}

	public SimpleStringProperty getMap_1_30() {
		return map_1_30;
	}

	public void setMap_1_30(SimpleStringProperty map_1_30) {
		this.map_1_30 = map_1_30;
	}

	public SimpleStringProperty getMap_1_40() {
		return map_1_40;
	}

	public void setMap_1_40(SimpleStringProperty map_1_40) {
		this.map_1_40 = map_1_40;
	}

	public SimpleStringProperty getMap_1_50() {
		return map_1_50;
	}

	public void setMap_1_50(SimpleStringProperty map_1_50) {
		this.map_1_50 = map_1_50;
	}

	public SimpleStringProperty getMap_1_60() {
		return map_1_60;
	}

	public void setMap_1_60(SimpleStringProperty map_1_60) {
		this.map_1_60 = map_1_60;
	}

	public SimpleStringProperty getMap_1_70() {
		return map_1_70;
	}

	public void setMap_1_70(SimpleStringProperty map_1_70) {
		this.map_1_70 = map_1_70;
	}

	public SimpleStringProperty getMap_1_80() {
		return map_1_80;
	}

	public void setMap_1_80(SimpleStringProperty map_1_80) {
		this.map_1_80 = map_1_80;
	}

	public SimpleStringProperty getMap_1_90() {
		return map_1_90;
	}

	public void setMap_1_90(SimpleStringProperty map_1_90) {
		this.map_1_90 = map_1_90;
	}

	public SimpleStringProperty getMap_2_00() {
		return map_2_00;
	}

	public void setMap_2_00(SimpleStringProperty map_2_00) {
		this.map_2_00 = map_2_00;
	}

	public List<String> getValoresVariavel(){
		return this.listaValores;
	}
	
	public List<String> getValores() {
		listaValores = new ArrayList<String>();
		listaValores.add(getMap_m_0_90().getValue());
		listaValores.add(getMap_m_0_85().getValue());
		listaValores.add(getMap_m_0_80().getValue());
		listaValores.add(getMap_m_0_75().getValue());
		listaValores.add(getMap_m_0_70().getValue());
		listaValores.add(getMap_m_0_65().getValue());
		listaValores.add(getMap_m_0_60().getValue());
		listaValores.add(getMap_m_0_55().getValue());
		listaValores.add(getMap_m_0_50().getValue());
		listaValores.add(getMap_m_0_45().getValue());
		listaValores.add(getMap_m_0_40().getValue());
		listaValores.add(getMap_m_0_35().getValue());
		listaValores.add(getMap_m_0_30().getValue());
		listaValores.add(getMap_m_0_25().getValue());
		listaValores.add(getMap_m_0_20().getValue());
		listaValores.add(getMap_m_0_15().getValue());
		listaValores.add(getMap_m_0_10().getValue());
		listaValores.add(getMap_m_0_05().getValue());
		listaValores.add(getMap_0_00().getValue());
		listaValores.add(getMap_0_05().getValue());
		listaValores.add(getMap_0_10().getValue());
		listaValores.add(getMap_0_20().getValue());
		listaValores.add(getMap_0_30().getValue());
		listaValores.add(getMap_0_40().getValue());
		listaValores.add(getMap_0_50().getValue());
		listaValores.add(getMap_0_60().getValue());
		listaValores.add(getMap_0_70().getValue());
		listaValores.add(getMap_0_80().getValue());
		listaValores.add(getMap_0_90().getValue());
		listaValores.add(getMap_1_00().getValue());
		listaValores.add(getMap_1_10().getValue());
		listaValores.add(getMap_1_20().getValue());
		listaValores.add(getMap_1_30().getValue());
		listaValores.add(getMap_1_40().getValue());
		listaValores.add(getMap_1_50().getValue());
		listaValores.add(getMap_1_60().getValue());
		listaValores.add(getMap_1_70().getValue());
		listaValores.add(getMap_1_80().getValue());
		listaValores.add(getMap_1_90().getValue());
		listaValores.add(getMap_2_00().getValue());
		return listaValores;
	}

	public void setValores(List<String> listaValores) {
		this.listaValores = listaValores;
		setMap_m_0_90(new SimpleStringProperty(listaValores.get(0)));
		setMap_m_0_85(new SimpleStringProperty(listaValores.get(1)));
		setMap_m_0_80(new SimpleStringProperty(listaValores.get(2)));
		setMap_m_0_75(new SimpleStringProperty(listaValores.get(3)));
		setMap_m_0_70(new SimpleStringProperty(listaValores.get(4)));
		setMap_m_0_65(new SimpleStringProperty(listaValores.get(5)));
		setMap_m_0_60(new SimpleStringProperty(listaValores.get(6)));
		setMap_m_0_55(new SimpleStringProperty(listaValores.get(7)));
		setMap_m_0_50(new SimpleStringProperty(listaValores.get(8)));
		setMap_m_0_45(new SimpleStringProperty(listaValores.get(9)));
		setMap_m_0_40(new SimpleStringProperty(listaValores.get(10)));
		setMap_m_0_35(new SimpleStringProperty(listaValores.get(11)));
		setMap_m_0_30(new SimpleStringProperty(listaValores.get(12)));
		setMap_m_0_25(new SimpleStringProperty(listaValores.get(13)));
		setMap_m_0_20(new SimpleStringProperty(listaValores.get(14)));
		setMap_m_0_15(new SimpleStringProperty(listaValores.get(15)));
		setMap_m_0_10(new SimpleStringProperty(listaValores.get(16)));
		setMap_m_0_05(new SimpleStringProperty(listaValores.get(17)));
		setMap_0_00(new SimpleStringProperty(listaValores.get(18)));
		setMap_0_05(new SimpleStringProperty(listaValores.get(19)));
		setMap_0_10(new SimpleStringProperty(listaValores.get(20)));
		setMap_0_20(new SimpleStringProperty(listaValores.get(21)));
		setMap_0_30(new SimpleStringProperty(listaValores.get(22)));
		setMap_0_40(new SimpleStringProperty(listaValores.get(23)));
		setMap_0_50(new SimpleStringProperty(listaValores.get(24)));
		setMap_0_60(new SimpleStringProperty(listaValores.get(25)));
		setMap_0_70(new SimpleStringProperty(listaValores.get(26)));
		setMap_0_80(new SimpleStringProperty(listaValores.get(27)));
		setMap_0_90(new SimpleStringProperty(listaValores.get(28)));
		setMap_1_00(new SimpleStringProperty(listaValores.get(29)));
		setMap_1_10(new SimpleStringProperty(listaValores.get(30)));
		setMap_1_20(new SimpleStringProperty(listaValores.get(31)));
		setMap_1_30(new SimpleStringProperty(listaValores.get(32)));
		setMap_1_40(new SimpleStringProperty(listaValores.get(33)));
		setMap_1_50(new SimpleStringProperty(listaValores.get(34)));
		setMap_1_60(new SimpleStringProperty(listaValores.get(35)));
		setMap_1_70(new SimpleStringProperty(listaValores.get(36)));
		setMap_1_80(new SimpleStringProperty(listaValores.get(37)));
		setMap_1_90(new SimpleStringProperty(listaValores.get(38)));
		setMap_2_00(new SimpleStringProperty(listaValores.get(39)));
	}

	public SimpleStringProperty getMap_0_05() {
		return map_0_05;
	}

	public void setMap_0_05(SimpleStringProperty map_0_05) {
		this.map_0_05 = map_0_05;
	}

}
