class Solution {
    public int[] solution(int n) {
       int count = 0;
        
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
            }
        }
        int[] divisors = new int[count];
        
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                divisors[index++] = i;
            }
        }
        
        return divisors;
    }
}