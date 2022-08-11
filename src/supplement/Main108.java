package supplement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main108 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("bufferedWriter.txt"));
        bw.write("hello\n");
        bw.newLine();
        bw.write("I am writing\n");
        bw.flush();
        bw.close();

    }
}
