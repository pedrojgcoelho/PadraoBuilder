package padroescriacao.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LojaBicicletasBuilderTest {

    @Test
    public void deveMontarMountainBike() {
        LojaBicicletas loja = new LojaBicicletas();
        Bicicleta bicicleta = loja.montarMountainBike("Caloi Explorer", "Preta");

        assertEquals("Caloi Explorer", bicicleta.getModelo());
        assertEquals("Mountain Bike", bicicleta.getTipoQuadro());
        assertEquals(29, bicicleta.getAro());
        assertEquals("Preta", bicicleta.getCor());
        assertEquals("Disco hidráulico", bicicleta.getFreio());
        assertTrue(bicicleta.getAcessorios().contains("Suporte de garrafa"));
    }

    @Test
    public void deveMontarSpeed() {
        LojaBicicletas loja = new LojaBicicletas();
        Bicicleta bicicleta = loja.montarSpeed("Sense Sprint", "Vermelha");

        assertEquals("Sense Sprint", bicicleta.getModelo());
        assertEquals("Speed", bicicleta.getTipoQuadro());
        assertEquals(700, bicicleta.getAro());
        assertEquals("Vermelha", bicicleta.getCor());
        assertEquals("Ferradura", bicicleta.getFreio());
        assertTrue(bicicleta.getAcessorios().contains("Guidão drop"));
    }

    @Test
    public void deveMontarUrbana() {
        LojaBicicletas loja = new LojaBicicletas();
        Bicicleta bicicleta = loja.montarUrbana("Monark City", "Azul");

        assertEquals("Monark City", bicicleta.getModelo());
        assertEquals("Urbana", bicicleta.getTipoQuadro());
        assertEquals(26, bicicleta.getAro());
        assertEquals("Azul", bicicleta.getCor());
        assertEquals("V-Brake", bicicleta.getFreio());
        assertTrue(bicicleta.getAcessorios().contains("Bagageiro"));
    }

    @Test
    public void deveMontarBicicletaPersonalizadaComBuilder() {
        Bicicleta bicicleta = new BicicletaBuilder()
                .setModelo("Bike Personalizada")
                .setTipoQuadro("Gravel")
                .setAro(700)
                .setCor("Cinza")
                .setFreio("Disco mecânico")
                .setCambio("Shimano 18 marchas")
                .setSuspensao("Sem suspensão")
                .setValorBase(5000.00)
                .adicionarAcessorio("Farol")
                .adicionarAcessorio("Bolsa de selim")
                .build();

        assertEquals("Bike Personalizada", bicicleta.getModelo());
        assertEquals("Gravel", bicicleta.getTipoQuadro());
        assertTrue(bicicleta.getAcessorios().contains("Farol"));
        assertTrue(bicicleta.getAcessorios().contains("Bolsa de selim"));
    }

    @Test
    public void deveRetornarErroQuandoModeloNaoForInformado() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BicicletaBuilder()
                .setTipoQuadro("Mountain Bike")
                .setAro(29)
                .setValorBase(3000.00)
                .build());

        assertEquals("Modelo da bicicleta é obrigatório.", exception.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoValorForInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BicicletaBuilder()
                .setModelo("Bike Teste")
                .setTipoQuadro("Urbana")
                .setAro(26)
                .setValorBase(0)
                .build());

        assertEquals("Valor da bicicleta deve ser maior que zero.", exception.getMessage());
    }
}
