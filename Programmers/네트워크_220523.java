public class 네트워크_220523 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check= new boolean[n];

        for(int i=0;i<n;i++){
            if(!check[i]){ // 방문하지 않은 노드의 경우
                dfs(i,computers,check);
                answer++; 
            }
        }
        return answer;
    }
    
    public static void dfs(int now,int[][] computers,boolean[] check){

        check[now]= true;

        for(int i=0;i<computers.length;i++){
            if(computers[now][i]==1 && check[i]==false){
                dfs(i,computers,check);
            }
        }
    }

    /*

    1. check 배열을 2차원으로 해서 푼 경우. 

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[][] check= new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]==false && check[j][i]==false &&  computers[i][j]==1){
                    check[i][j]=true;
                    check[j][i]=true; 
                    dfs(i,n,check,computers); 
                    answer++; 
                }
            }
        }

        return answer;
    }

    public static void dfs(int now,int n,boolean[][] check,int[][] computers){
        
        for(int i=0;i<n;i++){ // now부터 시작했더니 처음 틀림. 양방향이 아님 
            if(check[now][i]==false && computers[now][i]==1){
                check[now][i]=true;
                dfs(i,n,check,computers);
            }
        }

    }

    */


    public static void main(String[] args)
    {
        int[][] computers = 
        {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };
        int n=3;

        int[][] computers2 = 
        {
            {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
        };
        int n2=3;


        System.out.println(solution(n,computers));

    }
 
}
