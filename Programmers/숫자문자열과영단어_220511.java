import java.io.*;
import java.util.*;

class Main_220511 {

    public static int solution(String s) {
        int answer = 0;
        String[] eng={"zero","one","two","three","four","five","six","seven","eight","nine"};

        for(int i=0;i<eng.length;i++){
            s = s.replaceAll(eng[i], Integer.toString(i));
            
        }
        answer= Integer.parseInt(s);
        return answer;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder(); 
        
        String str= "123";
        int answer= solution(str);
           
        System.out.println(answer); 
    }

}


