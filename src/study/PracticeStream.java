package study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PracticeStream {
    public static void main(String[] args) throws IOException {


        try{
            FileReader fin = new FileReader("c:\\test.txt");
            int c;
            while ((c=fin.read())!=-1){
                System.out.print((char)c);
            }
            fin.close();
        }catch (FileNotFoundException e){
            System.out.println("파일을 열 수 없음");
        } catch (IOException e){
            System.out.println("입출력 오류");
        }
    }
}
