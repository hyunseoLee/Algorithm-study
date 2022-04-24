import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
1780. 부등호
- 재귀, 구현함수 사용
2022.04.24 
문제읽기 및 이해 10:20~ 10:40
코딩 시작 10:40 
완성 11:40 
*/

public class 종이의개수_220424 {

    static int num1=0; // -1 로 채워진 갯수 
    static int num2=0; // 0 으로 채워진 갯수
    static int num3=0; // 1 로 채워진 갯수 
    static int N;
    static int arr[][];
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

       
        N= Integer.parseInt(br.readLine());
        arr= new int[N][N];
        
        for(int i=0;i<N;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){   
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
    
        sizeCnt(0,0,N);

        bw.write(num1+"\n");
        bw.write(num2+"\n");
        bw.write(num3+"\n");

        bw.flush();
        bw.close();

    }
    /* 범위 내 사이즈 카운트 */
    public static void sizeCnt(int x, int y, int size){
       
        if(sameCheck(x,y,size)){
            int now= arr[x][y];
            if(now== -1) num1+=1;
            else if(now==0) num2+=1;
            else if(now==1) num3+=1; 
            
            return;
        }

        else{
            int div = size/3; 
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    sizeCnt(x + div*i, y+ div*j, div);
                }
            }
        }

    }

    /* 범위 내의 배열이 모두 같은 값인지 확인  */
    public static boolean sameCheck(int x, int y, int size){

        int now= arr[x][y];
        boolean sameOrNot = true;

        for(int i=x;i<x+size;i++){
            if(!sameOrNot) break;
            for(int j=y;j<y+size;j++){
                if(arr[i][j]!=now){
                    sameOrNot =false;
                    break; //여기서 빠져나가지못함.
                }
            }
        }

        return sameOrNot;
    }
    
}
