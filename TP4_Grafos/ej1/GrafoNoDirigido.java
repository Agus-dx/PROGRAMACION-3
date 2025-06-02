package TrabajosPracticos.TP4_Grafos.ej1;

import java.util.*;

public class GrafoNoDirigido extends Grafo {

    public GrafoNoDirigido() {
        super();
    }

    @Override
    public void agregarArista(int nodo1, int nodo2, int peso) {
        agregarNodo(nodo1);
        agregarNodo(nodo2);

        Arista arista1a2 = new Arista(nodo2, peso);
        Arista arista2a1 = new Arista(nodo1, peso);

        // Agregamos la arista de nodo1 a nodo2 si no existe ya
        if (!adyacencia.get(nodo1).contains(arista1a2)) {
            adyacencia.get(nodo1).add(arista1a2);
        }
        // Agregamos la arista de nodo2 a nodo1 si no existe ya
        if (!adyacencia.get(nodo2).contains(arista2a1)) {
            adyacencia.get(nodo2).add(arista2a1);
        }
    }

    @Override
    public void agregarArista(int nodo1, int nodo2) {
        // Llama al método con peso, usando el peso por defecto de la clase Arista (1)
        agregarArista(nodo1, nodo2, 1);
    }

    @Override
    public boolean existeArista(int nodo1, int nodo2) {
        if (adyacencia.containsKey(nodo1)) {
            // Usamos una Arista temporal para la comparación
            return adyacencia.get(nodo1).contains(new Arista(nodo2));
        }
        return false;
    }
}