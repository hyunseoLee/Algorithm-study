public class leetcode_array2 {
    
    public int findNumbers(int[] nums) {
        int ans =0;
        for(int i=0;i<nums.length;i++){
            String str= Integer.toString(nums[i]);
            //System.out.println(str + " : " + str.length());
            if(str.length()%2==0) ans++; 
        }
        return ans; 
        
    }

    public static void main(String[] args){

        leetcode_array2 sol= new leetcode_array2();
        int[] nums = {12,345,2,6,7896};
        sol.findNumbers(nums);

    }
}
