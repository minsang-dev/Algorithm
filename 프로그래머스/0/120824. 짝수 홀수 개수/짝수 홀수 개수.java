class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {0, 0};
        int 짝수의수 = 0;
        int 홀수의수 = 0;
        
        for(int i = 0; i<num_list.length; i++)
        {
            if(num_list[i] % 2 == 0)
                짝수의수++;
            else
                홀수의수++;
        }
            
        answer[0] = 짝수의수;
        answer[1] = 홀수의수;
        return answer;
    }
}