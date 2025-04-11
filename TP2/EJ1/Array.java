package tudai.prog3.TP2.EJ1;

public class Array{
    private int[] items;
    private int size;

    // Constructor que inicializa el arreglo con una capacidad fija
    public Array(int capacity) {
        items = new int[capacity]; // Inicializa el arreglo con el tamaño dado
        size = 0; // Inicialmente, el tamaño es 0
    }

    // Método para agregar un elemento al final del arreglo
    public boolean add(int item) {
        if (size < items.length) {
            items[size++] = item; // Agrega el elemento y aumenta el tamaño
            return true;
        } else {
            System.out.println("El arreglo está lleno, no se puede agregar el elemento: " + item);
            return false; // No se puede agregar si el arreglo está lleno
        }
    }

    // Método para eliminar un elemento por valor
    public boolean remove(int item) {
        for (int i = 0; i < size; i++) {
            if (items[i] == item) {
                // Desplazar elementos hacia la izquierda
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                items[--size] = 0; // Opcional: poner 0 en la última posición
                return true; // El elemento se ha eliminado
            }
        }
        System.out.println("Elemento " + item + " no encontrado en el arreglo.");
        return false; // Elemento no encontrado
    }

    // Método para acceder a un elemento en un índice específico
    public int getValueByIndex(int index) {
        if (index >= 0 && index < size) {
            return items[index]; // Retorna el elemento en el índice especificado
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++){
            if(items[i]==value){
                return i;
            }
        }
        return -1;
    }

    // Método para comprobar si el arreglo está ordenado
    public boolean isSorted() {
        for (int i = 1; i < size; i++) {
            if (items[i] < items[i - 1]) {
                return false; // No está ordenado
            }
        }
        return true; // Está ordenado
    }

    // Método para obtener el tamaño actual del arreglo
    public int getSize() {
        return size; // Retorna el tamaño del arreglo
    }

    //Ejercicio 2
    public int getElement(int indice){
        if(indice>0 && indice<size){
            for (int i = 0; i < size; i++) {
                if (i==indice) {
                    return items[i];
                }
            }
        }
        return -1;
    }

    // Método para representar el arreglo como una cadena
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}