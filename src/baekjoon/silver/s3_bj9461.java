package baekjoon.silver;

/*제목 : 파도반 수열*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 이해 :
* 정삼각형의 변의 길이 1로 시작한다.
* 이 규칙성을 보고 P(N)을 구하자.
*
* 1,1,1,2,2,3,4,5,7 보니까, f(N)=f(N-3) + f(N-2)공식이 나온다. N=1,2,3인 경우만 배열에 저장하자*/
public class s3_bj9461 {
    public static Long[]dp = new Long[101];

    public static long triangle(int N){
        if(dp[N]==-1){
            dp[N]=(triangle(N-2)+triangle(N-3));
        }
        return dp[N];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0]=0L; //0인 경우는 그냥 0으로 넣어줘도 되나보다.
        dp[1]=1L;
        dp[2]=1L;
        dp[3]=1L;

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());

            for(int j=4;j<dp.length;j++){
                dp[j]=-1;
            }
            System.out.println(triangle(N));

        }


    }
}
