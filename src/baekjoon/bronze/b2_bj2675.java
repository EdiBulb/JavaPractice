package baekjoon.bronze;
/*문자열 반복*/

/*문제 이해
* 문자열 s를 받는다.
* 각 문자를 R번 반복해 새 문자열 P를 만든다.
* S에는 0~9, A~Z. 특수기호 등이 들어간다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*접근법
* 1. 테스트 케이스 개수 int형 받기
* 1-1. 버퍼를 통해서 T개수만큼 한줄씩 받기
* 2. R도 int로 받기,
* 3. S는 문자열로 받기 - 1~20글자다.
* 4. 문자열의 각 문자를 떼서 R번 반복하고 넣어준다. - StringBuilder를 사용하고 append를 사용해보자*/
public class b2_bj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*첫째줄 값 넣기*/
        int T = Integer.parseInt(br.readLine());

        /*T번 입력값을 받는다.*/
        for(int i=0;i<T;i++){
            /*두번째 줄을 입력받는다.*/
            String str = br.readLine();
            /*공백으로 나눠준다.*/
            StringTokenizer st = new StringTokenizer(str);
            /*R 뽑아내기*/
            int R = Integer.parseInt(st.nextToken());
            /*S 뽑아내기*/
            String S = st.nextToken();

            //S에서 char를 하나씩 가져오고 R번 반복해주자
            StringBuilder sb = new StringBuilder();

            /*문자열의 길이만큼 반복해야지*/
            for(int l = 0;l<S.length();l++){
                /*각 char를 R번 반복해서 넣을 것임*/
                for(int j=0;j<R;j++){
                    /*근데 내가 S가 몇개의 문자로 이루어져있는지 모르잖아? - String의 사이즈를 아는 방법이 있나? - length 사용*/
                    sb.append(S.charAt(l));/*l이 문자열의 인덱스 역할을 해준다.*/
                }
            }
            System.out.println(sb);

        }
    }

}
