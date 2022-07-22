import java.util.*;

public class Menu {

    static HashMap<String, Integer> map = new HashMap<>();
    static int ans =0; 

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> list= new ArrayList<>(); 


        for(int i=0;i<course.length;i++){
            ans=0; 
            map.clear();
            for(int j=0;j<orders.length;j++){          
                menuScan(course[i],orders[j],0,0,""); 
            }

            Iterator<String> iter= map.keySet().iterator(); 
            while(iter.hasNext()){
                String key= iter.next();
                Integer val= map.get(key);
                if(ans >=2 && val==ans){
                    list.add(key);  
                }      
            }

        }
        Collections.sort(list);
        answer= new String[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]= list.get(i); 
            System.out.println(list.get(i));
        }


        
        



        return answer;
    }
    public void menuScan(int n, String order, int dpth, int idx, String now){

        if(idx == order.length()){
            if(dpth==n){ 
                //System.out.println(now);
                //map.getOrDefault(key, defaultValue)
                List<Character> list= new ArrayList<>(); 
                for(int i=0;i<now.length();i++){
                    list.add(now.charAt(i));
                }
                Collections.sort(list);
                
                String str= "";
                for(int i=0;i<list.size();i++){
                    str+= list.get(i); 
                }

                //System.out.println(str); 

                map.put(str, map.getOrDefault(str, 0)+1); 
                ans= Math.max(ans, map.get(str)); 
                return;
            }
            return; 
        }

        String result= now + String.valueOf(order.charAt(idx)); 
        menuScan(n,order,dpth+1, idx+1,result); 
        menuScan(n,order,dpth, idx+1,now);

    }

    public static void main(String[] args){
        String[] orders= {"XYZ", "XWY", "WXA"};
        int[] course={2,3,4};

        Menu sol= new Menu();
       sol.solution(orders, course);


    }
    
}
