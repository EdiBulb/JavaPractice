package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*문제 : 별 찍기 - 10*/
/*문제 이해 :
* */
public class g5_bj2447_2 {

    static char[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //배열 생성 -> N으로 27을 넣는다고 가정해보자
        arr=new char[N][N];

        star(0,0,N,false);


    }

    //star는 어떤 메소드지? - 재귀용으로 사용할 메소드임,
    static void star(int x, int y,int N, boolean blank){

        //arr[x][y]가 공백인 경우 이 조건문을 돈다.
        if(blank){
            for(int i=x;i<x+N;i++){
                for(int j=y;j<y+N;j++){
                    arr[i][j]=' ';
                }
            }
            return;//메소드를 빠져나옴
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
                //5번째는 중간이므로, 공백을 출력하러 간다.
                if(count==5){
                    star(i,j,size,true);
                }else{
                    //중간이 아닐 경우, 별을 계속 출력한다.
                    star(i,j,size,false);
                }
            }
        }

    }

}
