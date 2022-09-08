package baekjoon.silver;
/*제목 : 나이순 정렬*/

/*블로그 분석*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class s5_bj10814_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        //한 쌍을 이렇게 2차원 배열로 만들 수 있다.
        String[][] arr = new String[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine()," ");
            arr[i][0]= st.nextToken();//나이
            arr[i][1] = st.nextToken();//이름
        }

        //이렇게하면 세트로 들어간다.

        //보충공부가 필요하다.
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        }
        System.out.println(sb);


    }
}
