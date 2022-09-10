package baekjoon.silver;

/*제목 : 좌표 정렬하기 2*/

/*문제 이해 :
* 1.y를 오름차순으로 정렬한다.
* 2. y가 같다면 x를 오름차순으로 정렬한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*접근법
* 1. y값부터 오름차순으로 정렬시킨다.
* 2. 그 뒤에 x값을 오름차순으로 정렬한다.*/
public class s5_bj11651_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());


            //문제 1 : 배열에 어떻게 집어넣어야하는지 모르겠다.
            //문제 2 : 배열에 집어넣더라도 어떻게 y만 정렬시키는지 모르겠다.

            //가설 1 : 없음
            //가설 2 : Arrays를 사용하는 것 같은데, 어떻게 사용해야할지 모르겠다.


        int[][] arr = new int[N][2];

        StringTokenizer st;

        //해결책 1 : 2차원 배열로 만들어서 한 쌍 느낌으로 집어넣을 수 있다.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(bf.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        //역기서부터 잘 이해가 안감
        //해결책 2 : Arrays.sort를 사용하는데, 변형을 한다.
        Arrays.sort(arr,(e1, e2)->{
            if(e1[0] == e2[0]){
                return e1[1]-e2[1];
            } else{
                return e1[0] - e2[0];
            }
        });


        //Stringbuilder를 쓰는 습관 만들기
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(arr[i][1] + " " + arr[i][0]).append('\n');
        }
        System.out.println(sb);
    }
}
