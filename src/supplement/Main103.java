package supplement;

import java.util.Arrays;

public class Main103 {
    public static void main(String[] args) {
        String str ="harry";
//        char[] arr=new char[str.length()];
//
//        for(int i=0;i<str.length();i++){
//            arr[i]=str.charAt(i);
//        }
        char[]arr =str.toCharArray();
        System.out.println(Arrays.toString(arr));
    }
}
