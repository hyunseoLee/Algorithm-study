public class NQueen_221202 {
    
    static int[] col;  // col[idx] = val : idx행에는 val 열에 퀸이 있다. 
    static int N; 
    static int cnt=0; 

    public int solution(int n) {
        int answer = 0;
        N=n; 
        col = new int[n];

        for(int i=0;i<N;i++){
            col[0]=i; 
            backtracking(N,1); 
        }
        return answer;
    }

    public void backtracking(int N, int row ){
        if( row ==N ){
            cnt++; 
            return; 
        }

        for(int i=0;i<N;i++){
            col[row]= i;
            if(isPossible(row)){
                backtracking(N, row+1);
            }
            else{
                col[row]=0;
            }
        }
        col[row]=0; 

    }

    private boolean isPossible(int row){

        for(int i = 0 ; i < row ; i++ ){
            if(col[i] == col[row]) return false;
            if(Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        
        return true;
    }

    public static void main(String[] args){
        NQueen_221202 sol = new NQueen_221202();
        sol.solution(3); 
    }
}
