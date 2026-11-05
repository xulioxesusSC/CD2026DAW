package com.xulioxesus;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ContaBancariaTest {

    private ContaBancaria conta;
    private ContaBancaria destino;

    @BeforeEach
    void setUp() {
        conta = new ContaBancaria("Ana", 1000);
        destino = new ContaBancaria("Pedro", 500);
    }

    // CONSTRUCTOR

    @Test
    void testConstructorValido() {
        assertEquals("Ana", conta.getTitular());
        assertEquals(1000, conta.getSaldo());
        assertFalse(conta.isBloqueada());
    }

    @Test
    void testConstructorTitularNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria(null, 100));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void testConstructorTitularBaleiro(String titular) {
        assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria(titular, 100));
    }

    @Test
    void testConstructorSaldoNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria("Ana", -100));
    }

    @Test
    void testConstructorSaldoCero() {
        ContaBancaria nova = new ContaBancaria("Ana", 0);
        assertEquals(0, nova.getSaldo());
    }

    // INGRESAR

    @Test
    void testIngresarCorrectamente() {
        conta.ingresar(200);
        assertEquals(1200, conta.getSaldo());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -100})
    void testIngresarCantidadeInvalida(double cantidade) {
        assertThrows(IllegalArgumentException.class,
                () -> conta.ingresar(cantidade));

        assertEquals(1000, conta.getSaldo());
    }

    @Test
    void testIngresarContaBloqueada() {
        conta.bloquear();

        assertThrows(IllegalStateException.class,
                () -> conta.ingresar(100));

        assertEquals(1000, conta.getSaldo());
    }

    // RETIRAR

    @Test
    void testRetirarCorrectamente() {
        conta.retirar(300);
        assertEquals(700, conta.getSaldo());
    }

    @Test
    void testRetirarSaldoExacto() {
        conta.retirar(1000);
        assertEquals(0, conta.getSaldo());
    }

    @Test
    void testRetirarSaldoInsuficiente() {
        assertThrows(IllegalArgumentException.class,
                () -> conta.retirar(1500));

        assertEquals(1000, conta.getSaldo());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -50})
    void testRetirarCantidadeInvalida(double cantidade) {
        assertThrows(IllegalArgumentException.class,
                () -> conta.retirar(cantidade));

        assertEquals(1000, conta.getSaldo());
    }

    @Test
    void testRetirarContaBloqueada() {
        conta.bloquear();

        assertThrows(IllegalStateException.class,
                () -> conta.retirar(100));

        assertEquals(1000, conta.getSaldo());
    }

    // TRANSFERIR

    @Test
    void testTransferirCorrectamente() {
        conta.transferir(destino, 200);

        assertEquals(800, conta.getSaldo());
        assertEquals(700, destino.getSaldo());
    }

    @Test
    void testTransferirDestinoNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> conta.transferir(null, 100));

        assertEquals(1000, conta.getSaldo());
    }

    @Test
    void testTransferirSaldoInsuficiente() {
        assertThrows(IllegalArgumentException.class,
                () -> conta.transferir(destino, 1500));

        assertEquals(1000, conta.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void testTransferirDestinoBloqueado() {
        destino.bloquear();

        assertThrows(IllegalStateException.class,
                () -> conta.transferir(destino, 100));

        assertEquals(1000, conta.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void testTransferirOrixeBloqueada() {
        conta.bloquear();

        assertThrows(IllegalStateException.class,
                () -> conta.transferir(destino, 100));

        assertEquals(1000, conta.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void testTransferirCantidadeInvalida() {
        assertThrows(IllegalArgumentException.class,
                () -> conta.transferir(destino, 0));

        assertEquals(1000, conta.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    // BLOQUEAR E DESBLOQUEAR

    @Test
    void testBloquear() {
        conta.bloquear();
        assertTrue(conta.isBloqueada());
    }

    @Test
    void testDesbloquear() {
        conta.bloquear();
        conta.desbloquear();

        assertFalse(conta.isBloqueada());

        conta.ingresar(100);
        assertEquals(1100, conta.getSaldo());
    }

    // GETTERS

    @Test
    void testGetSaldo() {
        assertEquals(1000, conta.getSaldo());
    }

    @Test
    void testGetTitular() {
        assertEquals("Ana", conta.getTitular());
    }

    @Test
    void testIsBloqueada() {
        assertFalse(conta.isBloqueada());

        conta.bloquear();
        assertTrue(conta.isBloqueada());
    }

    // CASOS ESPECIAIS

    @Test
    void testTransferenciaMismaConta() {
        conta.transferir(conta, 200);

        assertEquals(1000, conta.getSaldo());
    }
}
