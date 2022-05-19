import java.util.*;

public class k진수에서소수개수구하기_220519 {
    public static int solution(int n, int k){

        int answer = 0; 

        // 1. 숫자 n 을 k 진수로 변환 
        String ans =  changeNum(n,k); 
        // 2. 각 String을 0 기준으로 분할 
        String[] newStr= ans.split("0"); 
        /* 
        String[] newStr= Integer.toString(n,k).split("0");
        */
        
        for(int i=0;i<newStr.length;i++){
            //3. 각 숫자들이 소수가 맞는지 확인 
            if(newStr[i].isEmpty()) continue; // if(t.length() == 0) continue; 
            if(isPrime(Long.parseLong(newStr[i]))) answer++; 
        }
       
        return answer;
    }

    //소수인지 판별하는 함수
    public static boolean isPrime(Long n){

        boolean check =true; 
        if(n==1 ) check= false; 
        for(Long i=(long) 2; i<=(long)Math.sqrt(n);i++){
            if(n%i==0) { 
                check= false; 
                break;
            }
        }
        return check;
    }
    //k 진수로 변환하는 함수 (list로 구현했다가 String으로 변경)
    public static String changeNum(int n, int k){

        //List<Integer> list  = new ArrayList<>(); 
        String str=""; 

        while(true){
            if(n<k) {
                //list.add(n); 
                str+=n; //Integer.toString(n);
                break; 
            }
           //  list.add(n%k);  
            str+=n%k; // Integer.toString(n%k); 
            n= n/k;
           
        }
        //Collections.reverse(list);

        String ans= "";
        for(int i=str.length()-1;i>=0;i--){
            ans+= str.charAt(i); 
        }

        return ans; 
    }
    public static void main(String[] args) {
        int n= 524287;
        int k= 2;

        //System.out.println(isPrime(0));
        System.out.println(changeNum(n,k));
//        String temp[] = Integer.toString(n, k).split("0");

        System.out.println(Integer.toString(n,k));

        String test= "11000011"; 
        String test2= "211020101011";
        String test3="1111111111111111111"; 

        System.out.println(Math.sqrt(36)+1);
//        System.out.println(isPrime(Long.parseLong(test3)));

        
        String[] newStr= test3.split("0"); 
        for(int i=0;i<newStr.length;i++){
            if(newStr[i].isEmpty()){System.out.println("이거임?"); }
            System.out.println(i +" : " +newStr[i]); 
        }
    


        //System.out.println(solution(n,k)); 
    }
}
