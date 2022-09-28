public class BFStudy {
    
   static int ans=0;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int size= dungeons.length;
        boolean[] check= new boolean[size];

        for(int i=0;i<dungeons.length;i++){
            check[i]=true;
            if(k>=dungeons[i][0]){
                BF(1,k-dungeons[i][1],check,dungeons);
            }
            check[i]=false;
        }

    
        System.out.println(ans);
        answer= ans;


        return answer;
    }

    public void BF(int cnt, int now, boolean[] check,int[][] dungeons){
        if(now<=0 || cnt== dungeons.length){
            //System.out.println(now);
            ans= Math.max(ans, cnt); 
            return; 
        }

        for(int i=0;i<dungeons.length;i++){
            if(check[i]==false && now>=dungeons[i][0] ){
                check[i]=true; 
                BF(cnt+1, now-dungeons[i][1], check,dungeons );
                check[i]=false;
            }
        }

        ans= Math.max(ans, cnt); 

    }
    public static void main(String[] args){
        BFStudy sol = new BFStudy();
        int k=80;
        int[][] dungeons= {{80,80},{80,20},{50,40},{30,10}}; 
        sol.solution(k,dungeons);

    }
}
