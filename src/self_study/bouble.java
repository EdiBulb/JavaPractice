package self_study;

import java.util.ArrayList;
import java.util.Collections;

class Sort{
    //배열을 매개변수로 받을 것이다.
    public static void boubleSort(int[] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
/*위에는 배열을 이용한 방법, 아래는 리스트를 이용한 방법*/
class BubbleSort{
    public static ArrayList<Integer> sort(ArrayList<Integer>dataList){
        for(int index = 0;index<dataList.size()-1;index++){
            boolean swap = false;

            for(int index2 = 0;index2<dataList.size()-1-index;index2++){
                if(dataList.get(index2)>dataList.get(index2+1)){
                    Collections.swap(dataList, index2,index2+1);
                    swap=true;
                }
            }
            if(swap==false){
                break;
            }
        }
        return dataList;
    }
}



public class bouble {
    /*버블정렬 메소드를 만들어보자*/

    public static void main(String[] args) {

        int[] arr = new int[]{3,6,41,2,4,1,5,754};
        Sort.boubleSort(arr);
        for(int i: arr){
            System.out.println(i+" ");
        }

        ArrayList<Integer> myArray = new ArrayList<>();
        myArray.add(1);
        myArray.add(40);
        myArray.add(20);
        myArray.add(4);
        myArray.add(2);
        myArray.add(99);

        System.out.println(BubbleSort.sort(myArray).toString());
    }
}
