public class JadenCase {

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/12951
    
    */
    public String solution(String s) {
        String answer = "";
        int start = 0 ;
        int end = 0;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i)== ' '){
                
                if(start!=end){
                    
                    String nowStr = s.substring(start, end);
                    String changeStr = changeStr(nowStr); 
                    //s= s.replaceFirst(nowStr, changeStr);
                    answer+= changeStr; 
                    
                    //replace 함수를 쓰면 안되네..
                }
                start = i+1;
                end= i+1; 
                answer+= ' '; 
                
            }
            else{
                end++; 
            }

            if(end==s.length()){

                if(start!= end){
                    String nowStr = s.substring(start, end);
                    
                    String changeStr = changeStr(nowStr); 
                    System.out.println(nowStr + " ->" +changeStr);
                    //s= s.replaceFirst(nowStr, changeStr);
                    answer+=changeStr; 
                }
            }
        }
        return answer;
    }

    public String changeStr(String s){
        String result = "";

        char c0= s.charAt(0);
        /* 첫 문자가 소문자인경우 */
        if(c0-'0' >=49 && c0-'0'<= 74){
            c0= Character.toUpperCase(c0);   
            System.out.println(c0);       
        }
        result+= c0; 

        /* A :17 / a: 49   / Z : 42 / z: 74*/
        for(int i=1;i<s.length();i++){
            char c= s.charAt(i); 
            /* 대문자인 경우 (A:17, Z:42)   */
            if(c-'0' >= 17 && c-'0'<= 42){
                c=Character.toLowerCase(c);
            }
            result+=c; 
        }
        return result; 

    }
    
    public static void main(String[] args){

        JadenCase sol = new JadenCase();
        sol.solution("5Mem                  ");


        
    }
}
