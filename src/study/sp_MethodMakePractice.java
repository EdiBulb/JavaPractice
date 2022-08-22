package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sp_MethodMakePractice {
    public static void boubleSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0;i<arr.length;i++){
            arr[i]= Integer.parseInt(br.readLine());
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
