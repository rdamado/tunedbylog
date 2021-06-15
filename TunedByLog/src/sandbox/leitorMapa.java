package sandbox;

public class leitorMapa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double[] getBancadaA(byte[] mapabyte) {
		double[] mapa = new double[256];

		for (int i = 0; i < 256; i++) {
			mapa[i] = ((Double) getValorInj3dA(i, mapabyte)).doubleValue();
		}

		return mapa;
	}

	public static Object getValorInj3dA(int p, byte[] mapa) {
		return getValorInj3dA(p, true, mapa);
	}

	public static Object getValorInj3dA(int p, boolean formatoConvertido, byte[] mapa) {
//		MotorMapa motorMapa = MotorMapaFactory.getInstance();

		if (p >= 256) {
			p = 255;
		}

		if (p < 175)
			return get(MapaEnum.B0_INJ_3D_A1, p, formatoConvertido, mapa);
		if (p < 220) {
			return get(MapaEnum.B1_INJ_3D_A2, p - 175, formatoConvertido, mapa);
		}
		return get(MapaEnum.B2_INJ_3D_A3, p - 220, formatoConvertido, mapa);
	}

	public static Object get(MapaEnum item, int index, boolean formatoConvertido, byte[] mapa) {
		RawBaseConverter rawBaseConverter = new RawBaseConverter();
//		DescricaoItemMapa desc = this.descricoes.get(item);
		return rawBaseConverter.get(mapa, null, index);
	}

}
