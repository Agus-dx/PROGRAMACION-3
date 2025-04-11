package tudai.prog3.TP2.EJ6;

public class Main {
    public static void main(String[] args) {
        /*
        EJERCICIO 6
        Implemente un algoritmo de ordenamiento por selección en un arreglo.
        Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
        ● ¿Qué complejidad big-O tienen estos algoritmos?
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

        list1.ordenarBurbujeo();
        list2.ordenarSeleccion();

        /*
        Complejidades Big-O...

        Ordenamiento por Burbuja (Bubble Sort):
        Complejidad Temporal: O(n²) en el peor de los casos.
        Complejidad Espacial: O(1) porque es un algoritmo in-place (no requiere espacio adicional significativo).

        Ordenamiento por Selección (Selection Sort):
        Complejidad Temporal: O(n²) en todos los casos (mejor, promedio y peor).
        Complejidad Espacial: O(1) también, ya que es in-place.
         */

    }
}
