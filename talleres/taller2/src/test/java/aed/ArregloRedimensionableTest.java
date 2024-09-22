package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArregloRedimensionableTest {

    @Test
    void nuevoVectorEstaVacio() {
        ArregloRedimensionableDeRecordatorios vector = new ArregloRedimensionableDeRecordatorios();

        assertEquals(0, vector.longitud());
    }

    @Test
    void agregarPocosElementos() {
        ArregloRedimensionableDeRecordatorios vector = new ArregloRedimensionableDeRecordatorios();

        vector.agregarAtras(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)));
        vector.agregarAtras(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)));
        vector.agregarAtras(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)));
        vector.agregarAtras(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)));
        vector.agregarAtras(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)));

        assertEquals(5, vector.longitud());

        assertEquals(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)), vector.obtener(0));
        assertEquals(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)), vector.obtener(1));
        assertEquals(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)), vector.obtener(2));
        assertEquals(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)), vector.obtener(3));
        assertEquals(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)), vector.obtener(4));

    }

    @Test
    void quitarElementos() {
        ArregloRedimensionableDeRecordatorios vector = new ArregloRedimensionableDeRecordatorios();

        vector.agregarAtras(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)));
        vector.agregarAtras(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)));
        vector.agregarAtras(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)));
        vector.agregarAtras(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)));
        vector.agregarAtras(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)));

        vector.quitarAtras();

        assertEquals(4, vector.longitud());
        assertEquals(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)), vector.obtener(0));
        assertEquals(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)), vector.obtener(1));
        assertEquals(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)), vector.obtener(2));
        assertEquals(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)), vector.obtener(3));

        vector.quitarAtras();
        vector.quitarAtras();
        vector.quitarAtras();
        vector.quitarAtras();

        assertEquals(0, vector.longitud());

        vector.agregarAtras(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)));

        assertEquals(1, vector.longitud());
        assertEquals(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)), vector.obtener(0));

    }

    @Test
    void modificarPosición() {
        ArregloRedimensionableDeRecordatorios vector = new ArregloRedimensionableDeRecordatorios();

        vector.agregarAtras(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)));
        vector.agregarAtras(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)));
        vector.agregarAtras(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)));
        vector.agregarAtras(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)));
        vector.agregarAtras(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)));

        vector.modificarPosicion(2, new Recordatorio("6", new Fecha(3, 5), new Horario(2, 0)));

        assertEquals(5, vector.longitud());
        assertEquals(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)), vector.obtener(0));
        assertEquals(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)), vector.obtener(1));
        assertEquals(new Recordatorio("6", new Fecha(3, 5), new Horario(2, 0)), vector.obtener(2));
        vector.agregarAtras(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)));
        vector.agregarAtras(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)));

    }

    @Test
    void copiarVector() {
        ArregloRedimensionableDeRecordatorios vector = new ArregloRedimensionableDeRecordatorios();

        vector.agregarAtras(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)));
        vector.agregarAtras(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)));
        vector.agregarAtras(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)));
        vector.agregarAtras(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)));
        vector.agregarAtras(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)));

        ArregloRedimensionableDeRecordatorios copiaDeVector = vector.copiar();

        vector.modificarPosicion(2, new Recordatorio("6", new Fecha(3, 5), new Horario(2, 0)));

        assertEquals(5, copiaDeVector.longitud());
        assertEquals(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)), copiaDeVector.obtener(0));
        assertEquals(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)), copiaDeVector.obtener(1));
        assertEquals(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)), copiaDeVector.obtener(2));
        assertEquals(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)), copiaDeVector.obtener(3));
        assertEquals(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)), copiaDeVector.obtener(4));

    }

    @Test
    void copiarVectorConstructor() {
        ArregloRedimensionableDeRecordatorios vector = new ArregloRedimensionableDeRecordatorios();

        vector.agregarAtras(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)));
        vector.agregarAtras(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)));
        vector.agregarAtras(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)));
        vector.agregarAtras(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)));
        vector.agregarAtras(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)));

        ArregloRedimensionableDeRecordatorios copiaDeVector = new ArregloRedimensionableDeRecordatorios(vector);

        vector.modificarPosicion(2, new Recordatorio("6", new Fecha(3, 5), new Horario(2, 0)));

        assertEquals(5, copiaDeVector.longitud());
        assertEquals(new Recordatorio("1", new Fecha(1, 1), new Horario(0, 0)), copiaDeVector.obtener(0));
        assertEquals(new Recordatorio("2", new Fecha(1, 2), new Horario(0, 1)), copiaDeVector.obtener(1));
        assertEquals(new Recordatorio("3", new Fecha(1, 3), new Horario(0, 2)), copiaDeVector.obtener(2));
        assertEquals(new Recordatorio("4", new Fecha(1, 4), new Horario(0, 3)), copiaDeVector.obtener(3));
        assertEquals(new Recordatorio("5", new Fecha(1, 5), new Horario(0, 4)), copiaDeVector.obtener(4));

    }
}
