package comento;


/*삽입정렬, 머지정렬, 퀵정렬을 구현하자*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//삽입 정렬
class InsertionSort{
    public ArrayList<Integer> sort(ArrayList<Integer>dataList){
        for(int index = 0;index<dataList.size()-1;index++){
            for(int index2 = index+1;index2>0;index2--){
                if(dataList.get(index2)<dataList.get(index2-1)){
                    Collections.swap(dataList, index2,index2-1);
                }else{
                    break;
                }
            }
        }
        return dataList;
    }
}

//머지 정렬
class MergeSort{
    public ArrayList<Integer> mergeFunc(ArrayList<Integer>leftList, ArrayList<Integer>rightList){
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;

        //Case 1 : left/right 둘 다 있을 때
        while (leftList.size()>leftPoint&&rightList.size()>rightPoint){
            if(leftList.get(leftPoint)>rightList.get(rightPoint)){
                mergedList.add(rightList.get(rightPoint));
                rightPoint+=1;
            }
            else{
                mergedList.add(leftList.get(leftPoint));
                leftPoint+=1;
            }
        }
        //Case 2 : right 데이터가 없을 때

        while (leftList.size()>leftPoint){
            mergedList.add(leftList.get(leftPoint));
            leftPoint+=1;
        }

        //Case 3 : left 데이터가 없을 때
        while (rightList.size()>rightPoint){
            mergedList.add(rightList.get(rightPoint));
            rightPoint+=1;
        }
        return mergedList;
    }
    public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer>dataList){
        if(dataList.size()<=1){
            return dataList;
        }
        int medium = dataList.size()/2;

        ArrayList<Integer> leftArr=new ArrayList<>();
        ArrayList<Integer> rightArr=new ArrayList<>();

        leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0,medium)));
        rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium,dataList.size())));

        return this.mergeFunc(leftArr,rightArr);
    }
}

//퀵 정렬

class QuickSort{
    public ArrayList<Integer> sort(ArrayList<Integer>dataList){
        if(dataList.size()<=1){
            return dataList;
        }
        int pivot = dataList.get(0);

        ArrayList<Integer> leftArr = new ArrayList<>();
        ArrayList<Integer> rightArr = new ArrayList<>();

        for(int index = 1;index<dataList.size();index++){
            if(dataList.get(index)>pivot){
                rightArr.add(dataList.get(index));
            }else{
                leftArr.add(dataList.get(index));
            }
        }
        ArrayList<Integer>mergeArr = new ArrayList<>();
        mergeArr.addAll(this.sort(leftArr));
        mergeArr.addAll(Arrays.asList(pivot));
        mergeArr.addAll(this.sort(rightArr));

        return mergeArr;
    }
}


public class Main1 {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort  quickSort = new QuickSort();

        //오름차순 정렬된 배열 arr1
        ArrayList arr1 = new ArrayList();
        for(int i=1;i<=10000000;i++){
            arr1.add(i);
        }

        //내림차순 정렬된 배열 arr2
        ArrayList arr2 = new ArrayList();
        for(int i=100000;i>=1;i--){
            arr2.add(i);
        }


        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        quickSort.sort(arr2);

        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}
