package baekjoon.etc;
//블로그 참고해서 따라 해본 방식
//사실 이해는 안갔음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bj2346_2 {
    //노드클래스를 만듬
    public static class Node<Integer> {
        int data;
        int num_order;
        Node<Integer> next;
        Node<Integer> prev;

        //생성자자
        Node(int data, int num_order) {
            this.data = data;
            this.num_order = num_order;
            this.next = null;
            this.next = null;
        }

        //입력받은 수를 헤더 노드부터 시작해 노드로 연결하기 위한 add()메소드
        //근데 왜 JCF에서 제공하는 링크드리스트를 안쓰고 직접 구현하는거지?

        public void add(int data, int order) {
            Node<Integer> balloon = this;
            while (balloon.next != null) {
                balloon = balloon.next;
            }
            balloon.next = new Node<>(data, order);
            if (balloon.prev == null) {
                balloon.prev = balloon.next;
            }
            balloon.next.prev = balloon;
        }

        public int remove(Node<Integer> balloon) {
            if (balloon.prev.prev == balloon) {
                System.out.println(balloon.num_order + " ");
                System.out.println(balloon.prev.num_order + " ");
                return 0;
            }

            Node<Integer> temp = balloon.prev;
            temp.next = balloon.next;
            temp = temp.next;
            temp.prev = balloon.prev;
            System.out.println(balloon.num_order + " ");

            return balloon.data;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        Node<Integer>head=new Node<>(Integer.parseInt(st.nextToken()),1);

        for(int i=1;i<N;i++){
            head.add(Integer.parseInt(st.nextToken()),i+1);
        }

        Node<Integer> flag=head;
        while(flag.next!=null){
            flag=flag.next;
        }
        flag.next=head;
        head.prev=flag;
        flag=flag.next;

        if(N==1){
            System.out.println(1);
            return;
        }

        for(int i=1;i<N;i++){
            int move = flag.remove(flag);

            if(move>0){
                while (move-->0){
                    flag=flag.next;
                }
            }
            else{
                while (move++<0){
                    flag=flag.prev;
                }
            }
        }
    }
}
