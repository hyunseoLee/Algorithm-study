import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main_220511 {
    

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){
            int start= commands[i][0];
            int end = commands[i][1];
            int num = commands[i][2];

            ArrayList list= new ArrayList();
            for(int j=start-1;j<end;j++){
                list.add(array[j]);
            }
            
            Collections.sort(list);

            answer[i]= (int) list.get(num-1);

        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        int[] array ={1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution(array, commands);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }

    }

}
