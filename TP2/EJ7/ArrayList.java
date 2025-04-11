package tudai.prog3.TP2.EJ7;

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

    // Método para imprimir la lista
    public void imprimir() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    // Método de ordenamiento Mergesort
    public void ordenarMergesort() {
        if (tamaño > 1) {
            int[] aux = new int[tamaño];
            mergesort(arreglo, aux, 0, tamaño - 1);
        }
        System.out.println("Arreglo ordenado por Mergesort: " + this);
    }

    private void mergesort(int[] arreglo, int[] aux, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergesort(arreglo, aux, inicio, medio);
            mergesort(arreglo, aux, medio + 1, fin);
            merge(arreglo, aux, inicio, medio, fin);
        }
    }

    private void merge(int[] arreglo, int[] aux, int inicio, int medio, int fin) {
        for (int i = inicio; i <= fin; i++) {
            aux[i] = arreglo[i];
        }

        int i = inicio;
        int j = medio + 1;
        int k = inicio;

        while (i <= medio && j <= fin) {
            if (aux[i] <= aux[j]) {
                arreglo[k++] = aux[i++];
            } else {
                arreglo[k++] = aux[j++];
            }
        }

        while (i <= medio) {
            arreglo[k++] = aux[i++];
        }
    }

    // Método de ordenamiento Quicksort
    public void ordenarQuicksort() {
        quicksort(arreglo, 0, tamaño - 1);
        System.out.println("Arreglo ordenado por Quicksort: " + this);
    }

    private void quicksort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int pivote = particionar(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, pivote - 1);
            quicksort(arreglo, pivote + 1, derecha);
        }
    }

    private int particionar(int[] arreglo, int izquierda, int derecha) {
        int pivote = arreglo[derecha];
        int i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arreglo[j] <= pivote) {
                i++;
                // Intercambiar
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        // Intercambiar pivote con el elemento en la posición i + 1
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[derecha];
        arreglo[derecha] = temp;

        return i + 1;
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