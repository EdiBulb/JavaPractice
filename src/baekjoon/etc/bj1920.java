package baekjoon.etc;

import java.util.Arrays;
import java.util.Scanner;
/*이건 이진탐색을 이용해서 푼 것이다.
* 내가 원하는 것은 이진탐색을 이용한 것이 아니라, 해시테이블을 이용한 것이다.
* 참고 풀이로 두자
* */

public class bj1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        //이진 탐색을 활용하기 위해서 sort를 사용해 정렬한다.

        Arrays.sort(arr);

        int M = sc.nextInt();
        int[]arr2 = new int[M];
        for(int i=0;i<M;i++){
            arr2[i]=sc.nextInt();
        }

        //binarysearch가 뭐지? -> 이진탐색(OK)
        for(int i=0;i<M;i++){

            //arr에 내가 찾고자 하는 arr2[i]가 있는지 확인하기

            System.out.println(binarySearch(arr,arr2[i]));
        }
    }

    //이진탐색 특성을 보니까, 파라미터에, 1.탐색할 배열, 2.찾을 수 를 적는구나.

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
