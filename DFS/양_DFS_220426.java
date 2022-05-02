import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 양_DFS_220426 {

    static BufferedWriter bw;
    static int R,C; 
    static char[][] arr; 
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] check;
    static int num_o, num_v;
    static int ans_o, ans_v; 

    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        check= new boolean[R][C];


        for(int i=0;i<R;i++){
            String str= br.readLine();
            for(int j=0;j<C;j++){
                arr[i][j] =  str.charAt(j); 
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j]!='#' && check[i][j]==false){
                    num_o=0; num_v=0; 
                    check[i][j]= true; 
                    dfs(i,j);

                    if(num_o==0 && num_v==0) continue; 

                    if(num_o > num_v){
                        ans_o += num_o;
                       
                    }
                    else if (num_o <= num_v){
                        ans_v += num_v;  
                        
                    }
                }
            }
        }

        bw.write(ans_o + " " + ans_v +"\n");

        
        bw.flush(); 
        bw.close();
    }

    public static void dfs(int x, int y) throws IOException {

        if(arr[x][y]=='o') num_o++;
        else if(arr[x][y]== 'v') num_v++;

        for(int k=0;k<4;k++){
            int nx= x+dx[k];
            int ny= y+dy[k];
            if(nx>=0 && nx<R && ny>=0 && ny<C && arr[nx][ny]!='#' && check[nx][ny]==false){
                check[nx][ny]=true;
                dfs(nx,ny); 
            }       
        }
    } 
}
