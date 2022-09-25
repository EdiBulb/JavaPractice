package baekjoon.bronze;

import java.util.Scanner;

/*임시로 블로그를 보고 제출함*/
public class b5_bj3003_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        king = king - in.nextInt();
        queen = queen - in.nextInt();
        rook = rook - in.nextInt();
        bishop = bishop - in.nextInt();
        knight = knight - in.nextInt();
        pawn = pawn - in.nextInt();

        System.out.print(king + " ");
        System.out.print(queen + " ");
        System.out.print(rook + " ");
        System.out.print(bishop + " ");
        System.out.print(knight + " ");
        System.out.print(pawn);

    }
}
