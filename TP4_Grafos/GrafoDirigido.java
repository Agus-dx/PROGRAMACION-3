package TrabajosPracticos.TP4_Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T> implements Grafo<T> {

	HashMap<Integer, Vertice<T>> vertices = new HashMap<>(); // Mapa para almacenar los vértices del grafo, la clave es el ID del vértice y el valor es el objeto Vertice

	@Override
	public void agregarVertice(int verticeId) {
		vertices.put(verticeId, new Vertice<T>(verticeId)); // Agrega un nuevo vértice al grafo, utilizando el ID proporcionado y creando una nueva instancia de Vertice
	}

	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(verticeId); // Elimina el vértice con el ID especificado del mapa de vértices

		Iterator<Integer> it = obtenerVertices(); // Obtiene un iterador sobre todos los IDs de los vértices restantes

		while (it.hasNext()) { // Itera sobre los IDs de los vértices
			getVertice(it.next()).borrarArco(verticeId); // Para cada vértice restante, borra cualquier arco que tenga como destino el vértice que se está eliminando
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		getVertice(verticeId1).agregarArco(verticeId2, etiqueta); // Agrega un nuevo arco dirigido desde verticeId1 hacia verticeId2 con la etiqueta especificada
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) // Verifica si ambos vértices existen en el grafo
			return; // Si alguno de los vértices no existe, no se puede borrar el arco, por lo que se retorna

		getVertice(verticeId1).borrarArco(verticeId2); // Borra el arco dirigido desde verticeId1 hacia verticeId2
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId); // Devuelve true si el grafo contiene un vértice con el ID especificado
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) // Verifica si ambos vértices existen en el grafo
			return false; // Si alguno de los vértices no existe, no puede haber un arco entre ellos, por lo que se retorna false

		return getVertice(verticeId1).contieneArco(verticeId2); // Devuelve true si existe un arco dirigido desde verticeId1 hacia verticeId2
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		return getVertice(verticeId1).obtenerArco(verticeId2); // Devuelve el objeto Arco que va desde verticeId1 hacia verticeId2, o null si no existe
	}

	@Override
	public int cantidadVertices() {
		return vertices.size(); // Devuelve la cantidad total de vértices en el grafo
	}

	@Override
	public int cantidadArcos() {
		int suma = 0; // Inicializa un contador para la cantidad de arcos
		for (Vertice<T> vertice : vertices.values()) { // Itera sobre todos los objetos Vertice en el mapa de vértices
			suma += vertice.getCantidadArcos(); // Suma la cantidad de arcos salientes de cada vértice al contador
		}
		return suma; // Devuelve la cantidad total de arcos en el grafo
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return vertices.keySet().iterator(); // Devuelve un iterador sobre los IDs de todos los vértices en el grafo
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		return getVertice(verticeId).obtenerAdyacentes().iterator(); // Devuelve un iterador sobre los IDs de los vértices adyacentes (a los que hay un arco saliente) al vértice con el ID especificado
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		List<Arco<T>> res = new ArrayList<>(); // Crea una nueva lista para almacenar todos los arcos del grafo

		for (Vertice<T> vertice : vertices.values()) { // Itera sobre todos los objetos Vertice en el mapa de vértices
			res.addAll(vertice.obtenerArcos()); // Agrega todos los arcos salientes de cada vértice a la lista
		}

		return res.iterator(); // Devuelve un iterador sobre todos los arcos del grafo
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return getVertice(verticeId).obtenerArcos().iterator(); // Devuelve un iterador sobre los arcos salientes del vértice con el ID especificado
	}

	public Vertice<T> getVertice(int id) {
		return vertices.get(id); // Devuelve el objeto Vertice asociado al ID especificado
	}

}