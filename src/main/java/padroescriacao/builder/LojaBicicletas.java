package padroescriacao.builder;

public class LojaBicicletas {

    public Bicicleta montarMountainBike(String modelo, String cor) {
        return new BicicletaBuilder()
                .setModelo(modelo)
                .setTipoQuadro("Mountain Bike")
                .setAro(29)
                .setCor(cor)
                .setFreio("Disco hidráulico")
                .setCambio("Shimano 21 marchas")
                .setSuspensao("Dianteira com trava")
                .setValorBase(3500.00)
                .adicionarAcessorio("Suporte de garrafa")
                .adicionarAcessorio("Protetor de corrente")
                .build();
    }

    public Bicicleta montarSpeed(String modelo, String cor) {
        return new BicicletaBuilder()
                .setModelo(modelo)
                .setTipoQuadro("Speed")
                .setAro(700)
                .setCor(cor)
                .setFreio("Ferradura")
                .setCambio("Shimano Claris 16 marchas")
                .setSuspensao("Sem suspensão")
                .setValorBase(4200.00)
                .adicionarAcessorio("Guidão drop")
                .adicionarAcessorio("Pneu fino")
                .build();
    }

    public Bicicleta montarUrbana(String modelo, String cor) {
        return new BicicletaBuilder()
                .setModelo(modelo)
                .setTipoQuadro("Urbana")
                .setAro(26)
                .setCor(cor)
                .setFreio("V-Brake")
                .setCambio("Shimano 7 marchas")
                .setSuspensao("Sem suspensão")
                .setValorBase(1800.00)
                .adicionarAcessorio("Bagageiro")
                .adicionarAcessorio("Campainha")
                .adicionarAcessorio("Paralama")
                .build();
    }
}
