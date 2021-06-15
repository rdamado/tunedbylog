package sandbox;

public class RawBaseConverter {
	public Object get(byte[] mapa, DescricaoItemMapa descricao, int index) {
		int pos, lo, hi, intValor = 0;

//		switch (descricao.getTipo()) {
//		case INT8:
//		case MATRIZ8:
//			pos = descricao.getPosicao() + index;
//			intValor = mapa[pos] & 0xFF;
//			break;
//
//		case INT16:
//		case MATRIZ16:
		pos = descricao.getPosicao() + index * 2;

		lo = mapa[pos] & 0xFF;
		hi = mapa[pos + 1] & 0xFF;

		intValor = hi;
		intValor <<= 8;
		intValor |= lo;
//			break;
//		}

		return Integer.valueOf(intValor);
	}

//	public void set(byte[] mapa, DescricaoItemMapa descricao, Object valor, int index) {
//		int pos, lo, hi, intValor = ((Integer) valor).intValue();
//
//		switch (descricao.getTipo()) {
//		case INT8:
//		case MATRIZ8:
//			pos = descricao.getPosicao() + index;
//			mapa[pos] = (byte) intValor;
//			break;
//
//		case INT16:
//		case MATRIZ16:
//			lo = intValor & 0xFF;
//			hi = intValor >> 8 & 0xFF;
//
//			pos = descricao.getPosicao() + index * 2;
//
//			mapa[pos] = (byte) lo;
//			mapa[pos + 1] = (byte) hi;
//			break;
//		}
//	}

	public boolean equals(Object oldValue, Object newValue) {
		int oldInt = ((Integer) oldValue).intValue();
		int newInt = ((Integer) newValue).intValue();

		return (oldInt == newInt);
	}
}
