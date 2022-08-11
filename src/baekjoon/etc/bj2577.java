package baekjoon.etc;

import java.util.Scanner;

public class bj2577 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();

        int total = a*b*c;

        //1. 숫자를 문자열로 형변환하기
        String str = Integer.toString(total);

        //2. 배열에 0~9 각 숫자가 몇번 들어갔는지 횟수 확인하기

        for(int i=0;i<10;i++){//2-1 0부터 9까지 하나씩 검사하기
            int cnt =0;
            for(int j=0;j<str.length();j++){//2-2.문자열 인덱스 0부터 문자열 길이까지 검사
                if(str.charAt(j)-'0'==i){//문자와 정수인 i을 비교해야함, so '0'을 빼줌으로써 문자을 정수로 바꿔준다
                    cnt++;
                }
            }
            System.out.println(cnt);

        }


    }
}
