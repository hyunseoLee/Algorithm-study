import java.util.*;


public class 정수제곱근판별_220519 {

    public static long solution(long n) {
        long answer = 0;
        if(Math.pow((int)Math.sqrt(n), 2) ==n ) answer= (long) Math.pow( Math.sqrt(n)+1, 2); 
        else answer = -1; 
                                            
        return answer;
    }

    public static void main(String[] args){
        int n= 145;

        System.out.println("Math.sqrt 제곱근 구하기 : " + Math.sqrt(145));
        System.out.println("floor함수 사용: " + Math.floor(Math.sqrt(145)));
        System.out.println("(int) 사용 :" + (int)(Math.sqrt(145)));

        //System.out.println(Math.pow(Math.sqrt(145), 2));
        
        //System.out.println(solution(145));

    }

    
}
