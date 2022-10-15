package baekjoon.silver;

/*제목 : 회의실 배정*/
/*문제 이해
* 1. 회의 개수 N개
* 2. 회싀 시작 시간, 끝 시간
* 3. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*접근법
* */
public class s1_bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력받기
        int N = Integer.parseInt(br.readLine());

        //시간표 배열
        ArrayList<meeting> timeTable = new ArrayList<>();

        //for문을 돌려서 배열에 넣자.
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            StringTokenizer st =new StringTokenizer(s);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meeting m = new meeting(start,end);

            timeTable.add(m);




        }
        for(int i = 0;i<timeTable.size();i++){
            System.out.println(timeTable.get(i).start +" " + timeTable.get(i).end);
        }

    }
}

class meeting{
    int start;
    int end;

    public meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}