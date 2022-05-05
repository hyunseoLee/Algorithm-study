import java.io.*;
import java.util.StringTokenizer;

public class 퇴사_DP_220505 {

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N= Integer.parseInt(br.readLine());
        int[] d= new int[17];
        int[] T= new int[N+1];
        int[] P= new int[N+1];

        d[0]= 0; T[0]= 0; P[0]= 0; 

        for(int i=1;i<=N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            T[i]= Integer.parseInt(st.nextToken());
            P[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N+1;i++){

            for(int day=1; day<=N;day++){
                if( day+T[day] <= i){
                    d[i]= Math.max(d[i], P[day]+d[day]); 
                }
            }
        }

        bw.write(d[N+1] +"\n" ); 

        bw.flush();
        bw.close();   
    }
}
