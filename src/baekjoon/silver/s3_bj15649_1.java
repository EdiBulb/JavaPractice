package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_bj15649_1 {
    static int N;
    static int M;
    static int[] arr; // M개의 수열을 담기위한 배열
    static boolean[] visit; // 방문 체크
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M]; // 수열 담을 크기의 배멸 생성
        visit = new boolean[N]; // N개의 노드가 방문되었는지 체크하기 위해 크기 N인 배열 생성

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=0;i<N;i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
