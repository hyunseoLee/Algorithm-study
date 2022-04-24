import java.io.*;
import java.util.StringTokenizer;

/*
   백준. 18429 : 근손실
   - 백트래킹 
*/

public class 근손실_recursion_220210{
    static BufferedWriter bw;
    static int N,K;
    static int[] arr;
    static boolean[] check;
    static int result=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        
        arr= new int[N];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        recursion(0,500);

        bw.write(result + "\n");
        
        bw.flush();
        bw.close();

    }
    private static void recursion(int day, int sum) throws IOException{

        if(day== N){
            result++;
            return;
        }

        for(int i=0;i<N;i++){
            if(!check[i]){
                sum= sum + (arr[i]- K);
                //bw.write(i +": " + sum +"\n");
                if(sum>=500){
                    check[i]=true;
                    recursion(day+1,sum);
                    check[i]=false;
                }
                sum= sum - (arr[i]-K); 

            }
        }

    }
}