public class DFSStudy3 {
    
    static int answer=0;
    public int solution(int[] numbers, int target) {
        //solve(numbers,0,0,target);
        // int answer= -1; 
        dfs(numbers,0,0,target);
        return answer;
    }

    public void dfs(int[] numbers,int idx,int sum,int target){
        if(idx==numbers.length){
            if(sum==target) answer++; 
            return; 
        }
        dfs(numbers,idx+1,sum+numbers[idx],target);
        dfs(numbers,idx+1,sum-numbers[idx],target);

    }
    
    public static void main(String[] args){
        DFSStudy3 sol = new DFSStudy3();
        int[] numbers={1,1,1,1,1};
        int target=3;
        sol.solution(numbers, target);
        

    }
}
