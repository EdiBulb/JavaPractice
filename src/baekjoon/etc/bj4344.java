package baekjoon.etc;

import java.util.Scanner;

public class bj4344 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //테스트케이스
        int c=sc.nextInt();
        while(c-->0){

        //학생 수
            int n=sc.nextInt();
            //학생 수 길이만큼 배열 생성
            int arr[]=new int[n];
            //배열에 값 입력
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }

            float sum=0;
            //데이터 합하기
            for(int i=0;i<arr.length;i++){
                sum+=arr[i];
            }
            //데이터 평균 구하기
            float ave = sum/n;
            //평균넘는 학생 수 cnt
            float cnt=0;
            for(int i=0;i<n;i++){
                if(ave<arr[i]){
                    cnt++;
                }
            }
            float result = cnt/n*100;

            System.out.format("%.3f%%",result);
            System.out.println();

        }
    }
}
