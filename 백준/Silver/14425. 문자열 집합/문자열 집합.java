import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashSet<String> word = new HashSet<>();
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			word.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String compareWord = br.readLine();
			
			if(word.contains(compareWord)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}