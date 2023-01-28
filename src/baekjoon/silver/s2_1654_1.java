package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class s2_1654_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int k = Integer.parseInt(firstLine[0]); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(firstLine[1]); // 필요한 랜선의 개수

        //랜선 길이 배열
        int[] LanArray = new int[k];

        //랜선 길이 넣기
        for(int i=0;i<k;i++){
            LanArray[i] = Integer.parseInt(br.readLine());
        }

        //오름차순 정렬
        Arrays.sort(LanArray);

        //이분 탐색 시작
        long right = LanArray[k-1];
        long left = 1;
        long middle = 0; // 중간값

        //right가 작아질때까지 반복
        while(right >= left){
            middle = (right + left)/2;
            long sameCount = 0; // 일정하게 잘린 랜선 개수

            for(int j=0;j<LanArray.length;j++){
                sameCount += LanArray[j]/middle; //잘린 길이 다 더하기
            }

            if(sameCount>= n){
                left = middle+1;
            }
            else if(sameCount<n){
                right = middle -1;
            }

        }
        System.out.println(right);

    }
}
