import java.io.IOException;
import java.util.*;
/*
class Solution {

    static int[] solution(int N, int[] stages) {
        int[] answer = {};

        HashMap<Integer,Double> map= new HashMap<>(); // 제네릭 클래스

        for(int i=1;i<=stages.length;i++){

            int parent_num=0;
            int child_num=0;
            for(int j=0;j<stages.length;j++){
                if(stages[j]>=i)  parent_num++;
                if(stages[j]==i)  child_num++;
            }
            double val= child_num/parent_num; 
            //map.put(i, (double)child_num/parnet_num ); 
            map.put(i, val);

        }
        
        for(int i=0;i<map.size();i++){
            System.out.println(map.get(i));

        }
        
        return answer;
    }

}
*/ 

public class 실패율_220517 {

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

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
    
        //Map 내림차순이 만만치않군..
        for(int i=0;i<N;i++){
            double maxVal= -1;
            int  maxCount=0; 

            for(int key: map.keySet()){ // keySet공부 다시.  HashMap에 저장된 모든 키가 저장된 Set을 반환. 
                if(maxVal<map.get(key)) {
                    maxVal= map.get(key);
                    maxCount= key;
                }
            }
            answer[i]= maxCount; 
            map.remove(maxCount); 
        }        

        /*
        내림차순 하는 방법에 대한 고안.. 
        Map을 List로 바꿔서 Collectio.sort를 사용할 방법을 찾아봤는데,
        너무 복잡하고 ..일단 패스! 
        List<Double> list= new ArrayList<>();
        for(int i=1;i<=N;i++){
            list.add(map.get(i));
           // System.out.println(map.get(i));
        }
        //내림차순 
        Collections.sort(list);
        Collections.reverse(list);
        */
        

        //map을 리스트로 받아서 내림차순 하는 법 

        List<Integer> list = sortByValue(map);
        int[] answer2 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer2[i] = list.get(i);
        }
        


        return answer;
    }

    public static List<Integer> sortByValue(final Map<Integer,Double> map) {
        List<Integer> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list, (Comparator) (o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);
            return ((Comparable) v2).compareTo(v1);
        });

        return list;
    }

    public static void main(String[] args) throws IOException{
       // Solution sol = new Solution();
        //sol.N=5;
        //sol.stages[] ={2, 1, 2, 6, 2, 4, 3, 3};

       int N = 4; 
       int[] stages ={2,2,2,2,2};
       int[] answer= solution(N, stages);

       for(int i=0;i<answer.length;i++){
           System.out.println(answer[i]);
       }

    }
    
}



