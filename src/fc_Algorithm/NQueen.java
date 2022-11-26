package fc_Algorithm;

import java.util.ArrayList;

public class NQueen {

    //조건에 맞는지를 검사하는 메서드
    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol){ // 현재까지의 퀸 리스트,
        Integer currentRow = candidate.size(); //
        for(int index = 0; index < currentRow; index++){ // 순회
            if((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index)-currentCol)==currentRow-index)){ // 해당 행에 대한 퀸의 위치와 동일한지 보기,
                return false;
            }
        }
        return true;
    }

    //지금 체크해야하는 행, 퀸이있는 리스트
    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate){
        if(currentRow == N){ // 전체행을 다 돌았다. 그리고 적절한 위치를 찾았다.
            System.out.println(currentCandidate); // 그때까지의 적절한 퀸의 위치를 담고 있다.
            return ;
        }
        for(int index = 0; index<N;index++){// 재귀호출할 때 처리하는 코드
            if(this.isAvailable(currentCandidate, index)==true){ // 조건을 체크한다. 기존 퀸의 위치와 어느 위치를 체크할지, 그리고 그 위치가 적합하다.
                currentCandidate.add(index);//넣는다.
                this.dfsFunc(N, currentRow + 1, currentCandidate); //
                currentCandidate.remove(currentCandidate.size()-1); //
            }
        }
    }

    public static void main(String[] args) {
        NQueen nObject = new NQueen();
        nObject.dfsFunc(4, 0, new ArrayList<>());
    }

}
