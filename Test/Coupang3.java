public class Coupang3 {

/* 기존 dfs처럼 모든 범위를 찾는게 아니라, 한번 갔을때의 최대 이동수를 찾는 거였다 . */
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int size = 4; 
    static int cnt=0; 

    public int solution(int[][] board){
     
        int answer= 0; 
        int result =0;
        /*
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                result=0; 
                boolean[][] check = new boolean[size][size]; 
                result= Math.max(result, checkBoard(i,j,board[i][j],board,check,0 ))  ; 
                
            }
        }

        answer= Math.max(answer,result ); 
        */ 

        /* test  */
        result=0; 
        boolean[][] check = new boolean[size][size]; 
        result= Math.max(result, checkBoard(2,0,board[2][0],board,check,0)); 
        System.out.println(result);

        return answer; 
    }

    public int checkBoard(int x, int y, int now, int[][] board, boolean[][] check, int cnt){

       // int result=0 ;
      

        int result=0;

        // 4방향 모두 갈 수 없을때. 
        if(isGoing(x,y,now,board,check)==false){
            System.out.println(cnt);
            return cnt; 
        }

        else{ 
            for(int k=0;k<4;k++){
                int nx=  x+ dx[k];
                int ny = y+ dy[k];
                if(nx>=0 && nx<size && ny>=0){
                    if(board[nx][ny]==now && check[nx][ny]==false){
                        check[nx][ny]=true;
                        checkBoard(nx,ny,now,board,check,cnt+1); 
                        cnt++; 
                    }
                    
                }
            }
        }

        return cnt;
    }
    public boolean isGoing(int x, int y,int now, int[][] board, boolean[][] check){

        for(int k=0;k<4;k++){
            int nx=  x+ dx[k];
            int ny = y+ dy[k];

            if(nx>=0 && nx<size && ny>=0 && board[nx][ny]==now && check[nx][ny]==false){
                return true;
            }

        }
        return false;
    }
 
    public static void main(String[] args){
        Coupang3 sol= new Coupang3();
        

        //무조건 가로4, 세로4 
        // 숫자는 1,2,3,4 중 하나 
        int[][] board= {{3,2,3,2},{2,1,1,2},{1,1,2,1}, {4,1,1,1}};

        sol.solution(board);

    }
}
