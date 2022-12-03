package baekjoon.silver;

import java.util.Scanner;

public class s3_bj15652_2 {
    static int N, M;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
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
            dfs(i, depth + 1);
        }
    }
}
