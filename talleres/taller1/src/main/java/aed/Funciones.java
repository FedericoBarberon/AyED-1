package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    boolean divideA(int d, int n) {
        return n % d == 0;
    }

    boolean esPar(int n) {
        return divideA(2, n);
    }

    boolean esBisiesto(int n) {
        return (divideA(4, n) && !divideA(100, n)) || divideA(400, n);
    }

    int factorialIterativo(int n) {
        int res = 1;

        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }

    int factorialRecursivo(int n) {
        if (n == 0)
            return 1;

        return n * factorialRecursivo(n - 1);
    }

    boolean esPrimo(int n) {
        if (n == 0 || n == 1)
            return false;

        for (int i = 2; i <= n / 2; i++) {
            if (divideA(i, n))
                return false;
        }

        return true;
    }

    int sumatoria(int[] numeros) {
        int sum = 0;

        for (int n : numeros) {
            sum += n;
        }

        return sum;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                return i;
            }
        }

        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int n : numeros) {
            if (esPrimo(n))
                return true;
        }

        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int n : numeros) {
            if (!divideA(2, n))
                return false;
        }

        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }

        return true;
    }

    boolean esSufijo(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();

        if (s1Len > s2Len)
            return false;

        for (int i = 0; i < s1Len; i++) {
            if (s1.charAt(s1Len - i - 1) != s2.charAt(s2Len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
