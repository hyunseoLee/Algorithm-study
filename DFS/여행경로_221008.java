import java.util.*;

public class DFSstudy4 {
    static List<String> list = new ArrayList<>(); 
    static boolean check[]; 
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length];
        check = new boolean[tickets.length]; 
        int cnt=0; 
        String ans = ""; 
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                ans = "ICN" + "," + tickets[i][1]; 
                check[i]=true; 
                dfs(tickets, ans, cnt+1);
                check[i]=false; 
            }
        }

        Collections.sort(list);
        answer= list.get(0).split(",");

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
        

        return answer;
    }

    public void dfs(String[][] tickets, String ans, int cnt){

        if(cnt== tickets.length){
            list.add(ans); 
            System.out.println(ans);
            return; 
        }
        for(int i=0;i<tickets.length;i++){
            String now= ans.substring(ans.length()-3, ans.length());  //현재 출발지 
            String start= tickets[i][0]; 
            String end = tickets[i][1]; 
           // System.out.println(now + ", "+ start +", "+ end);
            if(check[i]==false && now.equals(start)){
                String go= ans+","+end; 
                check[i]=true;
                dfs(tickets, go, cnt+1); 
                check[i]=false;
            }
        }

    }
    public static void main(String[] args){

        DFSstudy4 sol = new DFSstudy4();
        //System.out.println(test.substring(test.length()-3, test.length())); 

        String[][] tickets= {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        sol.solution(tickets); 


    }
    
}
