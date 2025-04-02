package tudai.prog3.TP1.EJ1;

public class DoubleNode<T> {

    private T info;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    public DoubleNode() {
        this.info = null;
        this.next = null;
        this.previous = null;
    }

    public DoubleNode(DoubleNode<T> previous, T info, DoubleNode<T> next) {
        this.setPrevious(previous);
        this.setInfo(info);
        this.setNext(next);
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }
    public void setPrevious(DoubleNode<T> next) {
        this.previous = previous;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

}
