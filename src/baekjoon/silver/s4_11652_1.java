package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class s4_11652_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //카드 숫자, 카드 개수 해시맵
        HashMap<Long, Integer> cards = new HashMap<>();

        //카드 개수 최대
        int max = 0;

        //가장 많은 카드 숫자
        long x = 0;
        for(int i=0;i<N;i++){

            //카드 숫자
            long card = Long.parseLong(br.readLine());

            //키값이 존재하면 해당 값을 가져오고, 존재하지 않으면 기본값을 가져온다.
            cards.put(card, cards.getOrDefault(card, 0)+1);

            //카드 숫자가 더 크면 갱신
            if(cards.get(card) > max){
                max = cards.get(card);
                x = card;
            } else if(cards.get(card) == max){ // 최댓값과 같다면, 둘 중 더 작은 수를 넣는다.
                x = Math.min(x, card);
            }
        }
        System.out.println(x);

    }
}
