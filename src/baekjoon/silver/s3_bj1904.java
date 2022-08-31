package baekjoon.silver;

/*제목 : 01타일*/

/*문제 이해 :
* 2진 수열이 사용된다.
* 즉, 1하나만 있는 타일과 00타일만 남았음
* 크기가 N인 모든 2진 수열을 만들 수 없게됨. 즉, N(자릴수)이 주어졌을 때, 만들 수 있는 가짓수를 세어라.
* 예시
* * N=1, 0,1 -> 1만 가능 -> 2개 중 1개
* N=2, 00 01 10 11 중 00 11만 가능 -> 4개 중 2개
* N=3, 000 001 010 011 100 101 110 111, 중 001 100 111만 가능 -> 8개 중 3개
* N=4, 0000 0001 0010 0011 0100 0101 0110 0111 1000 1001 1010 1011 1100 1101 1110 1111 중 0000 0011 1001 1100 1111만 가능 -> 16개 중 5개
* 설마 재귀? 피보나치 같은 건가?
* f(N-2) + f(N-1) = f(N)

*
* 조건, N이 100만 인 경우까지 있음.*/

/*접근법
* 1.피보나치 수열을 한번 만들어보자*/

//문제 발생1 : 시간초과
//해결법1 : 1.시간초과 이유를 파악한다. 2.수정한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_bj1904 {

    //메소드 - 이진 수열 규칙
    static int Recursive(int N){
        if(N==1){
            return 1;
        }
        if(N==2){
            return 2;
        }
        else{
            return Recursive(N-2)+Recursive(N-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        System.out.println(Recursive(N)%15746);

    }
}
