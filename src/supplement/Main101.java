package supplement;

import java.util.StringTokenizer;

public class Main101 {
    public static void main(String[] args) {
        String str1="a b c";
        String str2="A!B!C";

        StringTokenizer st1=new StringTokenizer(str1);
        System.out.println(st1.nextToken());
        System.out.println(st1.nextToken());
        System.out.println(st1.nextToken());

        StringTokenizer st2=new StringTokenizer(str2,"!");
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());
        System.out.println(st2.nextToken());

        StringTokenizer st3=new StringTokenizer(str2,"!",true);
        System.out.println(st3.nextToken());
        System.out.println(st3.nextToken());
        System.out.println(st3.nextToken());
        System.out.println(st3.nextToken());
        System.out.println(st3.nextToken());
    }
}
