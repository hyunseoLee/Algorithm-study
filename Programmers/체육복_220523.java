import java.util.Arrays;

public class 체육복_220523 {

    /* 재귀로 풀려고 했으나, 안되는 것을 깨달음 
    왜냐면, lost[0]에서 맞는 체육복을 찾기 못하면 그 뒤로 넘어가지 못하는데, 그럼 그뒤에 재귀가 발생 X.
    ( lost[1]에서는 맞는 체육복이 생길 수 있음에도 1 까지 재귀함수가 넘어오지 않는다. */
    static int result=0; 
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n- lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);


        //1. 여벌 가져온 아이가 도둑맞은 경우.
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    lost[i]=-1; reserve[j]=-1;
                    answer++; 
                }
            }
        }
        
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]){
                    reserve[j]= -1;
                    answer++;
                    break; 
                }
            }
        }
        return answer; 

    }

    //테스트케이스 n=5 / lost=[2, 3, 4] / reserve=[3, 4, 5] 로 런할 때, 답은 4인데 5가 나오지 않나요??

    public static void main(String[] args){
        int n=5;
        int[] lost = {2,3,4};
        int[] reserve= {3,4,5}; 
       // System.out.println(solution(n, lost,reserve)); 

       System.out.println(solution(7, new int[]{2, 3, 4}, new int[]{1, 2, 3, 6}));
    }
    
}
