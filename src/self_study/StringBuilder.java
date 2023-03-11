package self_study;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StringBuilder {
    public static void main(String[] args) {

        PriorityQueue<Integer> myque = new PriorityQueue();

        myque.add(10);
        myque.add(11);
        myque.add(12);
        myque.add(13);
        myque.add(14);
        myque.add(15);
        myque.add(5);

        System.out.println(myque);

        Queue<Integer> myque1 = new LinkedList<>();
        //큐를 사용할 때 왜 linkedlist를 쓰지, queue는 인터페이슨인가?
        myque1.add(10);
        myque1.add(11);
        myque1.add(12);
        myque1.add(13);
        myque1.add(14);
        myque1.add(15);
        myque1.add(5);
        System.out.println(myque1);
    }

    public void append(String s) {
    }
}
