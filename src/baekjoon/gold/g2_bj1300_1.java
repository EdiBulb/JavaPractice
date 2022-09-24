package baekjoon.gold;
/*제목 : K번째 수 */

/*블로그 문제 풀이 분석*/

import java.io.IOException;
import java.util.Scanner;

public class g2_bj1300_1 {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        long lo = 1;
        long hi = K;

        while (lo<hi){
            long mid = (lo + hi)/2;
            long count = 0;

            for(int i=1;i<=N;i++){
                count +=Math.min(mid/i,N);
            }

            if(K<=count){
                hi=mid;
            }
            else {
                lo = mid+1;
            }
        }
        System.out.println(lo);
    }
}
