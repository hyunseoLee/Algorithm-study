import java.util.*;

public class DFSstudy {

    static String result= ""; 
    static boolean[] check;
    static List<String> list = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1]; 
        check= new boolean[tickets.length];

        for(int i=0;i<tickets.length;i++){
           // List<String> list= new ArrayList<>();
            // list.add("ICN"); 
            if(tickets[i][0].equals("ICN")){
                check[i]=true;
                result = tickets[i][0] + ",";
                dfs(tickets, tickets[i][1],1); 
                //dfs(i, 1, tickets[i][1],list, check,tickets); 
                //list.remove(list.size()-1); 
            }
        }

        Collections.sort(list);
        answer= list.get(0).split(","); 


        /*
        for(int i=0;i<result.length();i++){
   
            if(i%3==0){
                String tmp= result.substring(i, i+3); 
               // System.out.println(tmp);
                answer[i/3]= tmp;
            }
            
        }

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
        */ 
        return answer;

    }

    public void dfs(String[][] tickets, String end, int cnt){
        result+= end +",";

        if(cnt== tickets.length){
            list.add(result); 
            return; 

        }

        for(int i=0;i<tickets.length; i++){
            if(check[i]==false && end.equals(tickets[i][0])){
                check[i]=true;
                dfs(tickets, tickets[i][1], cnt+1); 
                check[i]=false; 
                result= result.substring(0,result.length()-4); 
            }
        }


    }
    /*
    public void dfs(int idx, int cnt, String now, List<String> list, boolean[] check,String[][] tickets ){
        if(cnt==tickets.length  ){

           list.add(tickets[idx][1]);
           //System.out.println(idx+", "+tickets[idx][1]);

            // 알파벳이 더 빠른 순서가 결과값.
            String tmp="";
            for(int i=0;i<list.size();i++){
                tmp+= list.get(i); 
            }

            System.out.println(tmp); 

            if(tmp.compareTo(result) > 0 ){
                //tmp 가 더 크다면. 
                result= tmp; 
            }
            return; 
        }

        for(int i=0;i<tickets.length; i++){
            if(check[i]==false && now== tickets[i][0]){
                check[i]=true;
                list.add(tickets[i][1]);
                dfs(i,cnt+1, tickets[i][1], list,check,tickets); 
                list.remove(list.size()-1);
                check[i]=false; 
            }
        }
    }
    */

    public static void main(String[] args){
        DFSstudy sol = new DFSstudy();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; 
        String[][] tickets2= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        sol.solution(tickets2); 

    }
}
