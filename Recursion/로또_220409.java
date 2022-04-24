import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 로또_220409{

    static int N;
    static boolean[] check;
    static int[] arr; 
    static int[] ans; 
    static BufferedWriter bw; 
    static int size = 6; 
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
        

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            if(N==0) break;
            check= new boolean[N];
            arr =  new int[N];
            ans = new int[6]; 

            for(int i=0;i<N;i++){
                arr[i]= Integer.parseInt(st.nextToken());
            }

            recursion(0,0);
            bw.write("\n");

        }

        bw.flush();
        bw.close();

    }
    private static void recursion(int depth, int idx) throws IOException{
        if(depth == size){

            for(int i=0;i<6;i++){
                bw.write(ans[i] + " ");
            }
            bw.write("\n");

            return; 
        }

        for(int i=idx;i<N;i++){
            if(check[i]==false){
                check[i]=true;
                ans[depth]= arr[i];
                recursion(depth+1, i);
                check[i]=false;
            }
        }

    }
}