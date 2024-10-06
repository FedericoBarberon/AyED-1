package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int size;

    private class Nodo {
        T val;
        Nodo sig;
        Nodo ant;

        Nodo(T val) {
            this.val = val;
            this.sig = null;
            this.ant = null;
        }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);

        if (size == 0) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.sig = primero;
            primero.ant = nuevo;
            primero = nuevo;
        }

        size++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);

        if (size == 0) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.sig = nuevo;
            nuevo.ant = ultimo;
            ultimo = nuevo;
        }

        size++;
    }

    private Nodo obtenerNodo(int i) {
        Nodo actual = primero;
        while (i > 0) {
            actual = actual.sig;
            i--;
        }

        return actual;
    }

    public T obtener(int i) {
        Nodo n = obtenerNodo(i);
        return n.val;
    }

    public void eliminar(int i) {
        Nodo n = obtenerNodo(i);

        if (size == 1) {
            primero = null;
            ultimo = null;
        } else if (n == primero) {
            primero = n.sig;
            n.sig.ant = null;
        } else if (n == ultimo) {
            ultimo = n.ant;
            n.ant.sig = null;
        } else {
            n.ant.sig = n.sig;
            n.sig.ant = n.ant;
        }

        size--;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo n = obtenerNodo(indice);
        n.val = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Iterador<T> it = lista.iterador();

        while (it.haySiguiente()) {
            this.agregarAtras(it.siguiente());
        }
    }

    @Override
    public String toString() {
        Nodo actual = primero;
        String s = "[";

        while (actual != null) {
            s += actual.val;

            if (actual.sig != null) {
                s += ", ";
            }

            actual = actual.sig;
        }

        s += "]";

        return s;
    }

    private class ListaIterador implements Iterador<T> {
        private Nodo actual;
        private boolean esElFinal;

        public ListaIterador() {
            actual = primero;
            esElFinal = size <= 1;
        }

        public boolean haySiguiente() {
            return !esElFinal;
        }

        public boolean hayAnterior() {
            return actual != primero;
        }

        public T siguiente() {
            T val = actual.val;

            if (actual.sig == null) {
                esElFinal = true;
            } else {
                actual = actual.sig;
            }

            return val;
        }

        public T anterior() {
            if (esElFinal) {
                esElFinal = false;
                return actual.val;
            } else {
                actual = actual.ant;
                return actual.val;
            }
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
