class Solution {
    public String solution(String s) {
        String[] tmp = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < tmp.length; i++) {
            int num = Integer.parseInt(tmp[i]);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        return min + " " + max;
    }
}