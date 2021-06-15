package sandbox;

public class DescricaoItemMapa {
	private int posicao;
	private int tamanho;
	private RawBaseConverter converter;
//	private List<ChangeEventMotorMapa> listeners = new ArrayList<>();
//	private TipoItemMotorMapaEnum tipo;
	private DescricaoItemMapa flagRegion;

	public int getPosicao() {
		return this.posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public RawBaseConverter getConverter() {
		return this.converter;
	}

	public void setConverter(RawBaseConverter converter) {
		this.converter = converter;
	}

//	public List<ChangeEventMotorMapa> getListeners() {
//		return this.listeners;
//	}
//
//	public void setListeners(List<ChangeEventMotorMapa> listeners) {
//		this.listeners = listeners;
//	}
//
//	public TipoItemMotorMapaEnum getTipo() {
//		return this.tipo;
//	}
//
//	public void setTipo(TipoItemMotorMapaEnum tipo) {
//		this.tipo = tipo;
//	}

	public DescricaoItemMapa getFlagRegion() {
		return this.flagRegion;
	}

	public void setFlagRegion(DescricaoItemMapa flagRegion) {
		this.flagRegion = flagRegion;
	}
}
