package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class g4_9663_1 {

    //방법의 수
    static int cnt = 0;

    //체스판의 크기
    static int N;

    //퀸의 위치 - 배열 인덱스 : 행, 값 : 열
    static int[] queen;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 체스판 크기 입력

        //위치
        queen = new int[N];

        //깊이 0에서(0번쨰 행에서) dfs 시작
        dfs(0);

        System.out.println(cnt);
    }

    static void dfs(int depth){
        //깊이와 N이 같을 경우, 적절한 위치를 찾음
        if(depth == N){
            cnt++;
            return;
        }
        //같지 않은 경우, 확인하기
        for(int i=0;i<N;i++){
            //깊이에 값 넣기
            queen[depth] = i;

            //들어갈 수 있는지 확인하기
            if (canPut(depth)) // depth==0 인 경우, true.
                //다음 깊이 확인
                dfs(depth+1);
        }
    }
    static boolean canPut(int depth){
        for(int i=0;i<depth;i++){
            if(queen[depth] == queen[i]) // 같은 행에 있는 경우
                return false;
            else if(Math.abs(depth-i)== Math.abs(queen[depth] - queen[i])) // 대각선에 있는 경우
                return false;
        }
        return true;
    }
}
