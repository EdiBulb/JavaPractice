package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b4_bj11945 {
    public static void main(String[] args) throws IOException {
        //N,M 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //붕어빵 모양 입력받기
        //입력받을 때, 거꾸로 넣으면 출력만 하면 될 듯
        int[][] arr = new int[M][N]; // i, j
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }
        System.out.println(arr);
    }
}
