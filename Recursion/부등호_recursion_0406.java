import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
    22.04.02 
    [BOJ] 부등호 
    - 백트래킹, 브루트포스 
*/
public class 부등호_recursion_0406 {

    static BufferedWriter bw;
    static int N;
    static boolean[] check;
    static String[] arr;
    static int max = 0 ;
    static int min = 999999999; 
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());
        check= new boolean[10];
        arr= new String[N];

        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i]= st.nextToken();
        }
        /* 
            arr[0]= < 
            arr[1]= >  
        */
        for(int i=0;i<10;i++){
            check[i]=true;
            recursion(0,Integer.toString(i));
            check[i]=false; // 이거 깔끔하게 가고싶은데.
        }

        Collections.sort(result);

        
        bw.write(result.get(result.size()-1) +"\n");
        bw.write(result.get(0)+"\n");

        bw.flush();
        bw.close();


    }
    
    /* cnt: 현재 깊이
       now : 현재 숫자  (배열을 보내는게 나을까?)
    */
    public static void recursion(int cnt, String str) throws IOException{
        if(cnt==N){// 확인
            
            //bw.write(str +"\n");
            //int now= Integer.parseInt(str);
            result.add(str);
            
            // 결과값 now 를 최솟값, 최댓값 비교한다. 
            /*
            min= Math.min(min, now);
            max= Math.max(max, now);
            */
            return;
        }

        //1. 부등호가 > 인 경우: 그 다음 숫자가 지금숫자보다 작아야 한다. 
        //if(arr[cnt]==">"){
        if(arr[cnt].equals(">")){

            int end_num= str.charAt(str.length()-1) - '0';
        
            for(int i=0;i<end_num;i++){
                if(check[i]==false){
                    check[i]=true;
                    recursion(cnt+1,str+i);
                    check[i]=false;
                }
            }
        }
        //2. 부등호가 < 인 경우: 그 다음 숫자가 지금숫자보다 커야 한다. 
        //else if(arr[cnt]== "<"){
        else if (arr[cnt].equals("<")){
            int start_num = str.charAt(str.length()-1) - '0';
            for(int i= start_num+1;i<10;i++){
                if(check[i]==false){
                    check[i]=true;
                    recursion(cnt+1, str+i);
                    check[i]=false;
                
                }
            }
        }

    }
}
