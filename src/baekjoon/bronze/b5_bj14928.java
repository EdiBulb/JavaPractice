package baekjoon.bronze;

/*제목 : 큰 수*/

/*문제 이해 :
 * 1. 큰수를 입력받고 생일로 나눠서 나머지를 구한다.*/

/*접근법 :
 * 1. 큰수니까 BigInteger 클래스를 사용한다.
 * 2. BigInteger클래스의 나머지 연산자를 이용한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class b5_bj14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        BigInteger N = new BigInteger(bf.readLine());
//        BigInteger birth = new BigInteger("20000303");

        //BigInteger는 BigInteger끼리만 연산이 된다. -> 포스팅하기

        //왜 시간초과가 뜨지?

//        System.out.println(N.remainder("20000303"));
    }
}
