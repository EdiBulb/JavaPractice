package baekjoon.silver;

/*제목 : 수 정렬하기 2*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*블로그 풀이 분석*/
public class s5_bj2751_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>list = new ArrayList<>();

        for(int i=0;i<N;i++){
//            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        for(int value : list){
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
