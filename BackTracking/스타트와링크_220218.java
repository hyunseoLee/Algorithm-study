import java.io.*;
import java.util.*;

import org.xml.sax.ContentHandler;
public class Main_220218 {

    static BufferedWriter bw ;
    static int N;
    static int[][] arr;
    static boolean[] check;
    static int answer;
    static ArrayList<Integer> v = new ArrayList<>();

        public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr= new int[N][N];
        check= new boolean[N];
        answer=Integer.MAX_VALUE;


        
        for(int i=0;i<N;i++){
           StringTokenizer st= new StringTokenizer(br.readLine());
           for(int j=0;j<N;j++){
            arr[i][j]= Integer.parseInt(st.nextToken());
           }
        }  
        
        recursion(0,0);
        bw.write(answer +"\n");

        bw.flush();
        bw.close();

    }

    // idx : 인덱스값, cnt: 재귀 깊이 
    public static void recursion(int idx, int cnt) throws IOException{

        if(cnt == N/2){
            // 값을 비교하자..
            int score1 = 0;
            int score2 = 0;

            for(int i=0;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    if(check[i] && check[j]){
                        score1+= arr[i][j] +arr[j][i];
                    }
                    else if( !check[i] && !check[j]){
                        score2+=  arr[i][j]+arr[j][i];
                    }
                }
            }

            answer= Math.min(answer, Math.abs(score1-score2));

            return;
    
        }

        for(int i=idx;i<N;i++){
            if(check[i]== false){
                check[i]=true;
                recursion(i, cnt+1);
                check[i]=false;
            }
        }
    }
}
