public class TresBucles {

    public static void main(String[] args) {

        // 1. Bucle FOR
        for (int i = 1; i <= 3; i++) {
            System.out.println("FOR: " + i);
        }

        // 2. Bucle WHILE
        int j = 1;

        while (j <= 3) {
            System.out.println("WHILE: " + j);
            j++;
        }

        bucleInterno();

        // 3. Bucle DO-WHILE
        int k = 1;

        do {
            System.out.println("DO-WHILE: " + k);
            k++;
        } while (k <= 3);
    }

    public static void bucleInterno(){
        int k = 1;

        do {
            System.out.println("DO-WHILE: " + k);
            k++;
        }while (k <= 3);
    }
}