package baekjoon.silver;

/*블로그 참조 - 분석하기*/

import java.util.Arrays;
import java.util.Scanner;

public class s4_bj1920_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr =new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int M = sc.nextInt();

        int[] arr2 = new int[M];
        for(int i=0;i<M;i++){
            arr2[i]=sc.nextInt();
        }

        for(int i=0;i<M;i++){
            System.out.println(binarySearch(arr,arr2[i]));
        }
    }

    public static int binarySearch(int[]arr,int num){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;

        while (low<=high){
            mid = (low + high)/2;
            if(arr[mid]==num) return 1;

            else if(arr[mid]>num) high = mid -1;
            else if(arr[mid]<num) low = mid + 1;
        }
        return 0;
    }
}
