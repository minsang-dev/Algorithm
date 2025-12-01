import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
//			System.out.println(S);
			
			// 문자열 길이만큼 돌고
			for(int j = 0; j < S.length(); j++) {
				// R번 길이만큼 만들고
				for(int k = 0; k < R; k++) {
					// sb.append -> 문자열 길이 만큼 append					
					sb.append(S.charAt(j));
				}
				
			}
			
			sb.append("\n");

		}
		System.out.println(sb);
		
		
	}

}
