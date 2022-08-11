package supplement.chap18;

import java.io.*;

public class Main100 {
    public static void main(String[] args) throws Exception {
        //자바에서 데이터는 스트림을 통해 입출력되므로 스틸므이 트깆ㅇ을 잘 이해해야한다.
        //프로그램이 데이터를 입력 받을때에는 입력스트림, 데이터를 보낼 때는 출력스트림이라고 부른다.
        //입력스트림의 출발지 : 키보드, 파일, 네트워크상의 프로그램
        //출력스트림의 도착지 : 모니터, 파일, 네트워크상의 프로그램

        //정리하면, 프로그램을 기준으로, 데이터가 들어오면 입력스트림, 데이터가 나가면 출력스트림이다.
        //따라서 다른 프로그램과 데이터 교환을 하기 위해서는 양쪽 모두 입력스트림과 출력스트림이 필요하다.

        InputStream is = System.in;
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("입력:");
        String lineString = br.readLine();

        System.out.println("출력 :" + lineString);
    }
}

