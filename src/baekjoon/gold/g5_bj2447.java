package baekjoon.gold;

/*제목 : 별 찍기 - 10*/
/*문제 이해 :
* 1.재귀적인 패턴으로 별을 찍는다.
* 2.N이 3의 거듭제곱이다. ->3,9,27...
* 3.크기 N의 패턴은 NxN 정사각형 모양이다.
* 4.크기 3인 패턴은 가운데에 공백이 있고 가운데를 제외한 모든 칸에 별이 하나씩 있다.
* 5.N이 3보다 큰 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 정사각형을 패턴으로 둘러싼 형태이다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*해결법
* 1,N값을 입력받는다.
* 2. 패턴을 파악한다.
* 3. 제대로된 재귀 메서드를 만든다.*/
public class g5_bj2447 {


    //재귀함수를 만든다.
    static void print(int N){
        //NxN 크기의 이차원 배열을 만든다.
        char[][] pattern = new char[N][N];
        //마지막의 경우를 먼저 생각한다. N이 3인 경우,
        if(N==3){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==1&&j==1){
                        pattern[i][j]=' ';
                        break;
                    }
                    pattern[i][j]='*';
                }
            }
            return;
        }
        //N==3이 아닌 경우라면 잘게 쪼갤 수 있도록 만들어야할 것 같다.
        int size = N/3;
        print(size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //문제 1 : 이차원 배열의 값을 출력해야하는데 방법이 있는건지 없는건지 모르겠음.
        //해결책 1 :
    }
}
