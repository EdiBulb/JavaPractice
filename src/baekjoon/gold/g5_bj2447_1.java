package baekjoon.gold;

import java.util.Scanner;

/*문제 : 별 찍기 - 10*/
/*문제 이해 :
* */
public class g5_bj2447_1 {

    //2차원 배열을 사용한다.
    static char[][] arr;

    public static void main(String[] args) {
        //입력값을 받는다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //N*N 이차원 배열을 만든다.
        arr = new char[N][N];


        star(0,0,N,false);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    //method - N값에 따라 규칙적으로 공백칸인 경우와 아닌 경우를 판단해서 이차원 배열에 *또는 공백을 넣는 메소드
    static void star(int x, int y, int N, boolean blank){
        //지금이 공백칸일 경우 N*N개의 공백을 넣는다.
        if(blank){
            for(int i=x;i<x+N;i++){
                for(int j=y;j<y+N;j++){
                    arr[i][j]=' ';
                }
            }
            return;
        }
        //더이상 쪼갤 수 없는 블록일 때
        if(N==1){
            arr[x][y] = '*';
            return;
        }


        int size = N/3;
        int count =0;
        for(int i=x;i<x+N;i+=size){
            for(int j=y;j<y+N;j+=size){
                count++;
                if(count==5){
                    star(i,j,size,true);
                }else{
                    star(i,j,size,false);
                }
            }
        }
    }
}
