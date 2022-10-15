package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class s1_bj1931_1 {
    static List<Time> list = new ArrayList<>();
    static int N;

    static class Time{
        int start;
        int end;

        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Time(start,end));
        }

        compare_sort();

        greedy();
    }

    static void compare_sort(){
        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(s1_bj1931_1.Time o1, s1_bj1931_1.Time o2) {
                if(o1.end == o2.end){
                    return o1.start - o2.start;
                }
                return o1.end - o2.start;
            }
        });
    }

    static void greedy(){
        int count = 0;
        int prev_end_time = 0;

        for(int i=0;i<N;i++){
            Time time = list.get(i);

            if(prev_end_time <= time.start){
                prev_end_time = time.end;
                count++;
            }
        }
        System.out.println(count);
    }
}
