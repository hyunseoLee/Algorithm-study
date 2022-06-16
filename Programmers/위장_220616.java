import java.util.*;

public class 위장_220616 {

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){

            String key= clothes[i][1]; 
            System.out.println(key); 
            map.put(key, map.getOrDefault(key, 0)+1 );
   
        }
        Set<String> keySet = map.keySet();
        Iterator<String> iter= keySet.iterator();

        //Iterator<String> iter= map.keySet().iterator();

        while(iter.hasNext()){
            String key= iter.next();
            int size= map.get(key);

            answer*=  (size+1) ;
        }

        Iterator<Integer> it = map.values().iterator();
        while(it.hasNext()) {
            answer *= it.next().intValue()+1;
        }




       
        answer-=1;

        return answer;
    }
    public static void main(String[] args){

        위장_220616 sol = new 위장_220616();
        String[][] clothes2= {
            {"a1","A"}, {"a2","A"}, {"a3","A"},
            {"b1","B"}, {"b2","B"},
            {"c1","C"}, {"c2","C"}, {"c3","C"}
        };

        String[][] clothes={

            {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
        };
        
        sol.solution(clothes);





    }
    
}
