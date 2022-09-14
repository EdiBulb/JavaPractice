package baekjoon.bronze;

/*제목 : 수 정렬하기 3*/

/*문제 이해 :
* 1. N개의 수가 주어지고 오름차순으로 정렬하라
* 2. N기 1천만까지가 범위다.
* 3. 주어진 시간이 5초이다.
* */

/*접근법 :
* 1. 딱봐도 일반 정렬 쓰면 시간초과 날 것 같으니... collections.sort를 써보자.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//문제 1 : 왜 제한시간을 5초를 줬지?
// 가정 1 : nlog(n)에서 n이 1천만일 경우, 5초가 커느라인인지 찾아볼 것
public class b1_bj10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // Wrapper 클래스 사용

//        ArrayList arr = new ArrayList();
//
//        //배열에 입려값을 다 넣는다.
//        for(int i=0;i<N;i++){
//            arr.add(Integer.parseInt(bf.readLine()));
//        }
//
//        //오름차순 정렬한다.  -> Collections.sort와 Arrays.sort 비교 정리할 것
//        Collections.sort(arr);

        //문제 7 : Arrays.sort를 이용해서도 아슬아슬하게 풀 수는 있다고 한다.
        //궁금한 점 7 : Arrays.sort로 풀렸다. 하지만 Collections.sort를 쓰는게 메모리를 더 쓰는 이유가 뭐지?
        //나는 시간 초과가 생길 것을 걱정하여 collections.sort를 썼는데, 오히려 메모리 초과의 원인이 되었다.
        //Arrays.sort와 collections.sort를 비교 분석할 것

        //문제 8 : Arrays.sort 대신 기수 정렬을 쓰자 -> 어떻게 쓰지?

        int[] arr2 = new int[N];

        for(int i=0;i<N;i++){
            arr2[i]= Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr2);

        //문제 2 : 메모리 초과가 떳음
        //가정 2 : StringBuilder를 사용해보자 -> StringBuilder 의 효과 정리할 것
        StringBuilder sb = new StringBuilder();

//        for(int i=0;i<arr.size();i++){
//            sb.append(arr.get(i)).append("\n");
//
////            System.out.println(arr.get(i));
//        }


        for(int i=0;i<arr2.length;i++){
            sb.append(arr2[i]).append("\n");
        }
        System.out.println(sb);
        //문제 3 : StringBuilder 를 해도 메모리초과가 떴다.
        //가정 3 : 배열에 너무 많은 수를 집어넣는가?

        //문제 4 : 메모리를 줄일 수 있는 방법을 모르겠다.
        //문제 5 : 메모리 제한이 8MB라는 것의 의미를 모르고 있다.
        //가정 5 : 문제별로 메모리 제한의 의미를 파악하고 정리할 것
        //해결책 5 : 주어진 메모리를 계산하는 방법이 있다. 그것을 배울 것

        //문제 6 : 배열에 다 저장하면 메모리 초과가 뜰 수 밖에 없음. 저장하지 않고 넣는 정렬하는 법이 뭐지?
        //가정 6 : 우선순위 큐를 쓰는건가?

    }
}
