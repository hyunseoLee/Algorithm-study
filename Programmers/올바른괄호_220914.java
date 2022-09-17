import java.util.*;

public class StackStudy2 {
    

    boolean solution(String str) {
        boolean answer = true;
        Stack<Character> s= new Stack<>();

        for(int i=0;i<str.length();i++){
            char c= str.charAt(i);
            if(i!=0 && c==')' ){
                s.pop();
                
            }
            else{
                s.push(c); 
            }
        }

        if(s.empty()) answer= true;
        else answer= false; 


        return answer;
    }

    public static void main(String[] args){

        StackStudy2 sol = new StackStudy2();
        //String str= "()()"; 
        String str= ")()()";
        sol.solution(str);
    }
}
