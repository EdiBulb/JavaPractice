package supplement;

public class Ascii {
    public static void main(String[] args) {
        //배열을 알파벳으로 채우는 연습
        //1. 알파벳을 담을 배열을 만듬
        char[] arr= new char[26];

        //2. 알파벳 반복문으로 담기
        for(int i=0;i<arr.length;i++){
            arr[i]=(char)(97+i);
        }
        //3. 알파벳 출력하기
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }


    }
}
