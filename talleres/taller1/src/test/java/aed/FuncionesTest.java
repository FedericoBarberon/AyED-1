package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class FuncionesTest {
    Funciones funciones = new Funciones();

    @Test
    void testCuadrado() {
        assertEquals(0, funciones.cuadrado(0));
        assertEquals(4, funciones.cuadrado(2));
        assertEquals(9, funciones.cuadrado(3));
    }

    @Test
    void testDistancia() {
        assertEquals(0, funciones.distancia(0, 0), 1e-5);
        assertEquals(5, funciones.distancia(3, 4), 1e-5);
        assertEquals(1.41421356237, funciones.distancia(1, 1), 1e-5);
        assertEquals(8.0622577483, funciones.distancia(7, 4), 1e-5);
    }

    @Test
    void testPar() {
        assertTrue(funciones.esPar(0));
        assertTrue(funciones.esPar(-2));
        assertTrue(funciones.esPar(8));
        assertTrue(funciones.esPar(14));
        assertFalse(funciones.esPar(1));
        assertFalse(funciones.esPar(-7));
        assertFalse(funciones.esPar(33));
    }

    @Test
    void testBisiesto() {
        assertTrue(funciones.esBisiesto(2024));
        assertTrue(funciones.esBisiesto(2012));
        assertTrue(funciones.esBisiesto(2000));
        assertFalse(funciones.esBisiesto(2023));
        assertFalse(funciones.esBisiesto(2014));
        assertFalse(funciones.esBisiesto(2100));
    }

    @Test
    void testFactorialIterativo() {
        assertEquals(1, funciones.factorialIterativo(0));
        assertEquals(1, funciones.factorialIterativo(1));
        assertEquals(2, funciones.factorialIterativo(2));
        assertEquals(120, funciones.factorialIterativo(5));
        assertEquals(3628800, funciones.factorialIterativo(10));
    }

    @Test
    void testFactorialRecursivo() {
        assertEquals(1, funciones.factorialRecursivo(0));
        assertEquals(1, funciones.factorialRecursivo(1));
        assertEquals(2, funciones.factorialRecursivo(2));
        assertEquals(120, funciones.factorialRecursivo(5));
        assertEquals(3628800, funciones.factorialRecursivo(10));
    }

    @Test
    void testPrimo() {
        assertFalse(funciones.esPrimo(0));
        assertFalse(funciones.esPrimo(1));
        assertFalse(funciones.esPrimo(4));
        assertFalse(funciones.esPrimo(49));
        assertTrue(funciones.esPrimo(2));
        assertTrue(funciones.esPrimo(3));
        assertTrue(funciones.esPrimo(17));
    }

    @Test
    void testSumatoria() {
        assertEquals(0, funciones.sumatoria(new int[]{}));
        assertEquals(15, funciones.sumatoria(new int[]{0,1,2,3,4,5}));
        assertEquals(10, funciones.sumatoria(new int[]{2,3,5}));
        assertEquals(-8, funciones.sumatoria(new int[]{5, -25, 4, 8}));
    }

    @Test
    void testBusqueda() {
        assertEquals(0, funciones.busqueda(new int[]{1, 2, 3}, 1));
        assertEquals(2, funciones.busqueda(new int[]{10, 11, 15, 24}, 15));
        assertEquals(3, funciones.busqueda(new int[]{10, 11, 15, 24}, 24));
    }

    @Test
    void testTienePrimo() {
        assertFalse(funciones.tienePrimo(new int[]{1,4,6,15}));
        assertTrue(funciones.tienePrimo(new int[]{7,4,6,15}));
        assertTrue(funciones.tienePrimo(new int[]{1,4,7,15}));
        assertTrue(funciones.tienePrimo(new int[]{1,4,6,7}));
        assertTrue(funciones.tienePrimo(new int[]{2, 5, 11}));
    }

    @Test
    void testTodosPares() {
        assertTrue(funciones.todosPares(new int[]{6, 2, 14, 20}));
        assertFalse(funciones.todosPares(new int[]{3, 2, 14, 20}));
        assertFalse(funciones.todosPares(new int[]{6, 3, 14, 20}));
        assertFalse(funciones.todosPares(new int[]{6, 2, 14, 7}));
    }

    @Test
    void testPrefijo() {
        assertTrue(funciones.esPrefijo("abcde", "abcde"));
        assertTrue(funciones.esPrefijo("abcde", "abcdefg"));
        assertFalse(funciones.esPrefijo("abcde", "bcdefg"));
        assertFalse(funciones.esPrefijo("abcde", "abcdfg"));
        assertFalse(funciones.esPrefijo("abcde", "abc"));
    }

    @Test
    void testSufijo() {
        assertTrue(funciones.esSufijo("edcba", "edcba"));
        assertTrue(funciones.esSufijo("edcba", "gfedcba"));
        assertFalse(funciones.esSufijo("edcba", "gfedcb"));
        assertFalse(funciones.esSufijo("edcba", "gfdcba"));
        assertFalse(funciones.esSufijo("edcba", "cba"));
    }
}
