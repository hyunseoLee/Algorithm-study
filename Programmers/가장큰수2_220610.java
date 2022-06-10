import java.util.*;

public class BestNumber_study {
    public String solution(int[] numbers) {
        String answer = "";

        String[] strNum= new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            strNum[i]= Integer.toString(numbers[i]);
        }

        Arrays.sort(strNum, new Comparator<String>() {
            
            @Override
            // 양수를 반환하면 n1, n2의 순서를 변경  -> 내림차순
            public int compare(String n1, String n2){
                // n2+n1 이 n1+n2 보다 더 크다면 양수를 반환. 
                return (n2+n1).compareTo(n1+n2);
            }
        });

        if(strNum[0].equals("0")) return "0"; 

        for(String s:strNum){
            answer+=s; 
        }

        System.out.println(answer);

        
        return answer;

    }

    public static void main(String[] args){
        int[] numbers =  {0,0,0};
        BestNumber_study sol = new BestNumber_study();
        System.out.println(sol.solution(numbers));

    }
}
