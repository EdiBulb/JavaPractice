package baekjoon.silver;

/*블로그 참조 - 분석하기 + 내 풀이*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s4_bj1920_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //N개의 정수
        int N = Integer.parseInt(bf.readLine());

        //크기가 N인 배열에 넣을 정수값들
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        //크기 N인 배열 생성 및 데이터 추가
        int[] arr =new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순 정렬하기
        Arrays.sort(arr);

        //비교할 M개의 데이터 공백구분하기
        int M = Integer.parseInt(bf.readLine());
        String s2 = bf.readLine();

        StringTokenizer st2 = new StringTokenizer(s2);

        StringBuilder sb = new StringBuilder();

        //이진탐색 메소드로 비교한 데이터의 유무를 출력한다.
        for(int i=0;i<M;i++){
            sb.append( binarySearch(arr, Integer.parseInt(st2.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }

    //메소드 - 이진 탐색 메소드
    public static int binarySearch(int[]arr,int num){//탐색하고자 하는 배열, 찾고자하는 정수값
        int low = 0; //초기 처음값의 인덱스
        int high = arr.length-1;
        int mid = 0; //초기 중간값의 인덱스

        while (low<=high){
            mid = (low + high)/2;//중간값 인덱스 찾기
            if(arr[mid]==num) return 1;//중간값이 찾는값과 같다면 1 리턴

            else if(arr[mid]>num) high = mid -1; // 중간값이 찾는값보다 크다면, 최대값을 중간값으로 변경
            else if(arr[mid]<num) low = mid + 1; // 중간값이 찾는값보다 작다면, 최소값을 중간값으로 변경
        }
        return 0;
    }
}
