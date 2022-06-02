public class TargetNumber {
    static int answer=0; 
    public int solution(int[] numbers, int target) {

        solve(numbers,0,0,target);
        return answer;
    }
    public void solve(int[] numbers, int index, int sum, int target){
        if(index==numbers.length){
            //System.out.println(sum); 
            if(sum==target){
                answer++; 
            }
            return;
        }

        solve(numbers,index+1, sum-numbers[index],target);
        solve(numbers,index+1, sum+numbers[index],target);

    }

    public static void main(String[] args){
        int[] numbers= {4,1,2,1};
        int target=4; 
        TargetNumber sol = new TargetNumber();
        System.out.println(sol.solution(numbers, target));
        //System.out.println(sol.solution(numbers, 3));
    }
}
