class Solution {
    public long solution(int price, int money, int count) {
        long pay = 0;
        
        for(int i=1; i<=count; i++) {
            pay += i;
        }
        
        pay *= price;

        return (pay - money > 0) ? pay - money : 0;
    }
}