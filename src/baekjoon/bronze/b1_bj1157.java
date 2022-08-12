package baekjoon.bronze;
/*문제 : 단어 공부*/
/*문제 이해
* 알파벳 대소문자로 된 단어가 입력된다.
* 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내라
* 조건 :
* 1. 단어의 길이 백만을 넘지 않음
* 2. 대소문자 구분 안함
* 3. 출력 -> 대문자로 출력
* 4. 가장 많이 사용된 알파벳이 여러개 일 경우 -> ? 출력*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*접근법
* 1. 문자열로 받는다.
* 2. 문자열을 다 소문자나 대문자로 통일시킨다.
* 3. 같은 알파벳이 있을 떄 개수를 어떻게 파악하지?
*   3.1 알파벳 개수크기의 배열을 만든다.
*   3.2 a를 인덱스 0으로 두고, 각 알파벳이 나오면 그 인덱스의 값을 1더한다.
* 4. 배열의 가장 큰 값의 인덱스를 파악하고, 큰 값이 하나라면 그 인덱스를 알파벳 대문자로 바꾼다.
*   4.1 만약 큰 값이 하나가 아니라면, ?을 출력한다.*/
public class b1_bj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*1. 문자열을 받는다.*/
        String str = br.readLine();

        /*2. 대문자로 다 바꾼다.*/
        str = str.toUpperCase();

        /*3. 문자열 중 알파벳 개수 파악하기*/
        /*3.1 알파벳 개수 크기의 배열을 만든다. -> 알파벳은 26개*/
        int[] arr = new int[26];
        //인덱스 0 : a... 25 : z 로 둔다.
        //문제 : 각 알파벳을 추출하고 어떻게 정수로 바꿀까?
        //str.charAt(1)-'0'

        /*3.2 입력받은 알파벳을 배열의 인덱스로 바꾸고 값을 +1 해준다.*/

        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'A'] +=1;
        }
//        //문제 : 배열을 그냥 출력하면 이상한 값이 나와서, 출력하는 방법을 알아보다가 Arrays.toString()이라는 것을 알게됨
//        System.out.println(Arrays.toString(arr));
        /*여기까지 진행하면 배열에 각 알파벳의 개수가 잘 들어갔다.*/
        /*4. 가장 큰 값을 가진 인덱스 찾기*/
        //최대값이 중복될 경우를 위해서 flag를 만들어줌
        boolean flag = false; // 최대값 중복이 발생할 경우 true로 변환

        int max = 0;
        int max_index = 0;//최대값의 인덱스
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i]; //값을 갱신해준다.
                max_index=i;
            }
            //여기까지 했으면 max에는 최대값이 들어간다.
        }
        //최대값이 들어가는데, 중복을 확인하려면...
        for(int j =max_index+1;j<arr.length;j++){
            if(max ==arr[j]){
                flag = true; //최대값 중복이 있었음을 의미한다.
            }
        }

        /*출력 부분*/
        if(flag ==true){
            System.out.println("?");
        }else{
            System.out.println((char)(max_index+65));
        }


    }
}
