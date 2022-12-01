package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b4_bj11945_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for(int i=0;i<N;i++){
            String s1 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s1);
            while (st2.nextToken() !=null){
                StringBuilder sb = new StringBuilder(st2.nextToken());
                System.out.println(sb.reverse());
            }
        }

    }
}
