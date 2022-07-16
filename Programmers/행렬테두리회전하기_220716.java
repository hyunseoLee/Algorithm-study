import java.util.*;
import java.util.Collections;

public class Sol_220705 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        int[][] map= new int[rows][columns];

        int num=1; 
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j]= num;
                num++; 
            }
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println("");
        }
        
        for(int i=0;i<queries.length;i++){
            int x1= queries[i][0]-1;
            int y1= queries[i][1]-1;
            int x2= queries[i][2]-1;
            int y2= queries[i][3]-1;
            List<Integer> list= new ArrayList<>();
            map= changeMap(x1,y1,x2,y2,map,list); 
            //Collections.sort(list);
            for(int j=0;j<list.size();j++){
                System.out.print(list.get(j)+" ");
            }
            System.out.println();
            Collections.sort(list);
            System.out.println(list.get(0));
        }

        System.out.println("==============================");

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println("");
        }


        return answer;
    }

    public int[][] changeMap(int x1, int y1, int x2, int y2,int[][] map, List<Integer> list){

        //int[][] tmp= map; // ?? 동치 관계가 되는건가? 
        int row= map.length;
        int columns= map[0].length;
        int[][] tmp= new int[row][columns];

        /* 동치관계가 되는 건지 꼭 확인해보기 !!!!  */
        for(int i=0;i<row;i++){
            for(int j=0;j<columns;j++){
                tmp[i][j]= map[i][j];
            }
        }
        
        //1. x1행에서 오른쪽으로 한칸씩 밀기 
        for(int i=y2;i>y1;i--){
            tmp[x1][i]= map[x1][i-1]; 
            list.add(map[x1][i-1]);
        }
        //2. y2열에서 아래쪽으로 한칸씩 밀기
        for(int i=x1+1;i<=x2;i++){ 
            tmp[i][y2]= map[i-1][y2];  
            list.add(map[i-1][y2]);
        }

        //3. x2행에서 왼쪽으로 한칸씩 밀기
        for(int i=y2-1; i>=y1;i--){
            tmp[x2][i]= map[x2][i+1]; 
            list.add(map[x2][i+1]);
        }

        //4. y1열에서 위로 한칸씩 올리기
        for(int i=x2-1;i>=x1;i--){
            tmp[i][y1]= map[i+1][y1]; 
            list.add(map[i+1][y1]);
        }

        return tmp; 
    }
    public static void main(String[] args){
        Sol_220705 sol= new Sol_220705();

        int rows= 6;
        int columns= 6;
        int[][] queries={{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        sol.solution(rows, columns, queries);

    }
}
