package algs4.rewrite.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author totian
 * @Date 2019/11/4 14:02
 * @Version 1.0
 * @Description: 基于链表实现的Stack,first指向最后一个加入的元素
 */
public class MyLinkedListStack<E> implements Iterable {

    public static class Node<E>{
        E item;
        Node next;
    }

    Node first;
    int size;

    public MyLinkedListStack(){
        first = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void push(E item){
        Node node = new Node();
        node.item = item;

        Node oldFirst = first;
        first = node;
        node.next = oldFirst;

        size++;
    }

    public E pop(){
        if(size == 0) throw new NoSuchElementException();
        Node<E> oldFirst = first;
        first = oldFirst.next;
        size--;
        return oldFirst.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    public class MyIterator<E> implements Iterator<E>{
        int index = 0;
        @Override
        public boolean hasNext() {
            return size > index;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            Node<E> temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            index++;
            return temp.item;
        }
    }

    @Override
    public String toString() {
        String temp = "";
        Node t;
        t = first;
        temp += t.item.toString() + ",";
        for (int i = 0; i < size-1; i++) {
            t = t.next;
            temp += t.item.toString() + ",";
        }
        return temp.substring(0, temp.length() -1);
    }

    public static void main(String[] args) {
        MyLinkedListStack<String> myStack = new MyLinkedListStack();

        myStack.push("hello Eva");
        myStack.push("hello Tom");
        myStack.push("hello Carrie");

        System.out.println(myStack);
        System.out.println(myStack.size());
        Iterator<String> iterator = myStack.iterator();
        System.out.println("----Traverse though iterator----");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----pop up one element----");
        System.out.println(myStack.pop());
        System.out.println("----Traverse again----");
        for (Object o : myStack) {

            System.out.println((String) o);
        }
    }
}
