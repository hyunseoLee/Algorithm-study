import java.io.*;

public class 로마숫자만들기_recursion_220208{

    static int N;
    static int[] array= new int[4];
    static boolean[] check= new boolean[1002];  
    static int result = 0;
    static BufferedWriter bw; 

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(br.readLine());

        array[0]=1;
        array[1]=5;
        array[2]=10;
        array[3]=50;
    

        recursion(0,0,0);

        bw.write(result+"\n");

        bw.flush();
        bw.close();
        


    }

    private static void recursion (int idx, int K, int Sum) throws IOException{
        if(K==N){ 
            if(!check[Sum]){
                check[Sum]=true;
                result++;
                
            }  
            return;      
        }
        
        for(int i=idx;i<4;i++){
            Sum+= array[i];
            recursion(i, K+1, Sum);
            Sum-= array[i];

        }
    }
}