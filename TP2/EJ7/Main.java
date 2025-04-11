package tudai.prog3.TP2.EJ7;

public class Main {
    public static void main(String[] args) {
        /*
        EJERCICIO 7
        Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
        Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
        ● ¿Cuál es su complejidad en el peor caso?
        ● ¿Cuál es su complejidad promedio?
        */
        ArrayList list1 = new ArrayList(1);
        list1.add(5);
        list1.add(15);
        list1.add(0);
        list1.add(6);
        list1.add(4);
        list1.add(8);
        list1.add(10);
        System.out.println(list1);

        ArrayList list2 = new ArrayList(1);
        list2.add(5);
        list2.add(15);
        list2.add(0);
        list2.add(6);
        list2.add(4);
        list2.add(8);
        list2.add(10);
        System.out.println(list2);

        list1.ordenarQuicksort();
        list2.ordenarMergesort();

        /*
        Mergesort:
        Complejidad en el peor caso: O(n log n)
        Complejidad promedio: O(n log n)
        Complejidad espacial: O(n) (debido al uso del arreglo auxiliar).

        Quicksort:
        Complejidad en el peor caso: O(n²) (esto ocurre cuando el pivote es el menor o el mayor elemento repetidamente, p. ej., en un arreglo ya ordenado).
        Complejidad promedio: O(n log n)
        Complejidad espacial: O(log n) en el mejor de los casos, O(n) en el peor caso (debido a la profundidad de la pila de recursión).
         */

    }
}
