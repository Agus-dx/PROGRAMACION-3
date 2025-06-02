package TrabajosPracticos.TP4_Grafos.ej1;

import java.util.*;

public abstract class Grafo {
    protected int numNodos; // Número total de nodos en el grafo
    protected Map<Integer, List<Arista>> adyacencia; // Lista de adyacencia

    public Grafo() {
        this.numNodos = 0;
        this.adyacencia = new HashMap<>();
    }

    public void agregarNodo(int nodo) {
        if (!adyacencia.containsKey(nodo)) {
            adyacencia.put(nodo, new ArrayList<>());
            numNodos++;
        }
    }

    public abstract void agregarArista(int origen, int destino, int peso);

    public abstract void agregarArista(int origen, int destino);

    public abstract boolean existeArista(int origen, int destino);

    public List<Arista> obtenerAristasAdyacentes(int nodo) {
        return adyacencia.getOrDefault(nodo, Collections.emptyList());
    }

    public List<Integer> obtenerVecinos(int nodo) {
        List<Integer> vecinos = new ArrayList<>();
        for (Arista arista : adyacencia.getOrDefault(nodo, Collections.emptyList())) {
            vecinos.add(arista.getDestino());
        }
        return vecinos;
    }

    public int getNumNodos() {
        return numNodos;
    }

    public void imprimirGrafo() {
        System.out.println("Representación del Grafo:");
        for (Map.Entry<Integer, List<Arista>> entry : adyacencia.entrySet()) {
            System.out.println("  Nodo " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // --- Implementación de DFS (Depth-First Search) ---

    /**
     * Realiza un recorrido en profundidad (DFS) a partir de un nodo inicial.
     * Imprime los nodos visitados en el orden de DFS.
     * @param nodoInicial El nodo desde donde se comienza el recorrido.
     */
    public void dfs(int nodoInicial) {
        if (!adyacencia.containsKey(nodoInicial)) {
            System.out.println("El nodo inicial " + nodoInicial + " no existe en el grafo.");
            return;
        }

        Set<Integer> visitados = new HashSet<>(); // Para mantener un registro de los nodos visitados
        System.out.print("Recorrido DFS desde el nodo " + nodoInicial + ": ");
        dfsRecursivo(nodoInicial, visitados);
        System.out.println();
    }

    /**
     * Método auxiliar recursivo para el DFS.
     * @param nodoActual El nodo que se está visitando actualmente.
     * @param visitados Un conjunto de nodos ya visitados para evitar ciclos y repeticiones.
     */
    private void dfsRecursivo(int nodoActual, Set<Integer> visitados) {
        visitados.add(nodoActual); // Marcar el nodo actual como visitado
        System.out.print(nodoActual + " "); // Imprimir el nodo

        // Para cada vecino del nodo actual
        for (Integer vecino : obtenerVecinos(nodoActual)) {
            if (!visitados.contains(vecino)) { // Si el vecino no ha sido visitado
                dfsRecursivo(vecino, visitados); // Llamar recursivamente a DFS para el vecino
            }
        }
    }
    // --- Implementación de BFS (Breadth-First Search) ---
    /**
     * Realiza un recorrido en anchura (BFS) a partir de un nodo inicial.
     * Imprime los nodos visitados en el orden de BFS.
     * @param nodoInicial El nodo desde donde se comienza el recorrido.
     */
    public void bfs(int nodoInicial) {
        if (!adyacencia.containsKey(nodoInicial)) {
            System.out.println("El nodo inicial " + nodoInicial + " no existe en el grafo.");
            return;
        }

        Queue<Integer> cola = new LinkedList<>(); // Cola para nodos a visitar
        Set<Integer> visitados = new HashSet<>(); // Para mantener un registro de los nodos visitados

        cola.offer(nodoInicial); // Añadir el nodo inicial a la cola
        visitados.add(nodoInicial); // Marcar el nodo inicial como visitado

        System.out.print("Recorrido BFS desde el nodo " + nodoInicial + ": ");
        while (!cola.isEmpty()) {
            int nodoActual = cola.poll(); // Sacar el primer nodo de la cola
            System.out.print(nodoActual + " "); // Imprimir el nodo

            // Para cada vecino del nodo actual
            for (Integer vecino : obtenerVecinos(nodoActual)) {
                if (!visitados.contains(vecino)) { // Si el vecino no ha sido visitado
                    visitados.add(vecino); // Marcarlo como visitado
                    cola.offer(vecino);    // Añadirlo a la cola
                }
            }
        }
        System.out.println();
    }
}