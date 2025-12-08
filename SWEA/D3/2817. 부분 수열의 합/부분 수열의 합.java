
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N, K;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		subset(0, 0);
		
		System.out.println("#" + t + " " + count);
		}
	}
	
	static void subset(int idx, int sum) {
		if(idx == N) {
			if(sum == K) {
				count++;
			}
				return;
			} else {
				subset(idx+1, sum);
				sum += arr[idx];
				subset(idx+1, sum);
		}
		
	}

}