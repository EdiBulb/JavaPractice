package baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class s4_15970_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //점 개수
        int N =Integer.parseInt(br.readLine());

        //점 위치
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for(int i=0;i<=N;i++){
            a.add(new ArrayList<>());
        }

        //
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken()); // 위치
            int color = Integer.parseInt(st.nextToken()); // 색깔

            a.get(color).add(point); //같은 색깔에 위치를 넣는다.
        }

        //같은 색깔끼리 오름차순 정렬하기
        for(int i=0;i<=N;i++){
            Collections.sort(a.get(i));
        }

        //화살표 길이의 합
        int ans = 0; //초기값


        for(int i=0;i<=N;i++){
            //각 색깔의 수를 살펴보기
            for(int j=0;j<a.get(i).size(); j++){
                if(j==0){ // 맨 처음인 경우 - 다음 수에서 뺀 값
                    ans += a.get(i).get(j+1) - a.get(i).get(j);
                } else if(j==a.get(i).size()-1){ // 맨 끝인 경우 - 자신에서 전 값을 뺀 값
                    ans += a.get(i).get(j) - a.get(i).get(j-1);
                } else{// 중간인 경우 - 뒤에서 뺀 값과 앞을 뺀 값 중 작은 것 선택
                    int t = a.get(i).get(j+1) - a.get(i).get(j);
                    int f = a.get(i).get(j) - a.get(i).get(j-1);

                    ans += Math.min(t, f);
                }
            }
        }

        //출력하기
        bw.write(ans+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
