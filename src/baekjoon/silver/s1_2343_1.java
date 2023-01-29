package baekjoon.silver;

import java.util.Scanner;

public class s1_2343_1 {

    public static void main(String[] args) {

        int[] Lesson; // 레슨 시간
        int sum; // 레슨 합
        int count; //

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 강의 수
        int M = sc.nextInt(); // 블루레이 수

        Lesson = new int[N];

        //이분탐색
        int start = 0;
        int end = 0;
        for(int i=0;i<N;i++){
            Lesson[i] = sc.nextInt();
            if(start<Lesson[i]) start = Lesson[i];
            end = end + Lesson[i]; // 가장 긴 시간을 구한다.
        }

        while (start <= end){
            int middle = (start + end) /2;
            sum = 0;
            count = 0;
            for(int i=0;i<N;i++){
                if(sum + Lesson[i] > middle){
                    count++;
                    sum = 0;
                }
                sum = sum + Lesson[i];
            }

            if(sum !=0) count++;
            if(count>M) start = middle +1;
            else end = middle -1;
        }
        System.out.println(start);
    }
}