package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class s3_2512_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지방의 수
        long result=0;

        int[] Request = new int[N]; // 지방 예산 배열

        //지방 예산 요청
        for(int i=0;i<N;i++){
            Request[i] = sc.nextInt();
        }
        //이분 탐색(정렬)
        Arrays.sort(Request);

        long M = sc.nextLong(); // 총 예산
        long left = 0; // 예산의 최소값
        long right = Request[N-1]; // 예산의 최대값
        while(left <= right){
            long mid = (left + right)/2; // 분배할 세금
            long sum = 0;

            //예산 총합 구하기
            for(int money:Request){
                if(money >=mid)sum += mid;
                else sum += money;
            }
            //예산 총합을 M과 비교
            if(sum>M){
                right = mid-1;
            } else{
                left = mid+1;

                //최대값 구하기
                result = Math.max(result, mid);
            }
        }
        System.out.println(result);

    }
}
