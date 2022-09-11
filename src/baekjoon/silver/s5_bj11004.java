package baekjoon.silver;

/*제목 : K번째 수*/
/*문제 이해 :
* 1. N개의 수가 주어지고 이것을 오름차순 정렬한다.
* 2. 그리고 앞에서 K번째 있는 수를 구한다.
* 3. 둘다 int형*/

/*접근법 :
* 1. 수를 N개 입력받고 배열에 넣는다.
* 2. 배열을 정렬한다.
* 3. K번째 인덱스의 값을 출력한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s5_bj11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st1.nextToken());

        int K = Integer.parseInt(st1.nextToken());

//        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();


        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        for(int i=0;i<N;i++){
            list.add(Integer.valueOf(st2.nextToken()));
//            arr[i] = Integer.parseInt(st2.nextToken());
        }
//        Arrays.sort(arr);
        Collections.sort(list);
        //여기까지 했으면 배열에 값 다 들어감.

        System.out.println(list.get(K-1));
//        System.out.println(arr[K-1]);

        //문제 1 : Arrays.sort를 사용하니까 시간초과가 뜬다.
        //가설 1 : Arrays.sort의 시간복잡도를 확인해보니 collections.sort가 최악의 상황에 더 좋다고한다. colloection.sort를 써보자

    }
}
