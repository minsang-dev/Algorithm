import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class  Main{
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr = new int[N];

        for(int i =0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        Arrays.fill(dp, 1);

        int answer = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);

        }
        System.out.println(answer);

    }
}