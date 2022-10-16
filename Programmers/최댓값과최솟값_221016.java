import java.util.*;

public class 최댓값과최솟값_221016 {
    
    static int min_val = Integer.MAX_VALUE;
    static int max_val = Integer.MIN_VALUE; 

    public String solution(String s) {
        String answer = "";
        String[] str= new String[s.length()]; 
        str = s.split(" ");

        
        for(int i=0;i<str.length;i++){
            min_val = Math.min(min_val,Integer.parseInt(str[i]));
            max_val = Math.max(max_val, Integer.parseInt(str[i]));
        }

        answer = min_val+" "+ max_val ; 
        System.out.println(answer);
        
        return answer;
    }
    public static void main(String[] args){
        최댓값과최솟값_221016 sol  = new 최댓값과최솟값_221016();
        String s = "-1 -1"; 
        sol.solution(s);
    }
}
