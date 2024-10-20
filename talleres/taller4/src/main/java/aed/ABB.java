package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo _raiz;
    private int _cardinal;

    private class Nodo {
        T val;
        Nodo izq;
        Nodo der;
        Nodo arriba;

        Nodo(T val) {
            this.val = val;
            this.izq = null;
            this.der = null;
            this.arriba = null;
        }
    }

    private Nodo min_nodo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }

        Nodo min = nodo;

        while (min.izq != null) {
            min = min.izq;
        }

        return min;
    }

    private Nodo max_nodo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }

        Nodo max = nodo;

        while (max.der != null) {
            max = max.der;
        }

        return max;
    }

    private Nodo buscar_nodo(T elem) {
        Nodo actual = this._raiz;
        Boolean ultimo = actual == null;

        while (!ultimo) {
            int comp = elem.compareTo(actual.val);

            if (comp > 0 && actual.der != null) {
                actual = actual.der;
            } else if (comp < 0 && actual.izq != null) {
                actual = actual.izq;
            } else {
                ultimo = true;
            }
        }

        return actual;
    }

    private void conectar_nodo(Nodo padre, Nodo nodo, int direccion) {
        if (direccion > 0) {
            padre.der = nodo;
        } else {
            padre.izq = nodo;
        }

        if (nodo != null) {
            nodo.arriba = padre;
        }
    }

    private Nodo sucesor(Nodo nodo) {
        if (nodo.der != null) {
            return min_nodo(nodo.der);
        }

        Nodo padre = nodo.arriba;

        while (padre != null && padre.der == nodo) {
            nodo = padre;
            padre = padre.arriba;
        }

        return padre;
    }

    public ABB() {
        this._raiz = null;
        this._cardinal = 0;
    }

    public int cardinal() {
        return this._cardinal;
    }

    public T minimo() {
        return min_nodo(this._raiz).val;
    }

    public T maximo() {
        return max_nodo(this._raiz).val;
    }

    public void insertar(T elem) {
        Nodo ultimo_nodo_buscado = buscar_nodo(elem);

        if (ultimo_nodo_buscado == null) {
            Nodo nuevo_nodo = new Nodo(elem);
            this._raiz = nuevo_nodo;
            this._cardinal++;
            return;
        }

        int comp = elem.compareTo(ultimo_nodo_buscado.val);

        if (comp == 0) {
            return;
        }

        Nodo nuevo_nodo = new Nodo(elem);
        conectar_nodo(ultimo_nodo_buscado, nuevo_nodo, comp);
        this._cardinal++;
    }

    public boolean pertenece(T elem) {
        Nodo ultimo_nodo_buscado = buscar_nodo(elem);

        return ultimo_nodo_buscado != null && elem.compareTo(ultimo_nodo_buscado.val) == 0;
    }

    public void eliminar(T elem) {
        Nodo nodo = buscar_nodo(elem);

        if (nodo == null || elem.compareTo(nodo.val) != 0) {
            return;
        }

        int direccion_padre = nodo != this._raiz ? elem.compareTo(nodo.arriba.val) : 0;

        if (nodo.izq != null && nodo.der != null) { // Caso con dos hijos
            Nodo suc = sucesor(nodo);
            int direccion_padre_suc = suc.val.compareTo(suc.arriba.val);
            nodo.val = suc.val;

            conectar_nodo(suc.arriba, suc.der, direccion_padre_suc);
        } else if (nodo.izq != null) { // Caso con solo hijo izquierdo
            if (nodo == this._raiz) {
                this._raiz = nodo.izq;
                this._raiz.arriba = null;
            } else {
                conectar_nodo(nodo.arriba, nodo.izq, direccion_padre);
            }
        } else if (nodo.der != null) { // Caso con solo hijo derecho
            if (nodo == this._raiz) {
                this._raiz = nodo.der;
                this._raiz.arriba = null;
            } else {
                conectar_nodo(nodo.arriba, nodo.der, direccion_padre);
            }
        } else {
            if (nodo == this._raiz) { // Caso sin hijos
                this._raiz = null;
            } else {
                conectar_nodo(nodo.arriba, null, direccion_padre);
            }
        }

        this._cardinal--;
    }

    public String toString() {
        Iterador<T> it = iterador();
        String str = "{";

        if (it.haySiguiente()) {
            T val = it.siguiente();
            str += val;
        }

        while (it.haySiguiente()) {
            T val = it.siguiente();
            str += "," + val;
        }

        str += "}";

        return str;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public ABB_Iterador() {
            this._actual = min_nodo(_raiz);
        }

        public boolean haySiguiente() {
            return this._actual != null;
        }

        public T siguiente() {
            T val = this._actual.val;
            this._actual = sucesor(this._actual);
            return val;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
