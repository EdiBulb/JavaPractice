package baekjoon.silver;

/*제목 : 파도반 수열*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 이해 :
* 정삼각형의 변의 길이 1로 시작한다.
* 이 규칙성을 보고 P(N)을 구하자.
*
* 1,1,1,2,2,3,4,5,7 보니까, f(N)=f(N-3) + f(N-2)공식이 나온다. N=1,2,3인 경우만 배열에 저장하자*/
public class s3_bj9461_1 {

    //메모이제이션을 위한 배열을 N이 100이하이므로 101까지 생성한다.
    public static Long[] seq = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        seq[0] = 0L;
        seq[1] = 1L;
        seq[2] = 1L;
        seq[3] = 1L;

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            sb.append(padovan(Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.println(sb);
    }
    //padovan 메서드 - 계산된 값인지 아닌지를 판단해서 return을 하거나 N에 맞는 값을 구하는 메서드
    public static long padovan(int N){
        if(seq[N]==null){
            seq[N] = padovan(N-2)+padovan(N-3);
        }
        return seq[N];
    }
}
