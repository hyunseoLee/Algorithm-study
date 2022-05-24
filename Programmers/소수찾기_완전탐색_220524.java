import java.util.*;

public class Main__220524 {
    
    static List<Integer> result= new ArrayList<>(); 
  
    public static int solution(String numbers) {
        int answer = 0;
        

        for(int i=1;i<=numbers.length();i++){
           for(int j=0;j<numbers.length();j++){
               boolean[] check= new boolean[numbers.length()]; 
               String tmp="";
               tmp+=numbers.charAt(j);
               //System.out.println(tmp); 
               check[j]=true;
               solve(numbers,tmp,i, j, check);

           }
        }
        /*

        for(int j=0;j<numbers.length();j++){
            boolean[] check= new boolean[numbers.length()]; 
            String tmp="";
            tmp+=numbers.charAt(j);
            check[j]=true;
            solve(numbers,tmp,4, j, check);
        }
        */



        for(int i=0;i<result.size();i++){
            
            if( isPrime(result.get(i)) ) {
                answer++; 
            }
        }

        return answer;
    }
    /* 모든 경우의 수를 만든다.  */
    public static void solve(String numbers, String tmp, int dpth,int now,boolean[] check){

        //check[now]=true;
        // 반환하지 않고 원하는 크기의 string이 되어있을때 소수여부 확인 후 결과값 증가.
        if(tmp.length()==dpth){

            int num= Integer.parseInt(tmp);
            //System.out.println(num);
            if(! result.contains(num)) {
                //System.out.println(tmp) ;
                result.add(num);
            }
            return; 
        }
        // 어디서 return 시킬지가 고민이네 .

  
        for(int i=0;i<numbers.length();i++){
            if(check[i]==false){
                check[i]=true;
                String tmp2= tmp+numbers.charAt(i);
                solve(numbers,tmp2, dpth, i, check); 
                check[i]=false;
            }

        }



    }
    /* 소수 여부를 판단하는 함수  */
    public static boolean isPrime(int num){

        boolean check = true; 
        /* 소수인지 확인  */
        if(num==1 || num==0 ) check= false; 
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) {
                check=false; break;
            } 
        }
        
        return check;
    }
    public static void main(String[] args){

        System.out.println("return값 : " + solution("1231"));
    }
    
}
