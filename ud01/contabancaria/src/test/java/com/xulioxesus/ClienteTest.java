package com.xulioxesus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ClienteTest {

    @Test
    void testValoresInicialesNulos() {
        Cliente cliente = new Cliente();

        assertNull(cliente.getNome());
        assertNull(cliente.getDni());
        assertNull(cliente.getApelidos());
        assertNull(cliente.getEmail());
        assertNull(cliente.getTelefono());
    }

    @Test
    void testGettersESetters() {
        Cliente cliente = new Cliente();
        cliente.setNome("Ana");
        cliente.setDni("12345678A");
        cliente.setApelidos("Pérez López");
        cliente.setEmail("ana@example.com");
        cliente.setTelefono("600123456");

        assertEquals("Ana", cliente.getNome());
        assertEquals("12345678A", cliente.getDni());
        assertEquals("Pérez López", cliente.getApelidos());
        assertEquals("ana@example.com", cliente.getEmail());
        assertEquals("600123456", cliente.getTelefono());
    }
}
