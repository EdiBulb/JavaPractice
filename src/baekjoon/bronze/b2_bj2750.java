package baekjoon.bronze;

/*문제 : 수 정렬하기*/

/*문제 이해
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하라
 * 첫째줄에 수의 개수 N ->정수형
 * 둘쨰줄부터 N개의 수가 입력됨, 절대값이 1000보다 작거나 같은 정수 -> 마이너스도 있다는 얘기*/

/*접근법
 * 1. 정렬 메소드를 구현한다.
 * 1-1. 이미 있는 정렬 sort를 쓴다.*/

/*이 문제로 다양한 정렬에 대한 메소드를 구현해서 비교해볼 수 있음*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2_bj2750 {
    public static void main(String[] args) throws IOException {
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(3);
//        arr.add(-1);
//        arr.add(0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N의 개수를 받는다.
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
