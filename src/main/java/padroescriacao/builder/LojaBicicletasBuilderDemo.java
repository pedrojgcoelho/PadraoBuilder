package padroescriacao.builder;

public class LojaBicicletasBuilderDemo {

    public static void main(String[] args) {
        LojaBicicletas loja = new LojaBicicletas();

        Bicicleta mountainBike = loja.montarMountainBike("Caloi Explorer", "Preta");
        Bicicleta speed = loja.montarSpeed("Sense Sprint", "Vermelha");
        Bicicleta urbana = loja.montarUrbana("Monark City", "Azul");

        System.out.println(mountainBike.getDescricao());
        System.out.println(speed.getDescricao());
        System.out.println(urbana.getDescricao());
    }
}
