public class Solution {
    public int[] solution(long n) {
        if (n == 0) {
            return new int[]{0};
        }

        int[] answer = new int[String.valueOf(n).length()];

        int num = 0;

        while (n > 0) {
            answer[num] = (int) (n % 10);
            n = n / 10;
            num++;
        }
        return answer;
    }
}