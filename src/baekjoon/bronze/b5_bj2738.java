package baekjoon.bronze;

/*제목 : 행렬 덧셈*/

/*문제 이해 :
* 1. N*M 크기 행렬 A,B가 있다.
* 2. 두 행렬을 더해라*/

/*접근법 :
* N*M 2차원 배열을 두개 만들어서 더한다.*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b5_bj2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];

        for(int i=0;i<N;i++){
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            for(int j =0;j<M;j++){
                arr1[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            for(int j =0;j<M;j++){
                arr2[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int[][] result = new int[N][M];

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                result[i][j] = arr1[i][j] + arr2[i][j];
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
