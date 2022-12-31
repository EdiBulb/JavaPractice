package baekjoon.silver;
/*제목 : 연산자 끼워넣기*/

import java.io.IOException;
import java.util.Scanner;

public class s1_bj14888_2 {

    static int N, max, min;
    static int[] nums, operators, order;

    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = scan.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        order = new int[N+1];
        for(int i=1;i<=N;i++) nums[i] = scan.nextInt();
        for(int i=1;i<=4;i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    //완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
    static int calculator(){
        //nums, order
        int value = nums[1];
        for(int i=1;i<=N-1;i++){
            //value, order[i], num[i+1]
            if (order[i] == 1) // +
                value = value + nums[i+1];
            if (order[i] == 2) // -
                value = value - nums[i+1];
            if (order[i] == 3) // *
                value = value * nums[i+1];
            if (order[i] == 4) // /
                value = value / nums[i+1];

        }
        return value;
    }
    static void rec_func(int k){
        //order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.

        if(k==N){
            //완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(max, value);

        } else{
            //k 번째 연산자는 무엇을 선택할 것인가?
            for(int cand = 1; cand<=4; cand++){
                if(operators[cand] >=1){
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k+1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();//1번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색한다.
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());

    }
}
