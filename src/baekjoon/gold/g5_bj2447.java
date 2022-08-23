package baekjoon.gold;

/*문제 : 별 찍기 - 10*/
/*문제 이해 :
* */
public class g5_bj2447 {

    //재귀함수를 만든다.
    public static void Recursive(int N){
        for(int i=0;i<N;i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i=0;i<N/2;i++){
            System.out.print("*");
        }
        for(int i=0;i<N/2;i++){
            System.out.print(" ");
        }
        for(int i=0;i<N/2;i++){
            System.out.print("*");
        }
        for(int i=0;i<N;i++){
            System.out.print("*");
        }

        Recursive(N-1);
    }

    public static void main(String[] args) {
        Recursive(3);

    }
}
