import java.util.*;

public class 완주하지못한선수_220613 {
    
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();

    
        for(String str: participant){
            map.put(str, map.getOrDefault(str, 0)+1); 
        }

        /*
        // for문에 Str 바로 대입 ,  값이 없을때 있을때 getOrDefault사용하기 . 
        for(int i=0;i<participant.length;i++){
            map.put(participant[i], //map.get(participant[i])+1);
                    map.getOrDefault(participant[i], 0)+1 );
        }
        */ 

        for(String str: completion){
            // 존재하면 -1 
            map.put(str, map.get(str)-1);
        }

        for(String str: participant){
            if(map.get(str).equals(1)){
                answer= str; 
            }
        }
        /*

        Set<String> keys= map.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){

            String key= iter.next(); 
            if(map.get(key).equals(1)){
                answer= key;

            }


        }
        */ 
        

        return answer;
    }

    public static void main(String[] args){


        String[] participant= {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"}; 

        완주하지못한선수_220613 sol= new 완주하지못한선수_220613();
        System.out.println(sol.solution(participant, completion));
        
    }
}
