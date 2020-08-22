package darkmotorsport.tunedbylog.gui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosicaoValor {

	private float map;
	private int posicao;
	
	
	public static Map<Float,Integer> getMapaPosicoesValores() {
		
		Map<Float,Integer> posicoesValores = new HashMap<Float,Integer>();
		posicoesValores.put(MAP_m_0_90, POS_map_m_0_90);
		posicoesValores.put(MAP_m_0_85, POS_map_m_0_85);
		posicoesValores.put(MAP_m_0_80, POS_map_m_0_80);
		posicoesValores.put(MAP_m_0_75, POS_map_m_0_75);
		posicoesValores.put(MAP_m_0_70, POS_map_m_0_70);
		posicoesValores.put(MAP_m_0_65, POS_map_m_0_65);
		posicoesValores.put(MAP_m_0_60, POS_map_m_0_60);
		posicoesValores.put(MAP_m_0_55, POS_map_m_0_55);
		posicoesValores.put(MAP_m_0_50, POS_map_m_0_50);
		posicoesValores.put(MAP_m_0_45, POS_map_m_0_45);
		posicoesValores.put(MAP_m_0_40, POS_map_m_0_40);
		posicoesValores.put(MAP_m_0_35, POS_map_m_0_35);
		posicoesValores.put(MAP_m_0_30, POS_map_m_0_30);
		posicoesValores.put(MAP_m_0_25, POS_map_m_0_25);
		posicoesValores.put(MAP_m_0_20, POS_map_m_0_20);
		posicoesValores.put(MAP_m_0_15, POS_map_m_0_15);
		posicoesValores.put(MAP_m_0_10, POS_map_m_0_10);
		posicoesValores.put(MAP_m_0_05, POS_map_m_0_05);
		posicoesValores.put(MAP_0_00, POS_map_0_00);
		posicoesValores.put(MAP_0_05, POS_map_0_05);
		posicoesValores.put(MAP_0_10, POS_map_0_10);
		posicoesValores.put(MAP_0_20, POS_map_0_20);
		posicoesValores.put(MAP_0_30, POS_map_0_30);
		posicoesValores.put(MAP_0_40, POS_map_0_40);
		posicoesValores.put(MAP_0_50, POS_map_0_50);
		posicoesValores.put(MAP_0_60, POS_map_0_60);
		posicoesValores.put(MAP_0_70, POS_map_0_70);
		posicoesValores.put(MAP_0_80, POS_map_0_80);
		posicoesValores.put(MAP_0_90, POS_map_0_90);
		posicoesValores.put(MAP_1_00, POS_map_1_00);
		posicoesValores.put(MAP_1_10, POS_map_1_10);
		posicoesValores.put(MAP_1_20, POS_map_1_20);
		posicoesValores.put(MAP_1_30, POS_map_1_30);
		posicoesValores.put(MAP_1_40, POS_map_1_40);
		posicoesValores.put(MAP_1_50, POS_map_1_50);
		posicoesValores.put(MAP_1_60, POS_map_1_60);
		posicoesValores.put(MAP_1_70, POS_map_1_70);
		posicoesValores.put(MAP_1_80, POS_map_1_80);
		posicoesValores.put(MAP_1_90, POS_map_1_90);
		posicoesValores.put(MAP_2_00, POS_map_2_00);

		return posicoesValores;

	}
	
	

	public static List<PosicaoValor> getListaPosicoesValores() {
		List<PosicaoValor> posicoesValores = new ArrayList<PosicaoValor>();
		posicoesValores.add(new PosicaoValor(MAP_m_0_90, POS_map_m_0_90));
		posicoesValores.add(new PosicaoValor(MAP_m_0_85, POS_map_m_0_85));
		posicoesValores.add(new PosicaoValor(MAP_m_0_80, POS_map_m_0_80));
		posicoesValores.add(new PosicaoValor(MAP_m_0_75, POS_map_m_0_75));
		posicoesValores.add(new PosicaoValor(MAP_m_0_70, POS_map_m_0_70));
		posicoesValores.add(new PosicaoValor(MAP_m_0_65, POS_map_m_0_65));
		posicoesValores.add(new PosicaoValor(MAP_m_0_60, POS_map_m_0_60));
		posicoesValores.add(new PosicaoValor(MAP_m_0_55, POS_map_m_0_55));
		posicoesValores.add(new PosicaoValor(MAP_m_0_50, POS_map_m_0_50));
		posicoesValores.add(new PosicaoValor(MAP_m_0_45, POS_map_m_0_45));
		posicoesValores.add(new PosicaoValor(MAP_m_0_40, POS_map_m_0_40));
		posicoesValores.add(new PosicaoValor(MAP_m_0_35, POS_map_m_0_35));
		posicoesValores.add(new PosicaoValor(MAP_m_0_30, POS_map_m_0_30));
		posicoesValores.add(new PosicaoValor(MAP_m_0_25, POS_map_m_0_25));
		posicoesValores.add(new PosicaoValor(MAP_m_0_20, POS_map_m_0_20));
		posicoesValores.add(new PosicaoValor(MAP_m_0_15, POS_map_m_0_15));
		posicoesValores.add(new PosicaoValor(MAP_m_0_10, POS_map_m_0_10));
		posicoesValores.add(new PosicaoValor(MAP_m_0_05, POS_map_m_0_05));
		posicoesValores.add(new PosicaoValor(MAP_0_00, POS_map_0_00));
		posicoesValores.add(new PosicaoValor(MAP_0_05, POS_map_0_05));
		posicoesValores.add(new PosicaoValor(MAP_0_10, POS_map_0_10));
		posicoesValores.add(new PosicaoValor(MAP_0_20, POS_map_0_20));
		posicoesValores.add(new PosicaoValor(MAP_0_30, POS_map_0_30));
		posicoesValores.add(new PosicaoValor(MAP_0_40, POS_map_0_40));
		posicoesValores.add(new PosicaoValor(MAP_0_50, POS_map_0_50));
		posicoesValores.add(new PosicaoValor(MAP_0_60, POS_map_0_60));
		posicoesValores.add(new PosicaoValor(MAP_0_70, POS_map_0_70));
		posicoesValores.add(new PosicaoValor(MAP_0_80, POS_map_0_80));
		posicoesValores.add(new PosicaoValor(MAP_0_90, POS_map_0_90));
		posicoesValores.add(new PosicaoValor(MAP_1_00, POS_map_1_00));
		posicoesValores.add(new PosicaoValor(MAP_1_10, POS_map_1_10));
		posicoesValores.add(new PosicaoValor(MAP_1_20, POS_map_1_20));
		posicoesValores.add(new PosicaoValor(MAP_1_30, POS_map_1_30));
		posicoesValores.add(new PosicaoValor(MAP_1_40, POS_map_1_40));
		posicoesValores.add(new PosicaoValor(MAP_1_50, POS_map_1_50));
		posicoesValores.add(new PosicaoValor(MAP_1_60, POS_map_1_60));
		posicoesValores.add(new PosicaoValor(MAP_1_70, POS_map_1_70));
		posicoesValores.add(new PosicaoValor(MAP_1_80, POS_map_1_80));
		posicoesValores.add(new PosicaoValor(MAP_1_90, POS_map_1_90));
		posicoesValores.add(new PosicaoValor(MAP_2_00, POS_map_2_00));

		return posicoesValores;

	}

	public PosicaoValor(float map, int posicao) {
		super();
		this.map = map;
		this.posicao = posicao;
	}

	public float getMap() {
		return map;
	}

	public void setMap(float map) {
		this.map = map;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public static final int POS_map_m_0_90 = 0;
	public static final int POS_map_m_0_85 = 1;
	public static final int POS_map_m_0_80 = 2;
	public static final int POS_map_m_0_75 = 3;
	public static final int POS_map_m_0_70 = 4;
	public static final int POS_map_m_0_65 = 5;
	public static final int POS_map_m_0_60 = 6;
	public static final int POS_map_m_0_55 = 7;
	public static final int POS_map_m_0_50 = 8;
	public static final int POS_map_m_0_45 = 9;
	public static final int POS_map_m_0_40 = 10;
	public static final int POS_map_m_0_35 = 11;
	public static final int POS_map_m_0_30 = 12;
	public static final int POS_map_m_0_25 = 13;
	public static final int POS_map_m_0_20 = 14;
	public static final int POS_map_m_0_15 = 15;
	public static final int POS_map_m_0_10 = 16;
	public static final int POS_map_m_0_05 = 17;
	public static final int POS_map_0_00 = 18;
	public static final int POS_map_0_05 = 19;
	public static final int POS_map_0_10 = 20;
	public static final int POS_map_0_20 = 21;
	public static final int POS_map_0_30 = 22;
	public static final int POS_map_0_40 = 23;
	public static final int POS_map_0_50 = 24;
	public static final int POS_map_0_60 = 25;
	public static final int POS_map_0_70 = 26;
	public static final int POS_map_0_80 = 27;
	public static final int POS_map_0_90 = 28;
	public static final int POS_map_1_00 = 29;
	public static final int POS_map_1_10 = 30;
	public static final int POS_map_1_20 = 31;
	public static final int POS_map_1_30 = 32;
	public static final int POS_map_1_40 = 33;
	public static final int POS_map_1_50 = 34;
	public static final int POS_map_1_60 = 35;
	public static final int POS_map_1_70 = 36;
	public static final int POS_map_1_80 = 37;
	public static final int POS_map_1_90 = 38;
	public static final int POS_map_2_00 = 39;

	public static float MAP_m_0_90 = -0.90f;
	public static float MAP_m_0_85 = -0.85f;
	public static float MAP_m_0_80 = -0.80f;
	public static float MAP_m_0_75 = -0.75f;
	public static float MAP_m_0_70 = -0.70f;
	public static float MAP_m_0_65 = -0.65f;
	public static float MAP_m_0_60 = -0.60f;
	public static float MAP_m_0_55 = -0.55f;
	public static float MAP_m_0_50 = -0.50f;
	public static float MAP_m_0_45 = -0.45f;
	public static float MAP_m_0_40 = -0.40f;
	public static float MAP_m_0_35 = -0.35f;
	public static float MAP_m_0_30 = -0.30f;
	public static float MAP_m_0_25 = -0.25f;
	public static float MAP_m_0_20 = -0.20f;
	public static float MAP_m_0_15 = -0.15f;
	public static float MAP_m_0_10 = -0.10f;
	public static float MAP_m_0_05 = -0.05f;
	public static float MAP_0_00 = 0.00f;
	public static float MAP_0_05 = 0.05f;
	public static float MAP_0_10 = 0.10f;
	public static float MAP_0_20 = 0.20f;
	public static float MAP_0_30 = 0.30f;
	public static float MAP_0_40 = 0.40f;
	public static float MAP_0_50 = 0.50f;
	public static float MAP_0_60 = 0.60f;
	public static float MAP_0_70 = 0.70f;
	public static float MAP_0_80 = 0.80f;
	public static float MAP_0_90 = 0.90f;
	public static float MAP_1_00 = 1.00f;
	public static float MAP_1_10 = 1.10f;
	public static float MAP_1_20 = 1.20f;
	public static float MAP_1_30 = 1.30f;
	public static float MAP_1_40 = 1.40f;
	public static float MAP_1_50 = 1.50f;
	public static float MAP_1_60 = 1.60f;
	public static float MAP_1_70 = 1.70f;
	public static float MAP_1_80 = 1.80f;
	public static float MAP_1_90 = 1.90f;
	public static float MAP_2_00 = 2.00f;

}
