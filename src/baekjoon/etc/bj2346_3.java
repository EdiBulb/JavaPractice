package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj2346_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //풍선 개수 입력받기
        int N =Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        //풍선 개수만큼 배열 생성하기
        //배열을 왜 생성하지?
        int[] balloon=new int[N];

        //풍선이 터지는 순서를 저장할 변수 result
        ArrayList<Integer>result=new ArrayList<>();

        //풍선에 들어있는 종이의 값을 balloon 배열에 넣는다.
        for(int i =0;i<N;i++){
            balloon[i]=Integer.parseInt(st.nextToken());
        }

        //리스트 모양의 풍선 생성
        LinkedList<Integer>list=new LinkedList<>();

        //풍선을 1번부터 N번까지 정해준다
        for(int i=1;i<=N;i++){
            list.add(i);
        }
        //리스트의 인덱스를 가리키는 index 변수
        int index=0;
        //리스트의 index를 바꿔가면서 result 배열에 터진 풍선 위치를 저장한다.
        while (true){
            int num=list.remove(index);
            result.add(num);

            //풍선이 다 터지면 반복문 탈출하기
            if(list.isEmpty())break;

            //풍선이 터지고 움직여야하는 방향과 횟수 구하기
            int move = balloon[num-1];

            //방향(양수,음수)에 따라서 구분하기
            if(move>0){
                --index;
                index=(index+move)%list.size();
            }else{
                move=Math.abs(move);
                move=list.size()-(move%list.size());
                index=(index+move)%list.size();
            }
        }
        for(int num:result){
            System.out.println(num+" ");
        }
    }
}
