import java.io.IOException;

public class 소수만들기2_220511 {
    
    public int solution(int[] nums){

        int ans=0;

        //1. 3개의 랜덤숫자
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1; j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(isPrime(nums[i]+nums[j]+nums[k])){
                        ans++; 
                    }

                }
            }
        }
        return ans;
    }

    public static boolean isPrime(int num){

        boolean check= true;
        for(int i=2;i<num;i++){
            if(num%i==0) {
                check= false;
                break;
            }
        }
        return check; 
    }
    public static void main(String[] args) throws IOException{
        
    }
}
