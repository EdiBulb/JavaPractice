package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5_bj25372 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //반복횟수 N
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<N;i++){
            String s = bf.readLine();
            if(s.length()>=6 && s.length()<=9) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);

    }
}
