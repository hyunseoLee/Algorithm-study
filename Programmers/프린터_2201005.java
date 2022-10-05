import java.util.*;

public class StackStudy3 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        //내림차순 큐 
        Queue<Integer> q= new PriorityQueue<>(Collections.reverseOrder()); 
        for(int num: priorities){
            q.add(num); 
        }

        while(!q.isEmpty()){

            System.out.println(q.peek());
            q.poll();             
        }



        return answer;
    }


    public static void main(String[] args){
        StackStudy3 sol = new StackStudy3();
        int[] priorities = {2, 1, 3, 2};
        sol.solution(priorities, 2); 

    }
}
