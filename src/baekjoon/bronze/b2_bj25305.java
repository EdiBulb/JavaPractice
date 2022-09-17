package baekjoon.bronze;

/*제목 : 커트라인*/

/*문제 이해 :N명중 K번째 큰 수를 구하면 된다. */

/*접근법 :
* 1. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class b2_bj25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        //응시자 수
        int N = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[N];

        int K = Integer.parseInt(st.nextToken());

        String s2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(s2);

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(arr[K-1]);
    }
}
