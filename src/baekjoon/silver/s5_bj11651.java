package baekjoon.silver;

/*제목 : 좌표 정렬하기 2*/

/*문제 이해 :
* 1.y를 오름차순으로 정렬한다.
* 2. y가 같다면 x를 오름차순으로 정렬한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*접근법
* 1. y값부터 오름차순으로 정렬시킨다.
* 2. 그 뒤에 x값을 오름차순으로 정렬한다.*/
public class s5_bj11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        while(N-->0){
            String s = bf.readLine();
            StringTokenizer st =new StringTokenizer(s);
            //문제 1 : 배열에 어떻게 집어넣어야하는지 모르겠다.
            //문제 2 : 배열에 집어넣더라도 어떻게 y만 정렬시키는지 모르겠다.

            //가설 1 : 없음
            //가설 2 : Arrays를 사용하는 것 같은데, 어떻게 사용해야할지 모르겠다.

        }
    }
}
