public class BruteForceStudy {
    
    static boolean check[]; 
    static int answer=-1; 
    public int solution(int k, int[][] dungeons) {
        //int answer= -1;

        check = new boolean[dungeons.length]; 
        dfs(0,dungeons,k);

        System.out.println(answer); 

        return answer;
    }
    public void dfs(int result, int[][] dungeons, int val){
        answer= Math.max(answer, result);

        /* ans : 현재까지 던전 수, val: 현재까지의 피로도 */
        for(int i=0;i<dungeons.length;i++){
            //아직 방문하지 않았고, 현재피로도 보다 최소피로도가 낮은경우 
            if(check[i]==false && val >= dungeons[i][0]){
                check[i]= true; 
                dfs(result+1,dungeons, val-dungeons[i][1]);
                check[i]= false; 
            }
        }
    }

    public static void main(String[] args){
        BruteForceStudy sol = new BruteForceStudy();
        int[][] dungeons=  {{80,20},{50,40},{30,10}};
        sol.solution(80, dungeons);

    }
}
