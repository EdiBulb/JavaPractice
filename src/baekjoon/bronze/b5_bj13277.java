package baekjoon.bronze;

/*제목 : 큰 수 곱셈*/

/*문제 이해 :
* 1. 큰 정수 두개를 입력받고 그것의 곱을 출력하시오*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*접근법 :
* 1. bigInteger 클래스를 써서 큰 정수를 다루자*/
public class b5_bj13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        System.out.println(a.multiply(b));

    }
}
