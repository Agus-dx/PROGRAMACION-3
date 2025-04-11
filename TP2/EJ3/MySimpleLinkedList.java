package tudai.prog3.TP2.EJ3;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{

    private Node<T> first;
    private int tamano;

    public MySimpleLinkedList() {
        this.first = null;
        this.tamano = 0;
    }

    public void insertFront(T info) {
        //Node<T> tmp = new Node<T>(info,null);
        //tmp.setNext(this.first);
        //this.first = tmp;
        Node<T> newNode = new Node<T>(info, this.first);
        this.first = newNode;
        this.tamano = this.tamano+1;
    }

    public T extractFront() {
        if (isEmpty()) {
            return null; // o lanzar una excepción si se prefiere
        }
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        return info;
    }

    public boolean isEmpty() {
        return this.first == null; // Si el primer nodo es nulo, la lista está vacía
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("El índice no puede ser negativo");
        }
        Node<T> current = this.first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.getInfo();
            }
            current = current.getNext();
            count++;
        }
        throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista");
    }

    public int size() {
        return this.tamano;
    }

    public int indexOf(T element) {
        Node<T> current = this.first;
        int index = 0;

        while (current != null) {
            if (current.getInfo().equals(element)) {
                return index; // Elemento encontrado, devolver el índice
            }
            current = current.getNext();
            index++;
        }

        return -1; // Elemento no encontrado
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = this.first;

        sb.append("[");
        while (current != null) {
            sb.append(current.getInfo());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(this.first);
    }
}
