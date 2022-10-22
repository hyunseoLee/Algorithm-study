public class makeTwo {
    public int[] solution(String s) {
        int[] answer = new int[2];


        int cnt=1; 
        int zeroSum=0; 
        while( ! s.equals("1")){ // 1이 될때 까지 반복 

            String tmp= ""; 
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)== '0'){
                    zeroSum++; 
                }
                else{
                    tmp+= s.charAt(i);
                }

            }

            if(tmp.equals("1")) break; 
            //System.out.println("0을 제거 후: "+ tmp);
            // tmp의 자릿수를 이진수로 변환. 
            s= changeTwo(Integer.toString(tmp.length())); 
            //System.out.println("이진법 변환 후 : " + s);
            cnt++; 
        }

        System.out.println("<결과>  회차"+ cnt +"/ 제거한 0의 갯수: "+ zeroSum);

        answer[0]= cnt; 
        answer[1]= zeroSum;

        return answer;
    }

    /* 2진법 변환 함수 */
    public String changeTwo(String s){
        String ans ="";

        int num= Integer.parseInt(s);
        while(num>=2){
        
            if(num==2 || num==3){
                String tmp = Integer.toString(num/2) + Integer.toString(num%2); 
                ans = tmp+ ans; 
            }
            else{
                ans = Integer.toString(num%2) + ans;  
            }
            num= num/2; 

        }
        return ans; 
    }

    public static void main(String[] args){
        makeTwo sol = new makeTwo();
        sol.solution("01110"); 

    }
}
