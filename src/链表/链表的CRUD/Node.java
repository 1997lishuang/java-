package 链表.链表的CRUD;

public class Node<T> {
    public T item;
    public Node<T> next;

    public Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
