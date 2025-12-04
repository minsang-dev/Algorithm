import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			
			for(int j = 1; j <= N-i; j++) {
				System.out.print(" ");
			}
			
			for(int j = 1; j <= i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		for(int i = N+1; i <= 2*N-1; i++) {
			for(int j = 1; j <= i-N; j++) {
				System.out.print(" ");
			}
			
			for(int j = 1; j <= (2*N-i) * 2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
