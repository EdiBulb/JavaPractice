package baekjoon.bronze;
/*제목 : 엄청난 부자2*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*문제이해 : 돈의 양 n과 생명체 수 m이 주어진다.
* 몫과 나머지를 출력한다.*/
public class b5_bj1271 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        BigInteger money = new BigInteger(st.nextToken());
        BigInteger count = new BigInteger(st.nextToken());

        System.out.println(money.divide(count));
        System.out.println(money.remainder(count));


    }
}
