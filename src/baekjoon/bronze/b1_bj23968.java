package baekjoon.bronze;
/*문제 : 알고리즘 수업 - 버블 정렬 1*/

/*문제 이해
* N개의 서로 다른 양의 정수가 저장된 배열 A가 있다.
* 배열 A를 오름차순 정렬할 경우, K번째에 교환되는 수를 구해라
*
* 입력 : 배열 크기, 교환 횟수 ,, 배열 원소
*
* 즉, K번째 교환되는 두 수의 크기 순으로 출력한다.
* 오름차순으로 정렬되는데 교환되는 횟수가 K보다 작다면 -1 출력한다.*/

/*접근법
* 1. 버블정렬 구현
* 2. 첫째줄 입력값 N,K 받기
* 3. N번 반복해서 둘째줄 값을 배열 A에 넣기
* 여기까지 하면 배열 정렬 전 배열 세팅완료
* 4. 버블 정렬 시켜줌. 교환시, count를 해서 K값과 비교할 수 있도록 한다.
* 5. K번째 교환시 그 두 수를 배열에 집어넣는다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1_bj23968 {
    /*1. 버블 정렬 구현한다.*/
    //직접 구현 연습하기


    static int count =0; //교환 횟수를 세는 변수

    public static void boubleSort(int[]arr,int k){
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    //교환이 될 때마다 여기에 count를 +1 해준다.
                    count++;
                    if(count==k){
                        System.out.format("%d %d",arr[j],arr[j+1]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /*2. 첫째줄에 N과 K입력 받기*/
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();

        StringTokenizer st =new StringTokenizer(first);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*3. 둘째 줄에 입력값을 N번 입력 받고 배열에 넣는다..*/
        int[]arr=new int[N];
        String second = br.readLine();
        StringTokenizer st2 = new StringTokenizer(second);

        for(int i = 0;i<N;i++){
            arr[i]=Integer.parseInt(st2.nextToken());
        }
        /*4. 버블 정렬 시켜준다.*/
        boubleSort(arr,K);
        if(count<K){
            System.out.println(-1);
        }

    }
}
