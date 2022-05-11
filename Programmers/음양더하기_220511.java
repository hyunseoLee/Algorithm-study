import java.io.IOException;

public class Programmers_220511 {

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0;i<absolutes.length;i++){
            if(signs[i]){
                answer+= absolutes[i];
            }
            else{
                answer+= absolutes[i]*(-1); 
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException{
       
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};

        int ans= solution(absolutes, signs);
        System.out.println(ans);

    }
    
    
}
