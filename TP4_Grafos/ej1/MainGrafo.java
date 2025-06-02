package TrabajosPracticos.TP4_Grafos.ej1;

import java.util.List;

public class MainGrafo {

    public static void main(String[] args) {
        // --- Prueba de Grafo Dirigido con pesos ---
        System.out.println("--- Prueba de Grafo Dirigido con Aristas Ponderadas ---");
        GrafoDirigido grafoDirigido = new GrafoDirigido();

        // Agregando nodos
        for (int i = 1; i <= 6; i++) {
            grafoDirigido.agregarNodo(i);
        }

        // Agregando aristas dirigidas con pesos
        /*grafoDirigido.agregarArista(1, 2, 10);
        grafoDirigido.agregarArista(1, 3, 5);
        grafoDirigido.agregarArista(2, 4, 1);
        grafoDirigido.agregarArista(3, 2, 2); // Arista de 3 a 2
        grafoDirigido.agregarArista(3, 5, 8);
        grafoDirigido.agregarArista(4, 6, 4);
        grafoDirigido.agregarArista(5, 4, 3);
        grafoDirigido.agregarArista(6, 1, 6); // Arista de vuelta para mostrar recorrido*/

        grafoDirigido.agregarArista(1, 2, 8);
        grafoDirigido.agregarArista(1, 3, 1);
        grafoDirigido.agregarArista(2, 4, 12);
        grafoDirigido.agregarArista(3, 5, 5);
        grafoDirigido.agregarArista(4, 6, 7);
        grafoDirigido.agregarArista(5, 6, 3);

        grafoDirigido.imprimirGrafo();

        System.out.println("\n--- Recorridos DFS y BFS en Grafo Dirigido ---");
        grafoDirigido.dfs(1); // Inicia DFS desde nodo 1
        grafoDirigido.bfs(1); // Inicia BFS desde nodo 1

        System.out.println("\n--- Prueba de detección de ciclo en Grafo Dirigido ---");
        System.out.println("¿El grafo dirigido tiene ciclo? " + grafoDirigido.tieneCiclo());


        System.out.println("\n");
        for (int i = 0; i < 40; i++) { System.out.print("="); }
        System.out.println("\n");

        // --- Prueba de Grafo No Dirigido con pesos ---
        System.out.println("--- Prueba de Grafo No Dirigido con Aristas Ponderadas ---");
        GrafoNoDirigido grafoNoDirigido = new GrafoNoDirigido();

        // Agregando nodos
        for (int i = 1; i <= 6; i++) {
            grafoNoDirigido.agregarNodo(i);
        }

        // Agregando aristas no dirigidas con pesos
        grafoNoDirigido.agregarArista(1, 2, 8);
        grafoNoDirigido.agregarArista(1, 3, 1);
        grafoNoDirigido.agregarArista(2, 4, 12);
        grafoNoDirigido.agregarArista(3, 5, 5);
        grafoNoDirigido.agregarArista(4, 6, 7);
        grafoNoDirigido.agregarArista(5, 6, 3);

        grafoNoDirigido.imprimirGrafo();

        System.out.println("\n--- Recorridos DFS y BFS en Grafo No Dirigido ---");
        grafoNoDirigido.dfs(1); // Inicia DFS desde nodo 1
        grafoNoDirigido.bfs(1); // Inicia BFS desde nodo 1

        // Prueba con un nodo que no existe
        System.out.println("\n--- Prueba de nodo inicial no existente ---");
        grafoDirigido.dfs(1);
        grafoNoDirigido.bfs(1);



        //-----------Ejercicio 4---------------

        // Ejemplo de grafo dirigido acíclico
        GrafoDirigido grafoAciclico = new GrafoDirigido();
        grafoAciclico.agregarArista(1, 2);
        grafoAciclico.agregarArista(1, 3);
        grafoAciclico.agregarArista(2, 4);
        grafoAciclico.agregarArista(3, 4);
        grafoAciclico.agregarArista(4, 5);

        int inicio = 1;
        int fin = 5;
        List<Integer> caminoMasLargo = grafoAciclico.encontrarCaminoMasLargo(inicio, fin);

        System.out.println("Grafo Dirigido Acíclico:");
        grafoAciclico.imprimirGrafo();
        System.out.println("Camino simple más largo desde " + inicio + " hasta " + fin + ": " + caminoMasLargo);
        // Salida esperada (puede variar): [1, 2, 4, 5] o [1, 3, 4, 5]

        System.out.println("\n--- Otro ejemplo ---");
        GrafoDirigido grafoAciclico2 = new GrafoDirigido();
        grafoAciclico2.agregarArista(0, 1);
        grafoAciclico2.agregarArista(0, 2);
        grafoAciclico2.agregarArista(1, 3);
        grafoAciclico2.agregarArista(2, 3);
        grafoAciclico2.agregarArista(3, 4);
        grafoAciclico2.agregarArista(1, 5);
        grafoAciclico2.agregarArista(5, 4);

        int inicio2 = 0;
        int fin2 = 4;
        List<Integer> caminoMasLargo2 = grafoAciclico2.encontrarCaminoMasLargo(inicio2, fin2);
        System.out.println("Grafo Dirigido Acíclico 2:");
        grafoAciclico2.imprimirGrafo();
        System.out.println("Camino simple más largo desde " + inicio2 + " hasta " + fin2 + ": " + caminoMasLargo2);
        // Salida esperada (puede variar): [0, 1, 3, 4] o [0, 1, 5, 4] o [0, 2, 3, 4]

        System.out.println("\n--- Sin camino ---");
        List<Integer> caminoSinCamino = grafoAciclico.encontrarCaminoMasLargo(5, 1);
        System.out.println("Camino simple más largo desde 5 hasta 1: " + caminoSinCamino); // Salida esperada: []

        System.out.println("\n--- Vértice inexistente ---");
        List<Integer> caminoInexistente = grafoAciclico.encontrarCaminoMasLargo(1, 10);
        System.out.println("Camino simple más largo desde 1 hasta 10: " + caminoInexistente); // Salida esperada: []




    }
}