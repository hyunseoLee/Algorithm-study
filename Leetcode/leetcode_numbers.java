public class leetcode_numbers {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int m;
    static int n; 


    public int numIslands(char[][] grid) {
        
        m= grid.length; //행
        n= grid[0].length;  //열
        boolean[][] check = new boolean[m][n]; 
        int ans = 0; 

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]== '1' && check[i][j]==false){
                    check[i][j]=true;
                    dfs(i,j,grid,check);
                    ans++; 
                }
            }
        }
        return ans; 
    }

    public void dfs(int x, int y,char[][] grid, boolean[][] check){
        for(int k=0;k<4;k++){
            int nx= x+ dx[k];
            int ny= y+ dy[k];
            if(nx>=0 && nx <m && ny>=0 && ny<n && grid[nx][ny]=='1' && check[nx][ny]==false){
                check[nx][ny]=true;
                dfs(nx,ny,grid,check);
            }
        }
        return; 
    }

    public static void main(String[] args){
        leetcode_numbers sol = new leetcode_numbers();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        sol.numIslands(grid);

    }
}
