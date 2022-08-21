public class Coupang {
    
    static String[] result;
    static int[][] map; 
    
    public String solution(int n, int[][] delivery){

        result= new String[n+1];
       // if(result[0]==null){ System.out.println("null");}

        /* 1. 연결 map 생성  */
        map= new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                map[i][j] = -1; 
            }
        }
        for(int i=0;i<delivery.length;i++){
            int x = delivery[i][0];
            int y = delivery[i][1]; 
            int stat = delivery[i][2];
            map[x][y] =stat;
            map[y][x] =stat; 
        }

        for(int i=0;i<delivery.length;i++){
            int p1= delivery[i][0];
            String s1 = result[p1];
            int p2= delivery[i][1]; 
            String s2 = result[p2];
            int stat = delivery[i][2];
            
            statCheck(p1,s1,p2,s2,stat,n);
 
        }

        String answer = "";

        for(int k=1;k<result.length;k++){
            if(result[k]==null) result[k]="?"; 
            answer+= result[k];
            
        }

        System.out.println(answer);


        return answer; 
    }

    public void statCheck(int p1, String s1, int p2, String s2, int stat,int n){
        //1. 배송된 경우, 두 상품모두 재고 O 으로 저장 
        if(stat==1){
            if(s1!="O" && s2=="O"){
                result[p1]="O"; 

                for(int i=1;i<n+1;i++){
                   if(map[p1][i]==0) statCheck(p1,result[p1],i,result[i],0,n);
                }

            }
            if(s1=="O" && s2!="O"){
                result[p2]="O"; 
                for(int i=1;i<n+1;i++){
                    if(map[p2][i]==0) statCheck(p2,result[p2],i,result[i],0,n);
                 }
            }
            if(s1!="O" && s2!="O"){
                result[p1]="O";
                result[p2]="O"; 
                for(int i=1;i<n+1;i++){
                    if(map[p1][i]==0) statCheck(p1,result[p1],i,result[i],0,n);
                }
                for(int i=1;i<n+1;i++){
                if(map[p2][i]==0) statCheck(p2,result[p2],i,result[i],0,n);
                }
            }



        }
        //2. 배송불가한 경우
        if(stat==0){
            //2-1. 둘중 한개라도 재고 있으면, 나머지는 재고가 X 이다. 
            if(s1=="O" || s2=="O"){
                if(s1=="O" && s2!="O"){
                    result[p2]="X"; 
                }
                if(s1!="O" && s2=="O"){
                    result[p1]="X";
                }
            }
            else{

                //2-2. 둘중 하나라도 아직 값 체크를 못했다면 ?로 한다. 
                if(s1==null && (s2=="X" || s2=="?")){
                    result[p1]="?"; 
                }
                if((s1=="X" || s1=="?") && s2==null){
                    result[p2]="?"; 
                }
                if(s1==null && s2==null){
                    result[p1]="?";
                    result[p2]="?";
                }
                /*
                //2-3. 둘중 하나라도 O라면 나머지는 무조건 X이다.
                if(s1=="O" && s2!="O"){
                    result[p2]="X";
                }
                if(s1!="O" && s2=="O"){
                    result[p1]="X";
                }
                */

            }
        }
    }

    // HashMap<String,Integer> map = new HashMap<>();
    // map.put(str, map.getOrDefault(str, 0)+1);  
    public static void main(String[] args){
        Coupang sol  = new Coupang();

       
        int n=7;
        int[][] delivery={{5,6,0},{1,3,1},{1,5,0},{7,6,0},{3,7,1},{2,5,0}};
        sol.solution(n, delivery);

    }
}
