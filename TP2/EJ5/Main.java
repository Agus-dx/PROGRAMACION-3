package tudai.prog3.TP2.EJ5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        EJERCICIO 5
        Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
        determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
        cuál se encuentra, es decir, A[i] = i.
        1. Construir un algoritmo recursivo que responda a dicha verificación.
        2. Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10])

        */
        ArrayList list = new ArrayList(1);
        list.add(-3);
        list.add(-1);
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(10);

        System.out.println(list);
        System.out.println(list.contieneValorIgualPos());

    }
}
