package baekjoon.bronze;

/*문제 : 피보나치 수 5*/

/*문제 이해 :
* n이 주어졌을 때, n번째 피보나치 수를 구하라*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*접근법
* 1. 간단한 문제이다. n에 따른 피보나치 수를 구하는 메소드를 구현한다.*/
public class b2_bj10870 {

    public static int Fibonacci(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        else return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(Fibonacci(N));

    }
}
