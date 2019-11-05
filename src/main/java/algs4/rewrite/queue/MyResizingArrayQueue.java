package algs4.rewrite.queue;

import sun.security.util.Length;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author totian
 * @Date 2019/11/4 8:30
 * @Version 1.0
 * @Description A queue based on Array which can be resized.
 */
public class MyResizingArrayQueue<E> implements Iterable<E> {
    Object[] elementData;
    int size;
    //数组不为空时， 指向第一个元素的位置
    int first;
    //数组不为空时， 指向最后一个元素的下一个位置(根first不一样)
    int last;

    public MyResizingArrayQueue() {
        elementData = new Object[2];
        //数组为空时，下边三个都设置成0。这种情况下first, last没有实际意义。
        //如果希望size, first,last在任何时间点都有实际意义，可以考虑将first,last初始值设成-1.
        size = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < elementData.length; i++) {
            temp[i] = elementData[(i + first) % elementData.length];
        }
        elementData = temp;
        first = 0;
        last = size;
    }

    public void enqueue(E e) {
        if (size == elementData.length) resize(elementData.length * 2);

        elementData[last] = e;
        size++;
        last++;
        if (last == elementData.length) last = 0;
    }

    public E dequeue() {
        if (size == 0) throw new NoSuchElementException("The queue is empty, no data can be dequeue!");

        E temp = (E) elementData[first];
        elementData[first] = null;
        size--;
//        first = (++first) % elementData.length;
        first++;
        if(first == elementData.length) first = 0;
        if (size > 0 && size == elementData.length / 4) resize(elementData.length / 2);

        return temp;
    }




    //    public class MyIterator<E> implements Iterator<E>{

    //        int index = -1;
//        @Override
//        public boolean hasNext() {
//            return size - index > 1;
//        }
//
//        @Override
//        public E next() {
//            if(hasNext()){
//                E temp = (E) elementData[++index];
//            }
//            return null;
//        }
//    }


    @Override
    public String toString() {
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

    public class MyIterator<E> implements Iterator<E> {
        //index of element to be fetched.
        int index = 0;

        @Override
        public boolean hasNext() {
            return size > index;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E temp = (E) elementData[(index + first) % elementData.length];
            index++;
            return temp;
        }

    }

    public static void main(String[] args) {
        MyResizingArrayQueue<String> strings = new MyResizingArrayQueue<>();
        strings.enqueue("dog");
        strings.enqueue("cat");
        strings.enqueue("horse");
        strings.enqueue("mouse");

        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println(strings);
    }
}
