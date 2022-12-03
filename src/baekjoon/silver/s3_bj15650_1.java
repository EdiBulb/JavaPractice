package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s3_bj15650_1 {
    static int N, M;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");



//        N = sc.nextInt();
//        M = sc.nextInt();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        dfs(1,0);
        System.out.println(sb);
    }

    public static void dfs(int at, int depth){
        if(depth == M){
            for(int val : arr){
                sb.append(val).append(' ');
//                System.out.print(val + " ");
            }
//            System.out.println();
            sb.append('\n');
            return;
        }

        for(int i = at; i<=N; i++){
            arr[depth] = i;
            dfs(i+1, depth + 1);
        }
    }
}
