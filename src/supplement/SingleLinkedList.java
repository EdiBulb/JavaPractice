package supplement;


public class SingleLinkedList<T> {

    //head 노드에는 null이 있다.
    public Node<T>head=null;

    public class Node<T>{
        T data;
        //기본적으로 포인터는 비어있다.
        Node<T>next=null;

        public Node(T data){
            this.data=data;
        }
    }

    public void addNode(T data){
        //head가 비어있으면 노드를 생성해서 head에 넣어준다.
        if(head==null){
            head=new Node<>(data);

        }
        //head가 비어있지 않으면 head를
        else{
            Node<T>node=this.head;
            while (node.next!=null){
                node=node.next;
            }
            node.next=new Node<>(data);
        }
    }

}
