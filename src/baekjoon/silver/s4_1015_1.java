package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class s4_1015_1 {
    static void sortArray(int[][]arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[1]<arr2[1])
                    return -1;
                else if(arr1[1]>arr2[1])
                    return 1;
                else
                {
                    if(arr1[0]<arr2[0])
                        return -1;
                    else
                        return 1;
                }
            }
        });

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        //배열 크기
        int n = Integer.parseInt(br.readLine());

        //수열 A
        int A[][] = new int[n][2];
        //수열 B
        int B[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int k = Integer.parseInt(st.nextToken());
            A[i][0] = i;
            A[i][1] = k;
        }

        sortArray(A);

        for(int i=0;i<n;i++){
            B[A[i][0]]=i;
        }

        for(int j=0;j<B.length;j++){
            sb.append(B[j] + " ");
        }
        System.out.println(sb);
    }
}
