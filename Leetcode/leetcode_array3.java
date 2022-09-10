import java.util.Arrays;

public class leetcode_array3 {
    
    public int[] sortedSquares(int[] nums) {       

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) nums[i] = nums[i]*-1;
            nums[i]= nums[i]*nums[i];
            
        }
        Arrays.sort(nums);

        int ans[]= nums;

        return ans; 
    }

    public static void main(String[] args){
        leetcode_array3 sol = new leetcode_array3();
        int nums[]={-4,-1,0,3,10}; 
        sol.sortedSquares(nums);
    }
}
