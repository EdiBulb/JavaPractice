package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class g4_bj1253_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //n개 수열 입력
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //오름차순 정렬
        Arrays.sort(arr);

        //좋은 수 개수
        int cnt = 0;

        //투포인터
        for (int i = 0; i < n; i++) {
            //왼쪽, 오른쪽 인덱스에서부터 탐색
            int left = 0, right = n - 1;

            //타겟을 i=0부터 점검
            int target = arr[i];

            //인덱스 값을 더하고
            while (left < right) {
                //두 수를 더하고 비교한다.
                int cal = arr[left] + arr[right];
                if (cal < target) { // 타겟이 더 크면, left 인덱스를 올린다.
                    left++;
                } else if (cal > target) {
                    right--;
                } else { // 합이 target값과 같다면
                    if (i != left && i != right) { // 두 수가 자신과 같으면 안되기 때문에
                        cnt++; // 좋은 수 개수 올린다.
                        break;
                    }
                    if (left == i)
                        left++; // 다음 인덱스로 넘어간다.
                    if (right == i)
                        right--; // 인덱스를 줄인다.
                }
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}