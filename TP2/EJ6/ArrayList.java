package tudai.prog3.TP2.EJ6;

import java.util.Arrays;

public class ArrayList {
    private int[] arreglo;
    private int tamaño; // Número actual de elementos en la lista
    private int capacidad; // Capacidad total del arreglo dinámico

    // Constructor que inicializa el arreglo con una capacidad inicial
    public ArrayList(int capacidadInicial) {
        this.capacidad = capacidadInicial;
        this.arreglo = new int[capacidadInicial];
        this.tamaño = 0;
    }

    // Método para agregar un elemento a la lista
    public void add(int valor) {
        if (tamaño == capacidad) {
            aumentarCapacidad();
        }
        arreglo[tamaño++] = valor; // Agrega el valor y aumenta el tamaño
    }

    // Método para aumentar la capacidad del arreglo
    private void aumentarCapacidad() {
        capacidad++; // Doblar la capacidad
        arreglo = Arrays.copyOf(arreglo, capacidad);
    }

    // Método para obtener un elemento por índice
    public int get(int indice) {
        if (indice >= 0 && indice < tamaño) {
            return arreglo[indice];
        } else {
            System.out.println("Índice fuera de rango.");
            return -1; // Valor de error
        }
    }

    // Método para obtener el tamaño de la lista
    public int tamaño() {
        return tamaño;
    }

    // Método de ordenamiento por burbuja
    public void ordenarBurbujeo() {
        for (int i = 0; i < tamaño - 1; i++) {
            for (int j = 0; j < tamaño - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        System.out.println("Arreglo ordenado por burbuja: " + this);
    }

    // Método de ordenamiento por selección
    public void ordenarSeleccion() {
        for (int i = 0; i < tamaño - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < tamaño; j++) {
                if (arreglo[j] < arreglo[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            // Intercambiar el mínimo encontrado con el primer elemento
            int temp = arreglo[indiceMinimo];
            arreglo[indiceMinimo] = arreglo[i];
            arreglo[i] = temp;
        }
        System.out.println("Arreglo ordenado por selección: " + this);
    }

    // Método para imprimir la lista
    public void imprimir() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arreglo=" + Arrays.toString(arreglo) +
                ", tamaño=" + tamaño +
                ", capacidad=" + capacidad +
                '}';
    }
}