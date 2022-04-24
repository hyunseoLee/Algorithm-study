import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
    2022.03.26
    [BOJ] 차이를 최대로 ( 실버2 )
    - 백트래킹 
    - 6:40 ~ 7:08 내 멋대로 풀었음 하지만 오류남!!! 하하하 어디서 잘못된건지 다 내가 찾아봐야지 
    - 10:10 ~ 10:50 : 다 풀고 뭔가 check부분을 써야하는 부분, ans=max(ans,sum)을 해줘야하는 부분등을 
                      생각하느라 오래걸렸다. 난 아직도 재귀에 대해 잘 모르는 것 같다. ㅠㅠ
*/

public class 차이를최대로_220326 {
    static BufferedWriter bw;
    static int N;
    static int[] arr; 
    static int sum; 
    static boolean[] check;
    static int ans;
    static int tmp;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
    
        N= Integer.parseInt(br.readLine());
        arr= new int[N];
        check= new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            check[i]=true;
            solve(i,0,0);
            // ans = Math.max(ans,tmp);  여기서 결과값 처리하면, 마지막 tmp만 넘어온다. 
            check[i]=false;
        }

        bw.write(ans+"\n");

        bw.flush();
        bw.close();
    }

    public static void solve (int now, int cnt, int sum) throws IOException{

        if(cnt== N-1){
            // return sum; //재귀는 return 값이 없다.  
            ans = Math.max(ans,sum);
            return;
        }

        check[now]=true;
        for(int i=0;i<N;i++){
            if(check[i]==false){
                check[i]=true;
                // sum+= Math.abs(arr[now] - arr[i]); 
                //bw.write(now +"> / cnt: " +cnt +"/ sum: " + sum+"\n");
                solve(i,cnt+1, sum+ Math.abs(arr[now] - arr[i]));
                check[i]=false;
            }

        }

    }
    
}
