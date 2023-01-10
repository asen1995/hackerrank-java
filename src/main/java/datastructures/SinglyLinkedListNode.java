package datastructures;

public class SinglyLinkedListNode {
     int data;
     SinglyLinkedListNode next;

    public SinglyLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "SinglyLinkedListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
