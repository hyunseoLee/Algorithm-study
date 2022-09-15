import java.util.*;

public class leetcode_word2 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[]= new boolean[s.length()+1];
        dp[0]= true;
        for(int i=1;i < s.length()+1;i++){
            for(int j=0;j<wordDict.size();j++){
                String word = wordDict.get(j);
                int word_len= word.length();

                if(i-word_len >=0 && i <= s.length()){
                    //System.out.println(i +": dp["+ (i-word_len)+"]:" + dp[i-word_len] +"/ "+ s.substring(i-word_len, i));
                    if(dp[i-word_len] && s.substring(i-word_len, i).equals(word)){
                        dp[i]= true; 
                    }
                }

            }

        }
        System.out.println(dp[s.length()]);

        return dp[s.length()]; 
       
    }

    public static void main(String[] args){

        leetcode_word2 sol = new leetcode_word2();
        String s= "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(s.substring(0,4));

        sol.wordBreak(s, wordDict);

    }
}
