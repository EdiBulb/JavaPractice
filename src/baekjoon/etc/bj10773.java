package baekjoon.etc;
import java.util.Scanner;
import java.util.Stack;

public class bj10773 {
    public static void main(String[] args) {
        Stack<Integer> stack= new Stack<>();

        Scanner sc=new Scanner(System.in);

        //k번 입력받기
        int k=sc.nextInt();

        // 입력값이 0일 경우 pop(), 아닐경우 push()
        for(int i=0;i<k;i++){
            int input=sc.nextInt();
            if(input==0){
                stack.pop();
            }
            else{
                stack.push(input);
            }
        }
        int sum=0;

        //스택이 비어있을 경우 0 출력, 아닐 경우 pop()한 모든 값을 합한다.
        if(stack.isEmpty()){
            System.out.println(0);
        }
        else{
            for(int i=0;i<stack.size();i++){
//                sum+=stack.pop();
                sum+=stack.get(i);
            }
//            for(int o:stack){
//                sum+=o;
//            }

        System.out.println(sum);
        }

    }
}
