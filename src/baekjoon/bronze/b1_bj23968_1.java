package baekjoon.bronze;
/*버블 정렬 실험해보기*/

public class b1_bj23968_1 {

    static int count =0; // 버블 정렬에서 교환횟수
    public static void boubleSort(int[]arr,int k){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    count++; // 이 count를 K와 비교해야하는데...
                    //count와 k를 비교해주겠음
                    if(count ==k){
                        //두개의 수를 출력
                        System.out.format("%d %d",arr[j],arr[j+1]);
                    }else System.out.println(-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5,4,3,2,1};
        int k=11;
        boubleSort(arr,k);

        System.out.println();
        System.out.println(count);

    }
}
