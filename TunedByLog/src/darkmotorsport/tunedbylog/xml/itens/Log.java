package darkmotorsport.tunedbylog.xml.itens;

import java.util.ArrayList;
import java.util.List;

public class Log {
    private boolean acompanharPonteiro = true;
    private String enderecoArquivo;
    private LogInformacao informacao;
    private List<DataCanal> listaDados = new ArrayList<DataCanal>();
    private List<Tag> listaTags = new ArrayList<Tag>();
    private String tipoControle = "L";
    private boolean controleLargadaHabilitado;
    private String controleLargadaModo = "T";
    private int idCanalExibicao;
    private List<ControleLargadaItem> controleLargada = new ArrayList<ControleLargadaItem>();
    private List<ControleTracaoMarcha> controleTracao = new ArrayList<ControleTracaoMarcha>();
    private String resumo = "";
    
    public boolean autoCorrecaoAtivada = false;

    public boolean isAcompanharPonteiro() {
        return this.acompanharPonteiro;
    }

    public void setAcompanharPonteiro(boolean acompanharPonteiro) {
        this.acompanharPonteiro = acompanharPonteiro;
    }

    public String getEnderecoArquivo() {
        return this.enderecoArquivo;
    }

    public void setEnderecoArquivo(String enderecoArquivo) {
        this.enderecoArquivo = enderecoArquivo;
    }

    public LogInformacao getInformacao() {
        return this.informacao;
    }

    public void setInformacao(LogInformacao informacao) {
        this.informacao = informacao;
    }

    public List<DataCanal> getListaDados() {
        return this.listaDados;
    }

    public void setListaDados(List<DataCanal> listaDados) {
        this.listaDados = listaDados;
    }

    public List<Tag> getListaTags() {
        return this.listaTags;
    }

    public void setListaTags(List<Tag> listaTags) {
        this.listaTags = listaTags;
    }

    public String getTipoControle() {
        return this.tipoControle;
    }

    public void setTipoControle(String tipoControle) {
        if (tipoControle == null || !tipoControle.equals("T")) {
            tipoControle = "L";
        }
        this.tipoControle = tipoControle;
    }

    public boolean isControleLargadaHabilitado() {
        return this.controleLargadaHabilitado;
    }

    public void setControleLargadaHabilitado(boolean controleLargadaHabilitado) {
        this.controleLargadaHabilitado = controleLargadaHabilitado;
    }

    public String getControleLargadaModo() {
        return this.controleLargadaModo;
    }

    public void setControleLargadaModo(String controleLargadaModo) {
        this.controleLargadaModo = controleLargadaModo;
    }

    public List<ControleLargadaItem> getControleLargada() {
        return this.controleLargada;
    }

    public void setControleLargada(List<ControleLargadaItem> controleLargada) {
        this.controleLargada = controleLargada;
    }

    public List<ControleTracaoMarcha> getControleTracao() {
        return this.controleTracao;
    }

    public void setControleTracao(List<ControleTracaoMarcha> controleTracao) {
        this.controleTracao = controleTracao;
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getIdCanalExibicao() {
        return this.idCanalExibicao;
    }

    public void setIdCanalExibicao(int idCanalSelecionado) {
        this.idCanalExibicao = idCanalSelecionado;
    }
}