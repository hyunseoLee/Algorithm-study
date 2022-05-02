import java.io.*;
import java.util.StringTokenizer;

/*
2022.05.02 안전영역 DFS 
오후1:00 ~ 
*/
public class Main_220502 {
    static BufferedWriter bw; 
    static int N;
    static int[][] arr;
    static boolean[][] check; 
    static int max=0; 
    static int[] dx= {1,-1,0,0};
    static int[] dy= {0,0,1,-1};

    public static void main(String[] args) throws IOException{

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());
        arr= new int[N][N];
        check= new boolean[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine()); 
            for(int j=0;j<N;j++){            
               arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        

        /* STEP1. 1~ 100 까지 작업 실행 */
        for(int now=0; now<=100; now++){
            //1. check 배열 초기화 시켜야됨.
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    check[i][j]=false; 
                }
            }

            //2. 모든값 확인하여 dfs 실행. 
            int ans=0; 
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j]>now && check[i][j]==false){
                        check[i][j]=true; 
                        dfs(i,j,now); 
                        ans++; 
                    }
                }
            }
            bw.write(now +": " +ans +"\n");
            max= Math.max(max, ans); 
        }

        
        bw.write(max + "\n");

        bw.flush(); 
        bw.close();



    }

    public static void dfs(int x, int y, int now ) throws IOException{

        for(int k=0;k<4;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx>=0 && nx<N && ny>=0 && ny<N && check[nx][ny]== false && arr[nx][ny]>now ){
                check[nx][ny]=true; 
                dfs(nx,ny,now);
            }
        }

    }
    
}
