package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class b5_bj10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        BigInteger bigNumber1 = new BigInteger(st.nextToken());
        BigInteger bigNumber2 = new BigInteger(st.nextToken());

        System.out.println(bigNumber1.add(bigNumber2));

    }
}
