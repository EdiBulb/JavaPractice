package baekjoon.gold;
/*문제 : 알고리즘 수업 - 버블정렬 3*/

/*문제 이해
* N개의 서로 다른 양의 정수가 저장된 배열 A
* 배열 A를 오름차순 정렬한다.
* 배열 A를 오름차순 정렬하는 과정에서 배열 B가 나오는지 확인하는 프로그램*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*접근법
* 0. 버블정렬을 구현한다?
* 1. 배열의 크기를 입력받는다.
* 2. 배열의 크기에 따른 배열A와 배열B를 넣는다.
* 3. 배열 A를 swap을 한번씩 할 때마다 배열 B와 비교해서, 같다면 flag를 true로 바꿔준다.
* 4. flag가 true라면 1을, 아니라면 0을 출력한다.*/
public class g5_bj23970 {
    public static void boubleSort(int[] arr){
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){ //swap을 한다면?
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*1. 배열의 크기를 입력 받는다.*/
        int N = Integer.parseInt(br.readLine());

        /*2. 배열의 크기에 따른 배열 A와 B는 만들고 데이터를 넣는다.*/
        int[] A = new int[N];
        int[] B = new int[N];

        String first = (br.readLine());
        String second = (br.readLine());

        StringTokenizer st1 = new StringTokenizer(first);
        StringTokenizer st2 = new StringTokenizer(first);


        for(int i=0;i<N;i++){
            A[i]= Integer.parseInt(st1.nextToken());
        }
        for(int i=0;i<N;i++){
            B[i]= Integer.parseInt(st2.nextToken());
        }
        //여기까지 했으면 배열 A,B에 값이 들어있다.

        /*3. 배열 A를 swap할 때마다 배열 B와 비교해서, 맞다면 flag를 true로 바꿔준다.*/


    }
}
