package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4_bj5554 {

    static int a;
    static int b;
    static int c;
    static int d;

    public static void main(String[] args) throws IOException {
        //입력받기
        input();
        //결과 출력하기
        result();

    }
    static void result(){
        int result = 0;
        result = (a+b+c+d);
        System.out.println(result/60);
        System.out.println(result%60);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        d = Integer.parseInt(br.readLine());



    }
}
