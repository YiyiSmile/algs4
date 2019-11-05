package algs4.rewrite.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author totian
 * @Date 2019/11/4 18:20
 * @Version 1.0
 * @Description 基于单向linkedlist的链表实现
 */
public class MyLinkedListQueue<E> implements Iterable<E>{
    private class Node<E>{
        E value;
        Node<E> next;
    }

    /*成员变量*/
    Node<E> first;
    Node<E> last;
    /*元素个数*/
    int size;

    public MyLinkedListQueue(){
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(E element){

        Node<E> oldLast = last;
        Node<E> newNode = new Node<E>();
        newNode.value = element;
        newNode.next = null;
        last = newNode;

        if(isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    public E dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        E element = first.value;
        first = first.next;
        size--;
        if(isEmpty()) last = null;
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
        return new MyIterator<>();
    }

    private class MyIterator<E> implements Iterator<E>{
        Node<E> current;

        public MyIterator(){
            current = (Node<E>) first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if(current == null) throw new NoSuchElementException();
            E element = current.value;
            current = current.next;

            return element;
        }
    }

    public static void main(String[] args) {
        MyLinkedListQueue<String> strings = new MyLinkedListQueue<>();
        strings.enqueue("tom");
        strings.enqueue("jack");
        strings.enqueue("jerry");

        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(strings);




    }
}
