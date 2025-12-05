import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	// 쿼터의 개수 Q 25
	// 다임의 개수 D 10
	// 니켈의 개수 N 5
	// 페니의 개수 P 1
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] C = new int[T];
				
		for(int i = 0; i < T; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}
		
		// 그리디 알고리즘
		for(int i = 0; i < T; i++) {
			int money = C[i];
			
			int Q = money / 25;
			money %= 25;
			
			int D = money / 10;
			money %= 10;
			
			int N = money / 5;
			money %= 5;
			
			int P= money / 1;
			money %= 1;
			
			System.out.println(Q + " " + D + " " + N + " " + P);
		}
	}

}
