package supplement;

import java.io.*;

class Stack{
    private int top;
    private int stackArr[];

    public Stack(int size){
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
public class Main105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Stack stack = new Stack(n);

        for(int i=0;i<n;i++){
            String cons=br.readLine();

            if(cons.contains("push")){
                String spt[]=cons.split(" ");
                stack.push(Integer.parseInt(spt[1]));
            }
            else if(cons.contains("pop")){
                bw.write(String.valueOf(stack.pop())+"\n");
            }
            else if (cons.contains("size")){
                bw.write(String.valueOf(stack.size())+"\n");
            }
            else if(cons.contains("empty")){
                bw.write(String.valueOf(stack.empty())+"\n");
            }
            else if(cons.contains("top")){
                bw.write(String.valueOf(stack.top())+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();


    }
}
