package algs4.rewrite;

import algs4.rewrite.queue.MyResizingArrayQueue;

import java.util.*;

public class Test1 {

    private String a;
    private ArrayList<String> b;
    private Integer c;
    private int d;
    private boolean e;
    private String[] f = {};
    private String g = "";
    private int h = 5;

    public Test1() {
        getClass().getResource("");
    }

    public static void main(String[] args) {
/*        for(int i=0;i<10;i++){
            Random r = new Random();
            for(int j=0;j<10;j++){
                System.out.print(r.nextInt(12) + " ");
            }
            System.out.println();
        }*/

//        String[] s = {};
//        for (String s1 : s) {
//            System.out.println(s1);
//        }
//        System.out.println(s);

//        Test1 test1 = new Test1();
//        System.out.println(test1.a);
//        System.out.println(test1.b);
//        System.out.println(test1.c);
//        System.out.println(test1.d);
//        System.out.println(test1.e);
//        System.out.println(test1.f);
//        System.out.println(test1.g);
//        System.out.println(test1.h);

//        String a = "test";
//        System.out.println(2/4);
//        System.out.println(3/4);

//        String[] test = {"hello Tom", "Hello jack", "Hello bob"};
//        int i = 0;
//        System.out.println(test[++i]);
//        System.out.println(i);

//        List<String> strings = Arrays.asList(test);
//        Iterator<String> iterator = strings.iterator();

        MyResizingArrayQueue<String> queue = new MyResizingArrayQueue();
        queue.enqueue("Hello xxxx");
        queue.enqueue("Hello jack");
        queue.enqueue("Hello Tom");
        queue.enqueue("Hello bob");
        queue.dequeue();
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
//            String s = iterator.next();
//            System.out.println(queue.size());
            System.out.println(iterator.next());

        }
        for (String s : queue) {

        }

//        String[] a = new String[2];
//        a[0] = "Hello";
//        a[1] = "tom";
//        a[2] = "jack";
//        for (String s : a) {
//            System.out.println(s);

//        }


    }

}