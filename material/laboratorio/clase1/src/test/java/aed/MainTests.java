package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MainTests {
    Main main = new Main();

    @Test
    void fibTests() {
        assertEquals(0, main.fibonacci(0));
        assertEquals(1, main.fibonacci(1));
        assertEquals(1, main.fibonacci(2));
        assertEquals(2, main.fibonacci(3));
        assertEquals(3, main.fibonacci(4));
        assertEquals(5, main.fibonacci(5));
        assertEquals(8, main.fibonacci(6));
        assertEquals(13, main.fibonacci(7));
    }

    @Test
    void fibRetTests() {
        assertEquals(0, main.fibonacciReturn(0));
        assertEquals(1, main.fibonacciReturn(2));
        assertEquals(1, main.fibonacciReturn(1));
        assertEquals(2, main.fibonacciReturn(3));
        assertEquals(3, main.fibonacciReturn(4));
        assertEquals(5, main.fibonacciReturn(5));
        assertEquals(8, main.fibonacciReturn(6));
        assertEquals(13, main.fibonacciReturn(7));
    }

    @Test
    void maximoTests() {
        assertEquals(5, main.maximo(new double[]{1,2,3,4,5}));
        assertEquals(7, main.maximo(new double[]{1,2,7,4,5}));
        assertEquals(-3, main.maximo(new double[]{-8, -4, -5, -3, -10}));
    }

    @Test
    void sumarArreglosTests() {
        assertArrayEquals(new int[]{1,2,3}, main.sumarArreglos(new int[]{1,2,3}, new int[]{0,0,0}));
        assertArrayEquals(new int[]{-1,-4,7}, main.sumarArreglos(new int[]{1,2,3}, new int[]{-2,-6,4}));
    }

    @Test
    void inicialesTests() {
        assertEquals("h", main.iniciales("hola"));
        assertEquals("hm", main.iniciales("hola mundo"));
        assertEquals("hm", main.iniciales("hola   mundo"));
    }

}
