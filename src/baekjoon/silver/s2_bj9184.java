package baekjoon.silver;

/*제목 : 신나는 함수 실행*/

/*문제 이해 :
* 다음 조건의 재귀함수가 있다.
* 매우 오래걸린다.
* a,b,c, 가 주어졌을 떄 이 재귀함수를 출력하는 프로그램*/

/*접근법 :
* 1. 재귀함수를 우선 그대로 만든다.
* 2. dp를 사용해서 재귀 함수의 값을 저장할 수 있게 해본다.*/

/*문제&해결
* 1. 재귀함수 w를 어떻게 dp로 바꿀 수 있을까?
* 1. 20,20,20 배열을 만들어야할까?
* 예를 들어
* a[1][1][1] 일때 저장
* a[1][2][3]일 때 저장
*
*
* 2. 조건식이 부등호 범위로 되어있어서 cache 배열의 특정 위치를 선정해서 return값을 넣을 수가 없다.
* 2. 해결 - */
public class s2_bj9184 {
    static int w(int a,int b,int c){

        int[][][]cache = new int[21][21][21];
        if(a<=0 || b<=0 || c<=0){
            return 1;
        }
        if(a>20 || b>20 || c>20){
            return w(20,20,20);
        }
        if(a<b && b<c){
            return w(a,b,c-1)+w(a,b-1,c-1) - w(a,b-1,c);
        }
        return w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
    }
    public static void main(String[] args) {

    }
}
