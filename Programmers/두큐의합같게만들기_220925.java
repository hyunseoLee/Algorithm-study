import java.util.*;

public class QueueStudy {
    
  
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1= new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>(); 

        long total= 0;
        long v1= 0;
        long v2= 0; 

        for(int i=0;i<queue1.length;i++){
            v1+= queue1[i];
            q1.add(queue1[i]);
        }
        for(int i=0;i<queue2.length;i++){
            v2 += queue2[i];
            q2.add(queue2[i]);
        }

        total= v1+ v2;
        if(total%2!=0) return -1; 

        total/=2; 
        int i=0;

        while(true){
            if(i> (queue1.length + queue2.length)*2) return -1; 

            if(v1> total){

                v1-= q1.peek();
                v2+= q1.peek();
                q2.add(q1.poll()); 
            }
            else if(v2>total){
                v2-= q2.peek();
                v1+= q2.peek();
                q1.add(q2.poll()); 
            }
            else break; // v1== v2 
            answer++;
            i++; 
             
        }
        
        return answer;
    }


    public static void main(String[] args){
        QueueStudy sol = new QueueStudy();
        int[] queue1= {3,2,7,2};
        int[] queue2= {4,6,5,1}; 

        int ans= sol.solution(queue1,queue2);

    }
}
