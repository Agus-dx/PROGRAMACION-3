package TrabajosPracticos.TP4_Grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Vertice<T> {

  int id, tiempoInicial, tiempoFinal; // Identificador único del vértice, tiempos de descubrimiento y finalización (para algoritmos como DFS)
  char color; // Color del vértice (para algoritmos de recorrido de grafos, e.g., blanco, gris, negro)

  HashSet<Arco<T>> arcos = new HashSet<>(); // Conjunto para almacenar los arcos que salen de este vértice

  public Vertice(int id) {
    this.id = Math.abs(id); // Inicializa el ID del vértice, asegurándose de que sea no negativo
  }

  public void agregarArco(int verticeDestino, T etiqueta) {
    Arco<T> added = new Arco<>(this.getId(), verticeDestino, etiqueta); // Crea un nuevo arco con el vértice actual como origen, el destino especificado y la etiqueta
    arcos.add(added); // Agrega el nuevo arco al conjunto de arcos salientes
  }

  public void borrarArco(int verticeDestino) {
    Arco<T> deleted = new Arco<>(this.getId(), verticeDestino, null); // Crea un arco temporal con el origen y destino para identificar el arco a borrar (la etiqueta no importa para la comparación en HashSet)
    arcos.remove(deleted); // Remueve el arco del conjunto de arcos salientes
  }

  public boolean contieneArco(int verticeDestino) {
    Arco<T> contains = new Arco<T>(id, verticeDestino, null); // Crea un arco temporal para verificar si existe un arco hacia el vértice destino
    return arcos.contains(contains); // Devuelve true si el conjunto de arcos contiene un arco con el destino especificado
  }

  public Arco<T> obtenerArco(int verticeDestino) {
    Arco<T> searched = new Arco<T>(id, verticeDestino, null); // Crea un arco temporal para buscar el arco con el destino especificado
    if (!arcos.contains(searched)) // Si el conjunto de arcos no contiene un arco con ese destino
      return null; // Devuelve null

    for (Arco<T> arco : arcos) { // Itera sobre los arcos salientes
      if (arco.equals(searched)) { // Compara el arco actual con el arco buscado (la implementación de equals en Arco debe comparar origen y destino)
        return arco; // Devuelve el arco encontrado
      }
    }

    return null; // Si no se encuentra el arco (esto no debería ocurrir si contains devolvió true, pero se incluye como precaución)
  }

  public List<Integer> obtenerAdyacentes() {
    List<Integer> res = new ArrayList<>(); // Crea una nueva lista para almacenar los IDs de los vértices adyacentes
    for (Arco<T> arco : arcos) { // Itera sobre los arcos salientes
      res.add(arco.getVerticeDestino()); // Agrega el ID del vértice destino de cada arco a la lista de adyacentes
    }

    return res; // Devuelve la lista de IDs de los vértices adyacentes
  }

  public List<Arco<T>> obtenerArcos() {
    List<Arco<T>> res = new ArrayList<>(); // Crea una nueva lista para almacenar los arcos salientes

    for (Arco<T> arco : arcos) { // Itera sobre los arcos salientes
      res.add(arco); // Agrega cada arco a la lista
    }

    return res; // Devuelve la lista de todos los arcos salientes de este vértice
  }

  public int getCantidadArcos() {
    return arcos.size(); // Devuelve la cantidad de arcos salientes de este vértice
  }

  public Iterator<Arco<T>> iterator() {
    return arcos.iterator(); // Devuelve un iterador para recorrer los arcos salientes
  }

  public int getId() {
    return id; // Devuelve el ID del vértice
  }

  public char getColor() {
    return color; // Devuelve el color del vértice
  }

  public void setColor(char color) {
    this.color = color; // Establece el color del vértice
  }

  public void setTiempoInicial(int tiempoInicial) {
    this.tiempoInicial = tiempoInicial; // Establece el tiempo de descubrimiento del vértice
  }

  public void setTiempoFinal(int tiempoFinal) {
    this.tiempoFinal = tiempoFinal; // Establece el tiempo de finalización del vértice
  }

  @Override
  public String toString(){
    return "ID: "+getId(); // Devuelve una representación en String del vértice (solo su ID)
  }

}