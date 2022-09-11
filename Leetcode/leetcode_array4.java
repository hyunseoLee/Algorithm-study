public class leetcode_array4 {
    public void duplicateZeros(int[] arr) {
        boolean[] check = new boolean[arr.length];
        int[] tmp_arr= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            tmp_arr[i]= arr[i]; 
        }
        
        
        for(int i=0;i<arr.length-1;i++){
            
            if(arr[i]== 0 && check[i]==false ){    
                     
                for(int j=i+1;j<arr.length-1;j++){
                    //System.out.println(i+":"+j+"/"+ arr[j+1]+", "+tmp_arr[j]);   
                    arr[j+1]= tmp_arr[j]; 
                }
     
                arr[i+1]= 0;
                check[i+1]= true;
 
            }
            check[i]=true; 

            for(int k=0;k<arr.length;k++){
                tmp_arr[k]= arr[k]; 
            }
            /*
            for(int k=0;k<arr.length;k++){
                System.out.print(arr[k] + " "); 
            }
            System.out.println();
            */ 
        }

        
    }

    public static void main(String[] args){
        leetcode_array4 sol = new leetcode_array4();
        int[] arr = {0,0,0,0,0,0,0};
        sol.duplicateZeros(arr);

        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k] + " "); 
        }
        System.out.println();
    
        

    }
}
