package baekjoon.bronze;

/*제목 : 그대로 출력하기*/

/*문제 이해 :
* 1. 입력받은 문자열을 그대로 출력하라*/

/*접근법
* 1. 무한 루프를 써서 입력을 받고 출력하자
* 2. 입력이 없으면 break하자
* 3. StringBuilder를 사용하자*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5_bj11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        while (s != null){
            sb.append(s).append("\n");
            s = br.readLine();
        }
        System.out.println(sb);
    }
}
