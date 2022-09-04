package baekjoon.silver;

/*제목 : 신나는 함수 실행*/
/*블로그 풀이 분석*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2_bj9184_1 {

    //3차원 배열을 사용해서 데이터르 저장한다.
    //함수 w에서 a,b,c 중 20이 넘어가게 되면 w(20,20,20)을 호출하고,
    //0 이하일 경우는 1을 반환하기 때문에
    //각 배열의 크기가 21(0~20)을 넘지 않는다.
    //내가 고민했던 것 : 배열에 음수인 경우도 필요하지 않나?
    // 0보다 작은 값이 하나라도 있다면 값이 1로 정해져있기 때문에 굳이 배열에 저장할 필요 없다.

    //재귀 함수의 인자값의 3개가 필요하므로 메모이제이션을 하기 위해서 3차원 배열을 만든다.
    //배열의 크기는 메소드의 인자값의 범위가 결국 결정되는 값으로 정한다.
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            //a,b,c 값이 -1 -1 -1 이 나오면 종료한다.
            if(a==-1 && b==-1 && c==-1){
                break;
            }
            //배운 것 : sb를 통해서 한번에 줄바꿈까지 넣는 방법
            //w재귀함수를 호출한다.
            sb.append("w(" + a + ", " + b + ", " + c +") = ").append(w(a,b,c)).append('\n');

        }
        System.out.println(sb);


    }

    //w 메서드 - 다음 규칙을 가진 메서드
    static int w(int a,int b,int c){
        //a,b,c가 범위를 벗어나지 않는 경우와 메모이제이션이 되어있는 경우를 먼저 판단해서 불필요한 계산을 없애준다.
        if(inRange(a,b,c) && dp[a][b][c]!=0){
        //0이 아니라는 것은 이미 해당 데이터가 존재한다는 뜻이므로 계산 없이 바로 리턴해준다.
            return dp[a][b][c];
        }

        //그렇지 않은 경우는?
        //조건식을 그대로 적어준다.
        if(a<=0 || b<=0 || c<= 0){
            return 1;
        }
        //a,b,c 중 하날도 20이 넘는 경우, w(20,20,20)을 호출하기에, 그 값을 저장해둔다.
        if(a>20 || b>20 || c>20){
            return dp[20][20][20] = w(20,20,20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        }
        return dp[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c) + w(a-1,b,c-1)-w(a-1,b-1,c-1);
    }

    //메소드 - a,b,c 가 범위 안의 수인지 확인하는 메소드다.
    static boolean inRange(int a,int b,int c){
        //배운 점 : 이 return 값이 boolean 값이 될 수 있구나.
        return 0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<= 20;
    }
}
