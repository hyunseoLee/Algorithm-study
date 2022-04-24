import java.io.*;
import java.util.*;
/*
 2022.03.22
 [BOJ] 음식물피하기
 - DFS 
*/
public class 음식물피하기_DFS_220322 {
    static BufferedWriter bw;
    static int N,M,K;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static int answer=0;
    static int cnt=0;

    public static void main (String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        arr= new int[N][M];
        check = new boolean[N][M];

        for(int i=0;i<K;i++){
            st= new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            arr[x-1][y-1]=1; 
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(arr[i][j]==1 && check[i][j]==false){
                    cnt=0;
                    dfs(i,j); //  재귀는 리턴값이 없다.  
                    answer= Math.max(answer, cnt);  
                }
            }
        }
        bw.write(answer+"\n");
 
        bw.flush();
        bw.close();

        
    }
    public static void dfs(int x, int y) {
        
        cnt++;
        check[x][y]=true;

        for(int k=0;k<4;k++){
            int nx=  x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<N && ny>=0 && ny<M && check[nx][ny]==false && arr[nx][ny]==1){
                dfs(nx,ny);
            }
        }
    }
}
