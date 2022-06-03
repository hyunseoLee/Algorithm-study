import java.util.*;

public class FindPrimeNumber_220602 {
    
    List<Integer> list= new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;
       
        for(int i=1;i<=numbers.length();i++){
            // check함수를 만들어서 동일한 숫자 중복사용 방지  ex. 11, 77 
            boolean[] check= new boolean[numbers.length()];
            getNumber(numbers, "", 0, i,check);
        }

        answer= list.size();
        
        return answer;
    }
    public void getNumber(String numbers, String result, int index, int size,boolean[] check){
        if(index==size){
            //result가 String형이므로 int형으로 변환해줘야한다.
            int num = Integer.parseInt(result);
            
            if(isPrime(num)){ // 소수이면
                if(!list.contains(num)){ 
                // 011과 11은 같은 숫자이므로 같은 경우가 나올 수 있으므로 예외처리
                    System.out.println(num);
                    list.add(num);
                }
            }
            return;
        }
        
        for(int i=0;i<numbers.length();i++){
            if(check[i]==false){
                String tmp= result;
                tmp+= numbers.charAt(i);
                check[i]= true;
                getNumber(numbers,tmp, index+1,size,check);
                check[i]= false;
            }
        }

    }

    /* 소수 여부 판단하는 함수 */
    public boolean isPrime(int num){
        if(num==0 || num==1 ) return false;

        for(int i=2;i<= Math.sqrt(num);i++){ // 제곱근까지만 확인해보면 됨 
            if(num%2==0) return false; 
        }

        return true;
    }

    public static void main(String[] args){
        FindPrimeNumber_220602 sol = new FindPrimeNumber_220602();
        System.out.println(sol.solution("011"));
    }
}
  