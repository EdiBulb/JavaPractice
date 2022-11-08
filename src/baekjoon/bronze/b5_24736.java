package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b5_24736 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();

        StringTokenizer st1 = new StringTokenizer(s1);
        int a1 = Integer.parseInt(st1.nextToken());
        int b1 = Integer.parseInt(st1.nextToken());
        int c1 = Integer.parseInt(st1.nextToken());
        int d1 = Integer.parseInt(st1.nextToken());
        int e1 = Integer.parseInt(st1.nextToken());


        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2);
        int a2 = Integer.parseInt(st2.nextToken());
        int b2 = Integer.parseInt(st2.nextToken());
        int c2 = Integer.parseInt(st2.nextToken());
        int d2 = Integer.parseInt(st2.nextToken());
        int e2 = Integer.parseInt(st2.nextToken());

        System.out.println(a1*6+b1*3+c1*2+d1*1+e1*2 +" " + (a2*6+b2*3+c2*2+d2*1+e2*2));
    }
}
