package TrabajosPracticos.TP4_Grafos.ej1;

import java.util.Objects; // Necesario para Objects.hash y Objects.equals

public class Arista {
    private int destino; // El nodo al que apunta esta arista
    private int peso;    // El peso o costo asociado a esta arista

    /**
     * Constructor para una arista con peso.
     * @param destino El nodo de destino.
     * @param peso El peso de la arista.
     */
    public Arista(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Constructor para una arista sin peso explícito (peso por defecto 1).
     * @param destino El nodo de destino.
     */
    public Arista(int destino) {
        this(destino, 1); // Llama al constructor con peso, asignando 1 por defecto
    }

    // --- Getters ---
    public int getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    // --- Setters (opcional, si las aristas pueden cambiar su estado) ---
    public void setPeso(int peso) {
        this.peso = peso;
    }

    // --- Métodos importantes para comparaciones ---

    /**
     * Compara esta Arista con otro objeto para verificar si son iguales.
     * Dos aristas son consideradas iguales si tienen el mismo nodo de destino.
     * El peso no se considera para la igualdad a nivel de arista para evitar duplicados
     * en la lista de adyacencia (es decir, no queremos dos aristas de A a B solo porque tienen diferente peso).
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arista arista = (Arista) o;
        return destino == arista.destino; // Solo comparamos por destino
    }

    /**
     * Genera un código hash para esta Arista.
     * Consistente con el método equals, solo se basa en el nodo de destino.
     */
    @Override
    public int hashCode() {
        return Objects.hash(destino); // Solo el destino para el hash
    }

    /**
     * Representación en cadena de la arista.
     */
    @Override
    public String toString() {
        // Formato: (destino, peso)
        return "(" + destino + ", " + peso + ")";
    }
}
