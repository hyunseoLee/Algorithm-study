import java.util.*;

public class Coupang2 {
    public long[] solution(long n){

        List<Integer> list= new ArrayList<>(); 

        //시간초과 
       //  for(int i=2;i<n/2;i++){
        for(int i=2;i<Math.sqrt(n);i++){
          // 1. i가 소수라면 
           if(isPrime(i)){
             if(((n%i)==0 ) && isPrime(n/i)){
                if(!list.contains(i)) list.add(i);
                if(!list.contains((int) (n/i))) list.add((int) (n/i)); 

             }
           }
        }

        Collections.sort(list); // 오름차순 정렬
        long[] answer={}; 
        if(list.size()==0){
            answer= new long[2];
            answer[0]=-1; answer[1]= -1; 

        }
        else{
            answer= new long[list.size()]; 
            for(int i=0;i<list.size();i++){
                answer[i]= list.get(i);
            }
            
        }

        for(int i=0;i<answer.length;i++){
            System.out.println( answer[i] + " "); 
        }
        return answer;
    }
    
    /* 소수 여부 판단하는 함수 */
    public boolean isPrime(long num){
        if(num==0 || num==1 ) return false;

        for(int i=2;i<= Math.sqrt(num);i++){ // 제곱근까지만 확인해보면 됨 
            if(num%i==0) return false; 
        }

        return true;
    }

    public static void main(String[] args){
        Coupang2 sol = new Coupang2();
        sol.solution(65);
    }
}
