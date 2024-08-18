package aed;

class Main {
    int fibonacci(int n) {
        if (n <= 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    int fibonacciReturn(int n) {
        if (n <= 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    double maximo(double[] list) {
        double max = list[0];

        for (double x : list) {
            if (x > max)
                max = x;
        }

        return max;
    }

    int[] sumarArreglos(int[] l1, int[] l2) {
        int[] suma = new int[l1.length];

        for (int i = 0; i < l1.length; i++) {
            suma[i] = l1[i] + l2[i];
        }

        return suma;
    }

    String iniciales(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            if (i == 0 || str.charAt(i - 1) == ' ' && str.charAt(i) != ' ') {
                res += str.charAt(i);
            }
        }

        return res;
    }
}