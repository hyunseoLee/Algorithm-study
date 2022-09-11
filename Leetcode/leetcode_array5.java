import java.util.*;

public class leetode_array5 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

       // int[] ans= new int[nums1.length]; 
        ArrayList<Integer> list = new ArrayList<>();

        int cnt1=0; 
        for(int i=0;i<nums1.length;i++){
            if(cnt1==m) break; 
            list.add(nums1[i]); 
            cnt1++;           
           // if(cnt1==m) break; 
        }
        int cnt2=0; 
         for(int i=0;i<nums2.length;i++){    
            if(cnt2==n) break; 
            list.add(nums2[i]); 
            cnt2++; 

        }

        Collections.sort(list);
        for(int i=0;i<list.size();i++){
           //System.out.print(list.get(i) +" "); 
            nums1[i]= list.get(i);
        }
       // System.out.println();

        
    }   
    public static void main(String[] args){
        leetode_array5 sol= new leetode_array5();
        int[] nums1 = {-1,0,1,1,0,0,0,0,0};
        int m= 4;
        int[] nums2 = {-1,0,2,2,3};
        int n=5; 
        sol.merge(nums1, m, nums2, n);

        for(int i=0;i<nums1.length;i++){
            System.out.print( nums1[i] + " "); 
        }

    }
}
