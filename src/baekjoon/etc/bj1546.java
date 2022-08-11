package baekjoon.etc;

import java.util.Scanner;

public class bj1546 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        float[]scores = new float[n];

        //배열에 점수 넣기
        float max=0;

        for(int i=0;i<n;i++){
            scores[i]=sc.nextInt();
            //최대값구하기
            if(max<scores[i]){
                max=scores[i];
            }
        }

        float sum=0;
        for(int i=0;i<n;i++){
            sum+=(scores[i]/max*100);
        }
        float ave=sum/n;

        System.out.println(ave);
    }
}