package supplement;

import java.util.LinkedList;

//HashTable구현하기
class HashTable {
    //노드에는 검색할 key가 있고 검색 결과로 보여줄 value가 있다.
    class Node {
        String key;
        String value;

        //노드 생성할 때 key와 value 받아서 값 할당한다.
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        //value를 가져오는 함수
        String value() {
            return value;
        }

        //value를 저장하는 함수
        void value(String value) {
            this.value = value;
        }
    }

    //데이터를 저장할 링크드리스트를 배열로 선언한다.
    //이게 무슨 말이지? 링크드리스트는 배열이랑 다른 건데 배열로 선언이 된다고?
    LinkedList<Node>[] data;

    //해시테이블을 선언하는 순간, 해시테이블의 크기를 정해서 배열방을 미리 만든다.
    //해시테이블 생성자
    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    //해시함수
    int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray()) {
            hashcode += c;
        }
        return hashcode;
    }

    //해시코드를 받아서 배열방에 index로 정의해주는 함수
    int converToIndex(int hashcode) {
        return hashcode % data.length;
    }

    //인덱스로 배열방을 찾은 이후에, 배열 방에 노드가 여러개 존재하는 경우에, 키를 가지고 해당 노드를 찾아오는 함수 정의
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) return null; // 배열방이 null이면 null을 반환한다.
        for (Node node : list) {//null이 아니면, 리스트를 돈다.
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    //데이터를 받아서 저장하는 함수 put
    void put(String key, String value) {
        int hashcode = getHashCode(key);//key를 가지고 해시코드를 받아온다.
        int index = converToIndex(hashcode);//해시코드로 받아올 배열방 번호를 받아온다.
        LinkedList<Node> list = data[index];//배열방 번호를 이용해서 기존의 배열방에 있던 데이터를 가져온다.
        if (list == null) {//배열방이 null이면 링크드리스트를 생성한다.
            list = new LinkedList<>();
            data[index] = list;//해당 리스트를 배열방에 넣어준다..
        }
        Node node = searchKey(list, key);//해당 키로 데이터를 가지고 있는지 노드를 받아온다.
        if (node == null) {//노드가 null이면 데이터가 없다는 뜻이니까, 받아온 정보를 가지고 노드 객체를 생성해서 리스트에 추가한다.
            list.addLast(new Node(key, value));
        } else {
            node.value(value);
        }
    }

    //키를 가지고 데이터를 가져오는 함수
    String get(String key) {
        int hashcode = getHashCode(key);//키를 가지고 해시 코드를 가져온다.

        int index = converToIndex(hashcode);//받아온 해시코드로 인덱스를 가져온다.
        LinkedList<Node> list = data[index];//인덱스에서 링크드리스트를 가져온다.
        Node node = searchKey(list, key);//링크드리스트 안에 해당 키를 가지는 노드를 검색해온다.
        return node == null ? "Not found" : node.value();
    }
}

public class Test1 {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);//해쉬테이블은 3개로 고정된 배열방을 생성한다.


        h.put("sung", "she is pretty");
        h.put("jin", "she is a model");
        h.put("hee", "she is an angel");
        h.put("min", "she is cute");

        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
    }

}
