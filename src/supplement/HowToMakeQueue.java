package supplement;

import java.util.ArrayList;

public class HowToMakeQueue<T> {

    //ArrayList 생성
    private ArrayList<T> queue = new ArrayList<>();

    //enqueue 기능
    public void enqueue(T item){
        queue.add(item);
    }

    //dequeue 기능
    public T dequeue(){
        if(queue.isEmpty()){ //큐가 비었으면
            return null;// null을 리턴하고
        }
        return queue.remove(0); //비어있지 않으면 맨 앞의 값을 제거 및 리턴한다.
    }

    //isEmpty기능
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        HowToMakeQueue<Integer> queue = new HowToMakeQueue<>();
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
