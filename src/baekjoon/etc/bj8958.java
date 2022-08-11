package baekjoon.etc;

import java.util.Scanner;

public class bj8958 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T =sc.nextInt();
        for(int j=0;j<T;j++){
            String result = sc.next();
            int count=0;
            int sum=0;
            for(int i=0;i<result.length();i++){
                if(result.charAt(i)=='O'){
                    count++;
                    sum+=count;
                }
                else{
                    count=0;
                }
            }
            System.out.println(sum);

        }

    }
}
