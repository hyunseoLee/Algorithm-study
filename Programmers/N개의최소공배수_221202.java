import java.util.*;

public class N개의최소공배수_221202 {
    public int solution(int[] arr) {

        List<Integer> list= new ArrayList<>();
        
        int answer = 1;

        while(true){

            int min=101; int max=0;

            for(int i=0;i<arr.length;i++){
                if(arr[i]==1) continue;
                min= Math.min(min,arr[i]);
                max= Math.max(max,arr[i]);
            }

            System.out.println(min + " , "+ max ) ; 

            int cnt=0;
            for(int i=2; i<=max;i++){
                cnt=0; 
                for(int j=0;j<arr.length;j++){
                    if(arr[j]%i==0 && i!=1) cnt++;
                }
                if(cnt>=2){
                    list.add(i); 
                    for(int k=0;k<arr.length;k++){
                        if(arr[k]%i==0){
                            arr[k]= arr[k]/i;
                        }
                        System.out.print(arr[k] + " "); 
                        
                    }
                    System.out.println();

                    break;
                }
            }

            System.out.println(cnt);
            if(cnt==0 || cnt==1) break;


        }

        for(int k=0;k<arr.length;k++){
            list.add(arr[k]);
        }

        for(int i=0;i<list.size();i++){
            answer = answer * list.get(i); 
        }

        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args){
        N개의최소공배수_221202 sol = new N개의최소공배수_221202();
        int[] arr= {12, 32, 45, 67, 72}; 
        sol.solution(arr); 
    }
}
