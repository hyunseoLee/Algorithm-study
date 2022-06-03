public class changeWord {
    static int answer=Integer.MAX_VALUE; 
    public int solution(String begin, String target, String[] words) {
        boolean[] check= new boolean[words.length]; 
        dfs(begin,target,words,0,check);
        if(answer==Integer.MAX_VALUE) answer=0; 
        return answer;
    }

    public void dfs(String now, String target, String[] words,int result,boolean[] check){
       // if(now==target){ 
        if(now.equals(target)){
            answer= Math.min(answer, result); 
            return;
        }
        for(int i=0;i<words.length;i++){
        //한개 빼고 같은 단어인지 찾기.
            if(changeNum(now, words[i]) && check[i]==false){
                check[i]=true;
                dfs(words[i],target,words,result+1,check);
                check[i]=false;
            }
            
        }
    }
    public boolean changeNum(String now, String words){
        boolean[] check= new boolean[now.length()]; 
        for(int i=0;i<now.length();i++){
           // for(int j=0;j<words.length();j++){
                if((now.charAt(i)==words.charAt(i)) && check[i]==false){
                    check[i]=true; 
                }
            //}
        }
        int equalNum=0;
        for(int k=0;k<check.length;k++){
            if(check[k]) equalNum++;
        }
        int numLength= now.length();

        if(equalNum== (numLength-1)) {
            return true;
        }
        else{ return false;}

    }

    public static void main(String[] args){
        String begin="hit";
        String target = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};

        changeWord sol  = new changeWord();
        /*
        begin="dot";
        for(int i=0;i<words.length;i++){
            System.out.println(begin +"-> " + words[i] + " : " + sol.changeNum(begin,words[i]));
        }
        */
        System.out.println(sol.solution(begin,target,words)); 
    }

}
