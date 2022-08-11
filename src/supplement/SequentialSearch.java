package supplement;

import java.util.Scanner;

public class SequentialSearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int key = Integer.parseInt(in.nextLine());
        String[] s = in.nextLine().split("\\s+");

        int n = s.length;
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(s[i]);
        }
        int result = sequentialSearch(data, key);
        System.out.println(result);

        in.close();
    }

    //찾는 값 : x,
    static int sequentialSearch(int arr[], int x) {
        //배열의 길이만큼 반복을 해야한다. 그래서 length를 쓴다.

        int n = arr.length;
        int key = x;
        int[] array = arr;
        int rt = 0;
        for (int i = 0; i < n; i++) {
            //찾는 값과 같으면 반복을 멈춘다.
            if (array[i] == key) {
                rt = i;
                break;
            }
            rt = -1;
        }
        return rt;

    }
}
