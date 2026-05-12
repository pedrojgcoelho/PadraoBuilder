package padroescriacao.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bicicleta {

    private String modelo;
    private String tipoQuadro;
    private int aro;
    private String cor;
    private String freio;
    private String cambio;
    private String suspensao;
    private double valorBase;
    private List<String> acessorios;

    public Bicicleta() {
        this.acessorios = new ArrayList<>();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoQuadro() {
        return tipoQuadro;
    }

    public void setTipoQuadro(String tipoQuadro) {
        this.tipoQuadro = tipoQuadro;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getFreio() {
        return freio;
    }

    public void setFreio(String freio) {
        this.freio = freio;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getSuspensao() {
        return suspensao;
    }

    public void setSuspensao(String suspensao) {
        this.suspensao = suspensao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public List<String> getAcessorios() {
        return Collections.unmodifiableList(acessorios);
    }

    public void setAcessorios(List<String> acessorios) {
        this.acessorios = new ArrayList<>(acessorios);
    }

    public String getDescricao() {
        return modelo + " - Quadro " + tipoQuadro
                + ", aro " + aro
                + ", cor " + cor
                + ", freio " + freio
                + ", câmbio " + cambio
                + ", suspensão " + suspensao
                + ", acessórios " + acessorios
                + ", valor R$ " + String.format("%.2f", valorBase);
    }
}
