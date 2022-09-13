package baekjoon.silver;

/*제목 : 소트인사이드*/

/*문제 이해 :
* 1. 수를 입력받는다.
* 2. 그 수의 자리수를 내림차순으로 정렬한다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*접근법 :
* 1. 수를 입력받는다.
* 2. 각 자릿수를 추출해서 배열에 넣는다.
* 3. 배열을 내림차순 정렬한다.*/

/*참고 : 메소드로도 구현해본다.*/
public class s5_bj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        //문자열 s의 크기를 가진 int형 배열을 만든다.
//        int[] arr = new int[s.length()]; 가정 1 : interger[] arr로 바꿔보기
        Integer[] arr = new Integer[s.length()];

        //문자열의 크기만큼 반복해서 문자열의 각 자릿수를 배열에 넣는다.
        for(int i=0;i<s.length();i++){
            arr[i] = Integer.valueOf(s.charAt(i)-'0');
            //문제 3 : charAt()를 사용하면 char형이 나온다.
            //가정 3-1: int로 형변환 시켜보자 -> 여전히 아스키코드임
            //해결책 3-1 : charAt()에 대해서 깊에 공부해보자!
            //가정 3-2 : 문자열의 숫자를 뽑아오려면...? -> 0을 빼보자 -> 성공! -> char to int 방법 정리하기
        }

        //문제 1 : arrays.sort 내림차순 하는 방법 모름 -> 찾아볼 것
        //문제 2 : Arrays.sort(arr, Collections.reverOrder())를 쓰는데, arr 빨간줄 떴다. arr가 int타입인데, integer로 바꾸니까 해결됨. 이유를 찾아볼 것
        //문제 2-1 : arr만 있으면 괜찮은데, Collections.reverOrder()를 쓰니까 에러가 났다.
        //해결책 2 : Integer클래스를 적용하니까 해결됨. Integer클래스랑 int변수랑 어떻게 다른지 확인할 것

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

    }
}
