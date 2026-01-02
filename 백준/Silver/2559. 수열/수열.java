import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int window = 0;
		for(int i = 0; i < K; i++) {
			window += arr[i];
		}
		
		int answer = window;
		for(int i = 1; i < N - K + 1 ; i++) {
			window += arr[i + K - 1] - arr[i-1];
			
			if(window > answer) {
				answer = window;
			}
		}
		
		System.out.println(answer);
		
		
	}

}
