package baekjoon.bronze;

/*재귀란?
* 함수 안에서 동일한 함수를 호출하는 형태를 말한다.
* 여러 알고리즘 작성시 사용되므로 익숙해져야한다.
* */



/*제목 : 피보나치 수 5*/

/*문제 이해 :
* n이 주어졌을 때, n번째 피보나치 수를 구하라*/


/*접근법
 * 1. n에 따른 피보나치 수를 구하는 메소드를 구현한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2_bj10870 {

    //문제1: 피보나치 메소드를 어떻게 만드는가?

    /*해결책 1 : 메소드는 n이 주어졌을 때 n의 피보나치를 구하는 메소드를 만들기
    * 피보나치는 첫째 둘째 항이 1이고, 그 뒤 모든 항은 앞의 두 항의 합이다.
    *
    * f(0)인경우, f(1),f(2)인 경우를 고려 해야한다.
    * 0인경우의 피보나치는 0, 1과 2의 피보나치는 1, 그 외는 f(n-1)+f(n-2)로 한다.
    *  */
    static int Fibonacci(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        else return Fibonacci(n-1)+Fibonacci(n-2);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N입력 받기
        int N = Integer.parseInt(br.readLine());
        
        //메서드 호출
        System.out.println(Fibonacci(N));

    }
}
