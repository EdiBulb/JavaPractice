package baekjoon.silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class s4_10825_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //학생수
        int n = Integer.parseInt(br.readLine());

        //학생
        Student[] students = new Student[n];

        for(int i=0;i<n;i++){
            //학생 정보 - 이름, 국어, 영어, 수학 점수
            String[] score = br.readLine().split(" ");

            //정보 입력
            students[i] = new Student(
                    score[0],
                    Integer.parseInt(score[1]),
                    Integer.parseInt(score[2]),
                    Integer.parseInt(score[3])
            );
        }

        Comparator<Student> myComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //국어점수 내림차순 
                if(o1.korean < o2.korean){
                    return 1;
                }
                //국어 점수가 같으면 
                else if (o1.korean == o2.korean) {
                    //영어 점수 오름차순
                    if(o1.english>o2.english){
                        return 1;
                    } 
                    //영어 점수 같다면
                    else if (o1.english == o2.english) {
                        //수학점수 내림차순
                        if (o1.math<o2.math){
                            return 1;
                        }
                        //수학점수 같다면
                        else if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                    }
                }
                return -1; // -1이 의미하는게 뭔지?
            }
        };

        //재정렬
        Arrays.sort(students, myComparator);
        
        //출력
        for(int i=0;i<n;i++){
            bw.write(students[i].name + "\n");
        }
        
        //모름
        bw.flush();
        bw.close();
    }
}

class Student{
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int korean, int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}
