import java.io.IOException;
import java.util.*;

public class 신고결과받기2_220518 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int answer[]= new int[id_list.length]; 

        HashMap<String,ArrayList<String>> map1= new HashMap<>();
        HashMap<String, Integer> map2= new HashMap<>();
        for(int i=0;i<id_list.length;i++){
            map1.put(id_list[i], new ArrayList<>()); 
            map2.put(id_list[i],0);
        }

        for(int i=0;i<report.length;i++){

            String str[]= report[i].split(" ");
            String user1= str[0];
            String bad_user= str[1];

            if(! map1.get(user1).contains(bad_user)){
                //System.out.println(user1 +"/ "+ bad_user); 
                //System.out.println("작업 전 :"+ map1.get(user1)); 
                map1.get(user1).add(bad_user);
               // System.out.println("작업 후 :"+ map1.get(user1)); 
                int nowCnt= map2.get(bad_user);
                map2.put(bad_user, nowCnt+1); 
            }


        }

        //k번 이상 신고당한 유저 찾기!
        for(int i=0;i<id_list.length;i++){
            for(String key:map2.keySet()){
                if(map2.get(key)>k){

                }
            }
        }
    
        for(int i=0;i<id_list.length;i++){
            int cnt=0;
            for(int j=0;j<map1.get(id_list[i]).size();j++){
                String name= map1.get(id_list[i]).get(j); 
                if( map2.get(name)>=k){ cnt++; }
            }

            answer[i]= cnt; 
            
        }

        return answer; 
    }

    public static void main(String[] args) throws IOException{

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;
        int [] answer= solution(id_list, report, k); 

    }
    
}
