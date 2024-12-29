class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zeroCount = 0;
        int[] answer = new int[2];
        
        for(int lotto:lottos) {
            if(lotto == 0){
                zeroCount++;
                continue;
            }
            for(int win_num:win_nums) {
                if(win_num == lotto){
                    count++;
                    break;
                }
            }
        }
        answer[0] = Math.min(7-(count+zeroCount),6);
        answer[1] = Math.min(7-count,6);
        return answer;
    }
}