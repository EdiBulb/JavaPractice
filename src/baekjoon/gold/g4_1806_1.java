package baekjoon.gold;

import java.util.Scanner;

public class g4_1806_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 수열 길이
        int S = scan.nextInt(); // 부분합(기준)

        int[] nums = new int[N+1]; // 수열

        for(int i=0;i<N;i++){
            nums[i] = scan.nextInt();
        }

        //구하고자 하는 것
        //부분합의 길이가 최소인 것
        int min = Integer.MAX_VALUE;

        //투포인터 사용 - 범위 압축 - 두 포인터 모두 왼쪽에서 시작
        int Left = 0;
        int Right = 0;

        //부분합(임시)
        int total = 0;

        //투포인터 적용
        while (Left<=N && Right<=N){ // 전부 돌 때까지 반복
            //구하는 것의 핵심
            if(total >=S && min > Right - Left) min = Right - Left; // 부분합이 s(부분합)보다 크고, 기존의 min값이 새로운 부분수열의 길이보다 크다면 갱신한다.
            
            //투포인터 범위 압축
            if(total < S) total += nums[Right++];
            else total -= nums[Left++];
        }

        //최소길이를 찾지 못했다면
        if(min == Integer.MAX_VALUE){
            System.out.println("0");
        }
        
        //최소 길이 출력
        else{
            System.out.println(min);
        }

    }
}
