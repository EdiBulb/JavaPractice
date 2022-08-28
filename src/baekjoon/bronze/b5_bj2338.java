package baekjoon.bronze;

/*제목 : 긴자리 계산*/

/*문제 이헤 : 두 수를 입력받아서, 덧셈 뺄셈 곱셈을 구하라 */

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class b5_bj2338 {



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BigInteger A = sc.nextBigInteger();
        BigInteger B = sc.nextBigInteger();

        System.out.println(A.add(B));
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
    }
}
