package baekjoon.bronze;
/*제목 : 세수 정렬*/

/*문제 이해 :
* 1. 세 수를 입력받는다.
* 2. 세수를 오름차순 정렬해라
*/

/*접근법
* 1. 반복문을 통해서 푼다?
* 2. 세수가 주어졌을 떄 오름차순을 만드는 메서드를 만든다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b4_bj2752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        int[] arr = new int[3];
        for(int i=0;i<3;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
