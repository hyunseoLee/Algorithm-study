import java.io.IOException;

public class 소수만들기1_220511 {

    static int answer=0; 
    
    public static int solution(int[] nums) {
        //int answer = 0;
        // STEP1. nums배열 중에서 3개만 선택하는 재귀함수 호출. 
        for(int i=0;i<nums.length;i++){
            int[] tmp= new int[4]; 
            tmp[0]= nums[i]; 
            recursion(i,0,nums.length,tmp,nums);
        }

        return answer;
    }

    public static void recursion(int index, int N, int size, int[] tmp,int[] nums){
        if(N==2){
            int sum=0;
            for(int i=0;i<3;i++){
                sum+= tmp[i]; 
            }
            if( checkNum(sum)) {
                answer++; 
            }
            return;
        }
        for(int i=index+1;i<size;i++){
            tmp[N+1]= nums[i]; 
            recursion(i,N+1, size,tmp,nums); 
        }
    }

    public static boolean checkNum(int num){

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

        int[] nums={1,2,7,6,4}; 
        int ans= solution(nums);
        System.out.println(ans);

    }
    
}
