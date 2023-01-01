package baekjoon.silver;

import java.util.Scanner;

/*제목 : 부분수열의 합*/
/*접근법(다른 풀이 참고) :
* 1. DFS 알고리즘을 적용해서 지금 위치의 원소를 선택하거나 선택하지 않거나 2가지 조건을 재귀함수로 계속 호출하였다.*/

public class s2_bj1182_1 {

    static int N, S, count = 0; // N: N개의 수, S: 더한값, count: 부분수열의 개수
    static int[] num; //수열의 값을 넣는 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N 입력받기
        S = sc.nextInt(); // S 입력받기
        num = new int[N]; // 수열 넣는 배열 만들기

        //수열 값 넣기
        for(int i=0;i<N;i++){
            num[i] = sc.nextInt();
        }

        dfs(0,0);

        if(S==0){ // count 합이 0인 경우, 공집합도 포함되므로 그 수를 하나 빼주고 출력한다.
            count--;
            System.out.println(count);
        }else{
            System.out.println(count);
        }
    }

    private static void dfs(int depth, int sum){ // depth: 위치를 나타낸다. sum: 부분수열의 합
        if(depth==N){ // 마지막 위치인 경우,
            if(sum == S){ // 더한 값과 같을 경우,
                count++; //부분수열 개수 +1
            }
            return;
        }

        //마지막 위치가 아니라면,
        dfs(depth+1, sum+num[depth]); // 지금 위치의 원소를 선택하고 다음으로 넘어가기
        dfs(depth+1, sum); // 선택하지 않고 다음으로 넘어가기.
    }
}