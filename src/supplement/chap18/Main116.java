package supplement.chap18;

import java.util.ArrayList;
import java.util.Scanner;

//MyStack 클래스를, ArrayList를 통해서
// push() pop() isEmpty()를 구현한다.
class MyStack{
    private ArrayList<Integer> stack = new ArrayList<>();

    //push 메소드
    public void push(int item){
        stack.add(item);
    }

    //pop 메소드
    public int pop(){
        //스택이 비어있다면 -1 리턴
        if(stack.isEmpty()){
            return -1;
        }
        //스택이 차있다면 수를 리턴하고 size 1감소
        return stack.remove(stack.size()-1);
    }
    //isEmpty 메소드
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    //size 메소드
    public int size(){
        return stack.size();
    }
    //top 메소드
    public int top(){
        //비어있다면 -1 출력
        if(stack.isEmpty()){
            return -1;
        }
        //값이 들어있다면 가장 위의 정수 출력
        return stack.get(stack.size()-1);
    }


}

public class Main116 {
    public static void main(String[] args) {
        MyStack  ms = new MyStack();
        Scanner sc = new Scanner(System.in);
        //명령 수
        int cnt = sc.nextInt();

        //명령 수만큼 반복한다.
        for(int i=0;i<cnt;i++){
            String s = sc.next();
            //만약 입력값이 push면
            if(s.equals("push")){
                ms.push(sc.nextInt());
            }
            else if(s.equals("top")){
                System.out.println(ms.top());
            }
            else if(s.equals("size")){
                System.out.println(ms.size());
            }
            else if(s.equals("empty")){
                if(ms.isEmpty()==false){
                    System.out.println(0);
                }
                else{
                    System.out.println(1);
                }
            }
            else{
                System.out.println(ms.pop());
            }
        }
    }
}
