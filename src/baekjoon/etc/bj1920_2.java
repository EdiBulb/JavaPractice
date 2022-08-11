package baekjoon.etc;

import java.util.Arrays;
import java.util.Scanner;

public class bj1920_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int M = sc.nextInt();

        //stringbuilder가 뭐지?
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(binarySearch(arr,sc.nextInt())>=0){
                sb.append(1).append('\n');
            }
            else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }



    public static int binarySearch(int[]arr,int num){
        int low=0;
        int high = arr.length-1;
        int mid=0;

        while(low<=high){
            mid=(low+high)/2;
            if(arr[mid]==num)return 1;
            else if(arr[mid]>num)high=mid-1;
            else if(arr[mid]<num)low=mid+1;
        }
        return 0;
    }
}
