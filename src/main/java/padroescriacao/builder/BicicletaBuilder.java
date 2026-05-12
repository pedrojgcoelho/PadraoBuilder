package padroescriacao.builder;

import java.util.ArrayList;
import java.util.List;

public class BicicletaBuilder {

    private String modelo;
    private String tipoQuadro;
    private int aro;
    private String cor;
    private String freio;
    private String cambio;
    private String suspensao;
    private double valorBase;
    private List<String> acessorios = new ArrayList<>();

    public BicicletaBuilder setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public BicicletaBuilder setTipoQuadro(String tipoQuadro) {
        this.tipoQuadro = tipoQuadro;
        return this;
    }

    public BicicletaBuilder setAro(int aro) {
        this.aro = aro;
        return this;
    }

    public BicicletaBuilder setCor(String cor) {
        this.cor = cor;
        return this;
    }

    public BicicletaBuilder setFreio(String freio) {
        this.freio = freio;
        return this;
    }

    public BicicletaBuilder setCambio(String cambio) {
        this.cambio = cambio;
        return this;
    }

    public BicicletaBuilder setSuspensao(String suspensao) {
        this.suspensao = suspensao;
        return this;
    }

    public BicicletaBuilder setValorBase(double valorBase) {
        this.valorBase = valorBase;
        return this;
    }

    public BicicletaBuilder adicionarAcessorio(String acessorio) {
        this.acessorios.add(acessorio);
        return this;
    }

    public Bicicleta build() {
        validarBicicleta();

        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setModelo(modelo);
        bicicleta.setTipoQuadro(tipoQuadro);
        bicicleta.setAro(aro);
        bicicleta.setCor(cor);
        bicicleta.setFreio(freio);
        bicicleta.setCambio(cambio);
        bicicleta.setSuspensao(suspensao);
        bicicleta.setValorBase(valorBase);
        bicicleta.setAcessorios(acessorios);

        return bicicleta;
    }

    private void validarBicicleta() {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("Modelo da bicicleta é obrigatório.");
        }
        if (tipoQuadro == null || tipoQuadro.isBlank()) {
            throw new IllegalArgumentException("Tipo do quadro é obrigatório.");
        }
        if (aro <= 0) {
            throw new IllegalArgumentException("Aro da bicicleta deve ser maior que zero.");
        }
        if (valorBase <= 0) {
            throw new IllegalArgumentException("Valor da bicicleta deve ser maior que zero.");
        }
    }
}
