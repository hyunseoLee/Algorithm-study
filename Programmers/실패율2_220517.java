import java.io.IOException;
import java.util.*;

// 클래스 따로 떼어놨을때 왜 안되는지 공부하라규~! 
class 실패율2_220518{
    public int[] solution(int N, int[] stages) {
        //int[] answer = new int[N];

        HashMap<Integer,Double> map= new HashMap<>(); // 제네릭 클래스

        for(int i=1;i<=N;i++){

            int parent_num=0;
            int child_num=0;
            for(int j=0;j<stages.length;j++){
                if(stages[j]>=i)  parent_num++;
                if(stages[j]==i)  child_num++;
            }
            double val; 
            if(parent_num==0) {val=0;}
            else{ val = (double)child_num/parent_num; }
            //System.out.println(i+"인덱스의 분모: "+parent_num +"/ 분자: "+child_num+"/ 결과: "+ val );
            //map.put(i, (double)child_num/parnet_num ); 
            map.put(i, val);

        }

        // 내림차순 정렬 하는 방법 1. 
        
        /*
        for(int i=0;i<N;i++){
            Double maxVal= -1.0;
            int maxIndex= 0;
            for(int key: map.keySet()){ 
                if(maxVal<map.get(key)){
                    maxVal= map.get(key);
                    maxIndex= key; 
                }           
              // System.out.println(i+"번째/ key값:  " + key +"/ value: "+ map.get(key)); 

            } 
            //System.out.println("MaxVal= "+ maxVal +"MaxIndex: "+ maxIndex); 
            answer[i]= maxIndex;

            map.remove(maxIndex);

        }
        */ 

        // 내림차순 정렬 하는 방법 2. 
        List<Integer> list= sortByValue(map); 
        int[] answer= new int[list.size()]; 
        for(int i=0;i<list.size();i++){
            answer[i]= list.get(i);
        }


        return answer;
    }

    public List<Integer> sortByValue (Map<Integer,Double> map){

        List<Integer> list= new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, (Comparator)(o1,o2)->{
            Object v1= map.get(o1);
            Object v2= map.get(o2);
            return ((Comparable) v2).compareTo(v1); 
        });

        return list;

    }
    
    public static long add2(long c, long d){ // 클래스메서드 = static 메서드
        return c+d;
    }
}

public class 실패율2_220517 {

    public static void main(String[] args){
       // Solution sol = new Solution();
        //sol.N=5;
        //sol.stages[] ={2, 1, 2, 6, 2, 4, 3, 3};

       // System.out.println(Solution.add2(100L,200L));
 
       int N = 5; 
       int[] stages ={2, 1, 2, 6, 2, 4, 3, 3};
       Solution sol = new Solution();
       int[] answer= Solution.solution(N, stages);


       /*
       int[] answer= Solution.solution(N, stages);

       for(int i=0;i<answer.length;i++){
           System.out.println(answer[i]);
       }
       */ 

    }
}

    



