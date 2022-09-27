import java.util.*;

public class QueueStudy2 {

    public int[] solution(int[] progresses, int[] speeds) {
       
        Queue<Integer> q= new LinkedList<>();

        for(int i=0;i<progresses.length;i++){
            int sum=progresses[i];
            int work= speeds[i];
            int day=0; 
            while(sum<100){
                sum+=work;
                day++;
            }
            q.add(day);
            //System.out.println(day);
        }

        List<Integer> list = new ArrayList<>(); 

        while(!q.isEmpty()){
            int now= q.poll();
            int num=1;
            while(!q.isEmpty() && q.peek()<= now){
                q.poll();
                num++;
            }   
            //System.out.println(num);
            list.add(num); 
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i);
        }
   
        return answer;
    }

    
    public static void main(String[] args){
        QueueStudy2 sol= new QueueStudy2();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds ={1, 1, 1, 1, 1, 1};
        int[] answer= sol.solution(progresses, speeds);

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }


    }
}
