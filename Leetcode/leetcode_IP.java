import java.util.*;

public class leetcode_IP {

    static List<String> list;

    public List<String> restoreIpAddresses(String s) {
       
        list= new ArrayList<>();


        for(int i=0;i<s.length();i++){
            List<String> ans= new ArrayList<>();
            makeIp(i,s,ans); 

        }

        return list;  

    }

    public void makeIp(int idx, String s, List<String> ans){

        if(ans.size()==4){
            
           // if( s.isEmpty()){ 
                String ip = "";
                for(int i=0;i<ans.size();i++){
                    System.out.print(ans.get(i) + ", ");
                    ip+= ans.get(i);
                    if(i!= ans.size()-1){
                        ip+= ".";
                    }

                    list.add(ip);
                }
                System.out.println();
          //  }   
            return; 
        }

        for(int j=1;j<=3;j++){
            if(idx+j <= s.length()){ 
            String str= s.substring(idx, idx+j);
            System.out.println(s+"를 "+ idx + " 부터 " +(idx+j) +"까지 ! " + str);
                // 범위 : 0~ 255
                if(Integer.parseInt(str)<256){
                    System.out.println( s.replaceFirst(str, "") );
                    String tmp_s= s.replaceFirst(str, "");
                    List<String> tmp_ans = new ArrayList<>();
                    for(int i=0;i<ans.size();i++){
                        tmp_ans.add(ans.get(i));
                    }
                
                    makeIp(0,tmp_s,tmp_ans); 

                }
            }
        }
    }
    public static void main(String[] args){
        leetcode_IP sol = new leetcode_IP();
        String s= "25525511135";
        String s1= "255255";
        sol.restoreIpAddresses(s1);
    }
}

