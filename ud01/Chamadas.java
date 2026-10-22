public class Chamadas {

    public static void main(String[] args) {
        String nome = "Ana";
        int numero = 10;

        funcion1(nome, numero);

        System.out.println("hola");
    }

    public static void funcion1(String nome, int numero) {
        String mensaxe = "Ola, " + nome;
        int valor1 = numero + 5;
        numero++;

        System.out.println("Nivel 1: " + mensaxe);
        funcion2(nome, valor1, mensaxe);
    }

    public static void funcion2(String nome, int valor, String mensaxe) {
        int valor2 = valor * 2;
        String contexto = mensaxe + ". Estamos no nivel 2.";

        System.out.println("Nivel 2: " + contexto);
        funcion3(nome, valor2, contexto);
    }

    public static void funcion3(String nome, int valor, String contexto) {
        int resultado = valor + 10;

        System.out.println("Nivel 3: " + nome);
        System.out.println("Contexto recibido: " + contexto);
        System.out.println("Resultado final: " + resultado);
    }
}