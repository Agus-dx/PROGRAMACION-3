package TrabajosPracticos.TP4_Grafos;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco<T> {

  private int verticeOrigen;
  private int verticeDestino;
  private T etiqueta;

  public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
    this.verticeOrigen = verticeOrigen;
    this.verticeDestino = verticeDestino;
    this.etiqueta = etiqueta;
  }

  public Arco(Arco<T> arco) {
    this(arco.getVerticeOrigen(), arco.getVerticeDestino(), arco.getEtiqueta());
  }

  public int getVerticeOrigen() {
    return verticeOrigen;
  }

  public int getVerticeDestino() {
    return verticeDestino;
  }

  public T getEtiqueta() {
    return etiqueta;
  }

  @Override
  public int hashCode() {
    // Cantor: ((a + b) * (a + b + 1)) / 2 + b;
    return ((verticeOrigen + verticeDestino) * (verticeOrigen + verticeDestino + 1)) / 2 + verticeDestino;
  }

  @Override
  public boolean equals(Object o) {
    try {
      Arco<T> other = (Arco<T>) o;
      return other.getVerticeDestino() == getVerticeDestino() && other.verticeOrigen == getVerticeOrigen();
    } catch (Exception e) {
      return false;
    }
  }

}