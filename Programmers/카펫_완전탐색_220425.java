public class 카펫_완전탐색_220425 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 브라운 = (가로-2)*2 + 세로*2
        // 옐로우 = (가로-2)* ( 세로-2)*2
        // 가로 = row , 세로 = col
        int col; int row;
        for(col=3; col <= brown/2; col++){
            row= brown/2 - col+2;
            if(yellow== (col-2)* (row-2)){
                answer[0]= row;
                answer[1]= col; 
                break; 
            }
        }

        return answer;
    }
    
    public static void main(String[] args){
        
        int[] answer= solution(24,24); 
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]); 
        }

    }

}
