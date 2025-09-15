import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 뒤집기 횟수
        
        // 바구니 초기화 (1번부터 N번까지)
        int[] basket = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }
        
        // M번 뒤집기 수행
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            // i번째부터 j번째까지 순서 뒤집기
            reverse(basket, i, j);
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(basket[i]);
            if (i < N) sb.append(" ");
        }
        System.out.println(sb.toString());
        
        br.close();
    }
    
    // 배열의 start부터 end까지 순서 뒤집기
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}