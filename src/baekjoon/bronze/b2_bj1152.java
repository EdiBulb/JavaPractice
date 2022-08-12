package baekjoon.bronze;
/*문제 : 단어의 개수*/

/*문제 이해
* 문자열을 입력받는다.  - 대소문자와 공백이 있다.
* 이 문자열에 몇 개의 단어가 들어있는지 구하는 프로그램이다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*접근법
* 1. 문자열을 입력받는다.
* 2. 공백을 구분해서 토큰으로 받는다.
* 3. 단어의 개수를 어떻게 파악하지? 더 이상 토큰이 없다면, 반복을 끝내야하는데..
* 입력값이 null이면 반복을 멈추게 할까?
* 문제가 뭐지? 문자열을 공백으로 구분할 것, 그리고 그 토큰의 개수를 파악하는 방법은?
* 아,,, 그 공백을 구분할 때 배열에 넣는 방법이 있던데, 그 배열의 사이즈를 파악하는 건 어떨까?*/

public class b2_bj1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        /*1. 문자열을 받는다.*/
        String str = bf.readLine();

        /*2. split을 사용해서 공백으로 구분하여 배열을 만든다.*/
        //StringTokenizer가 아닌 split을 사용한 이유 -> 배열을 통해 단어의 개수를 찾을 수 있기 때문
        String[] arr = str.split(" ");


        //ArrayList를 써볼까? -> ArrayList가 중요한게 아니라, 맨 앞이 공백일 경우 공백이 인덱스 0으로 들어가는 것이 문제인 것이다.

        //문자열 str의 첫 문자가 공백인 경우와, 아닌 경우를 나눠볼까? -> 놓친 조건이 있었음. 문자열로 공백만 넣는 경우임

        /*3가지 경우로 나눔.*/
        if(str.charAt(0)==' ' && str.length()==1){ /*입력값으로 공백 한개를 넣는 경우 -> 0만 출력하면 됌.*/
            System.out.println(0);
        }else if(str.charAt(0)==' '){/*문자열의 첫 문자가 공백인 경우*/
            System.out.println(arr.length-1);
        }else{/*첫 문자가 공백이 아닌 모든 경우*/
            System.out.println(arr.length);
        }
    }
}
