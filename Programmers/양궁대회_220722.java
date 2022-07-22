public class Lion {
    
    static int ans = -1; 
    static int[] result= new int[11]; 

    /* 2시간정도 걸렸는데. 테스트케이스 하나 틀려서
       30분정도 뭐가틀렸나 찾았다 (근데 그것도 인터넷통해서 찾음) 
       반례 테스트케이스 찾는 연습도 해야할 것 같다. 
       */

    public int[] solution(int n, int[] info) {
        int[] answer= {}; 
       // int[] answer = new int[11];

        // STEP1. 이길건지 or 질건지 에 대한 모든 라이언의 경우의 수를 구한다.
        int[] rion= new int[info.length];

        Rion(n,0,0,info,rion); 


        if(ans == -1 || ans==0 ) { // 여기서 테스트케이스23 걸렸음. 만약 어피치랑 라이언이 같았다면 그건 라이언이 진 게임이므로 -1 반환해야 한다. 
            answer= new int[1];
            answer[0]= -1;
        }
        else{
            answer= new int[11];
            for(int i=0;i<answer.length;i++){
                answer[i]= result[i]; 
            }
        }
        return answer;
    }

    public void Rion (int n, int idx, int sum, int[] info, int[] rion){
        if(sum==n || idx== info.length ){ // 모든 과녁을 다 쐈으면 끝. 
        
            int tmp= rion[idx-1];

            //2. 라이언의 과녁점수와 어피치의 과녁점수 비교하기 
            if(idx==info.length  && sum<n){
                rion[idx-1]= n-sum;  // 여기서 라이언의 마지막인덱스를 고정시킬 수 있으니 주의해야 한다.              
            }
            
            int resultA=0; // 어피치 점수
            int resultL=0; // 라이언 점수
            for(int i=0;i<info.length;i++){
                //1. 점수가 같거나 큰 경우 : 어피치 승리
                if(info[i] >= rion[i]){
                    if(info[i]!=0 || rion[i]!=0){ //둘중 한명은 0 이 아니여야 한다. 
                        resultA+= (10-i); 
                    }
                }
                //2. 
                else{
                    if(info[i]!=0 || rion[i]!=0){ 
                    resultL+= (10-i);
                    }
                }
            }
            if(ans < (resultL-resultA)){
                ans= (resultL- resultA); 
                for(int i=0;i<result.length;i++){
                    result[i] = rion[i]; 
                }
            }

            if(ans == (resultL-resultA)){

                // 가장 낮은 점수를 많이 맞힌 배열이 정답임.
                for(int i=result.length-1;i>=0;i--){
                    if(result[i]!=0 || rion[i]!=0 ){
                       // System.out.println(i+"번째 배열이 같음!!! " +result[i] + ", "+ rion[i]);
                        if(result[i] > rion[i]) break;
                        if(result[i] < rion[i]){
                            for(int j=0;j<result.length;j++){
                                result[j] = rion[j]; 
                            }
                            break; 
                        }
                    }
                }
                /*
                System.out.println("결과물 ㅎㅎ ");
                for(int i=0;i<result.length;i++){
                    System.out.print(result[i] +" ");
                }
                System.out.println();
                */
            }
            
            rion[idx-1] = tmp; // 여기서 꼭 다시 라이언을 원복시켜줘야함. (이게뭐라고 여기서 막히네 !? )

            /*
            for(int i=0;i<rion.length;i++){
                System.out.print(rion[i] + " "); 
            }
            System.out.println("/ 어피치점수: "+ resultA +", 라이언점수: "+ resultL +"/ 결과값: "+ (resultL-resultA)); 
            */
            return; 
        }
        //1. 이기는 경우
        if(sum+ info[idx]+1 <= n){
            rion[idx] = info[idx]+1; 
            Rion(n,idx+1, sum+ rion[idx], info, rion); 
        }
        
        //2. 지는 경우
        rion[idx] = 0; // 지는경우 깔끔하게 0점으로 가야함. 
        Rion(n, idx+1, sum, info, rion); 

        
    }

    public static void main(String[] args){
        Lion sol= new Lion();
        int n= 2;
        int[] info = {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        
        int[] answer= sol.solution(n, info);

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i] +" ");
        }
        System.out.println();

        // 1,1,2,0,1,2,2,0,0,0,0
    }
}
