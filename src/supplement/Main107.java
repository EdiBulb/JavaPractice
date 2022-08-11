package supplement;

import java.io.*;

class Mystack{
    private int top;
    private int stackArr[];

    public Mystack(int size){
        this.top=-1;
        this.stackArr=new int[size];
    }

    public void push(int x){
        this.stackArr[++top]=x;
    }
    public int pop(){
        if(top==-1){
            return -1;
        }
        else{
            return this.stackArr[top--];
        }
    }
    public int size(){
        return this.top+1;
    }
    public int empty(){
        if(top==-1){
            return 1;
        }
        else{
            return 0;
        }
    }
    public int top(){
        if(top==-1){
            return -1;
        }
        else{
            return this.stackArr[top];
        }
    }
}
public class Main107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());

        Mystack mystack = new Mystack(n);

        for(int i=0;i<n;i++){
            String cons=br.readLine();


        }

    }
}
