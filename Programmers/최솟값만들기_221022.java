import java.util.*;

public class fineMin {

    static int min = Integer.MAX_VALUE; 
    boolean[] checkA;
    boolean[] checkB; 
    public int solution(int []A, int []B)
    {
        int answer = 0;
        checkA = new boolean[A.length];
        checkB = new boolean[B.length]; 
        Arrays.sort(A);
        Arrays.sort(B);

        //findMin(A,B,0,0);

        for(int i=0;i<A.length;i++){
           answer+= A[i] * B[(B.length-1)-i]; 
   
        }
        System.out.println(answer);
        return answer; 
        //return min;
    }

    public void findMin(int[] A, int[] B ,int sum, int cnt){
        if(cnt== A.length){
            //TEST 
            //System.out.println(sum);
            min= Math.min(sum,min); 
        }

        for(int i=0;i<A.length;i++){
            if(checkA[i]==false){
                checkA[i]=true; 
                for(int j=0;j<B.length;j++){
                    if(checkB[j]== false){  
                        checkB[j]=true;
                        // sum+= A[i]*B[j]; 
                        findMin(A,B,sum+(A[i]*B[j]),cnt+1) ; 
                        checkB[j]=false; 
                    }
                }
                checkA[i]=false; 
            }
        }

    }
    public static void  main(String[] args){

        fineMin sol = new fineMin();
        int[] A = {1,4,2};
        int[] B= {5,4,4}; 
        sol.solution(A, B);


    }   
}
