import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치함수_DP_220503 {

    static int T;
    static int[] d0 = new int[41]; // 0의 갯수  
    static int[] d1 = new int[41]; // 1의 갯수

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));


        d0[0]=1; d1[0]=0; 
        d0[1]=0; d1[1]=1; 

        T= Integer.parseInt(br.readLine());        

        while(T>0){
            
            int N= Integer.parseInt(br.readLine());

            for(int i=2;i<=N;i++){
                d0[i]= d0[i-1]+d0[i-2];
                d1[i]= d1[i-1]+d1[i-2];

            }

            bw.write ( d0[N] +" "+ d1[N] + "\n"); 

            T--;
            
        }

        bw.flush();
        bw.close();
    }
    
}
