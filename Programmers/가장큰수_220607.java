import java.util.*;

class BestNumber_220607 {
    public String solution(int[] numbers) {
        String strArr[] = new String[numbers.length];
        
        //숫자를 조합해야하므로 문자열로 변경 
        for(int i=0; i<numbers.length; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        //정렬함수 및 Comparator인터페이스를 사용하여, 사용자 정의 방식으로 정렬시킴
        Arrays.sort(strArr , new Comparator<String>(){
            @Override
            public int compare (String n1 , String n2){
                //두숫자의 조합이 더 큰 경우 왼쪽으로 이동시킴(내림차순 정렬이기 때문)
                //내림차순(큰 -> 작) 정렬 : 2번째 파람값을 compareTo 함수 앞쪽에 위치시킴
                //오름차순(작 -> 큰) 정렬 : 1번째 파람값을 compareTo 함수 앞쪽에 위치시킴
                //compareTo의 결과값은 앞이 뒤보다 작으면 음수 크면 양수 같으면 0
                //문자열 비교이기 때문에 아스키코드값을 계산한 값의 차이만큼 음/양수가 리턴됨
                return (n2+n1).compareTo(n1+n2);
            }
        });
        
        //맨 앞이 0인경우 0이 제일 큰 수이므로 0으로만 이루어진 값.
        if(strArr[0].equals("0")) return "0";
        String answer = "";
        
        for(String s : strArr){
            answer += s;
        }
        
        return answer;
    }
}