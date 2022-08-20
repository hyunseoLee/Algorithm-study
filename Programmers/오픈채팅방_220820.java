import java.util.*;

public class Open {

    static HashMap<String, String> idMap = new HashMap<>();
    static List<String> list= new ArrayList<>(); 

    public String[] solution(String[] record) {
        //String[] answer = {};
        for(int i=0;i<record.length;i++){
           
           String[] str = record[i].split(" ");

           // 아이디 저장
           if(str[0].equals("Enter") || str[0].equals("Change")){
               idMap.put(str[1],str[2]); 
           }

           // enter, leave 기록 남기기 
           if(str[0].equals("Enter") || str[0].equals("Leave")){
            String stat= str[0]+" "+ str[1];
            list.add(stat);
            }

        }

        String[] answer= new String[list.size()];
       
        for(int i=0;i<list.size();i++){
            String[] str= list.get(i).split(" ");
            String result=""; 
            if(str[0].equals("Enter")){
                result= idMap.get(str[1]) +"님이 들어왔습니다.";
                //System.out.println(result);

            }
            if(str[0].equals("Leave")){
                result= idMap.get(str[1]) +"님이 나갔습니다.";
                //System.out.println(result);

            }

            answer[i]= result; 
        }
        return answer;
    }

    public static void main(String[] args){

        Open sol= new Open();

        String[] record={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        sol.solution(record);
    }
}
