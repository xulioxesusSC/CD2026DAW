import java.util.Random;

public class Sorteo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java Sorteo <número positivo>");
            return;
        }

        int limite;
        try {
            limite = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("O argumento debe ser un número enteiro.");
            return;
        }

        if (limite < 1) {
            System.err.println("O número debe ser maior que cero.");
            return;
        }

        int resultado = new Random().nextInt(limite) + 1;
        System.out.println(resultado);
    }
}
