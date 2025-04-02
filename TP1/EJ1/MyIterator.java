package tudai.prog3.TP1.EJ1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

    private Node<T> cursor;

    public MyIterator(Node<T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
}
