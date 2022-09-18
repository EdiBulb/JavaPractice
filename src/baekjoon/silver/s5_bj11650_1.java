package baekjoon.silver;
/*제목 : 좌표 정렬하기*/

/*블로그 풀이 분석*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class s5_bj11650_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //이차원 배열을 만든다.
        int[][] arr = new int[N][2];

        StringTokenizer st;
        //이차원 배열에 값을 입력한다.
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //정렬을 재정의한다.(정렬 조건을 바꾼다.)
//        Arrays.sort(arr,(e1,e2)-> {
//            if(e1[0] == e2[0]){
//                return e1[1] - e2[1];
//            }else{
//                return e1[0]-e2[0];
//            }
//        });

        //정렬을 재정의한다.(람다식 x)
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            //x좌표로 정렬하고 x좌표가 같으면, y좌표를 오름차순으로 정렬한다.
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){//x가 같으면
                    return o1[1]-o2[1];//y의 결과에 따라 위치를 바꾼다. -> 음수 : o1이 작으므로 오름차순 그래도, 양수 : o1이 크므로 순서를 바꾼다.
                }
                else{
                    return o1[0]-o2[0];//x가 같지 않으면 x의 결과에 따라 위치를 바꾼다.
                }
            }
        });

        System.out.println();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}