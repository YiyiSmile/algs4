package algs4.rewrite.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author totian
 * @Date 2019/11/4 17:02
 * @Version 1.0
 * @Description: 优化后的版本
 */
public class MyLinkedListStackVersion2<E> implements Iterable<E>{

    private class Node<E> {
        E value;
        Node<E> next;
    }

    Node<E> first;
    int size;

    public MyLinkedListStackVersion2(){
        first = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void push(E element){
        Node<E> newNode = new Node();
        newNode.value = element;
        newNode.next = first;
        first = newNode;
        size++;
    }

    public E pop(){
        if(size == 0) throw new NoSuchElementException();
        E element = first.value;
        first = first.next;
        size--;
        return element;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (E e : this) {
            sb.append(e.toString());
            sb.append("--");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private  class MyIterator implements Iterator<E>{
        //why it report error like this?
        //Node<E> current = first;
        Node current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(current == null) throw new NoSuchElementException();
            E element = (E)current.value;
            current = current.next;
            return element;
        }
    }

    public static void main(String[] args) {
        MyLinkedListStackVersion2<String> myStack = new MyLinkedListStackVersion2<String>();
        myStack.push("tom");
        myStack.push("jack");
        myStack.push("bob");

        System.out.println(myStack);
        for (String s : myStack) {
            System.out.println(s);
        }
    }
}
