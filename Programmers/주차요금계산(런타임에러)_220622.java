import java.util.*;

public class dev {

    Map<String, Integer> map= new HashMap<>(); // 차량번호, 누적시간 (IN인 경우만, OUT이면 제거하기)
    Map<String,Integer> result= new HashMap<>(); // 누적시간의 결과값 (차번호, 누적시간)
    Map<String,Integer> f_result= new HashMap<>(); // 요금의 결과값 (차번호, 요금) 

    public int[] solution(int[] fees, String[] records) {
        
        calTime(records);

        int[] answer = new int[result.size()]; 

        // map의 key를 오름차순으로 정렬.

        //fees[0] = 기본 시간(분)
        //fees[1] = 기본 요금(원)
        //fees[2] = 단위 시간(분)
        //fees[3] = 단위 요금(원) 

        
        Iterator<String> iter= result.keySet().iterator();
        // while말고 다른것 써보기 
        while(iter.hasNext()){
        //for(int i=0;i< result.keySet().size();i++){}
            String key = iter.next(); 
            int T = result.get(key);
            if(T> fees[0]){
                int F = fees[1];

                T-= fees[0];

                double tmpT = (double) T/fees[2];      
                tmpT = Math.ceil(tmpT);  // ceil함수 사용할때도 double형을 넣어야만 제대로 동작됨 
                F+= tmpT * fees[3]; 
     
                f_result.put(key, F); 
                
            }
            else{
                f_result.put(key, fees[1]);
            }
        }


        /*
        Iterator<String> f_iter= f_result.keySet().iterator();
        while(f_iter.hasNext()){
            String key= f_iter.next();

            System.out.println( key + " : " + f_result.get(key)); 
        
        }
        */
        

        List<String> list = new ArrayList<>();
        list.addAll(f_result.keySet());
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            answer[i]= f_result.get(list.get(i)); 
            
        }

        /*
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
        */

        
        return answer;
    }


    public void calTime(String[] records){

        for(int i=0;i<records.length;i++){
            String[] list= records[i].split(" "); 
            int hour= Integer.parseInt(list[0].substring(0, 2)); // 시간
            hour = hour*60; 
            int min= Integer.parseInt(list[0].substring(3,5)); // 분
            int sumMin= hour+min; 

            
            // 입차 (IN) 인 경우
            if(list[2].equals("IN")){
                //1. 만약 아직 입차 내역이 없는 차라면,
                if(map.containsKey(list[1])== false ){
                    map.put(list[1], sumMin); //현재 입차 시간 입력. 
                }

                //2. 만약 입차 내역이 있는데 또 IN이라면? 
                else{
                    //2-1. 이전 출차 내역이 없는 경우
                    // 이전 출차시간을 23:59로 설정하고 누적시간을 계산해서 입력한다. 
                    int outMin= (23*60) + 59; 
                    int nowMin= map.get(list[1]); 
                    // map2.put(list[1], outMin-nowMin);

                    result.put(list[1], outMin-nowMin); // 결과에 담고
                    //map.remove(list[1]); //없애버리기. 
                    map.put(list[1], sumMin); // 다시 put할거면 remove 할 필요 없을듯.                
                }   
            }       
            // 출차 (OUT) 인 경우 
            else{
                //이전에 입차 내역은 무조건 있겠지.
                int nowT = map.get(list[1]);
                int resultT= sumMin- nowT; 
                
                if(result.containsKey(list[1])){
                    int tmpT= result.get(list[1]);
                    result.put(list[1], tmpT + resultT); 
                }
                else{
                    result.put(list[1], resultT);

                }

                map.remove(list[1]);
            }
        }
        //만약 다 끝났음에도 출차되지않은 경우, 출차시간을 23:59로 설정함
  
        Iterator<String> iter= map.keySet().iterator();

        while(iter.hasNext()){
            String key = iter.next();
            
            int nowT= map.get(key);
            int outT= (23*60) + 59; 

            if(result.containsKey(key)){
                result.put(key, result.get(key) + (outT-nowT));
            }
            else{
                result.put(key, (outT-nowT)); 
            }
            map.remove(key); 

        }

    }

    public static void main(String[] args){

        int[] fees= {120, 0, 60, 591}; 
        String[] records={
            "16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"
            /*
            "05:34 5961 IN", 
            "06:00 0000 IN", 
            "06:34 0000 OUT", 
            "07:59 5961 OUT", 
            "07:59 0148 IN", 
            "18:59 0000 IN", 
            "19:09 0148 OUT",
            "22:59 5961 IN", 
            "23:00 5961 OUT"
            */
           
        };

        dev sol = new dev();
        sol.solution(fees, records);

    }
    
}
