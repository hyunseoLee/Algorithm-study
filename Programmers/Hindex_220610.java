import java.util.Arrays;

public class Hindex_220610 {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 최대값부터 최솟값을 정하자.
        Arrays.sort(citations);

        boolean[] check= new boolean[citations.length];

        //System.out.println(citations[now]);
        
        int minVal= citations[0];
        int maxVal= citations[citations.length-1];

        //System.out.println(maxVal +", "+ minVal);
        
        for(int i=maxVal;i>=0;i--){
            int BigNum=0;
            int SmallNum=0; 
            int val =i; 
            for(int j=0;j<citations.length;j++){
                if(citations[j]>= val) {
                    check[j]=true; 
                    BigNum++;
                }
            }

            if(val<= BigNum){
                boolean isNum= true;
                for(int j=0;j<citations.length;j++){
                    if(check[j]==false){
                        if(citations[j]>val) { isNum=false; break;}
                    }
                }
                if(isNum) {
                    answer= val; 
                    break;
                }
            }
        }
        
        return answer;
    }

    public static void main(String[] args){
        int[] citations={10, 10, 10, 10, 10}; 

        Hindex_220610 sol = new Hindex_220610();

        System.out.println(sol.solution(citations));
    }
}
