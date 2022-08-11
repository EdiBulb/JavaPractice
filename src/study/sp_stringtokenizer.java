package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sp_stringtokenizer {
    public static void main(String[] args) throws IOException {
        /*버퍼의 특징*/
        //버퍼를 사용하는 입력은, 키보드의 입력이 있을 때마다 한 문자씩 버퍼로 전송한다.
        //버퍼가 가득 차거나 혹은 개행 문자가 나타나면 버퍼의 내용을 한 번에 프로그램에 전달한다.

        /*버퍼 사용법*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //한 줄을 받아오는 방법
        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        /*받아온 한 줄을 공백단위로 나누는 방법*/
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(s);
        System.out.println(i);

        System.out.println(N);
        System.out.println(M);



    }
}
