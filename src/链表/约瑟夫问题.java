package 链表;

import 链表.链表的CRUD.Node;

public class 约瑟夫问题 {
    public static void main(String[] args) {

    }
    public Node<Integer> create(int size){

        Node<Integer> head = null;
        Node<Integer> pre = null;


      for(int i=1;i<=size;i++){
            if(i==1){
                head = new Node<Integer>(i,null);
                pre = head;
                continue;
            }
            Node<Integer> newNode = new Node<Integer>(i,null);
            pre.next=newNode;
            pre = newNode;

            if(i==41) {
                pre.next = head;
            }

      }

        return head;
    }
}
