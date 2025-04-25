package data_structures.stack;

import java.util.EmptyStackException;

public class Stack {

    public Node head = null;
    public int count;

    public void push(String name) {
        if (head == null) {
            Node newNode = new Node(name);
            this.head = newNode;      
        } else {
            Node newNode = new Node(name);
            newNode.next = head.next;
            this.head.next = newNode;
            this.head = newNode;   
        }
        count++;
    }

    public String pop() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        String topValue = this.head.value;
        this.head = this.head.next;
        return topValue;
    }

    public String peek() {
        if (this.head == null) {
            throw new EmptyStackException();
        }
        return this.head.value;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("steffen");
        stack.push("nick");
        stack.isEmpty();
        System.out.println( stack.peek());
    }
    
}
