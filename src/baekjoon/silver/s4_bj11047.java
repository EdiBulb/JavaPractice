package baekjoon.silver;
/*제목 : 동전 0 */

/*문제 이해 :
* 1. K 금액을 만들기 위한 동전 최소 개수를 구해라*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*접근법 :
* 1. 동전 종류 리스트를 만든다.
* 2. 그리디 메소드를 만든다.
* 3. 동전 종류 리스트를 내림차순 정렬한다.
* 4. 메소드를 실행한다.
* */

public class s4_bj11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 값 K

        /*1번*/
        ArrayList<Integer> coinList = new ArrayList<Integer>(); //동전 종류를 담는 리스트

        //coinList에 동전 담기
        for(int i=0;i<N;i++){
            coinList.add(Integer.valueOf(br.readLine()));
        }
        
        /*3번*/
        //그리디 사용을 위해 가장 큰 값의 동전을 사용해야함으로, 내림차순 정렬하기
        Collections.sort(coinList,Collections.reverseOrder());
 
        //그리디 객체생성
        GreedyAlgorithm gObject = new GreedyAlgorithm();
        
        /*4번*/
        //coinFunc() 메소드로 총 코인 개수 출력하기
        gObject.coinFunc(K, coinList);

    }


}

/*2번*/
//그리디 클래스
class GreedyAlgorithm {
    public void coinFunc(Integer price, ArrayList<Integer> coinList) {//가격과 동전 종류 리스트를 파라미터로 받으면 총 동전 개수를 출력하는 메소드
        Integer totalCoinCount = 0; //K값을 최소로 만들기 위한 사용된 총 동전 개수
        Integer coinNum = 0; //각 종류별 동전이 K를 최소한으로 만족하기 위해 필요한 동전의 개수

        for (int index = 0; index < coinList.size(); index++) {//파라미터인 coinList의 길이만큼 반복한다.
            coinNum = price / coinList.get(index);//각 동전별로 사용되어야 할 개수를 구함
            totalCoinCount += coinNum;//사용되어야 할 coinNum 를 총 개수에 합한다.
            price -= coinNum * coinList.get(index);//남은 가격을 구한다.
        }
        System.out.println(totalCoinCount);//총 사용된 동전 출력
    }
}
