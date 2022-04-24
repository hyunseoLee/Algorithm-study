import java.io.*;
import java.util.StringTokenizer;

public class 로또_recursion_220212{
    static BufferedWriter bw;
    static int[] arr;
    static int[] ans;
    static boolean[] check;
    static boolean[] map;
    static int size = 6;
    static int n;;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n= Integer.parseInt(st.nextToken());

            if(n==0) break; 

            arr= new int[n];
            ans= new int[n];
            map = new boolean[n];
            check = new boolean[n];

            for(int i=0;i<n;i++){   
                arr[i]= Integer.parseInt(st.nextToken());
            }
            recursion(0,0);
            bw.write("\n");
            
    
        }
        bw.flush();
        bw.close();

    }
    public static void recursion(int idx,int K) throws IOException{

        if(K==size){
            //String tmp="";
            for(int i=0;i<size;i++){
               // tmp+= Integer.toString(ans[i]);
               bw.write(ans[i] +" ");
            }
            bw.write("\n");
            
            return;
        }

        for(int i=idx;i<n;i++){
            if(!check[i]){  
                ans[K]= arr[i];
                check[i]=true;
                //bw.write(i +" : " + ans[K]+ "\n");
                recursion(i,K+1);
                check[i]=false;

            }
        }
    }
}
