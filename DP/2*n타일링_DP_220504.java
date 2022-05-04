import java.io.*;

public class Main_2n_220504 {

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N= Integer.parseInt(br.readLine());

        int[] d= new int[1001];
        //int[] d= new int[N+1];
        d[0]=0;
        d[1]=1;
        d[2]=2; 

        for(int i=3;i<=N;i++){
            d[i]= d[i-2] + d[i-1];
            d[i]= d[i]%10007; 
        }
        bw.write( d[N] +"\n"); 

        bw.flush();
        bw.close();
    } 
}
;