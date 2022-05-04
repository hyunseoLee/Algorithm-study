import java.io.*;

public class Main_220504 {
    static int[] d= new int[12];
    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int T =  Integer.parseInt(br.readLine());
        d[0]=0;
        d[1]=1;
        d[2]=2;
        d[3]=4;

        while(T>0){
            int N= Integer.parseInt(br.readLine());

            for(int i=4;i<=N;i++){
                d[i]= d[i-1]+d[i-2]+d[i-3];
            }

            bw.write(d[N]+"\n");

            T--; 

        }

        bw.flush();
        bw.close();
    }
    
}
