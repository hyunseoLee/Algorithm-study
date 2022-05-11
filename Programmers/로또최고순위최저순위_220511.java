import java.io.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int equal_num =0;
        int zero_num =0;
        int[] prize={6,6,5,4,3,2,1};  

        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0) zero_num++; 
            for(int j=0;j<win_nums.length;j++){
                if(lottos[i]== win_nums[j]) equal_num++;
            }
        }
        // 최고순위  : zero_num + equal_num 
        // 최저순위 : equl_num

        answer[0]= prize[zero_num+equal_num];
        answer[1]= prize[equal_num]; 

        return answer;
    }
}

public class Programmers_220511 {
 
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder(); 

        int[] lottos={44, 1, 0, 0, 31, 25};
        int[] win_nums={31, 10, 45, 1, 6, 19};

        Solution sol = new Solution();
        int[] ans = sol.solution(lottos, win_nums); 

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }
}

