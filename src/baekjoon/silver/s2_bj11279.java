package baekjoon.silver;
/*백준  : 최대 힙 */
/*1. insert메서드
 * 2. pop 메서드 구현*/

/*자연수 -> insert()
 * 0 -> pop()
 * head ==null, 0 -> 0 출력*/

/*접근방법
 * 1.최대 힙 클래스를 구현한다. - insert메소드, pop메소드
 * 2. elseif 문으로 3가지 경우로 나눈다.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Heap {
    // 보통 내부 attribute 는 private 으로 선언하기도 하지만, 외부에서도 간단히 데이터를 확인할 수 있도록 public 으로 선언

    /*Heap은 배열을 사용해서 만든 자료구조이다.*/
    public ArrayList<Integer> heapArray = null;

    public Heap(Integer data) {
        this.heapArray = new ArrayList<Integer>();
        // 배열은 인덱스가 0번부터 시작하지만, 힙 구현의 편의를 위해, root 노드 인덱스 번호를 1로 지정하기 위해,
        // 0번 인덱스에는 강제로 null 을 넣어주기로 함
        this.heapArray.add(null);
        this.heapArray.add(data);
    }

    /*method - 노드를 insert할 때 '입력된 노드'와 '부모 노드'를 비교해서 swap을 해야하는지 판단한다.*/
    public boolean move_up(Integer inserted_idx) {
        if (inserted_idx <= 1) {//노드가 없거나 1개라면 (배열의 첫번째는 null이므로)
            return false;//swap 실패
        }
        Integer parent_idx = inserted_idx / 2; //부모 노드의 인덱스를 구하고
        if (this.heapArray.get(inserted_idx) > this.heapArray.get(parent_idx)) {//삽입된 노드와 부모 노드의 값을 비교한다.
            return true;//swap 해야함
        } else {
            return false;//swap 불가능
        }
    }

    /*method - 노드를 넣고 넣은 노드의 적절한 위치를 찾아 배열해준다.*/
    public boolean insert(Integer data) {
        Integer inserted_idx, parent_idx;//부모 노드와 비교를 해야해서 두개의 index 변수가 필요하다.
        if (this.heapArray == null) {//배열이 null이면 만들어준다.
            this.heapArray = new ArrayList<Integer>();
            // 배열은 인덱스가 0번부터 시작하지만, 힙 구현의 편의를 위해, root 노드 인덱스 번호를 1로 지정하기 위해,
            // 0번 인덱스에는 강제로 null 을 넣어주기로 함
            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;//삽입 완료
        }
        //그렇지 않다면
        this.heapArray.add(data);
        inserted_idx = this.heapArray.size() - 1;

        while (this.move_up(inserted_idx)) {//swap 실행
            parent_idx = inserted_idx / 2;
            Collections.swap(heapArray, inserted_idx, parent_idx);
            inserted_idx = parent_idx;
        }
        return true;//삽입 완료
    }

    /*method - 노드를 delete할 때 '끌어 올려와진 노드'와 'child 노드'를 비교해서 swap을 해야하는지 판단한다.*/
    public boolean move_down(Integer popped_idx) {
        Integer left_child_popped_idx, right_child_popped_idx;

        left_child_popped_idx = popped_idx * 2;
        right_child_popped_idx = popped_idx * 2 + 1;

        // CASE1: 왼쪽 자식 노드도 없을 때(즉, 자식 노드 둘다 없을 때)(완전 이진 트리이므로 왼쪽 노드 없이 오른쪽이 있을 수 없다.)
        if (left_child_popped_idx >= this.heapArray.size()) {//사이즈를 넘어갈 때
            return false;//swap 불가능
            // CASE2: 오른쪽 자식 노드만 없을 때(즉, 왼쪽 노드 있을 때)
        } else if (right_child_popped_idx >= this.heapArray.size()) {
            if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                return true;
            } else {
                return false;
            }
            // CASE3: 왼쪽, 오른쪽 자식 노드 모두 있을 때
        } else {
            if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public Integer pop() {
        Integer returned_data, popped_idx, left_child_popped_idx, right_child_popped_idx;

        if (this.heapArray.size() <= 1) {
            return null;
        }

        returned_data = this.heapArray.get(1);
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
        this.heapArray.remove(this.heapArray.size() - 1);
        popped_idx = 1;//이제 시작!!

        while (this.move_down(popped_idx)) {
            left_child_popped_idx = popped_idx * 2;
            right_child_popped_idx = popped_idx * 2 + 1;

            /*왼쪽 노드밖에 없다면*/
            if (right_child_popped_idx >= this.heapArray.size()) {
                if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                    Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                    popped_idx = left_child_popped_idx;
                }
                //왼쪽이 더 큰게 아니면 안바꿈 - 코드 굳이 안적음

            } else {/*노드가 두개가 있다면*/
                if (this.heapArray.get(left_child_popped_idx) > this.heapArray.get(right_child_popped_idx)) {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(left_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, left_child_popped_idx);
                        popped_idx = left_child_popped_idx;
                    }
                } else {
                    if (this.heapArray.get(popped_idx) < this.heapArray.get(right_child_popped_idx)) {
                        Collections.swap(this.heapArray, popped_idx, right_child_popped_idx);
                        popped_idx = right_child_popped_idx;
                    }
                }
            }
        }
        return returned_data;
    }
}

public class s2_bj11279 {
    public static void main(String[] args) throws IOException {

        //BufferedReader를 사용한다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());

        //일단 힙을 만들자
        Heap myHeap = new Heap(1);
        //그리고 값을 빼서 null로 만들자

//        System.out.println(myHeap.heapArray); //null, 1 출력됨

        myHeap.pop();

        //        System.out.println(myHeap.heapArray); // null 출력됨

        //현재 힙 배열에는 0인덱스에 null만 들어가있는 상태임.

        //count만큼 반복한다.
        for (int i = 0; i < count; i++) {
            //입력값이 0이 아니라면,
            int data = Integer.parseInt(bf.readLine());

            //입력값이 자연수라면 insert 해준다.
            if (data != 0) {
                myHeap.insert(data);
            }
            //입력값이 0이라면, 2가지 경우가 있다.
            else {

                //1. 힙의 배열이 비었으면, 즉 배열의 사이즈가 1이라면 - 0출력
                if (myHeap.heapArray.size()==1) {
                    System.out.println(0);
                }

                //2. 힙 배열이 차있다면 - pop을 한다.
                else {
                    System.out.println(myHeap.pop());
                }
            }

        }
    }
}

