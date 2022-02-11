
import java.io.*;

/*
    백준. 2992번:  크면서 작은 수
    - 백트래킹 
*/

public class 크면서작은수_220211 {

    static int[] arr;
    static boolean[] check;
    static int size; 
    static BufferedWriter bw;
    static int[] ans;
    static String str;
    static int tmp = 999999;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        size = str.length(); 

        arr= new int[size];
        check= new boolean[size];
        ans = new int[size];
        
        for(int i=0;i<size;i++){
            //arr[i]= Integer.valueOf(str[i]);
            arr[i]= str.charAt(i)-'0';
        }

        recursion(0);
        if(tmp==999999){
            tmp=0;
        }
        bw.write(tmp+"\n");

        bw.flush();
        bw.close();
    }
    public static void recursion(int K) throws IOException{
        if(K== size){

            String result="";
 
            for(int i=0;i<size;i++){
                result+= Integer.toString(ans[i]);          
            }
            if( Integer.parseInt(result)> Integer.parseInt(str))
            {
               tmp =  Math.min(Integer.parseInt(result),tmp);
            }

            return;
            
        }
        for(int i=0;i<size;i++){
            if(!check[i]){
                check[i]=true;
                ans[K]= arr[i];
                recursion(K+1);
                check[i]=false;
            }
        }

    }
    
}
