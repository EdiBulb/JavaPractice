package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b5_bj15964 {
    //method - a,b를 입력받아 (a+b)*(a-b)를 출력한다.
    //이 클래스에서만 사용할 메소드라서 private로 선언함
    private static void fun1(long a, long b){

        System.out.println((a+b)*(a-b));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = (br.readLine());

        StringTokenizer st = new StringTokenizer(first);

        fun1(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));


    }
}
