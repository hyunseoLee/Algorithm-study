import java.io.*;
import java.util.StringTokenizer;

public class 외판원순회2_backtracking_220321 {
    

    static BufferedWriter bw ;
    static int N; // 2<=N<=10  
    static int[][] arr; 
    static boolean[] check;
    static int answer;
    
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());
        arr= new int[N][N];
        check= new boolean[N];
        answer= Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
             arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }  
        
        for(int i=0;i<N;i++){
            check[i]=true;
            recursion(i,i,0,0); //  어떤 정점부터 시작일지는 모름.  
            check[i]=false;
        }

        bw.write(answer +"\n");

        bw.flush();
        bw.close();

    }
    public static void recursion(int start, int now, int cnt, int sum) throws IOException {
        if(cnt == N-1 && arr[now][start]!=0 ){
            sum+= arr[now][start];
            answer= Math.min(answer,sum);
            return;
        }

        for(int i=0;i<N;i++){
            if(check[i]==false && arr[now][i]!=0 ){
                check[i]=true;
                recursion(start, i, cnt+1, sum + arr[now][i]);
                check[i]=false;
            }
        }
    }
}
