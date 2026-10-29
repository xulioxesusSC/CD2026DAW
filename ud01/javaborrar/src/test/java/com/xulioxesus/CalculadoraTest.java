package com.xulioxesus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    public void probarSuma() {
        assertEquals(5, calculadora.sumar(2, 3));
    }

    @Test
    public void probarResta() {
        assertEquals(2, calculadora.restar(5, 3));
    }

    @Test
    public void probarMultiplicacion() {
        assertEquals(12, calculadora.multiplicar(3, 4));
    }

    @Test
    public void probarDivision() {
        assertEquals(2.0, calculadora.dividir(6, 3), 0.001);
    }

    @Test
    public void probarDivisionEntreCero() {
        assertThrows(
            IllegalArgumentException.class,
            () -> calculadora.dividir(10, 0)
        );
    }
}