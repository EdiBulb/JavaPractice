package baekjoon.bronze;
/*블로그 참조 풀이*/
/*접근법
* 이 풀이는 나와는 나르게 StringTokenizer를 사용했다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*배운 점
* 1. countTokens() 메소드가 있다는 것을 배웠다.
* 2. StringTokenizer와 split 의 차이점을 배웠다.
* 차이점 1. StringTokenizer는 클래스이고 Split은 메소드이다.
* 차이점 2. StringTokenizer는 빈 문자열을 토큰으로 인식하지 못하지만 split은 빈 문자열을 토큰으로 인식함
* 차이점 3. 결과 값의 차이 - 전자는 문자열, 후자는 문자열 배열이다.
* */

public class b2_bj1152_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*1. 문자열을 받는다.*/
        String str = br.readLine();

        /*2. 공백을 기준으로 나눈다.*/
        StringTokenizer st = new StringTokenizer(str);

        /*3. countTokens() 메소드를 통해, 토큰의 개수를 출력한다.*/
        System.out.println(st.countTokens());

    }
}
