import java.io.*;
import java.util.StringTokenizer;

public class N과M1_220206 {
    static int N,M; 
    static int[] arr; 
    static boolean[] check;
    static BufferedWriter bw ;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        arr= new int[M+1];
        check= new boolean[N+1];

        recursion(0); // 재귀함수

        bw.flush();
        bw.close();
    }
    /* 
        K번째 자리수의 값을 계산하는 함수
    */
    private static void recursion(int K) throws IOException{
        if(K==M){
            //retun. 
            for(int i=0;i<M;i++){
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return; 
        }
        for(int i=1;i<=N;i++){
            if(!check[i]){ // 방문하지 않은 노드 일 때. 
                // 오름차순이기 때문에 더 커야한다. 
                // arr[k] < i
                if( ( K>=1 && arr[K-1]< i) || K==0 ) {
                    arr[K]= i;
                    check[i]=true;
                    recursion(K+1);
                    check[i]=false;
                }
            }
        }

    }
    
}
