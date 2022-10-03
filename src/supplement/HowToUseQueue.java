package supplement;

import java.util.LinkedList;
import java.util.Queue;

public class HowToUseQueue {
    public static void main(String[] args) {
        Queue<Integer> mq = new LinkedList<>();

        Queue<String> mq2 = new LinkedList<>();
        //자바에서 큐는 LinkedList를 활용해서 생성한다. 왜?

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.offer(3);

        System.out.println(queue);
    }
}
