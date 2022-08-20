package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 : 수 정렬하기*/
/* 다양한 정렬 법을 적용해서 시간복잡도를 비교해볼 것!!!!*/
/**/

class Sort{
    public static void bubbleSort(int[]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}

public class b2_bj2750_1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0;i<N;i++){

            arr[i] = Integer.parseInt(br.readLine());
        }
        Sort.bubbleSort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }
}
