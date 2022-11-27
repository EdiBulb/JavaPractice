package fc_Algorithm;

import java.util.ArrayList;

//N*N의 크기에서 N개의 퀸이 존재할 수 있는 방법에 대한 클래스
public class NQueen {

    //조건에 맞는지를 검사하는 메서드
    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol){ // 현재까지의 퀸 리스트, 해당 인덱스 번호
        Integer currentRow = candidate.size(); //
        for(int index = 0; index < currentRow; index++){ // 순회
            //promising 기법
            if((candidate.get(index) == currentCol) || (Math.abs(candidate.get(index)-currentCol)==currentRow-index)){ // 수평 조건, 대각선 조건
                return false; // 조건에 안 맞음
            }
        }
        return true; // 해당 행에 퀸 위치 가능
    }

    //지금 체크해야하는 행, 퀸이있는 리스트
    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate){// N:크기, currentRow: 지금 체크해야하는 행, 퀸이 있는 리스트
        if(currentRow == N){ // currentRow == N 은 전체 행(N-1까지)을 돌았다는 의미이고 적절한 퀸의 위치를 찾았다는 의미이다.
            System.out.println(currentCandidate); // 출력하기
            return ;
        }
        //순회하기
        for(int index = 0; index<N;index++){// 해당 열의 모든 위치를 체크하기
            if(this.isAvailable(currentCandidate, index)==true){ // 기존의 퀸의 위치와 index의 위치의 조건을 확인한다. true라면 위치가 적합하다는 뜻이다.
                currentCandidate.add(index);//넣는다.
                //그 다음줄을 체크한다.
                this.dfsFunc(N, currentRow + 1, currentCandidate);
                //prunning 기법 - 가지치기
                currentCandidate.remove(currentCandidate.size()-1); //이용가능하지 않은 퀸을 삭제하기
            }
        }
    }

    public static void main(String[] args) {
        NQueen nObject = new NQueen();
        nObject.dfsFunc(4, 0, new ArrayList<>());//N: 4, 0부터 시작, 처음 candidate는 아무것도 없음
    }
}
