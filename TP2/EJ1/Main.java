package tudai.prog3.TP2.EJ1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        Ejercicio 1
        Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado y
        responda:
        1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
        2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
        3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
        */
        Array staticArray = new Array(5); // Crea un arreglo de tamaño 5

        staticArray.add(3);
        staticArray.add(1);
        staticArray.add(4);
        staticArray.add(2);
        staticArray.add(5);
        System.out.println("Contenido del arreglo: " + staticArray); // Debe mostrar todos los elementos

        // Intentar agregar un elemento más, debería fallar
        staticArray.add(6);

        System.out.println("Elemento en la posición 2: " + staticArray.getValueByIndex(2)); // Debe dar 4
        System.out.println("Posicion del elemento: " + staticArray.getIndexByValue(2)); // Debe dar 4
        System.out.println("¿Está ordenado? " + staticArray.isSorted()); // Debe ser false

        staticArray.remove(1); // Remueve el número 1
        System.out.println("Contenido del arreglo después de eliminar 1: " + staticArray);

        System.out.println("¿Está ordenado? " + staticArray.isSorted()); // Debe seguir siendo false

        // Ordenamos manualmente para probar la función isSorted
        staticArray.add(6);
        staticArray.add(7); // Esto es solo para probar el método
        System.out.println("Contenido del arreglo antes de ordenar: " + staticArray);
        System.out.println("Contenido después de ordenar: " + staticArray);
        System.out.println("¿Está ordenado? " + staticArray.isSorted()); // Debe ser true

        /*
        1.¿Qué complejidad O tiene? (La complejidad en el peor caso):
        La complejidad temporal del algoritmo es O(N), donde N es el tamaño del arreglo.
        La complejidad espacial también es O(N) debido a la pila de llamadas. Cada llamada recursiva consume un espacio en la pila,
        y en el peor caso de N elementos, habrá N llamadas esperando en la pila.

        2.¿Trae algún problema hacerlo recursivo? ¿Cuál?:
        Problemas de pila: La recursión puede llevar a un desbordamiento de pila (stack overflow) si el tamaño del arreglo es muy grande,
        ya que cada llamada a la función ocupa espacio en la pila.
        Rendimiento: En términos de rendimiento, la función recursiva puede ser más lenta que una solución iterativa, dado que la sobrecarga de la llamada de función puede ser significativa.

        3.¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?:
        Ofrecen funcionalidades diferentes y simplifican algunas operaciones complejas que tendríamos que manejar manualmente si estuviéramos usando arreglos estáticos
        Tamaño Dinámico: Las listas (como ArrayList) permiten almacenar un número variable de elementos sin necesidad de definir un tamaño fijo inicialmente.
        Gestión Automática de Capacidad: ArrayList maneja automáticamente su capacidad interna.
        Métodos Convenientes: Las listas proporcionan métodos útiles como add(), remove(), y clear() que hacen que el manejo de la colección de datos sea más limpio y menos propenso a errores.
        Menor Complejidad: No necesitas implementar la lógica para desplazar elementos manualmente al eliminar un elemento.
        Interoperabilidad: Muchas APIs y bibliotecas de Java esperan colecciones en lugar de arreglos fijos.
        */
    }

}
