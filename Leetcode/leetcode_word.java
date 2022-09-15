import java.util.*;

public class leetcode_word {
    
    static List<String> result; // = new ArrayList<>();
    /* 완전탐색 */
    public boolean wordBreak(String s, List<String> wordDict) {
        
        result= new ArrayList<>();
        boolean ans = false; 
        
        for(int i=0;i<wordDict.size();i++){
            String word = wordDict.get(i);
            if(s.contains(word)){
                findWord(s.replaceFirst(word, " "), wordDict);
            }
        }

        for(int i=0;i<result.size();i++){
            //System.out.println(result.size() +"," + result.get(i));
            if(result.get(i).isEmpty()){
                ans = true;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public void findWord(String str,List<String> wordDict ){
        

        for(int i=0;i<wordDict.size();i++){
            String word= wordDict.get(i);
            if(str.contains(word)){
               //  str= str.replaceFirst(word, ""); 
               // System.out.println( word  +"를 뺀 나머지 : " + str.replaceFirst(word, ""));
                findWord(str.replaceFirst(word, " ") ,wordDict); 
            }
        }

        if(str.replaceAll(" ", "").isEmpty()){
            result.add(str.replaceAll(" ", "")); 
            return; 
        }


    }

    public static void main(String[] args){
        leetcode_word sol = new leetcode_word();

        String s= "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        sol.wordBreak(s, wordDict);

        
    }
}
