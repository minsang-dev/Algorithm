import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		
		while(N > 0) {
			
			// 나머지가 각 자리 값이 되기 때문에
			int r = N % B; // r = 나머지
			
			if(r < 10) {
				sb.append((char)(r+'0'));
			} else {
				sb.append((char)(r-10+'A'));
			}
			
			N /= B;
		}
		
		// 오른쪽 자리부터 왼쪽 자리 순서로 이동 -> reverse
		System.out.println(sb.reverse().toString());

	}

}
