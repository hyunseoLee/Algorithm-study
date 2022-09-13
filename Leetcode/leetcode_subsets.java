import java.util.*;

public class leetcode_subsets {
    
    static List<List<Integer>> list;  

    public List<List<Integer>> subsets(int[] nums) {
       
        list = new ArrayList<>();
        list.add(new ArrayList<>()); 
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<=nums.length;j++){
                List<Integer> ans= new ArrayList<>();
                ans.add(nums[i]);
                dfs(i,ans,j,nums);
            }
        }

        
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
   
        
        return list; 
    }

    /* idx : 몇번째 인덱스부터 시작하는지, 
       str : 현재까지 조합된 숫자들,
       cnt:  몇자릿수 인지
     */
    public void dfs(int idx, List<Integer> ans , int cnt, int[] nums){
        if(ans.size()== cnt){
            
            for(int i=0;i<ans.size();i++){
                System.out.println(ans.get(i)+" "); 
            }
            System.out.println();
            

            list.add(new ArrayList<>(ans)); 
            //list.add(ans)
            /*
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i)+ " ");
            }
            System.out.println();
            
            */
            return; 
        }

        for(int i=idx+1;i<nums.length;i++){
            //String tmp= str+nums[i];
            ans.add(nums[i]);
            //System.out.println(tmp); 
            dfs(i,ans,cnt,nums);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args){
        leetcode_subsets  sol = new leetcode_subsets();
        int[] nums={1,2,3}; 
        sol.subsets(nums);
    }
}
