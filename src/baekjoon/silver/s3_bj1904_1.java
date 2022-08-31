package baekjoon.silver;

/*제목 : 01타일*/



//문제 발생1 : 시간초과
//해결법1 : 재귀를 사용하지 말고 동적계획법을 사용한다. 재귀를 사용하면 왜 시간초과가 나는지 알아보자


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s3_bj1904_1 {
    static Integer[] cache = new Integer[10000001];


    static int Dynamic(int data){

        for(int index=3;index<data+1;index++){
            cache[index]=cache[index-1]+cache[index-2];
        }
        return cache[data];
    }
//문제 발생 2: 틀렸음
//해결법 2 : 뭐가 틀린거지?

    //문제 3 : 다른 풀이 중에 재귀 이용해서 풀은 풀이가 있다. 어떻게 푸는거지?
    //해결법 3 : 이해해보기


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        cache[0]=0;
        cache[1]=1;
        cache[2]=2;



        System.out.println(Dynamic(N)%15746);

    }
}
