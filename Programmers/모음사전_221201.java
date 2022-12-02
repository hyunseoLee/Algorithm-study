import java.util.*;

public class aeiou {

    static char[] Alpha= {'A','E','I','O','U'};  
    ArrayList<String> wordlist = new ArrayList<>(); 
    
    public int solution(String word) {
        int answer = 0;
       // answer= AEIOU(word,0,""); 
        search("",0 );
        answer= wordlist.indexOf(word)+1;
        System.out.println(answer);
        return answer;
    }

    public void search(String tmp, int now){
        //종료조건 
        if(now >= 5){
            return; 
        }
        
        for(int i = 0 ; i < 5; i++){
        
            wordlist.add(tmp+Alpha[i]);
            search(tmp+Alpha[i] , now+1);
        }
        

        
    }



    public static void main(String[] args){
        aeiou sol = new aeiou();
        sol.solution("AA");

    }
}
