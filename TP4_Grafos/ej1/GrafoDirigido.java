package TrabajosPracticos.TP4_Grafos.ej1;

import java.util.*;

public class GrafoDirigido extends Grafo {

    public GrafoDirigido() {
        super();
    }

    @Override
    public void agregarArista(int origen, int destino, int peso) {
        agregarNodo(origen);
        agregarNodo(destino);
        // Creamos una nueva Arista y la agregamos a la lista de adyacencia del origen
        adyacencia.get(origen).add(new Arista(destino, peso));
    }

    @Override
    public void agregarArista(int origen, int destino) {
        // Llama al método con peso, usando el peso por defecto de la clase Arista (1)
        agregarArista(origen, destino, 1);
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        if (adyacencia.containsKey(origen)) {
            // Creamos un objeto Arista temporal para usar el método contains()
            // que internamente usará el método equals() de Arista (comparando solo el destino)
            return adyacencia.get(origen).contains(new Arista(destino));
        }
        return false;
    }

    /**
     * Detecta si el grafo dirigido contiene algún ciclo utilizando DFS.
     * @return true si el grafo contiene un ciclo, false en caso contrario.
     */
    public boolean tieneCiclo() {
        Set<Integer> visitados = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (Integer nodo : adyacencia.keySet()) {
            if (!visitados.contains(nodo)) {
                if (tieneCicloDFS(nodo, visitados, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método auxiliar recursivo para la detección de ciclos mediante DFS.
     * @param nodoActual El nodo que se está visitando actualmente.
     * @param visitados Conjunto de nodos ya visitados en la exploración general.
     * @param recursionStack Conjunto de nodos actualmente en la pila de recursión del DFS para la rama actual.
     * @return true si se detecta un ciclo desde este nodo, false en caso contrario.
     */
    private boolean tieneCicloDFS(int nodoActual, Set<Integer> visitados, Set<Integer> recursionStack) {
        visitados.add(nodoActual);
        recursionStack.add(nodoActual);

        for (Arista vecinoArista : obtenerAristasAdyacentes(nodoActual)) {
            int vecino = vecinoArista.getDestino();
            if (!visitados.contains(vecino)) {
                if (tieneCicloDFS(vecino, visitados, recursionStack)) {
                    return true;
                }
            } else if (recursionStack.contains(vecino)) {
                return true; // Se ha encontrado un nodo en la pila de recursión, lo que indica un ciclo
            }
        }

        recursionStack.remove(nodoActual); // Al finalizar la exploración de este nodo, se retira de la pila de recursión
        return false;
    }

    /**
     * Encuentra el camino simple de mayor longitud desde el vértice 'inicio' al vértice 'fin'
     * en un grafo dirigido acíclico.
     * @param inicio El vértice de inicio.
     * @param fin El vértice de destino.
     * @return Una lista de enteros representando el camino simple de mayor longitud,
     * o una lista vacía si no hay camino.
     */
    public List<Integer> encontrarCaminoMasLargo(int inicio, int fin) {
        if (!adyacencia.containsKey(inicio) || !adyacencia.containsKey(fin)) {
            System.out.println("Uno o ambos vértices no existen en el grafo.");
            return new ArrayList<>();
        }

        List<Integer> caminoMasLargo = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        List<Integer> caminoActual = new ArrayList<>();

        encontrarCaminoMasLargoRecursivo(inicio, fin, visitados, caminoActual, caminoMasLargo);

        return caminoMasLargo;
    }

    private void encontrarCaminoMasLargoRecursivo(int actual, int fin, Set<Integer> visitados,
                                                  List<Integer> caminoActual, List<Integer> caminoMasLargo) {
        visitados.add(actual);
        caminoActual.add(actual);

        if (actual == fin) {
            if (caminoActual.size() > caminoMasLargo.size()) {
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
        } else {
            for (Arista arista : obtenerAristasAdyacentes(actual)) {
                int vecino = arista.getDestino();
                if (!visitados.contains(vecino)) {
                    encontrarCaminoMasLargoRecursivo(vecino, fin, visitados, caminoActual, caminoMasLargo);
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1); // Backtrack
        visitados.remove(actual); // Permitir que este nodo sea visitado en otros caminos
    }
}