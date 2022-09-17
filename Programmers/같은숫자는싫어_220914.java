import java.util.*;

public class StackStudy {
    

    public int[] solution(int []arr) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            if( i!=0 && list.get(list.size()-1).equals(arr[i])) continue;
            list.add(arr[i]); //System.out.println(arr[i]);
        }
        answer= new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i); 
            //System.out.println(answer[i]);
        }

        return answer;
    }
    public static void main(String[] args){

        StackStudy sol = new StackStudy();
        int[] arr= {1,1,3,0,1,1}; 
        sol.solution(arr);
        
    }
}
