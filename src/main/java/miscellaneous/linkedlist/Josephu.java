package miscellaneous.linkedlist;

import java.util.concurrent.ForkJoinPool;

/**
 * @Author Tom
 * @Date 2020/6/25 13:58
 * @Version 1.0
 * @Description: Josephu issue, Kid got out of the circle game.
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = CircleSingleLinkedList.newCircleSingleLinkedList(3);
        list.showKids();
        System.out.println("***********************");
        list.countKid(1, 4, 3);

    }

}

class CircleSingleLinkedList{
    private Kid first;

    public static CircleSingleLinkedList newCircleSingleLinkedList(int num){
        if(num <= 0)
            throw new IllegalArgumentException("The number couldn't be less than or equal 0");
        CircleSingleLinkedList list = new CircleSingleLinkedList();

        Kid current = list.first = new Kid(1, null);
        list.first.setNext(list.first);

        if(num == 1) return list;

        for (int i = 1; i < num; i++) {
            current.setNext(new Kid(i + 1, null));
            current = current.getNext();
        }
        current.setNext(list.first);
        return list;
    }

    public void showKids(){
        Kid current = first;
        while(true){
            System.out.printf("Kid No: %d\n",current.getNo());
            current = current.getNext();
            if(current == first) break;
        }
    }

    public void countKid(int startNo, int countNum, int nums){
        if(startNo < 1 || startNo > nums)
            throw new IllegalArgumentException("Start No can't be less than 1 or great than the total " +
                    "number of kids");
        Kid helper = first;
        while(helper.getNext() != first){
            helper = helper.getNext();
        }
        for (int i = 1; i < startNo; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while(true){
            if(helper == first){
                System.out.printf("Kid %d out!\n",first.getNo());
                break;
            }
            for (int i = 1; i < countNum; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("Kid %d out!\n",first.getNo());
            helper.setNext(first.getNext());
            first = helper.getNext();
        }
    }

}

class Kid{
    private int no;
    private Kid next;

    public Kid(int no, Kid next) {
        this.no = no;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Kid getNext() {
        return next;
    }

    public void setNext(Kid next) {
        this.next = next;
    }
}
