package supplement;

import java.util.ArrayList;

//MyQueue는 ArrayList를 이용하는 방법으로 큐를 구현하는 클래스이다.
class MyQueue1<T>{

    private ArrayList<T>queue = new ArrayList<>();

    //enqueue 기능
    public void enqueue(T item){
        //ArrayList의 add메소드를 통해 구현한다.
        queue.add(item);
    }

    //dequeue 기능
    public T dequeue(){
        // ArrayList의 isEmpty 메소드를 통해 구현한다.
        if(queue.isEmpty()){
            return null;
        }
        //ArrayList의 remove 메소드를 통해 첫 번째 데이터를 삭제하여 구현한다.
        return queue.remove(0);
    }

    //isEmpty 기능
    public boolean isEmpty(){
        //ArrayList의 isEmpty 메소드를 통해 구현한다.
        return queue.isEmpty();
    }
}

//MyStack은 ArrayList를 이용하는 방법으로 큐를 구현하는 클래스이다.

class MyStack<T>{

    private ArrayList<T> stack = new ArrayList<>();

    //push 기능
    public void push(T item){
        //ArrayList의 add메소드를 이용해 구현한다.
        stack.add(item);
    }
    //pop 기능
    public T pop(){
        //ArrayList의 isEmpty메소드를 이용해 구현한다.
        if(stack.isEmpty()){
            return null;
        }
        //ArrayList의 remove 메소드를 이용해 맨 마지막 데이터를 제거하여 구현한다.
        return stack.remove(stack.size()-1);
    }
    //isEmpty 기능
    public boolean isEmpty(){
        //ArrayList의 isEmpty 메소드를 이용해 구현한다.
        return stack.isEmpty();
    }
}
public class Main116 {
    public static void main(String[] args) {
        //ArrayList를 이용하여 큐를 구현하는 MyQueue 객체를 생성한다.
        MyQueue<Integer>mq = new MyQueue<>();

        mq.enqueue(27);
        mq.enqueue(28);
        mq.enqueue(30);
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());
        System.out.println(mq.dequeue());

        MyStack<Integer> ms = new MyStack<>();
        ms.push(000);
        ms.push(001);
        ms.push(002);

        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());
    }

}
