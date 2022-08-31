package baekjoon.silver;

/*제목 : 01타일*/

/*블로그 코드 분석*/

//해결법 : 똑같이 재귀를 사용했지만 이미 만들어진 값은 배열에 저장된 값으로 가져왔다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_bj1904_2 {
    //메모이제이션으로 사용할 배열을 선언한다.
    public static int[]dp = new int[1000001];

    //메서드 - 처음 나오는 값인지 확인한다.
    public static int Tile(int N){
        if(dp[N]==-1){//처음 나오는 값이라면, 다음 식을 행한다.
            dp[N]=(Tile(N-1)+Tile(N-2))%15746;
        }
        return dp[N];//이미 나왔던 값이라면 바로 return 해준다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1]= 1;
        dp[2]=2;

        // -1로 초기화
        //문제 : 왜 -1로 초기화하는거지? -> -1이라는 것은 이미 값이 만들어졌는지 확인하는 용도로 사용한다.
        for(int i=3;i<dp.length;i++){
            dp[i]=-1;
        }

        System.out.println(Tile(N));
    }
}
