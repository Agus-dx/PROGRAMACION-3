package tudai.prog3.TP1.EJ1;

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

    public void hacerListaComun(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
        int aux=0;
        for(T i : lista1){
            for(T j : lista2){
                aux++;
                if (i.equals(j)){
                    this.insertFront(i);
                }
                System.out.println("RECORRIDO: " + aux);
            }
        }
    }

    public void hacerListaComunOrdenada(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
        Node<T> current1 = lista1.first;
        Node<T> current2 = lista2.first;
        int valorLista1;
        int valorLista2;
        int aux=0;
        while (current1 != null && current2 != null) {
            valorLista1 = (Integer) current1.getInfo();
            valorLista2 = (Integer) current2.getInfo();
            if (valorLista1==valorLista2) {
                this.insertFront(current1.getInfo()); // Agregar al frente (de modo que se mantenga el orden)
                current1 = current1.getNext(); // Moverse al siguiente nodo en la primera lista
                current2 = current2.getNext(); // Moverse al siguiente nodo en la segunda lista
            } else if (valorLista1>valorLista2) {
                current1 = current1.getNext(); // Moverse en la primera lista
            } else {
                current2 = current2.getNext(); // Moverse en la segunda lista
            }
            aux++;
            System.out.println("RECORRIDO: " + aux);
        }
    }

    public void hacerListaSinComunes(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
        boolean comun;
        for(T i : lista1){
            comun=false;
            for(T j : lista2){
                if (i.equals(j)){
                    comun=true;
                    break;
                }
            }
            if(!comun){
                this.insertFront(i);
            }
        }
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
