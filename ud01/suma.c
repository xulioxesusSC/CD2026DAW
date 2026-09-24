#include <stdio.h>

int main() {
    int num1, num2, suma;

    printf("Introduce o primeiro número: ");
    scanf("%d", &num1);

    printf("Introduce o segundo número: ");
    scanf("%d", &num2);

    suma = num1 + num2;

    printf("A suma é: %d\n", suma);

    return 0;
}