package baekjoon.etc;

import java.util.ArrayList;
import java.util.Scanner;

class MyQueue<T>{
    private ArrayList<T> queue=new ArrayList<T>();
    //push기능
    public void enqueue(T item){
        queue.add(item);
    }
    //pop기능
    public int dequeue(){
        if(queue.isEmpty()){
            System.out.println(-1);
        }
        return (int)queue.remove(0);
    }
    //size기능은 int를 반환해야함
    public int size(){
        return queue.size();
    }

    public int isEmpty(){
        if(queue.isEmpty()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int front(){
        if(queue.isEmpty()){
            return -1;
        }
        else{
            return (int)queue.get(0);
        }
    }
    public int back(){
        if(queue.isEmpty()){
            return -1;
        }
        else{
            return (int)queue.get(size()-1);

        }
    }
}
public class bj18258 {
    public static void main(String[] args) {
        MyQueue<Integer> mq=new MyQueue();

        Scanner sc=new Scanner(System.in);

        //명령의 수 n
        int n=sc.nextInt();

        //n번 명령을 입력받는다.
        for(int i=0;i<n;i++){
            String s=sc.next();

            if(s.equals("push")){
                int next=sc.nextInt();
                mq.enqueue(next);
            }
            else if(s.equals("pop")){
                mq.dequeue();
            }
            else if(s.equals("size")){
                System.out.println(mq.size());
            }
            else if(s.equals("empty")){
                System.out.println(mq.isEmpty());
            }
            else if(s.equals("front")){
                System.out.println(mq.front());
            }
            else if(s.equals("back")){
                System.out.println(mq.back());
            }

        }

    }
}
