package baekjoon.etc;

import java.util.LinkedList;
import java.util.Scanner;

public class bj2346 {
    public static void main(String[] args) {

        //링크드리스트 만들기
        LinkedList<Integer> deque = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        //풍선의 개수 T 입력받기
        int T = sc.nextInt();

        //풍선의 개수만큼 종이를 입력받는다.
        for (int i = 0; i < T; i++) {
            deque.add(sc.nextInt());
        }
        //바뀌는 인덱스 번호를 저장할 변수 idx
        int idx = 0;
        //줄어들 풍선의 개수를 셀 변수 count
        int count = T;


        for (int j = 0; j < T; j++) {
            int next = deque.remove();
            for(int i=0;i<next;i++){
                //빼서 뒤에 넣기
                deque.add(deque.pop());
            }

        }


    }
}
