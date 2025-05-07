class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        
        String[] str = s.split("");
        
        int key = 0;
        
        for(int i=0; i<str.length; i++) {
            if(key % 2 == 0) {
                str[i] = str[i].toUpperCase();
            }

            if(str[i].isBlank()) {
                key = -1;
            }
            answer += str[i];
            key++;
        }
        
        return answer;
    }
}