import java.util.*;

public class 괄호회전하기_221202 {

    public int solution(String str) {
        int answer = 0;

        int size =str.length(); 

        String tmp; 
        for(int i=0;i<size;i++){
            tmp=""; 
            for(int j=i;j<size;j++){
                tmp+= str.charAt(j); 
            }
            for(int j=0;j<i;j++){
                tmp+=str.charAt(j);
            }
            
            
            System.out.println(tmp +" : " + nowStrCheck(tmp));
            if(nowStrCheck(tmp)) answer++; 

        }
   


       System.out.println(answer); 
        
        return answer;
    }


    /* nowStrCheck : 올바른 괄호인지 확인하는 함수  */
    public boolean nowStrCheck(String str){

        Stack<Character> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            Character c= str.charAt(i);
            if(st.empty()){
                st.add(c);
            } 
            else{
                Character now= st.peek(); 
                switch(c){
                    case '}' :
                        if(now.equals('{')) {
                            st.pop();
                        }
                        else st.add(c); 
                        break; 
                    case ']' :
                        if(now.equals('[')) {
                            st.pop();
                        }
                        else st.add(c); 
                        break;
                    
                    case ')' : 
                        if(now.equals('(')) {
                            st.pop();
                        }
                        else st.add(c); 
                        break;
                    default : st.add(c); break; 
                }
            }

        }

        if(st.empty()) return true;
        else return false; 
    
    }
    public static void main(String[] args){
        Study_221202 sol = new Study_221202();
        //sol.solution("12345");
        sol.solution("}}}");

    }
    
}
