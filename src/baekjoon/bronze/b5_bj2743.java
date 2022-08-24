package baekjoon.bronze;
/*단어 길이 재기*/
/*문제 이해
* 알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*접근법
* 1.buffer로 문자열을 입력받는다.
* 2.문자열의 길이를 구한다.*/
public class b5_bj2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(s.length());
    }
}
