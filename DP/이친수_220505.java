import java.io.*; 

public class 이친수_220505 {
    
    static long[][] d= new long[91][2];
    static int N; 

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        d[0][0]=0; d[0][1]=0;
        d[1][0]=0; d[1][1]=1;
        d[2][0]=1; d[2][1]=0; 
        // 1<=N <= 90 
        N= Integer.parseInt(br.readLine());

        for(int i=3;i<=N;i++){
            d[i][0]= d[i-1][0]+ d[i-1][1];
            d[i][1]= d[i-1][0]; 
        }

        long ans= d[N][0]+ d[N][1]; 
        
        bw.write(Integer.MAX_VALUE + "\n"); 
    
        bw.write(Long.MAX_VALUE + "\n"); 
        //bw.write(d[N][0]+ ", " +d[N][1] + "\n"); 
        bw.write( ans + "\n"); 

        bw.flush();
        bw.close();



    }
    
}
