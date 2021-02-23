package 链表.链表的CRUD;

public class LinkList<T> {

    //创建头节点
    private Node head;
    private int size;

    private class Node{
        T item;
        Node next;
        public Node(T item,Node next){
          this.item = item;
          this.next = next;
        }

    }


//    寻找指定位置的代码

    private T get(int i){

        Node n = head.next ;
       
        for (int j = 0; j < i; j++) {
             n = n.next;
        }

      return n.item;
    }

    //插入节点

    private void insert(T t,int i){
        Node pre = head;
//        寻找位置的前一个节点
        for (int j = 0; j < i; j++) {
             pre = pre.next;
        }
        Node cur = pre.next;

        Node newNode = new Node(t,cur);

        pre.next = newNode;
        size++;
    }

//    删除节点


    private T remove(int i){

        Node pre = head;
//        寻找位置的前一个节点
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }

        Node cur =  pre.next;

       Node nextNode  = cur.next;
       pre.next = nextNode;

       size--;

        return cur.item;
    }
}
