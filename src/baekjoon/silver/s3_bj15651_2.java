package baekjoon.silver;

/*패캠 강의 문제 해설*/
/*문제*/

import java.util.Scanner;

/*이해도 : 이해 안됨...*/
public class s3_bj15651_2 {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //N까지의 자연수
        M = sc.nextInt(); // 길이

        arr = new int[M];

        dfs(0);
        System.out.println(sb);

    }

    public static void dfs(int depth){
        if(depth ==M){
            for(int i=0;i<M;i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1;i<=N;i++){
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
