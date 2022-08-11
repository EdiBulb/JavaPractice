package baekjoon.etc;

import java.util.LinkedList;
import java.util.Scanner;

public class bj1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> deque = new LinkedList<>();

        int count = 0;//2,3번 연산 횟수 누적합 변수

        int N = sc.nextInt();//큐의 크기
        int M = sc.nextInt();//뽑으려는 숫자의 개수

        //1부터 N까지 덱이 담아둔다.
        for (int i = 1; i <= N; i++) {
            //offer()는 링크드리스트에 add()와 기능이 같다.
            deque.offer(i);
        }

        int[] seq = new int[M];//뽑고자 하는 수를 담은 배열

        for (int i = 0; i < M; i++) {
            seq[i] = sc.nextInt();
        }
        //M번 반복해서 수를 확인하기
        for (int i = 0; i < M; i++) {
            //덱에서 뽑고자 하는 숫자의 위치(index)찾기
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if (deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }

            //터켓 원소가 중간지점을 기준으로 어디에 있느냐에 따라 경우를 나눔
            if (target_idx <= half_idx) {
                //2번 연산한다.

                for (int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();//pollFirst() : 덱의 앞 데이터를 제거한 뒤 리턴
                    deque.offerLast(temp);//offerLast(): 덱의 마지막에 엘리먼트 삽입
                    count++;

                }
            } else {//중간지점보다 원소의 위치가 뒤에 있는 경우
                //3번 연산한다.
                for (int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();//연산이 끝나고 맨 앞 원소 제거

        }
        System.out.println(count);

    }
}
