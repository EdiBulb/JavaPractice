package baekjoon.silver;

/*제목 : 단어 정렬*/
/*블로그 참고*/

/*문제 이해 :
* 1. 단어를 n개 입력 받는다.
* 2. 단어의 개수 순으로 출력을 한다.
* 3. 단어의 개수가 같다면 사전순으로 출력한다.
* 4. 같은 단어가 입력되면 한번만 출력한다.*/

/*접근법
* 1. 입력받은 데이터를 배열에 다 넣는다?
* 2. 배열을 정렬시킨다? - 문자열의 길이에 따라서 배치하고 알파벳순으로 배치한다.
* 3. 출력한다. 일텐데... 이게 쉽지가 않을 것 같음
* 해시를 써야하나?
* 배열 순서로 문자를 넣어야할텐데,
* 문자열의 개수가 50이 넘지 않는다면, 배열을 50개 만들어서 문자열의 크기에 따라서 들어가는 배열을 분류하는 것은 어떨까?
* 그 다음에는 그 문자열의 크기가 같으니까, 알파벳끼리 비교를 해서.. !!해보는거지
*
* 접근법도 잘 떠오르지 않음...
*
* 재도전
* 입력은 받아서 어딘가에는 넣어야하는데...
* 예를들어, 문자열 배열에 넣는다고하면,,,
* 1.문자열의 길이로 재배치를 먼저 하고,
* 2.그 다음, 알파벳 배치를 해야한다.
* 그렇다면, 문자열의 길이에 따른 배열을 나눌까? 그럼 배열을 50개를 생성해야한다.
* 문제1 : 50개를 생성할 수 있어? -> 배열 다수의 개수를 한번에 생성하는 방법이 있나?
* 막힌부분1 : 어떻게 입력을 처리해야할지 모르겠다. -> 배열 하나에 다 넣는다면, 사이즈별로 어떻게 넣어야할지 모르겠어
* 배열을 50개를 또 만들어야하는지... 만든다면 이름은 arr1...arr50으로 해야하는데 이것을 어떻게 만들어야하는지...
*
* 해결책1(가정) : 배열 하나에 다 넣었다고 생각해보자.
*
* */

/*블로그로 배운 것
* 1. 배열을 특정한 규칙에 의해 정렬하고 싶은 경우, Arrays.sort에소드에 Comparator을 구현한다.
* 2. Arrays.sort를 재정의하는 것
* 3. Comparator 객체에 대한 것
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class s5_bj1181_1 {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //단어의 개수 N
        int N = Integer.parseInt(bf.readLine());

        //N개의 단어를 넣을 배열 생성한다.
        String[] arr = new String[N];

        //배열에 값을 넣는다.
        for(int i=0;i<N;i++){
            arr[i] = bf.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            //compare 사용법 알기
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2); //길이가 같다면 사전으로 정렬한다.
                }else {
                    return o1.length() - o2.length(); //
                }

            }
        });

        //이전 값과 같은지 비교하기 위해서 i-1을 해야하므로 arr[0]을 먼저 출력한다.
        System.out.println(arr[0]);
        for(int i=1;i<N;i++){
            if(!arr[i].equals(arr[i-1])){
                System.out.println(arr[i]);
            }
        }
//        System.out.println(arr.toString()); //toString()을 정확히 모르는구나.
//        System.out.println(Arrays.toString(arr));
    }
}