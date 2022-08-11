package study;

import java.util.PriorityQueue;

public class sp_priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> myque = new PriorityQueue();

        myque.add(30);
        myque.add(11);
        myque.add(5);
        myque.add(20);
        myque.add(3);
        myque.add(10);

        System.out.println(myque);
        for(int i = 0;i<6;i++){
            System.out.println(myque.poll());
        }

    }
}
