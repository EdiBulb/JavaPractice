package study;

public class sp_StringAdd {
    public static void main(String[] args) {
//        String str1 = "abc";
//        String str2 = "def";
//
//        System.out.println(str1+str2);

        StringBuilder sb = new StringBuilder();
        sb.append("ABC");
        sb.append("DEF");

        System.out.println(sb);
        System.out.println(sb.toString());
    }
}
