public class leetcode_array1 {
    
    public int findMaxConsecutiveOnes(int[] nums) {

        int ans=0;
        
        if(nums.length==1 && nums[0]==1){
            ans = 1; 
        }
        
        for(int i=0;i<nums.length;i++){
            int cnt=0 ;
            if(nums[i]==1){
                cnt =1 ; 
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]==nums[j] && nums[j]==1) cnt++;
                    else{
                        ans= Math.max(ans, cnt);
                        break; 
                    }
                    
                }
                ans= Math.max(ans, cnt);
            }
        }
        return ans ;

    }

    public static void main(String[] args){

        leetcode_array1 sol= new leetcode_array1();
        int[] nums = {0,1};
        System.out.println(sol.findMaxConsecutiveOnes(nums));


    }
}
