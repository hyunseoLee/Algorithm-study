import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class 단지번호붙이기_220211 {

    static BufferedWriter bw;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt= 0;
    static int n;
    static ArrayList<Integer> v = new ArrayList<>();  // c++에서 vector와 비슷한 듯 
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));

        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        check = new boolean[n][n];


        for(int i=0;i<n;i++){
            String str= br.readLine();
            for(int j=0;j<n;j++){
                map[i][j]= str.charAt(j) - '0';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]== 1 && check[i][j]==false ){
                   // bw.write(i +", "+j +"\n");
                    dfs(i,j);
                    // 재귀는 리턴값이 없다.
                    v.add(cnt);
                    cnt=0;

                }
            }
        }

        bw.write(v.size() + "\n");
        Collections.sort(v); // 오름차순 해주는 함수 Collection ( import java.util.* )
        for(int i=0;i<v.size();i++){
            bw.write(v.get(i) + "\n");
        }


        bw.flush();
        bw.close();

    }
    public static void dfs(int x, int y){
        
        check[x][y]=true;
        cnt++;

        for(int k=0;k<4;k++){
            int nx= x+dx[k];
            int ny= y+dy[k];
            if(nx>=0 && nx< n && ny>=0 && ny<n && map[nx][ny]==1 && check[nx][ny]==false){
                check[nx][ny]=true;
                dfs(nx,ny);
               
            }
        }
    }
    
}
