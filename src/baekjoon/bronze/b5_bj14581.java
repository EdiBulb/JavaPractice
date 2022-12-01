package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5_bj14581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for(int i=0;i<3;i++){
            System.out.print(":fan:");
        }
        System.out.println();

        System.out.print(":fan:");
        System.out.print(":" + s + ":");
        System.out.println(":fan:");

        for(int i=0;i<3;i++){
            System.out.print(":fan:");
        }    }
}
