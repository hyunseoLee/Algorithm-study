public class 멀리뛰기_221203 {

    public long solution(int n) {
        long answer = 0;
        int[] dp= new int [n+1];

        dp[0]=0;
        dp[1]= 1;
        if(n>=2){
            dp[2]= 2;
        }

        for(int i=3;i<=n;i++){
            dp[i]= (dp[i-1] + dp[i-2])%1234567; 
        }
        
        answer= dp[n]%1234567; 
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args){
        멀리뛰기_221203 sol = new 멀리뛰기_221203();
        sol.solution(1); 


    }
    
}
