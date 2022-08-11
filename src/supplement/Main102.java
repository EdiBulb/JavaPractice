package supplement;

import java.util.Scanner;

public class Main102 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int[]arr = new int[3];
        arr[0]=10;
        arr[1]=50;
        arr[2]=80;

        int max=50;

        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=(arr[i]/max*100);
        }
        float ave=sum/arr.length;

        System.out.println(ave);
    }
}
