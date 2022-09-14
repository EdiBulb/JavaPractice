package fc_Algorithm;
/*제목 : 탐욕 알고리즘 - 동전문제 1*/
import java.util.ArrayList;
import java.util.Arrays;

public class GreedyAlgorithm {
    public void coinFunc(Integer price, ArrayList<Integer>coinList){ // 가격과 동전의 종류를 받는다.
        Integer totalCoinCount =0;//동전의 최종 개수
        Integer coinNum=0;//각각의 동전이 가격을 매꿀때 쓰이는 개수
        ArrayList<Integer>details = new ArrayList<>();//실제 내부적으로 어떻게 계산이되는지 기록하기 위해서 별도 배열 만듬

        for(int index =0;index<coinList.size();index++){//코인리스트를 순화하면서
            coinNum =price/coinList.get(index);
            totalCoinCount+=coinNum;
            price-=coinNum*coinList.get(index);
            details.add(coinNum);
            System.out.println(coinList.get(index)+"원: "+coinNum+"개");
        }
        System.out.println("총 동전 갯수 : "+totalCoinCount);
    }

    public static void main(String[] args) {
        GreedyAlgorithm gObject = new GreedyAlgorithm();
        ArrayList<Integer> coinList = new ArrayList<>(Arrays.asList(500,100,50,1));
        gObject.coinFunc(4720,coinList);
    }
}
