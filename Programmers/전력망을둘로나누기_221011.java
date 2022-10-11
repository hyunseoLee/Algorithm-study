public class bruteforce1 {
    

    static int[][] map;
    static boolean[] check; 
    static int result=0;
    public int solution(int n, int[][] wires) {
        int answer = 102;

        map= new int[n+1][n+1];
        check= new boolean[n+1]; 
        
        //Step1. map에 wires 정보를 입력한다.
        for(int i=0;i<wires.length;i++){
            int x= wires[i][0];
            int y= wires[i][1]; 
            map[x][y]=1;  map[y][x]=1; 
        }

        //Step2.연결되어있는 전선을 끊는다.
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(map[i][j]==1){
                    map[i][j]=0; map[j][i]=0;
                    //node1 : i 
                    result=1;
                    int tmp1= dfs(i,n);  //방법1. 리턴형을 int 로 받을때 
                    dfs(i,n); int ans1= result; //방법2. 리턴형을 void 로 받을때. 전역변수 사용
                    
                    //node2 : j 
                    result=1;
                    int tmp2= dfs(j,n); 
                    dfs(j,n); int ans2= result;

                    // 두 결과값이 차이를 answer와 최솟값 비교
                    answer= Math.min( answer, Math.abs(ans1-ans2)); 
   
                    map[i][j]=1; map[j][i]=1; // 원상복구
                }
            }
        }

        return answer;
    }
    public int dfs(int now, int n){
        /* now : 현재 시작 노드, ans : 현재까지 탐색한 노드의 갯수  */ 
        check[now]=true;  

        int sum=1; 

        for(int i=0;i<=n;i++){
            //아직 방문하지 않은 노드라면, 
            if(map[now][i]==1 &&check[i]==false){
                check[i]=true; result++; 
                sum+= dfs(i,n); // 리턴형 int를 반환하여 결과값을 더해줌. 
                check[i]=false; 
            }
        }

        check[now]=false;

        return sum;  // 리턴값 반환 


    }

    public static void main(String[] args){
        bruteforce1 sol = new bruteforce1();
        int n=9;
        int[][] wires =  {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}; 
        sol.solution(n, wires);
    }
}
