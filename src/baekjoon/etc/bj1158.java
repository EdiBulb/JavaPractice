package baekjoon.etc;

import java.util.LinkedList;
import java.util.Scanner;

public class bj1158 {
    public static void main(String[] args) {
        //큐 만들기
        LinkedList<Integer> circle = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        //N명의 사람
        int N = sc.nextInt();
        //K번째 사람
        int K = sc.nextInt();
        //리스트에 1~N집어넣기
        for(int i=1;i<=N;i++){
            circle.offer(i);
        }
        System.out.print("<");
        //리스트에서 K번째 제거한다.
        for(int j=0;j<N-1;j++){

            for(int i=0;i<K-1;i++){
                circle.offer(circle.poll());
            }
            System.out.print(circle.poll()+", ");
        }
        System.out.print(circle.poll());
        System.out.print(">");

    }
}
