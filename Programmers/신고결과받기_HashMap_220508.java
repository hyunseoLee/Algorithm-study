import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String,ArrayList<String>> map1= new HashMap<>();
        HashMap<String,Integer> map2= new HashMap<>();

        for(int i=0;i<id_list.length;i++){
            map1.put(id_list[i], new ArrayList<>());
            map2.put(id_list[i], 0);
        }
        for(int i=0;i<report.length;i++){
            String s[]= report[i].split(" ");
            String my_name= s[0];
            String report_name= s[1];  

            if( ! map1.get(my_name).contains(report_name)){
                map1.get(my_name).add(report_name);
                int score= map2.get(report_name)+1;
                map2.put(report_name, score); 
            }
        }

        for(int i=0;i<id_list.length;i++){
            int cnt=0; 
            for(int j=0;j<map1.get(id_list[i]).size();j++){
                String name= map1.get(id_list[i]).get(j);
                if( map2.get(name) >=k){
                    cnt++; 
                }
            }
            answer[i]= cnt; 
        }
        return answer;
    }
}
public class programmers_220508 {

    public static void main(String[] args ) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder(); 


        String[] id_list= {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        
        int k=2;

        Solution sol= new Solution();
        int[] answer= sol.solution(id_list, report, k);
        for(int i=0;i<answer.length; i++){
            System.out.println(answer[i] +" ");
        }

    }

}

