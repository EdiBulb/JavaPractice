package baekjoon.silver;
/*제목 : 좌표 정렬하기*/

/*블로그 풀이 분석*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s5_bj11650_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //질문 : 왜 이렇게 하는걸까?
        int[][] arr = new int[N][2];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(e1,e2)-> {
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{
                return e1[0]-e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
