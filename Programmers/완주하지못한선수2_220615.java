import java.util.*;

public class 완주하지못한선수2_220615 {

    public String solution(String[] participant, String[] completion) {
        String answer="";

        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            // map.getOrDefault : p 값이 없으면 0, p 값이 있으면 +1 .
            map.put(p , map.getOrDefault(p,0)+1); 
           
        }

        for (String c : completion){
            map.put( c, map.get(c)-1); 
        }

        for(String p:participant){
            if(map.get(p).equals(1)){
                answer= p; 
            }
        }

        return answer; 
    }
    public static void main(String[] args){

        String[] participant= {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        
        완주하지못한선수2_220615 sol = new 완주하지못한선수2_220615();
        System.out.println(sol.solution(participant, completion));

    }
    
}
