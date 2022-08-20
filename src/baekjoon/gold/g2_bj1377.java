package baekjoon.gold;
/*문제 : 버블 소트*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class g2_bj1377 {
    public static void bubbleSort(int[] A){
        boolean changed = false;
        for(int i=1;i<A.length+1;i++){
            changed =false;
            for(int j=1;j<A.length-i;j++){
                if(A[j]>A[j+1]){
                    changed = true;
                    int temp = A[j+1];
                    A[j+1]= A[j];
                    A[j]=temp;
//                    Collections.swap(A,A[j],A[j+1]);
                }
            }
            /*sort를 몇번 해야지 다 정렬이 되는가? 를 묻는 문제인듯하다.*/
            if(changed==false){
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[]arr = new int[N];

        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        g2_bj1377.bubbleSort(arr);
    }
}
