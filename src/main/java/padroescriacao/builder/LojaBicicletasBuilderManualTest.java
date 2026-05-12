package padroescriacao.builder;

public class LojaBicicletasBuilderManualTest {

    public static void main(String[] args) {
        deveMontarMountainBike();
        deveMontarSpeed();
        deveMontarUrbana();
        deveMontarBicicletaPersonalizadaComBuilder();
        deveRetornarErroQuandoModeloNaoForInformado();
        deveRetornarErroQuandoValorForInvalido();

        System.out.println("Todos os testes manuais passaram com sucesso!");
    }

    private static void deveMontarMountainBike() {
        LojaBicicletas loja = new LojaBicicletas();
        Bicicleta bicicleta = loja.montarMountainBike("Caloi Explorer", "Preta");

        assertEquals("Caloi Explorer", bicicleta.getModelo());
        assertEquals("Mountain Bike", bicicleta.getTipoQuadro());
        assertEquals(29, bicicleta.getAro());
        assertTrue(bicicleta.getAcessorios().contains("Suporte de garrafa"));
        System.out.println("OK - deveMontarMountainBike");
    }

    private static void deveMontarSpeed() {
        LojaBicicletas loja = new LojaBicicletas();
        Bicicleta bicicleta = loja.montarSpeed("Sense Sprint", "Vermelha");

        assertEquals("Speed", bicicleta.getTipoQuadro());
        assertEquals(700, bicicleta.getAro());
        assertTrue(bicicleta.getAcessorios().contains("Guidão drop"));
        System.out.println("OK - deveMontarSpeed");
    }

    private static void deveMontarUrbana() {
        LojaBicicletas loja = new LojaBicicletas();
        Bicicleta bicicleta = loja.montarUrbana("Monark City", "Azul");

        assertEquals("Urbana", bicicleta.getTipoQuadro());
        assertEquals(26, bicicleta.getAro());
        assertTrue(bicicleta.getAcessorios().contains("Bagageiro"));
        System.out.println("OK - deveMontarUrbana");
    }

    private static void deveMontarBicicletaPersonalizadaComBuilder() {
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
                .build();

        assertEquals("Bike Personalizada", bicicleta.getModelo());
        assertTrue(bicicleta.getAcessorios().contains("Farol"));
        System.out.println("OK - deveMontarBicicletaPersonalizadaComBuilder");
    }

    private static void deveRetornarErroQuandoModeloNaoForInformado() {
        try {
            new BicicletaBuilder()
                    .setTipoQuadro("Mountain Bike")
                    .setAro(29)
                    .setValorBase(3000.00)
                    .build();
            throw new AssertionError("Era esperado erro de modelo obrigatório.");
        } catch (IllegalArgumentException exception) {
            assertEquals("Modelo da bicicleta é obrigatório.", exception.getMessage());
            System.out.println("OK - deveRetornarErroQuandoModeloNaoForInformado");
        }
    }

    private static void deveRetornarErroQuandoValorForInvalido() {
        try {
            new BicicletaBuilder()
                    .setModelo("Bike Teste")
                    .setTipoQuadro("Urbana")
                    .setAro(26)
                    .setValorBase(0)
                    .build();
            throw new AssertionError("Era esperado erro de valor inválido.");
        } catch (IllegalArgumentException exception) {
            assertEquals("Valor da bicicleta deve ser maior que zero.", exception.getMessage());
            System.out.println("OK - deveRetornarErroQuandoValorForInvalido");
        }
    }

    private static void assertEquals(Object esperado, Object obtido) {
        if (!esperado.equals(obtido)) {
            throw new AssertionError("Esperado: " + esperado + " | Obtido: " + obtido);
        }
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) {
            throw new AssertionError("Condição esperada como verdadeira.");
        }
    }
}
