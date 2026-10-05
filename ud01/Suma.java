import java.util.Scanner;

public class Suma {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Itroduce el pri: ");
        double numero1 = lector.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double numero2 = lector.nextDouble();

        double suma = numero1 + numero2;

        System.out.println("La suma es: " + suma);

        lector.close();
    }
}

