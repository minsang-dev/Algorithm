import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 0;

        int[] parent = new int[N+1];
        parent[1] = 0;

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + 1;
            parent[i] = i - 1;

            if(i % 2 == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
                parent[i] = i / 2;
            }

            if(i % 3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
                parent[i] = i / 3;
            }
        }
        System.out.println(dp[N]);

        StringBuilder path = new StringBuilder();
        int cur = N;
        while(cur != 0){
            path.append(cur).append(" ");
            cur = parent[cur];
        }
        System.out.println(path.toString().trim());
    }
}