package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class b5_bj15740 {
    static BigInteger add(BigInteger a, BigInteger b){
        return a.add(b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        StringTokenizer st = new StringTokenizer(s);

//        char a = st.nextToken().charAt(0);
//        char b = st.nextToken().charAt(0);

//        System.out.println((char)a+(char)b); //공부할 것 : char로 정수 계산하는 방법알기 - 계속 아스키코드로 바뀌어서...


        byte a = Byte.parseByte(st.nextToken());
        byte b = Byte.parseByte(st.nextToken());
        System.out.println();

//
//        BigInteger a = new BigInteger(st.nextToken());
//        BigInteger b = new BigInteger(st.nextToken());
//


//        System.out.println(add(a,b));
    }
}
