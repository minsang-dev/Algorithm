class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i : index_list){
            sb.append(my_string.charAt(i));
        }
        return answer = sb.toString();
    }
}