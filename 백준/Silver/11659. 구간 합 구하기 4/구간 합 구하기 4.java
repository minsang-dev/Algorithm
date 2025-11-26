import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] A;
	static int sum;
	// 수의 개수 N, 합을 구해야하는 횟수 M
	// i번째 수 ~ j번째 수 -> 인덱스
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = 0; // 출력해야하는 sum값 초기화
		A = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
//			A[i] = Integer.parseInt(st.nextToken());
			A[i] += Integer.parseInt(st.nextToken()) + A[i-1];
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(A[b] - A[a-1]).append("\n");
			
		}
		
		System.out.println(sb.toString());

	}

}
